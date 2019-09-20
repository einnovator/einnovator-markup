/**
 * 
 */
package org.einnovator.markup.sass;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 *
 */
public class StyleRule {

	private String extend;
	
	private List<String> selectors;

	private Map<String, String> style;

	private Map<String, StyleRule> rules;

	/**
	 * Get the value of property {@code extend}.
	 *
	 * @return the extend
	 */
	public String getExtend() {
		return extend;
	}

	/**
	 * Set the value of property {@code extend}.
	 *
	 * @param extend the extend to set
	 */
	public void setExtend(String extend) {
		this.extend = extend;
	}

	/**
	 * Get the value of property {@code selectors}.
	 *
	 * @return the selectors
	 */
	public List<String> getSelectors() {
		return selectors;
	}

	/**
	 * Set the value of property {@code selectors}.
	 *
	 * @param selectors the selectors to set
	 */
	public void setSelectors(List<String> selectors) {
		this.selectors = selectors;
	}

	/**
	 * Get the value of property {@code style}.
	 *
	 * @return the style
	 */
	public Map<String, String> getStyle() {
		return style;
	}

	/**
	 * Set the value of property {@code style}.
	 *
	 * @param style the style to set
	 */
	public void setStyle(Map<String, String> style) {
		this.style = style;
	}

	/**
	 * Get the value of property {@code rules}.
	 *
	 * @return the rules
	 */
	public Map<String, StyleRule> getRules() {
		return rules;
	}

	/**
	 * Set the value of property {@code rules}.
	 *
	 * @param rules the rules to set
	 */
	public void setRules(Map<String, StyleRule> rules) {
		this.rules = rules;
	}
	
	public void addSelector(String selector) {
		if (this.selectors==null) {
			this.selectors = new ArrayList<String>();
		}
		this.selectors.add(selector);
	}

	public void addStyle(String name, String value) {
		if (this.style==null) {
			this.style = new LinkedHashMap<String, String>();
		}
		this.style.put(name, value);
	}

	public void addStyle(String selector, StyleRule rules) {
		if (this.rules==null) {
			this.rules = new LinkedHashMap<String, StyleRule>();
		}
		this.rules.put(selector, rules);
	}

}
