/**
 * 
 */
package org.einnovator.markup.html;

import java.io.IOException;

import org.markdown4j.Markdown4jProcessor;

/**
 * A {@code Markdown4jTextTransform}.
 *
 * @author Jorge Simao {@code {jorge.simao@einnovator.org}}
 */
public class Markdown4jTextTransform implements MarkupProcessor {

	
	Markdown4jProcessor processor;
	
	//
	// Constructors
	//
	
	/**
	 * Create instance of {@code Markdown4jTextTransform}.
	 *
	 */
	public Markdown4jTextTransform() {
		processor = new Markdown4jProcessor();
	}

	
	//
	// MarkupProcessor implementation
	//

	/**
	 * @see org.einnovator.markup.text.TextTransform#transform(java.lang.String)
	 */
	@Override
	public String transform(String text) {
		try {
			return processor.process(text);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

}
