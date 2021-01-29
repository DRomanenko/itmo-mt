import java.io.ByteArrayInputStream
import java.nio.charset.StandardCharsets
import Token.Type.*


class Parser(line: String) {
    private val lex = LexicalAnalyzer(ByteArrayInputStream(line.toByteArray(StandardCharsets.UTF_8)))

    private fun S() = Tree("S", listOf(C(), `S'`()))

    private fun `S'`(): Tree = when (lex.curToken.type) {
        SELECT -> {
            lex.nextToken()
            Tree("S'", listOf(Tree("|"), C(), `S'`()))
        }
        else -> Tree("Ɛ")
    }

    private fun C() = Tree("C", listOf(K(), `C'`()))

    private fun `C'`(): Tree = when (lex.curToken.type) {
        LPAREN, LETTER -> Tree("C'", listOf(K(), `C'`()))
        else -> Tree("Ɛ")
    }

    private fun K() = Tree("R", listOf(R(), `K'`()))

    private fun `K'`(): Tree = when (lex.curToken.type) {
        KLEENE -> {
            lex.nextToken()
            Tree("K'", listOf(Tree("*")))
        }
        else -> Tree("Ɛ")
    }

    private fun R(): Tree = when (lex.curToken.type) {
        LPAREN -> {
            lex.nextToken()
            val sub = S()
            if (lex.curToken.type !== RPAREN)
                myParserException(lex, "')'")
            lex.nextToken()
            Tree("R", listOf(Tree("("), sub, Tree(")")))
        }
        LETTER -> {
            val save = lex.curToken.letter.toString()
            lex.nextToken()
            Tree(save)
        }
        else -> myParserException(lex, "'(' or 'a..z'")
    }

    fun parse(): Tree {
        lex.nextToken()
        val res = S()
        if (lex.curToken.type != END)
            myParserException(lex, "EOF")
        return res
    }
}