package parsers.shortbad

import java.io.Reader
import Token
import GroupMatcherLexer

private val _literals: Map<Token, String> = mapOf(
	0 to "+",
	1 to ""
)

private val _patterns: Map<Token, Regex> = mapOf(
	2 to Regex("\\s+")
)

private val _tokensToSkip = setOf(2)

object TOKENS {
	val PLUS = 0
	val EPS = 1
	val WHITESPACES = 2
	val EOF = -1
}

class ShortbadLexer(reader: Reader)
	: GroupMatcherLexer(reader, _literals, _patterns, _tokensToSkip, TOKENS.EOF)

