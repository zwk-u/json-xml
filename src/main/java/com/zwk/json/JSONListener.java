// Generated from D:/tools/workspace/demo/src/main/java/com/ahs/json\JSON.g4 by ANTLR 4.9.1
package com.zwk.json;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link JSONParser}.
 */
public interface JSONListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link JSONParser#json}.
	 * @param ctx the parse tree
	 */
	void enterJson(JSONParser.JsonContext ctx);
	/**
	 * Exit a parse tree produced by {@link JSONParser#json}.
	 * @param ctx the parse tree
	 */
	void exitJson(JSONParser.JsonContext ctx);
	/**
	 * Enter a parse tree produced by {@link JSONParser#obj}.
	 * @param ctx the parse tree
	 */
	void enterObj(JSONParser.ObjContext ctx);
	/**
	 * Exit a parse tree produced by {@link JSONParser#obj}.
	 * @param ctx the parse tree
	 */
	void exitObj(JSONParser.ObjContext ctx);
	/**
	 * Enter a parse tree produced by {@link JSONParser#pair}.
	 * @param ctx the parse tree
	 */
	void enterPair(JSONParser.PairContext ctx);
	/**
	 * Exit a parse tree produced by {@link JSONParser#pair}.
	 * @param ctx the parse tree
	 */
	void exitPair(JSONParser.PairContext ctx);
	/**
	 * Enter a parse tree produced by {@link JSONParser#arr}.
	 * @param ctx the parse tree
	 */
	void enterArr(JSONParser.ArrContext ctx);
	/**
	 * Exit a parse tree produced by {@link JSONParser#arr}.
	 * @param ctx the parse tree
	 */
	void exitArr(JSONParser.ArrContext ctx);
	/**
	 * Enter a parse tree produced by the {@code stringValue}
	 * labeled alternative in {@link JSONParser#value}.
	 * @param ctx the parse tree
	 */
	void enterStringValue(JSONParser.StringValueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code stringValue}
	 * labeled alternative in {@link JSONParser#value}.
	 * @param ctx the parse tree
	 */
	void exitStringValue(JSONParser.StringValueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code atomValue}
	 * labeled alternative in {@link JSONParser#value}.
	 * @param ctx the parse tree
	 */
	void enterAtomValue(JSONParser.AtomValueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code atomValue}
	 * labeled alternative in {@link JSONParser#value}.
	 * @param ctx the parse tree
	 */
	void exitAtomValue(JSONParser.AtomValueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code objValue}
	 * labeled alternative in {@link JSONParser#value}.
	 * @param ctx the parse tree
	 */
	void enterObjValue(JSONParser.ObjValueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code objValue}
	 * labeled alternative in {@link JSONParser#value}.
	 * @param ctx the parse tree
	 */
	void exitObjValue(JSONParser.ObjValueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code arrValue}
	 * labeled alternative in {@link JSONParser#value}.
	 * @param ctx the parse tree
	 */
	void enterArrValue(JSONParser.ArrValueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code arrValue}
	 * labeled alternative in {@link JSONParser#value}.
	 * @param ctx the parse tree
	 */
	void exitArrValue(JSONParser.ArrValueContext ctx);
}
