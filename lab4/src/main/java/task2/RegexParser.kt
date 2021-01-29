package task2

import Token
import ParseException
import Tree

class RegexParser(private val lexer: RegexLexer) {

	private fun skip(token: Token): String {
		if (lexer.token != token) throw ParseException.expectedNotFound(lexer, token)
		val res = lexer.tokenValue ?: throw IllegalArgumentException("Cannot skip EOF token")
		lexer.next()
		return res
	}

	private fun S() : Tree = when(lexer.token) {
		TOKENS.KLEENE, TOKENS.SELECT, TOKENS.LPAREN, TOKENS.RPAREN, TOKENS.LETTER -> {
			val c = C()
			val s1 = S1()
			Tree("S", listOf(c, s1))
		}
		else -> throw ParseException.expectedNotFound(lexer, TOKENS.KLEENE, TOKENS.SELECT, TOKENS.LPAREN, TOKENS.RPAREN, TOKENS.LETTER)
	}

	private fun S1() : Tree = when(lexer.token) {
		TOKENS.SELECT -> {
			val SELECT = skip(TOKENS.SELECT)
			val c = C()
			val s1 = S1()
			Tree("S'", listOf(Tree("|"), c, s1))
		}
		/*TOKENS.KLEENE -> {
			Tree("Ɛ")
		}
		TOKENS.LPAREN -> {
			Tree("Ɛ")
		}
		TOKENS.RPAREN -> {
			Tree("Ɛ")
		}
		TOKENS.LETTER -> {
			Tree("Ɛ")
		}*/
		else -> Tree("Ɛ")
	}

	private fun C() : Tree = when(lexer.token) {
		TOKENS.KLEENE, TOKENS.SELECT, TOKENS.LPAREN, TOKENS.RPAREN, TOKENS.LETTER -> {
			val k = K()
			val c1 = C1()
			Tree("C", listOf(k, c1))
		}
		else -> throw ParseException.expectedNotFound(lexer, TOKENS.KLEENE, TOKENS.SELECT, TOKENS.LPAREN, TOKENS.RPAREN, TOKENS.LETTER)
	}

	private fun C1() : Tree = when(lexer.token) {
		TOKENS.LPAREN -> {
			val k = K()
			val c1 = C1()
			Tree("C", listOf(k, c1))
		}
/*		TOKENS.LETTER -> {
			val k = K()
			val c1 = C1()
			Tree("C", listOf(k, c1))
		}
		TOKENS.KLEENE -> {
			Tree("Ɛ")
		}
		TOKENS.SELECT -> {
			Tree("Ɛ")
		}
		TOKENS.RPAREN -> {
			Tree("Ɛ")
		}*/
        else -> Tree("Ɛ")
	}

	private fun K() : Tree = when(lexer.token) {
		TOKENS.KLEENE -> {
			val r = R()
			val k1 = K1()
			Tree("R", listOf(r, k1))
		}
		TOKENS.SELECT -> {
			val r = R()
			val k1 = K1()
			Tree("R", listOf(r, k1))
		}
		TOKENS.LPAREN -> {
			val r = R()
			val k1 = K1()
			Tree("R", listOf(r, k1))
		}
		TOKENS.RPAREN -> {
			val r = R()
			val k1 = K1()
			Tree("R", listOf(r, k1))
		}
		TOKENS.LETTER -> {
			val r = R()
			val k1 = K1()
			Tree("R", listOf(r, k1))
		}
		else -> throw ParseException.expectedNotFound(lexer, TOKENS.KLEENE, TOKENS.SELECT, TOKENS.LPAREN, TOKENS.RPAREN, TOKENS.LETTER)
	}

	private fun K1() : Tree = when(lexer.token) {
		TOKENS.KLEENE -> {
			val KLEENE = skip(TOKENS.KLEENE)
			val k1 = K1()
			Tree("*", listOf(Tree("*"), k1))
		}
/*		TOKENS.SELECT -> {
			Tree("Ɛ")
		}
		TOKENS.LPAREN -> {
			Tree("Ɛ")
		}
		TOKENS.RPAREN -> {
			Tree("Ɛ")
		}
		TOKENS.LETTER -> {
			Tree("Ɛ")
		}*/
		else -> Tree("Ɛ")
	}

	private fun R() : Tree = when(lexer.token) {
		TOKENS.LPAREN -> {
			val LPAREN = skip(TOKENS.LPAREN)
			val s = S()
            val RPAREN = skip(TOKENS.RPAREN)
			Tree("R", listOf(Tree("("), s, Tree(")")))
		}
		TOKENS.LETTER -> {
			val LETTER = skip(TOKENS.LETTER)
			Tree(LETTER)
		}
		else -> throw ParseException.expectedNotFound(lexer, TOKENS.LPAREN, TOKENS.LETTER)
	}

	fun parse() : Tree { 
		lexer.next()
		return S()
	}
}

