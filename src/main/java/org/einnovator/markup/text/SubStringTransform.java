/**
 * 
 */
package org.einnovator.markup.text;

import org.einnovator.markup.text.TextTransform;

/**
 * A {@code SubStringTransform}.
 *
 * @author  {@code support@einnovator.org} {@code {jorge.simao@einnovator.org}}
 */
public class SubStringTransform implements TextTransform {

	private int beginIndex = 0;
	
	private int endIndex = -1;

	//
	// Constructors
	//
	
	/**
	 * Create instance of {@code SubStringTransform}.
	 *
	 */
	public SubStringTransform() {
	}
	
	
	/**
	 * Create instance of {@code SubStringTransform}.
	 *
	 * @param beginIndex the starting index
	 * @param endIndex the ending index
	 */
	public SubStringTransform(int beginIndex, int endIndex) {
		this.beginIndex = beginIndex;
		this.endIndex = endIndex;
	}
	
	/**
	 * Create instance of {@code SubStringTransform}.
	 *
	 * @param endIndex the ending index
	 */
	public SubStringTransform(int endIndex) {
		this.endIndex = endIndex;
	}


	
	
	//
	// Getters/Setters
	//

	/**
	 * Get the value of {@code beginIndex}.
	 *
	 * @return the value of {@code beginIndex}
	 */
	public int getBeginIndex() {
		return beginIndex;
	}

	/**
	 * Set the value of {@code beginIndex}.
	 *
	 * @param beginIndex the {@code beginIndex}
	 */
	public void setBeginIndex(int beginIndex) {
		this.beginIndex = beginIndex;
	}

	/**
	 * Get the value of {@code endIndex}.
	 *
	 * @return the value of {@code endIndex}
	 */
	public int getEndIndex() {
		return endIndex;
	}

	/**
	 * Set the value of {@code endIndex}.
	 *
	 * @param endIndex the {@code endIndex}
	 */
	public void setEndIndex(int endIndex) {
		this.endIndex = endIndex;
	}	

	//
	// TextTransform implementation
	//

	
	/**
	 * @see org.einnovator.markup.text.TextTransform#transform(java.lang.String)
	 */
	@Override
	public String transform(String text) {
		if (text==null) {
			return null;
		}
		if (endIndex==-1) {
			endIndex = text.length();
		}
		if (endIndex>text.length()) {
			endIndex = text.length();
		}
		return text.substring(beginIndex, endIndex);
	}

}
