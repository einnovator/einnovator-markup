/**
 * 
 */
package org.einnovator.markup.html;

/**
 * AA {@code AppMarkupProcessor}.
 *
 * @author Jorge Simao {@code {jorge.simao@einnovator.org}}
 */
public class AppMarkupProcessor extends RootMarkupProcessor {

	//
	// Constructors
	//
	
	/**
	 * Create instance of {@code AppMarkupProcessor}.
	 *
	 */
	public AppMarkupProcessor() {	
		add(new Markdown4jTextTransform());
		add(new SanitizationMarkupProcessor().configDefaultPolicy());
	}
	
	public String process(String text) {
		return transform(text);
	}

}
