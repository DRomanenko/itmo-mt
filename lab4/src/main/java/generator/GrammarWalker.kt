package generator

import Token
import antlr.GrammarBaseListener
import antlr.GrammarParser
import cleanUpCode

const val EPS = "EPS"
const val EOF = "EOF"

class GrammarWalker : GrammarBaseListener() {
    private var tokenCnt = 0

    val _tokenTable: MutableMap<String, Token> = LinkedHashMap()
    val terms: Set<String>
        get() = if (hasEPSprods) _tokenTable.keys + EPS else _tokenTable.keys

    val _patterns: MutableMap<Token, Regex> = HashMap()
    val _literals: MutableMap<Token, String> = HashMap()
    val _tokensToSkip: MutableSet<Token> = HashSet()

    val trans: MutableMap<String, Assignments> = LinkedHashMap()

    private var hasEPSprods = false
    val nonTerms: Set<String>
        get() = trans.keys

    var pckg: String? = null
    lateinit var startNT: String

    // Package
    override fun exitPckg(ctx: GrammarParser.PckgContext) {
        pckg = ctx.text.removePrefix("+p").cleanUpCode()
    }

    // Parser
    override fun exitStart(ctx: GrammarParser.StartContext) {
        startNT = ctx.NON_TERM().text
    }

    override fun exitParserRulee(ctx: GrammarParser.ParserRuleeContext) {
        val curRule = trans.getOrPut(ctx.NON_TERM().text, { Assignments(ctx.NON_TERM().text) })

        if (ctx.outAttr() != null)
            curRule.returnType = ctx.outAttr().text
        if (ctx.inAttrs() != null)
            curRule.args = ctx.inAttrs().param().map { it.paramName().text to it.paramType().text }

        curRule.transitions = ctx.prods().map { prodsCtx ->
            var prod = if (prodsCtx.prod().isEmpty()) {
                hasEPSprods = true
                listOf(Gen.Casual(Transition.Term(EPS)))
            } else
                prodsCtx.prod().map { prodCtx ->
                    if (prodCtx.NON_TERM() != null) {
                        Gen.Casual(
                            Transition.NonTerm(
                            prodCtx.NON_TERM().text,
                            prodCtx.args()?.arg()?.map { it.text.cleanUpCode() }
                        ))
                    } else if (prodCtx.TERM() != null) {
                        Gen.Casual(Transition.Term(prodCtx.TERM().text))
                    } else {
                        Gen.Code(prodCtx.CODE().text.cleanUpCode())
                    }
                }
            var elems = prod.filterIsInstance<Gen.Casual>()
            if (elems.isEmpty()) {
                hasEPSprods = true
                elems = listOf(Gen.Casual(Transition.Term(EPS)))
                prod = elems + prod
            }
            Transitions(elems.map { it.elem }, prod)
        }
    }

    // Lexer
    override fun exitTokenRule(ctx: GrammarParser.TokenRuleContext) {
        fillMap(ctx.TERM().text, ctx.term_value(), false)
    }

    override fun exitSkipRule(ctx: GrammarParser.SkipRuleContext) {
        fillMap(ctx.TERM().text, ctx.term_value(), true)
    }

    override fun exitFile(ctx: GrammarParser.FileContext?) {
        _tokenTable[EOF] = -1
    }

    private fun fillMap(token: String, right: GrammarParser.Term_valueContext, skip: Boolean) {
        val token_id = _tokenTable.getOrPut(token, { tokenCnt++ })
        if (right.STRING() != null) {
            _literals[token_id] = right.STRING().text.trim('\"')
        } else {
            _patterns[token_id] = Regex(right.REGEX().text.trim('\''))
        }
        if (skip) {
            _tokensToSkip.add(token_id)
        }
    }
}