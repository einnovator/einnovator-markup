/**
 * 
 */
package org.einnovator.markup.sass;

import org.einnovator.util.model.ObjectBase;
import org.einnovator.util.model.ToStringCreator;

/**
 *
 */
public class StyleObject extends ObjectBase {

	protected int line;
	
	protected int column;

	/**
	 * Create instance of {@code StyleObject}.
	 *
	 */
	public StyleObject() {
	}
	
	
	/**
	 * Create instance of {@code StyleObject}.
	 *
	 * @param line the line number
	 * @param column the column number
	 */
	public StyleObject(int line, int column) {
		super();
		this.line = line;
		this.column = column;
	}


	/**
	 * Get the value of property {@code line}.
	 *
	 * @return the line
	 */
	public int getLine() {
		return line;
	}

	/**
	 * Set the value of property {@code line}.
	 *
	 * @param line the line to set
	 */
	public void setLine(int line) {
		this.line = line;
	}

	/**
	 * Get the value of property {@code column}.
	 *
	 * @return the column
	 */
	public int getColumn() {
		return column;
	}

	/**
	 * Set the value of property {@code column}.
	 *
	 * @param column the column to set
	 */
	public void setColumn(int column) {
		this.column = column;
	}
	
	/* 
	 * @see org.einnovator.util.model.ObjectBase#toString2(org.einnovator.util.model.ToStringCreator)
	 */
	@Override
	public ToStringCreator toString2(ToStringCreator creator) {
		return creator
			.append("line", line)
			.append("column", column)
			;
	}
}
