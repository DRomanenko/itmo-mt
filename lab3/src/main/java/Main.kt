import antlr.PythonLexer
import antlr.PythonParser
import org.antlr.v4.runtime.CharStreams
import org.antlr.v4.runtime.CommonTokenStream
import java.io.File
import java.nio.file.Files
import java.nio.file.Path
import java.util.stream.Collectors

object Main {
    @JvmStatic
    fun main(args: Array<String>) {
        val s = File.separator
        val testRoot = "src${s}test${s}java"
        val ansRoot = "src${s}main${s}resources${s}"
        Files.walk(Path.of(testRoot))
            .filter(Files::isRegularFile)
            .collect(Collectors.toList()).forEach {
                val testName = it.fileName.toString()
                val ansName = testName.replace(".py", ".c")
                val lexer = PythonLexer(CharStreams.fromFileName("$testRoot$s$testName"))
                val tokens = CommonTokenStream(lexer)
                val parser = PythonParser(tokens)
                val walker = PythonWalker(parser)
                File("$ansRoot$s$ansName").printWriter().use {
                    it.println(walker.programC)
                }
            }
    }
}