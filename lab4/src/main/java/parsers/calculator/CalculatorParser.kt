package parsers.calculator

import Token
import ParseException
import Tree

class CalculatorParser(private val lexer: CalculatorLexer) {

	private fun skip(token: Token): String {
		if (lexer.token != token) throw ParseException.expectedNotFound(lexer, token)
		val res = lexer.tokenValue ?: throw IllegalArgumentException("Cannot skip EOF token")
		lexer.next()
		return res
	}

	private fun Pm() : Int = when(lexer.token) {
		TOKENS.LPAREN, TOKENS.NUM -> {
			val md = Md()
			val pms = Pms(md)
			pms
		}
		else -> throw ParseException.expectedNotFound(lexer, TOKENS.LPAREN, TOKENS.NUM)
	}

	private fun Pms(acc: Int) : Int = when(lexer.token) {
		TOKENS.PLUS -> {
			val PLUS = skip(TOKENS.PLUS)
			val md = Md()
			val next = acc + md
			val pms = Pms(next)
			pms
		}
		TOKENS.MINUS -> {
			val MINUS = skip(TOKENS.MINUS)
			val md = Md()
			val next = acc - md
			val pms = Pms(next)
			pms
		}
		TOKENS.EOF, TOKENS.RPAREN -> {
			acc
		}
		else -> throw ParseException.expectedNotFound(lexer, TOKENS.PLUS, TOKENS.MINUS, TOKENS.EOF, TOKENS.RPAREN)
	}

	private fun Md() : Int = when(lexer.token) {
		TOKENS.LPAREN, TOKENS.NUM -> {
			val shift = Shift()
			val mds = Mds(shift)
			mds
		}
		else -> throw ParseException.expectedNotFound(lexer, TOKENS.LPAREN, TOKENS.NUM)
	}

	private fun Mds(acc: Int) : Int = when(lexer.token) {
		TOKENS.MUL -> {
			val MUL = skip(TOKENS.MUL)
			val shift = Shift()
			val mds = Mds(acc * shift)
			mds
		}
		TOKENS.DIV -> {
			val DIV = skip(TOKENS.DIV)
			val shift = Shift()
			val mds = Mds(acc / shift)
			mds
		}
		TOKENS.PLUS, TOKENS.MINUS, TOKENS.EOF, TOKENS.RPAREN -> {
			acc
		}
		else -> throw ParseException.expectedNotFound(lexer, TOKENS.MUL, TOKENS.DIV, TOKENS.PLUS, TOKENS.MINUS, TOKENS.EOF, TOKENS.RPAREN)
	}

	private fun Shift() : Int = when(lexer.token) {
		TOKENS.LPAREN, TOKENS.NUM -> {
			val atom = Atom()
			val shifts = Shifts(atom)
			shifts
		}
		else -> throw ParseException.expectedNotFound(lexer, TOKENS.LPAREN, TOKENS.NUM)
	}

	private fun Shifts(acc: Int) : Int = when(lexer.token) {
		TOKENS.LSHIFT -> {
			val LSHIFT = skip(TOKENS.LSHIFT)
			val atom = Atom()
			val shifts = Shifts(acc shl atom)
			shifts
		}
		TOKENS.RSHIFT -> {
			val RSHIFT = skip(TOKENS.RSHIFT)
			val atom = Atom()
			val shifts = Shifts(acc ushr atom)
			shifts
		}
		TOKENS.MUL, TOKENS.DIV, TOKENS.PLUS, TOKENS.MINUS, TOKENS.EOF, TOKENS.RPAREN -> {
			acc
		}
		else -> throw ParseException.expectedNotFound(lexer, TOKENS.LSHIFT, TOKENS.RSHIFT, TOKENS.MUL, TOKENS.DIV, TOKENS.PLUS, TOKENS.MINUS, TOKENS.EOF, TOKENS.RPAREN)
	}

	private fun Atom() : Int = when(lexer.token) {
		TOKENS.LPAREN -> {
			val LPAREN = skip(TOKENS.LPAREN)
			val pm = Pm()
			val RPAREN = skip(TOKENS.RPAREN)
			pm
		}
		TOKENS.NUM -> {
			val num = Num()
			num
		}
		else -> throw ParseException.expectedNotFound(lexer, TOKENS.LPAREN, TOKENS.NUM)
	}

	private fun Num() : Int = when(lexer.token) {
		TOKENS.NUM -> {
			val NUM = skip(TOKENS.NUM)
			NUM.toInt()
		}
		else -> throw ParseException.expectedNotFound(lexer, TOKENS.NUM)
	}

	fun parse() : Int { 
		lexer.next()
		return Pm()
	}
}

