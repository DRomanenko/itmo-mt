package task2

import java.io.Reader
import Token
import GroupMatcherLexer

private val _literals: Map<Token, String> = mapOf(
	0 to "*",
	1 to "|",
	2 to "(",
	3 to ")"
)

private val _patterns: Map<Token, Regex> = mapOf(
	4 to Regex("[a-z]+"),
	5 to Regex("\\s+")
)

private val _tokensToSkip = setOf(5)

object TOKENS {
	val KLEENE = 0
	val SELECT = 1
	val LPAREN = 2
	val RPAREN = 3
	val LETTER = 4
	val WHITESPACES = 5
	val EOF = -1
}

class RegexLexer(reader: Reader)
	: GroupMatcherLexer(reader, _literals, _patterns, _tokensToSkip, TOKENS.EOF)

