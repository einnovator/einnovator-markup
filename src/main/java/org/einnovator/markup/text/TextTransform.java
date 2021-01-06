/**
 * 
 */
package org.einnovator.markup.text;

/**
 * A text to text transformation.
 * 
 * @author Jorge Sim�o, {@code support@einnovator.org}
 *
 */
public interface TextTransform {

	/**
	 * Transforms the input text.
	 * 
	 * @param text the input text
	 * @return the transformed text
	 */
	String transform(String text);
}
