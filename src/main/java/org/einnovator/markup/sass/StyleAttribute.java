/**
 * 
 */
package org.einnovator.markup.sass;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.einnovator.script.model.JExpr;
import org.einnovator.util.model.ToStringCreator;

/**
 *
 */
public class StyleAttribute extends StyleObject {

	private String name;

	private JExpr expr;
	
	private String value;

	/**
	 * Create instance of {@code StyleProperty}.
	 *
	 */
	public StyleAttribute() {
	}
	
	/**
	 * Create instance of {@code StyleProperty}.
	 *
	 * @param line the line number
	 * @param column the column number
	 */
	public StyleAttribute(int line, int column) {
		super(line, column);
	}
	
	/**
	 * Get the value of property {@code name}.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}



	/**
	 * Set the value of property {@code name}.
	 *
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Get the value of property {@code expr}.
	 *
	 * @return the expr
	 */
	public JExpr getExpr() {
		return expr;
	}

	/**
	 * Set the value of property {@code expr}.
	 *
	 * @param expr the expr to set
	 */
	public void setExpr(JExpr expr) {
		this.expr = expr;
	}

	/**
	 * Get the value of property {@code value}.
	 *
	 * @return the value
	 */
	public String getValue() {
		return value;
	}



	/**
	 * Set the value of property {@code value}.
	 *
	 * @param value the value to set
	 */
	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public ToStringCreator toString0(ToStringCreator creator) {
		return creator
				.append("name", name)
				.append("value", value)
				;
	}

}
