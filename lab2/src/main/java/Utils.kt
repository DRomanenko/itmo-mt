import java.io.BufferedInputStream
import java.io.ByteArrayInputStream
import java.io.File
import java.nio.charset.StandardCharsets
import java.text.ParseException
import java.util.*

fun myParserException(lex: LexicalAnalyzer, expected: String): Nothing =
    throw ParseException(
        "Unexpected token '${lex.curToken.letter}' (expected $expected) at position ${(lex.curPos - 2)}",
        lex.curPos
    )

fun printResult(dirPath: String, fileName: String, inputStream: String? = null) {
    val filePath = "$dirPath${File.separator}$fileName"
    val line = (if (inputStream == null) Scanner(System.`in`) else Scanner(inputStream)).nextLine()
    File(dirPath).mkdir()
    File("$filePath.dot").printWriter().use {
        it.println(treeToDot(Parser(line).parse(), line))
    }
    Runtime.getRuntime().exec("dot -Tpng $filePath.dot -o $filePath.png")
}

/* https://graphs.grevian.org/example */
fun treeToDot(tree: Tree, regex: String): String = buildString {
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