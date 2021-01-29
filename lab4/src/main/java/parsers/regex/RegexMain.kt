package parsers.regex

import printResult

fun main(args: Array<String>) {
	println(RegexParser(RegexLexer(args[0].reader())).parse())
}

