/**
 * 
 */
package org.einnovator.markup.html;

import javax.annotation.PostConstruct;

import org.owasp.html.PolicyFactory;
import org.owasp.html.Sanitizers;

/**
 * An HTML sanitization {@code MarkupProcessor} based on OWASP HTML sanitization project.
 *
 * @author Jorge Simao {@code {jorge.simao@einnovator.org}}
 */
public class SanitizationMarkupProcessor implements MarkupProcessor {

	private PolicyFactory policy;
	
	//
	// Constructors
	//
	
	/**
	 * Create instance of {@code SanitizationMarkupProcessor}.
	 *
	 */
	public SanitizationMarkupProcessor() {		
	}	
	
	/**
	 * Create instance of {@code SanitizationMarkupProcessor}.
	 *
	 * @param policy
	 */
	public SanitizationMarkupProcessor(PolicyFactory policy) {
		this.policy = policy;
	}

	@PostConstruct
	public void init() {
		if (policy==null) {
			policy = getDefaultPolicyFactory();
		}
	}

	public SanitizationMarkupProcessor configDefaultPolicy() {
		policy = getDefaultPolicyFactory();
		return this;
	}

	
	//
	// Getters and setters
	//
	
	
	/**
	 * Get the value of property {@code policy}.
	 *
	 * @return the value of property {@code policy}
	 */
	public PolicyFactory getPolicy() {
		return policy;
	}

	/**
	 * Set the value of property {@code policy}.
	 *
	 * @param policy the value of property {@code policy}
	 */
	public void setPolicy(PolicyFactory policy) {
		this.policy = policy;
	}	
	
	//
	// MarkupProcessor implementation
	//
	
	/**
	 * @see org.einnovator.text.TextTransform#transform(java.lang.String)
	 */
	@Override
	public String transform(String text) {
		return policy.sanitize(text);
	}

	
	//
	// Support
	//
	
	public static PolicyFactory getDefaultPolicyFactory() {
		return Sanitizers.FORMATTING
			.and(Sanitizers.BLOCKS)
			.and(Sanitizers.FORMATTING)
			.and(Sanitizers.IMAGES)
			.and(Sanitizers.LINKS)
			.and(Sanitizers.STYLES);
	}

}
