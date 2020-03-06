/**
 * 
 */
package org.einnovator.markup.sass;

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
				"		 padding: 10px;\r\n" + 
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
	
	@Test
	public void test2() {
		StylesheetParser parser = new StylesheetParser();
		String s = 
				"a {\r\n" + 
				"	 padding: 10px;\r\n" + 
				"}";
		Stylesheet stylesheet = parser.parseScss(s);
		System.out.println("------Tree:");
		stylesheet.printTree();
		System.out.println("------Css:");
		stylesheet.setFilename("stylesheet.scss");
		stylesheet.printCss();
		System.out.println("--Vars:");
		System.out.println(stylesheet.getVars());
		System.out.println("------Eval:");
		stylesheet.evalAll();

		stylesheet.printCss();
	}

	
	@Test
	public void test3() {
		StylesheetParser parser = new StylesheetParser();
		String s = 
				".a {\r\n" + 
				"	color: red;\r\n" + 
				"	.b {\r\n" + 
				"		margin: 10;\r\n" + 
				"		.c {\r\n" + 
				"	 		padding: 10px;\r\n" + 
				"		}\r\n" +
				"	}\r\n" +
				"}";
		Stylesheet stylesheet = parser.parseScss(s);
		System.out.println("------Tree:");
		stylesheet.printTree();
		System.out.println("------Css:");
		stylesheet.setFilename("stylesheet.scss");
		stylesheet.printCss();
	}
	
	

	@Test
	public void test4() {
		StylesheetParser parser = new StylesheetParser();
		String s = 
".footer {\r\n" + 
//"    padding: 1;\r\n" + 
//"    margin: 0 0;\r\n" + 
//"    margin: 2px 2px;\r\n" + 
//"    border-top: none;\r\n" + 
"    color: white !important;\r\n" + 
"}";
			
		Stylesheet stylesheet = parser.parseScss(s);
		System.out.println("------Tree:");
		stylesheet.printTree();
		System.out.println("------Css:");
		stylesheet.setFilename("stylesheet.scss");
		stylesheet.printCss();
	}
	



}
