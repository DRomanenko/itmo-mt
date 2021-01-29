package generator

class MainGenerator(private val walker: GrammarWalker) : AbstractGenerator() {
    override fun generate(grammarName: String) = buildString {
        val gn = grammarName.capitalize()
        walker.pckg?.let {
            printLine("package $it")
            LINESEPARATOR
        }
        printLine("import printResult")
        LINESEPARATOR
        printLine("fun main(args: Array<String>) {")
        balance { printLine("println(${gn}Parser(${gn}Lexer(args[0].reader())).parse())") }
        printLine("}")
    }
}