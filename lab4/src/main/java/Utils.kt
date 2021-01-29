import task2.RegexLexer
import task2.RegexParser
import java.io.File
import java.io.IOException
import java.io.Reader
import kotlin.collections.LinkedHashMap

class ParseException(
    message: String = "Parse error", val pos: Int? = null,
    val expectedAndFound: Pair<List<Token>, Token>? = null
) : Exception(
    buildString {
        append(message)
        if (pos != null) append(" at position $pos")
        if (expectedAndFound != null) {
            append(", expected tokens: ${expectedAndFound.first}, found: ${expectedAndFound.second}")
        }
    }
) {
    companion object {
        fun expectedNotFound(lexer: GroupMatcherLexer, vararg expected: Token) =
            ParseException(pos = lexer.position, expectedAndFound = (expected.asList() to lexer.token))
    }
}

fun printResult(dirPath: String, fileName: String, line: Reader) {
    val s = File.separator
    val filePath = "src${s}main${s}$dirPath${s}$fileName"
    File("src${s}main${s}$dirPath").mkdir()
    File("$filePath.dot").printWriter().use {
        val tree = RegexParser(RegexLexer(line)).parse()
        it.println(treeToDot(tree))
    }
    Runtime.getRuntime().exec("dot -Tpng $filePath.dot -o $filePath.png")
}

/* https://graphs.grevian.org/example */
fun treeToDot(tree: Tree, regex: String? = null): String = buildString {
    appendLine("graph {")
    appendLine("label=\"$regex\"")
    appendLine(System.identityHashCode(tree))
    append(dfs(tree))
    append("}")
}

fun dfs(tree: Tree): String = buildString {
    val id = System.identityHashCode(tree)
    if (tree.children.isEmpty())
        appendLine("$id [label=\"${tree.node}\"]")
    tree.children.forEach {
        appendLine("$id [label=\"${tree.node}\"]")
        appendLine("$id -- ${System.identityHashCode(it)}")
        append(dfs(it))
    }
}

fun String.escape() = replace("\\", "\\\\").replace("\"", "\\\"")

fun String.cleanUpCode() = this.trim('{', '}', ' ')

typealias Token = Int

const val UNKNOWN_CHAR = -2

open class GroupMatcherLexer(
    _reader: Reader,
    literals: Map<Token, String>,
    patterns: Map<Token, Regex>,
    private val tokensToSkip: Set<Token>,
    private val EOF_TOKEN: Token = -1
) {

    private val allTokens: Map<Token, Regex> =
        literals.mapValues { (_, v) -> Regex.escape(v).toRegex() } + patterns + (UNKNOWN_CHAR to Regex(".+"))
    private val groupsToTokens: MutableMap<Int, Token> = LinkedHashMap()

    private val tokenStream: Iterator<TokenMatch>

    var token: Token = EOF_TOKEN
        private set

    var tokenValue: String? = null
        private set

    var position: Int = -1
        private set

    init {
        val text = _reader.readText()
        var grp = 0

        tokenStream = allTokens
            .map { (t, r) ->
                groupsToTokens[grp++] = t
                "($r)"
            }.joinToString("|")
            .toRegex().findAll(text)
            .map {
                it.groups.mapIndexedNotNull { i, g ->
                    if (i == 0 || g == null) null else TokenMatch(i, g.range.first, g.value)
                }.singleOrNull() ?: throw ParseException("Ambiguous tokens")
            }
            .iterator()
    }

    data class TokenMatch(val groupPos: Int, val strPos: Int, val value: String? = null)

    private fun _next() {
        if (!tokenStream.hasNext()) {
            if (token != EOF_TOKEN) {
                token = EOF_TOKEN
                tokenValue = null
                return
            } else throw IOException("No more tokens!")
        }
        val (g, s, v) = tokenStream.next()
        token = groupsToTokens.getValue(g - 1)
        position = s
        tokenValue = v
        if (token == UNKNOWN_CHAR) throw ParseException("Unexpected symbol $v", position)
    }

    fun next() {
        do {
            _next()
        } while (token in tokensToSkip)
    }
}