package generator

import generator.*
import ParseException
import java.util.*


class ParserGenerator(private val walker: GrammarWalker) : AbstractGenerator() {
    private val first: Map<String, Set<String>> by lazy {
        val fst: MutableMap<String, MutableSet<String>> = mutableMapOf()
        walker.terms.forEach { fst[it] = mutableSetOf(it) }
        walker.trans.forEach { (name, rule) ->
            fst[name] = mutableSetOf()
            if (rule.transitions.any { it.first().name == EPS })
                fst[name]!!.add(EPS)
        }
        var changed = true
        while (changed) {
            changed = false
            walker.trans.forEach { (name, rule) ->
                rule.transitions.forEach { prod ->
                    for (i in prod.indices) {
                        val curNT = prod[i].name
                        if (EPS in fst.getValue(curNT)) {
                            changed = changed || fst.getValue(name).addAll(fst.getValue(curNT))
                            if (i == prod.size - 1)
                                changed = changed || fst.getValue(name).add(EPS)
                        } else {
                            changed = changed || fst.getValue(name).addAll(fst.getValue(curNT))
                            break
                        }
                    }
                }
            }
        }
        return@lazy fst
    }

    private val follow: Map<String, Set<String>> by lazy {
        val flw: MutableMap<String, MutableSet<String>> = mutableMapOf()
        walker.nonTerms.forEach { flw[it] = mutableSetOf() }
        flw.getValue(walker.startNT).add(EOF)
        var changed = true
        while (changed) {
            changed = false
            for ((name, rule) in walker.trans) {
                rule.transitions.forEach { prod ->
                    (0..prod.size - 2)
                        .filter { prod[it] is Transition.NonTerm }
                        .forEach { i ->
                            changed = changed || flw.getValue(prod[i].name).addAll(
                                first.getValue(prod[i + 1].name).filter {
                                    it != EPS
                                }
                            )
                        }
                    if (prod.last() is Transition.NonTerm)
                        changed = changed || flw.getValue(prod.last().name).addAll(flw.getValue(name))
                    if (prod.size > 1 && EPS in first.getValue(prod.last().name)) {
                        val prelast = prod[prod.size - 2]
                        if (prelast is Transition.NonTerm)
                            changed = changed || flw.getValue(prelast.name).addAll(flw.getValue(name))
                    }
                }
            }
        }
        return@lazy flw
    }

    private fun checkLL1(notTermName: String, assignments: Assignments) {
        for (i in assignments.transitions.indices) {
            for (q in assignments.transitions.indices) {
                if (i != q) {
                    val n = assignments.transitions[i][0].name
                    var chooseFollow = false
                    val a = when {
                        first.getValue(assignments.transitions[i][0].name).contains(EPS) -> {
                            chooseFollow = true
                            follow.getValue(notTermName)
                        }
                        else -> first.getValue(assignments.transitions[i][0].name)
                    }
                    val b = first.getValue(assignments.transitions[q][0].name)

                    val intersect = a.intersect(b)
                    if (intersect.isNotEmpty()) {
                        val aName = if (chooseFollow) "follow(${notTermName})"
                        else "first(${assignments.transitions[i][0].name})"
                        val bName = "first(${assignments.transitions[q][0].name})"
                        throw ParseException(
                            "This grammar is not LL(1): ${aName} ⋂ ${bName} = ${intersect}\n" +
                                    "1. ${assignments.transitions[i]},\n2. ${assignments.transitions[q]}"
                        )
                    }
                }
            }
        }
    }

    override fun generate(grammarName: String) = buildString {
        val gn = grammarName.capitalize()

        walker.pckg?.let {
            printLine("package $it")
            LINESEPARATOR
        }
        printLine("import Token")
        printLine("import ParseException")
        printLine("import Tree")
        LINESEPARATOR
        printLine("class ${gn}Parser(private val lexer: ${gn}Lexer) {")
        LINESEPARATOR
        balance {
            printLine("private fun skip(token: Token): String {")
            balance {
                printLine("if (lexer.token != token) throw ParseException.expectedNotFound(lexer, token)")
                printLine("val res = lexer.tokenValue ?: throw IllegalArgumentException(\"Cannot skip EOF token\")")
                printLine("lexer.next()")
                printLine("return res")
            }
            printLine("}")
            LINESEPARATOR
            for ((name, assignment) in walker.trans) {
                printLine(
                    "private fun ${name.capitalize()}(${assignment.checkArgs()}) : ${assignment.returnType ?: "Unit"} = when(lexer.token) {"
                )
                checkLL1(name, assignment)
                val m = checkTransitions(name, assignment)
                balance { ->
                    for ((prod, tokens) in m) {
                        printLine("${tokens.joinToString { "TOKENS.$it" }} -> {")
                        balance {
                            val lst = listable(prod)
                            lst.forEach { (e, _) ->
                                when (e) {
                                    in walker.terms -> printLine("val $e : MutableList<String> = mutableListOf()")
                                    in walker.nonTerms -> {
                                        val returnType = walker.trans[e]!!.returnType
                                        if (returnType != null)
                                            printLine("val $e : MutableList<$returnType> = mutableListOf()")
                                    }
                                }
                            }
                            products@ for (exElem in prod.gens) {
                                when (exElem) {
                                    is Gen.Casual -> {
                                        when (val elem = exElem.elem) {
                                            is Transition.Term -> {
                                                if (elem.name == EPS) continue@products
                                                if (elem.name in lst)
                                                    printLine("${elem.name}.add(skip(TOKENS.${elem.name}))")
                                                else
                                                    printLine("val ${elem.name} = skip(TOKENS.${elem.name})")
                                            }
                                            is Transition.NonTerm -> {
                                                val callAttrs = elem.callAttrs?.joinToString().orEmpty()
                                                if (elem.name in lst)
                                                    printLine("${elem.name}.add(${elem.name.capitalize()}($callAttrs))")
                                                else
                                                    printLine("val ${elem.name} = ${elem.name.capitalize()}($callAttrs)")
                                            }
                                        }
                                    }
                                    is Gen.Code -> printLine(exElem.code)
                                }
                            }
                        }
                        printLine("}")
                    }
                    printLine(
                        "else -> throw ParseException.expectedNotFound(lexer, ${
                            m.values.flatten().joinToString { "TOKENS.$it" }
                        })"
                    )
                }
                printLine("}")
                LINESEPARATOR
            }
            val startRule = walker.trans.getValue(walker.startNT)

            printLine("fun parse(${startRule.checkArgs()}) : ${startRule.returnType ?: "Unit"} { ")
            balance {
                printLine("lexer.next()")
                printLine(
                    "return ${walker.startNT.capitalize()}(${
                        startRule.args?.joinToString { (a, _) -> a }.orEmpty()
                    })"
                )
            }
            printLine("}")
        }
        printLine("}")
    }

    private fun checkTransitions(name: String, assignments: Assignments) =
        assignments.transitions.associate { transitions ->
            when (transitions[0].name) {
                EPS -> {
                    transitions to follow.getValue(name).toList()
                }
                else -> transitions to first.getValue(transitions[0].name).toList()
            }
        }.also {
            it.values.flatten().also { curr ->
                val v1 = curr
                val v2 = curr.distinct()
                if (curr.size != curr.distinct().size) {
                    throw ParseException("This grammar is not LL(1): $v1 ⋂ $v2")
                }
            }
        }

    private fun listable(transitions: Transitions) =
        transitions.groupingBy { it.name }.eachCount().filterValues { i -> i > 1 }
}