/**
 * 
 */
package org.einnovator.markup.sass;

import java.util.List;

/**
 *
 */
public class StyleFunction extends StyleObject {

	String name;
	
	List<String> params;
	
	List<StyleAction> actions;

	/**
	 * Create instance of {@code StyleFunction}.
	 *
	 */
	public StyleFunction() {
	}
	
	/**
	 * Create instance of {@code StyleFunction}.
	 *
	 * @param line the line number
	 * @param column the column number
	 */
	public StyleFunction(int line, int column) {
		super(line, column);
	}

	public void printTree(int n) {
		
	}
}
