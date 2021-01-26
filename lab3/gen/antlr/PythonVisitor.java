// Generated from C:/Users/mrnea/IdeaProjects/itmo-mt/lab3/src/main/java/antlr\Python.g4 by ANTLR 4.9.1
package antlr;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link PythonParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface PythonVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link PythonParser#prog}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProg(PythonParser.ProgContext ctx);
	/**
	 * Visit a parse tree produced by {@link PythonParser#structure}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStructure(PythonParser.StructureContext ctx);
	/**
	 * Visit a parse tree produced by {@link PythonParser#structures}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStructures(PythonParser.StructuresContext ctx);
	/**
	 * Visit a parse tree produced by {@link PythonParser#assign}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssign(PythonParser.AssignContext ctx);
	/**
	 * Visit a parse tree produced by {@link PythonParser#control}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitControl(PythonParser.ControlContext ctx);
	/**
	 * Visit a parse tree produced by {@link PythonParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr(PythonParser.ExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link PythonParser#bin_op}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBin_op(PythonParser.Bin_opContext ctx);
	/**
	 * Visit a parse tree produced by {@link PythonParser#unary_op}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnary_op(PythonParser.Unary_opContext ctx);
	/**
	 * Visit a parse tree produced by {@link PythonParser#cond}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCond(PythonParser.CondContext ctx);
	/**
	 * Visit a parse tree produced by {@link PythonParser#cond_op}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCond_op(PythonParser.Cond_opContext ctx);
	/**
	 * Visit a parse tree produced by {@link PythonParser#tabs}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTabs(PythonParser.TabsContext ctx);
}