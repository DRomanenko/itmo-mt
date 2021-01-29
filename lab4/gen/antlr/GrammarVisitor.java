// Generated from C:/Users/mrnea/work/itmo-mt/lab4/src/main/java/antlr\Grammar.g4 by ANTLR 4.9.1
package antlr;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link GrammarParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface GrammarVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link GrammarParser#file}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFile(GrammarParser.FileContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarParser#start}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStart(GrammarParser.StartContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarParser#pckg}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPckg(GrammarParser.PckgContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarParser#rulee}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRulee(GrammarParser.RuleeContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarParser#parserRulee}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParserRulee(GrammarParser.ParserRuleeContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarParser#inAttrs}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInAttrs(GrammarParser.InAttrsContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarParser#param}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParam(GrammarParser.ParamContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarParser#paramType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParamType(GrammarParser.ParamTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarParser#paramName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParamName(GrammarParser.ParamNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarParser#outAttr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOutAttr(GrammarParser.OutAttrContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarParser#prods}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProds(GrammarParser.ProdsContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarParser#prod}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProd(GrammarParser.ProdContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarParser#args}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgs(GrammarParser.ArgsContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarParser#arg}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArg(GrammarParser.ArgContext ctx);
	/**
	 * Visit a parse tree produced by the {@code tokenRule}
	 * labeled alternative in {@link GrammarParser#lexerRulee}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTokenRule(GrammarParser.TokenRuleContext ctx);
	/**
	 * Visit a parse tree produced by the {@code skipRule}
	 * labeled alternative in {@link GrammarParser#lexerRulee}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSkipRule(GrammarParser.SkipRuleContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarParser#term_value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTerm_value(GrammarParser.Term_valueContext ctx);
}