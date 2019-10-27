/**
 * 
 */
package org.einnovator.markup.sass;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author jsima
 *
 */
public class StylesheetParserTests {

	@Test
	public void test() {
		StylesheetParser parser = new StylesheetParser();
		String s = 
				"$primary: #c6538c;\r\n" +
				"a {\r\n" + 
				"	color: red;\r\n" + 
				"	background-color: $primary;\r\n" + 
				"	span {\r\n" + 
				"		 color: #880;\r\n" + 
				"	}\r\n" + 
				"	&:hover {\r\n" + 
				"		text-decoration: underline;\r\n" + 
				"	}\r\n" + 
				"}";
		Stylesheet stylesheet = parser.parseScss(s);
		System.out.println("------");
		stylesheet.printTree();
		System.out.println("------");
		stylesheet.setFilename("stylesheet.scss");
		stylesheet.printCss();
		System.out.println("------");
		stylesheet.evalAll();

		stylesheet.printCss();
	}

}
