/**
 * 
 */
package org.einnovator.markup.text;

import org.einnovator.util.StringUtil;
import org.einnovator.markup.text.TextTransform;

/**
 * A {@code SubStringTransform}.
 *
 * @author  {@code support@einnovator.org} {@code {jorge.simao@einnovator.org}}
 */
public class SlugTransform implements TextTransform {

	public static final String DEFAULT_SEPARATOR = "-";
	
	private String separator = DEFAULT_SEPARATOR;
	
	//
	// Constructors
	//
	
	/**
	 * Create instance of {@code SubStringTransform}.
	 *
	 */
	public SlugTransform() {
	}
	
	//
	// Getters an Setters
	//
	
	/**
	 * Get the value of property {@code separator}.
	 *
	 * @return the {@code separator}
	 */
	public String getSeparator() {
		return separator;
	}

	/**
	 * Set the value of property {@code separator}.
	 *
	 * @param separator the {@code separator} to set
	 */
	public void setSeparator(String separator) {
		this.separator = separator;
	}
	
	//
	// TextTransform Implementation
	//
	

	/**
	 * @see org.einnovator.markup.text.TextTransform#transform(java.lang.String)
	 */
	@Override
	public String transform(String text) {
		if (text==null) {
			return null;
		}
		return StringUtil.normalizeSpace(text.toLowerCase()).trim().replace(" ", separator);
	}

	
}
