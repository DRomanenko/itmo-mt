import antlr.PythonParser
import antlr.PythonBaseListener
import java.util.*

/* https://habr.com/ru/post/346038/ */
class PythonWalker(parser: PythonParser) : PythonBaseListener() {
    val programC: String
    private var balanceTabs = 0
    private val main = StringBuilder()
    private val variables = TreeSet<String>()

    init {
        val header = StringBuilder()
        header.appendLine("#include <stdio.h>\n")
        enterProg(parser.prog())
        if (variables.isNotEmpty()) {
            header.append("int ")
            var counter = 0
            variables.forEach {
                header.append("$it${if (variables.size == ++counter) ";${System.lineSeparator()}${System.lineSeparator()}" else ", "}")
            }
        }
        programC = header.append(main).toString()
    }

    override fun enterProg(ctx: PythonParser.ProgContext) {
        main.appendLine("signed main(void) {")
        balanceTabs++
        ctx.structure().forEach { enterStructure(it) }
        main.append("\t".repeat(balanceTabs))
        main.appendLine("return 0;")
        balanceTabs--
        main.appendLine("}")
    }

    override fun enterStructure(ctx: PythonParser.StructureContext) {
        when {
            ctx.assign() != null -> enterAssign(ctx.assign())
            ctx.control() != null -> enterControl(ctx.control())
        }
    }

    override fun enterStructures(ctx: PythonParser.StructuresContext) {
        ctx.structure().forEach { enterStructure(it) }
    }

    override fun enterAssign(ctx: PythonParser.AssignContext) {
        main.append("\t".repeat(balanceTabs))
        when {
            // NAME ASSIGNMENT INPUT
            ctx.INPUT() != null -> {
                val name = ctx.NAME().text
                main.appendLine("scanf(\"%d\", &$name);")
                variables.add(name)
            }
            // OUTPUT expr
            ctx.OUTPUT() != null -> {
                main.append("printf(\"%d\\n\", ")
                enterExpr(ctx.expr())
                main.appendLine(");")
            }
            // NAME ASSIGNMENT expr
            else -> {
                val name = ctx.NAME().text
                if (!variables.contains(name)) {
                    variables.add(name)
                }
                main.append("$name = ")
                enterExpr(ctx.expr())
                main.appendLine(";")
            }
        }
    }

    override fun enterControl(ctx: PythonParser.ControlContext) {
        main.append("\t".repeat(balanceTabs))
        when {
            ctx.IF() != null -> {
                main.append("if (")
                enterCond(ctx.cond())
                main.appendLine(") {")
                balanceTabs++
                enterStructures(ctx.structures(0))
                balanceTabs--
                main.append("\t".repeat(balanceTabs))
                main.append("}")
                if (ctx.ELSE() != null) {
                    main.appendLine(" else {")
                    balanceTabs++
                    enterStructures(ctx.structures(1))
                    balanceTabs--
                    main.append("\t".repeat(balanceTabs))
                    main.append("}")
                }
                main.appendLine()
            }
        }
    }

    override fun enterExpr(ctx: PythonParser.ExprContext) {
        when {
            ctx.LPAREN() != null && ctx.RPAREN() != null -> {
                main.append("(")
                enterExpr(ctx.expr(0))
                main.append(")")
            }
            ctx.unary_op() != null -> {
                enterUnary_op(ctx.unary_op())
                enterExpr(ctx.expr(0))
            }
            ctx.bin_op() != null -> {
                enterExpr(ctx.expr(0))
                main.append(" ")
                enterBin_op(ctx.bin_op())
                main.append(" ")
                enterExpr(ctx.expr(1))
            }
            ctx.LITERAL() != null -> main.append(ctx.LITERAL().text)
            ctx.NAME() != null -> main.append(ctx.NAME().text)
        }
    }

    override fun enterBin_op(ctx: PythonParser.Bin_opContext) {
        main.append(
            when {
                ctx.PLUS() != null -> ctx.PLUS().text
                ctx.MINUS() != null -> ctx.MINUS().text
                ctx.MUL() != null -> ctx.MUL().text
                else -> ctx.DIV().text
            }
        )
    }

    override fun enterUnary_op(ctx: PythonParser.Unary_opContext) {
        main.append(
            when {
                ctx.PLUS() != null -> ctx.PLUS().text
                else -> ctx.MINUS().text
            }
        )
    }

    override fun enterCond(ctx: PythonParser.CondContext) {
        when {
            ctx.LPAREN() != null && ctx.RPAREN() != null -> {
                main.append("(")
                enterCond(ctx.cond())
                main.append(")")
            }
            ctx.cond_op() != null -> {
                enterExpr(ctx.expr(0))
                main.append(" ")
                enterCond_op(ctx.cond_op())
                main.append(" ")
                enterExpr(ctx.expr(1))
            }
            ctx.LITERAL() != null -> {
                main.append(ctx.LITERAL().text)
            }
            ctx.NAME() != null -> {
                main.append(ctx.NAME().text)
            }
        }
    }

    override fun enterCond_op(ctx: PythonParser.Cond_opContext) {
        main.append(
            when {
                ctx.EQ() != null -> ctx.EQ().text
                ctx.NEQ() != null -> ctx.NEQ().text
                ctx.GT() != null -> ctx.GT().text
                ctx.LT() != null -> ctx.LT().text
                ctx.GEQ() != null -> ctx.GEQ().text
                else -> ctx.LEQ().text
            }
        )
    }
}