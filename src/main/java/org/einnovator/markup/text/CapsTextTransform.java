/**
 * 
 */
package org.einnovator.markup.text;

import org.einnovator.util.StringUtil;
import org.einnovator.markup.text.TextTransform;
import org.springframework.util.StringUtils;

/**
 * A {@code CapsTextTransform}.
 *
 * @author  {@code support@einnovator.org} {@code {jorge.simao@einnovator.org}}
 */
public class CapsTextTransform implements TextTransform {

	private boolean capitalize;
	
	private boolean capitalizeWords;

	//
	// Constructors
	//
	
	/**
	 * Create instance of {@code CapsTextTransform}.
	 *
	 * @param capitalize capitalize flag
	 */
	public CapsTextTransform(boolean capitalize) {
		this.capitalize = capitalize;
	}
	
	/**
	 * Create instance of {@code CapsTextTransform}.
	 *
	 * @param capitalize capitalize flag
	 * @param capitalizeWords capitalize words flag
	 */
	public CapsTextTransform(boolean capitalize, boolean capitalizeWords) {
		this.capitalize = capitalize;
		this.capitalizeWords = capitalizeWords;
	}

	//
	// Getters and setters
	//
	
	/**
	 * Get the value of capitalize.
	 *
	 * @return the capitalize
	 */
	public boolean isCapitalize() {
		return capitalize;
	}

	/**
	 * Set the value of capitalize.
	 *
	 * @param capitalize the capitalize to set
	 */
	public void setCapitalize(boolean capitalize) {
		this.capitalize = capitalize;
	}
	
	/**
	 * Get the value of property {@code capitalizeWords}.
	 *
	 * @return the {@code capitalizeWords}
	 */
	public boolean isCapitalizeWords() {
		return capitalizeWords;
	}

	/**
	 * Set the value of property {@code capitalizeWords}.
	 *
	 * @param capitalizeWords the {@code capitalizeWords} to set
	 */
	public void setCapitalizeWords(boolean capitalizeWords) {
		this.capitalizeWords = capitalizeWords;
	}	
	
	//
	// TextTransform implementation
	//
	
	@Override
	public String transform(String text) {
		if (!capitalizeWords) {
			return capitalize ? StringUtils.capitalize(text) : StringUtils.uncapitalize(text);
		} else {
			String[] a = text.split(" ");
			for (int i=0; i<a.length; i++) {
				a[i] = capitalize ? StringUtils.capitalize(a[i]) : StringUtils.uncapitalize(a[i]);
			}
			return StringUtil.join(a, " ");
		}
	}

	
	//
	// Static utility
	//

	private static CapsTextTransform capitalizeInstance;

	private static CapsTextTransform uncapitalizeInstance;
	
	public static CapsTextTransform getCapitalizeInstance() {
		if (capitalizeInstance==null) {
			capitalizeInstance = new CapsTextTransform(true);
		}
		return capitalizeInstance;
	}

	public static CapsTextTransform getUncapitalizeInstance() {
		if (uncapitalizeInstance==null) {
			uncapitalizeInstance = new CapsTextTransform(false);
		}
		return uncapitalizeInstance;
	}

}
