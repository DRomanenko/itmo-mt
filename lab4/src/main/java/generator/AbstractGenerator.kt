package generator

abstract class AbstractGenerator {

    protected var indent = 0

    protected inline fun balance(block: () -> Unit) {
        indent++
        block()
        indent--
    }

    protected fun StringBuilder.printLine(line: String) {
        append("\t".repeat(indent))
        appendLine(line)
    }

    protected val StringBuilder.LINESEPARATOR: Unit
        get() {
            appendLine()
            Unit
        }

    protected fun StringBuilder.pop() {
        for (i in (length - 1) downTo -1)
            if (i < 0 || !this[i].isWhitespace()) {
                if (i >= 0) deleteCharAt(i)
                break
            }
    }

    abstract fun generate(grammarName: String): String
}