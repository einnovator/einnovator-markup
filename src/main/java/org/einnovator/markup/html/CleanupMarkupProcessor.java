package org.einnovator.markup.html;

import org.einnovator.markup.text.TextTransform;

/**
 * A {@code CleanupMarkupProcessor}.
 *
 * @author Jorge Simao, {@code jorge.simao@einnovator.org}
 */
public class CleanupMarkupProcessor implements TextTransform {


	
	//
	// Constructors
	//
	
	/**
	 * Create instance of {@code SimpleMarkupExtractorTransform}.
	 *
	 */
	public CleanupMarkupProcessor() {
	}
	

	//
	// Getters and Setters
	//
	
	
	//
	// TextTransform Implementation
	//	
	
	/**
	 * @see org.einnovator.text.TextTransform#transform(java.lang.String)
	 */
	@Override
	public String transform(String text) {
		if (text==null) {
			return null;
		}
		StringBuilder sb = new StringBuilder();
		while (!text.isEmpty()) {
			int i = text.indexOf("<");
			if (i>0) {
				if (sb.length()>0) {
					sb.append(" ");				
				}
				sb.append(text.substring(0, i));				
			}
			if (i<0 || i==text.length()-1) {
				return sb.toString();
			}
			text = text.substring(i+1);
			i = text.indexOf(">");
			if (i<0 || i==text.length()-1) {
				return sb.toString();
			}
			text = text.substring(i+1);
		}
		return sb.toString();
	}
}
