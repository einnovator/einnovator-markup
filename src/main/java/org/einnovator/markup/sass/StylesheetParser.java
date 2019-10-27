/**
 * 
 */
package org.einnovator.markup.sass;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.einnovator.markup.sass.antlr.ScssLexer;
import org.einnovator.markup.sass.antlr.ScssParser;
import org.einnovator.markup.sass.antlr.ScssParser.StylesheetContext;

/**
 *
 */
public class StylesheetParser {

	public Stylesheet parseScss(String s) {
		ScssLexer lexer = new ScssLexer(CharStreams.fromString(s));
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		ScssParser parser = new ScssParser(tokens);
		StylesheetContext tree = parser.stylesheet();
		ScssParserListenerImpl listener = new ScssParserListenerImpl();
		ParseTreeWalker walker = new ParseTreeWalker();
		walker.walk(listener, tree);
		return listener.getStylesheet();
	}
	
	
}
