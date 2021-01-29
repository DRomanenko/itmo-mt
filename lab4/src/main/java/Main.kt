import org.antlr.v4.runtime.CharStreams
import org.antlr.v4.runtime.CommonTokenStream
import org.antlr.v4.runtime.tree.ParseTreeWalker
import antlr.GrammarLexer
import antlr.GrammarParser
import generator.GrammarWalker
import generator.LexerGenerator
import generator.ParserGenerator
import generator.MainGenerator
import java.io.File
import java.nio.file.Files
import java.nio.file.Path
import java.util.stream.Collectors

/* https://habr.com/ru/post/341138/ */
object Main {
    @JvmStatic
    fun main(args: Array<String>) {
        val s = File.separator
        val testRoot = "src${s}test${s}java"
        val ansRoot = "src${s}main${s}java${s}parsers"
        File(ansRoot).mkdir()
        Files.walk(Path.of(testRoot))
            .filter(Files::isRegularFile)
            .collect(Collectors.toList()).forEach {
                val testName = it.fileName.toString()
                val ansDirName = testName.replace(".g", "")
                val collector = GrammarWalker()
                val lexer = GrammarLexer(CharStreams.fromFileName("$testRoot$s$testName"))
                val parser = GrammarParser(CommonTokenStream(lexer))
                val walker = ParseTreeWalker()
                walker.walk(collector, parser.file())
                val lexerImpl = LexerGenerator(collector) to "Lexer"
                val parserImpl = ParserGenerator(collector) to "Parser"
                val mainImpl = MainGenerator(collector) to "Main"
                listOf(lexerImpl, parserImpl, mainImpl).forEach { (generator, postfix) ->
                    File("$ansRoot$s$ansDirName").mkdir()
                    val ansFileName = ansDirName[0].toUpperCase() + ansDirName.substring(1)
                    File("$ansRoot$s$ansDirName$s$ansFileName$postfix.kt").printWriter().use {
                        it.println(generator.generate(ansFileName))
                    }
                }
            }
    }
}