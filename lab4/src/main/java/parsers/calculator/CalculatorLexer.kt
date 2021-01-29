package parsers.calculator

import java.io.Reader
import Token
import GroupMatcherLexer

private val _literals: Map<Token, String> = mapOf(
	0 to "+",
	1 to "-",
	2 to "*",
	3 to "/",
	4 to "<<",
	5 to ">>",
	6 to "(",
	7 to ")"
)

private val _patterns: Map<Token, Regex> = mapOf(
	8 to Regex("[0-9]+"),
	9 to Regex("\\s+")
)

private val _tokensToSkip = setOf(9)

object TOKENS {
	val PLUS = 0
	val MINUS = 1
	val MUL = 2
	val DIV = 3
	val LSHIFT = 4
	val RSHIFT = 5
	val LPAREN = 6
	val RPAREN = 7
	val NUM = 8
	val WHITESPACES = 9
	val EOF = -1
}

class CalculatorLexer(reader: Reader)
	: GroupMatcherLexer(reader, _literals, _patterns, _tokensToSkip, TOKENS.EOF)

