// Generated from E:/Documents/Java Projects/Java_Projects_year4/TranslatorDesign/ANTLRTranslatorDesignProject/src\Java.g4 by ANTLR 4.4.1-dev
package grammar;

import structure.*;

import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link JavaParser}.
 */
public interface JavaListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link JavaParser#package_statement}.
	 * @param ctx the parse tree
	 */
	void enterPackage_statement(@NotNull JavaParser.Package_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaParser#package_statement}.
	 * @param ctx the parse tree
	 */
	void exitPackage_statement(@NotNull JavaParser.Package_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaParser#import_statement}.
	 * @param ctx the parse tree
	 */
	void enterImport_statement(@NotNull JavaParser.Import_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaParser#import_statement}.
	 * @param ctx the parse tree
	 */
	void exitImport_statement(@NotNull JavaParser.Import_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaParser#start}.
	 * @param ctx the parse tree
	 */
	void enterStart(@NotNull JavaParser.StartContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaParser#start}.
	 * @param ctx the parse tree
	 */
	void exitStart(@NotNull JavaParser.StartContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(@NotNull JavaParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(@NotNull JavaParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaParser#class_statement}.
	 * @param ctx the parse tree
	 */
	void enterClass_statement(@NotNull JavaParser.Class_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaParser#class_statement}.
	 * @param ctx the parse tree
	 */
	void exitClass_statement(@NotNull JavaParser.Class_statementContext ctx);
}