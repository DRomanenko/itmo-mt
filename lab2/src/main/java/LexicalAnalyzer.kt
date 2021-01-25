import java.io.IOException
import java.io.InputStream
import java.text.ParseException
import Token.Type.*

class LexicalAnalyzer(private val `is`: InputStream) {
    var curChar: Int = 0
        private set
    var predChar: Char = '0'
        private set
    var curPos: Int = 0
        private set
    var curToken: Token = Token(OTHERWISE)
        private set

    init {
        nextChar()
    }

    private fun isBlank(c: Int): Boolean {
        return Character.isWhitespace(c)
    }

    private fun nextChar() {
        curPos++
        predChar = curChar.toChar()
        curChar = try {
            `is`.read()
        } catch (e: IOException) {
            throw ParseException(e.message, curPos)
        }
    }

    fun nextToken() {
        while (isBlank(curChar)) {
            nextChar()
        }

        curToken = if (curChar == -1) Token(END, predChar) else when (curChar.toChar()) {
            '|' -> {
                nextChar()
                Token(SELECT, predChar)
            }
            '*' -> {
                nextChar()
                Token(KLEENE, predChar)
            }
            '(' -> {
                nextChar()
                Token(LPAREN, predChar)
            }
            ')' -> {
                nextChar()
                Token(RPAREN, predChar)
            }
            in 'a'..'z' -> {
                nextChar()
                Token(LETTER, predChar)
            }
            else -> throw ParseException("Illegal char: ${curChar.toChar()}", curPos)
        }
    }
}