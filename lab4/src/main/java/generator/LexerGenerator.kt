package generator

import escape
import Token

class LexerGenerator(private val walker: GrammarWalker) : AbstractGenerator() {
    private val tokensToSkip: Set<Token>
        get() = walker._tokensToSkip

    private val literals: Map<Token, String>
        get() = walker._literals

    private val patterns: Map<Token, Regex>
        get() = walker._patterns

    private val tokenTable: Map<String, Token>
        get() = walker._tokenTable

    override fun generate(grammarName: String) = buildString {
        walker.pckg?.let {
            printLine("package $it")
            LINESEPARATOR
        }
        printLine("import java.io.Reader")
        printLine("import Token")
        printLine("import GroupMatcherLexer")
        LINESEPARATOR
        printLine("private val _literals: Map<Token, String> = mapOf(")
        balance { literals.forEach { (t, s) -> printLine("$t to \"${s.escape()}\",") } }
        pop()
        printLine(")")
        LINESEPARATOR
        printLine("private val _patterns: Map<Token, Regex> = mapOf(")
        balance { patterns.forEach { (t, r) -> printLine("$t to Regex(\"${r.toString().escape()}\"),") } }
        pop()
        printLine(")")
        LINESEPARATOR
        printLine("private val _tokensToSkip = setOf(${tokensToSkip.joinToString()})")
        LINESEPARATOR
        printLine("object TOKENS {")
        balance { (tokenTable - tokensToSkip).forEach { (t, i) -> printLine("val $t = $i") } }
        printLine("}")
        LINESEPARATOR
        printLine("class ${grammarName.capitalize()}Lexer(reader: Reader)")
        balance { printLine(": GroupMatcherLexer(reader, _literals, _patterns, _tokensToSkip, TOKENS.EOF)") }
    }
}