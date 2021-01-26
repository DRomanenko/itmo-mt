// Generated from C:/Users/mrnea/IdeaProjects/itmo-mt/lab3/src/main/java/antlr\Python.g4 by ANTLR 4.9.1
package antlr;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link PythonParser}.
 */
public interface PythonListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link PythonParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProg(PythonParser.ProgContext ctx);
	/**
	 * Exit a parse tree produced by {@link PythonParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProg(PythonParser.ProgContext ctx);
	/**
	 * Enter a parse tree produced by {@link PythonParser#structure}.
	 * @param ctx the parse tree
	 */
	void enterStructure(PythonParser.StructureContext ctx);
	/**
	 * Exit a parse tree produced by {@link PythonParser#structure}.
	 * @param ctx the parse tree
	 */
	void exitStructure(PythonParser.StructureContext ctx);
	/**
	 * Enter a parse tree produced by {@link PythonParser#structures}.
	 * @param ctx the parse tree
	 */
	void enterStructures(PythonParser.StructuresContext ctx);
	/**
	 * Exit a parse tree produced by {@link PythonParser#structures}.
	 * @param ctx the parse tree
	 */
	void exitStructures(PythonParser.StructuresContext ctx);
	/**
	 * Enter a parse tree produced by {@link PythonParser#assign}.
	 * @param ctx the parse tree
	 */
	void enterAssign(PythonParser.AssignContext ctx);
	/**
	 * Exit a parse tree produced by {@link PythonParser#assign}.
	 * @param ctx the parse tree
	 */
	void exitAssign(PythonParser.AssignContext ctx);
	/**
	 * Enter a parse tree produced by {@link PythonParser#control}.
	 * @param ctx the parse tree
	 */
	void enterControl(PythonParser.ControlContext ctx);
	/**
	 * Exit a parse tree produced by {@link PythonParser#control}.
	 * @param ctx the parse tree
	 */
	void exitControl(PythonParser.ControlContext ctx);
	/**
	 * Enter a parse tree produced by {@link PythonParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(PythonParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link PythonParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(PythonParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link PythonParser#bin_op}.
	 * @param ctx the parse tree
	 */
	void enterBin_op(PythonParser.Bin_opContext ctx);
	/**
	 * Exit a parse tree produced by {@link PythonParser#bin_op}.
	 * @param ctx the parse tree
	 */
	void exitBin_op(PythonParser.Bin_opContext ctx);
	/**
	 * Enter a parse tree produced by {@link PythonParser#unary_op}.
	 * @param ctx the parse tree
	 */
	void enterUnary_op(PythonParser.Unary_opContext ctx);
	/**
	 * Exit a parse tree produced by {@link PythonParser#unary_op}.
	 * @param ctx the parse tree
	 */
	void exitUnary_op(PythonParser.Unary_opContext ctx);
	/**
	 * Enter a parse tree produced by {@link PythonParser#cond}.
	 * @param ctx the parse tree
	 */
	void enterCond(PythonParser.CondContext ctx);
	/**
	 * Exit a parse tree produced by {@link PythonParser#cond}.
	 * @param ctx the parse tree
	 */
	void exitCond(PythonParser.CondContext ctx);
	/**
	 * Enter a parse tree produced by {@link PythonParser#cond_op}.
	 * @param ctx the parse tree
	 */
	void enterCond_op(PythonParser.Cond_opContext ctx);
	/**
	 * Exit a parse tree produced by {@link PythonParser#cond_op}.
	 * @param ctx the parse tree
	 */
	void exitCond_op(PythonParser.Cond_opContext ctx);
	/**
	 * Enter a parse tree produced by {@link PythonParser#tabs}.
	 * @param ctx the parse tree
	 */
	void enterTabs(PythonParser.TabsContext ctx);
	/**
	 * Exit a parse tree produced by {@link PythonParser#tabs}.
	 * @param ctx the parse tree
	 */
	void exitTabs(PythonParser.TabsContext ctx);
}