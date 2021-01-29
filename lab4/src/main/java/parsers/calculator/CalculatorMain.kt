package parsers.calculator

import printResult

fun main(args: Array<String>) {
	println(CalculatorParser(CalculatorLexer(args[0].reader())).parse())
}

