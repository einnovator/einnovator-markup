/**
 * 
 */
package org.einnovator.markup.text;

import org.einnovator.markup.text.TextTransform;


/**
 * A PrefixSuffixTextTransform.
 *
 * @author  {@code support@einnovator.org}
 */
public class PrefixSuffixTextTransform implements TextTransform {

	private String prefix;
	
	private String suffix;
	
	//
	// Constructors
	//
	
	/**
	 * Create instance of PrefixSuffixTextTransform.
	 *
	 * @param prefix the prefix
	 * @param suffix the suffix
	 */
	public PrefixSuffixTextTransform(String prefix, String suffix) {
		this.prefix = prefix;
		this.suffix = suffix;
	}

	/**
	 * Create instance of PrefixSuffixTextTransform.
	 *
	 */
	public PrefixSuffixTextTransform() {
	}

	//
	// Getters/Setters
	//
	
	/**
	 * Get the value of prefix.
	 *
	 * @return the prefix
	 */
	public String getPrefix() {
		return prefix;
	}

	/**
	 * Set the value of prefix.
	 *
	 * @param prefix the prefix to set
	 */
	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}

	/**
	 * Get the value of suffix.
	 *
	 * @return the suffix
	 */
	public String getSuffix() {
		return suffix;
	}

	/**
	 * Set the value of suffix.
	 *
	 * @param suffix the suffix to set
	 */
	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}


	//
	// TextTransform implementation
	//
	
	@Override
	public String transform(String text) {
		StringBuilder sb = new StringBuilder();
		if (prefix!=null) {
			sb.append(prefix);
		}
		sb.append(text);
		if (suffix!=null) {
			sb.append(suffix);
		}
		return sb.toString();
	}

	
}
