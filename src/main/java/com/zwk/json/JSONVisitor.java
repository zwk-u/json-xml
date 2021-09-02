// Generated from D:/tools/workspace/demo/src/main/java/com/ahs/json\JSON.g4 by ANTLR 4.9.1
package com.zwk.json;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link JSONParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface JSONVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link JSONParser#json}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJson(JSONParser.JsonContext ctx);
	/**
	 * Visit a parse tree produced by {@link JSONParser#obj}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitObj(JSONParser.ObjContext ctx);
	/**
	 * Visit a parse tree produced by {@link JSONParser#pair}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPair(JSONParser.PairContext ctx);
	/**
	 * Visit a parse tree produced by {@link JSONParser#arr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArr(JSONParser.ArrContext ctx);
	/**
	 * Visit a parse tree produced by the {@code stringValue}
	 * labeled alternative in {@link JSONParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringValue(JSONParser.StringValueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code atomValue}
	 * labeled alternative in {@link JSONParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtomValue(JSONParser.AtomValueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code objValue}
	 * labeled alternative in {@link JSONParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitObjValue(JSONParser.ObjValueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code arrValue}
	 * labeled alternative in {@link JSONParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrValue(JSONParser.ArrValueContext ctx);
}
