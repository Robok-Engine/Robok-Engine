package org.robok.easyui.antlr4;

// Generated from GUI.g4 by ANTLR 4.13.2

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link GUIParser}.
 */
public interface GUIListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link GUIParser#guiFile}.
	 * @param ctx the parse tree
	 */
	void enterGuiFile(GUIParser.GuiFileContext ctx);
	/**
	 * Exit a parse tree produced by {@link GUIParser#guiFile}.
	 * @param ctx the parse tree
	 */
	void exitGuiFile(GUIParser.GuiFileContext ctx);
	/**
	 * Enter a parse tree produced by {@link GUIParser#component}.
	 * @param ctx the parse tree
	 */
	void enterComponent(GUIParser.ComponentContext ctx);
	/**
	 * Exit a parse tree produced by {@link GUIParser#component}.
	 * @param ctx the parse tree
	 */
	void exitComponent(GUIParser.ComponentContext ctx);
	/**
	 * Enter a parse tree produced by {@link GUIParser#argumentList}.
	 * @param ctx the parse tree
	 */
	void enterArgumentList(GUIParser.ArgumentListContext ctx);
	/**
	 * Exit a parse tree produced by {@link GUIParser#argumentList}.
	 * @param ctx the parse tree
	 */
	void exitArgumentList(GUIParser.ArgumentListContext ctx);
	/**
	 * Enter a parse tree produced by {@link GUIParser#argument}.
	 * @param ctx the parse tree
	 */
	void enterArgument(GUIParser.ArgumentContext ctx);
	/**
	 * Exit a parse tree produced by {@link GUIParser#argument}.
	 * @param ctx the parse tree
	 */
	void exitArgument(GUIParser.ArgumentContext ctx);
	/**
	 * Enter a parse tree produced by {@link GUIParser#value}.
	 * @param ctx the parse tree
	 */
	void enterValue(GUIParser.ValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link GUIParser#value}.
	 * @param ctx the parse tree
	 */
	void exitValue(GUIParser.ValueContext ctx);
}