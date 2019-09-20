/**
 * 
 */
package org.einnovator.markup.sass;

import java.util.List;
import java.util.Map;

/**
 *
 */
public class Stylesheet {

	private String filename;
	
	private List<StyleRule> content;

	private List<StyleRule> mixins;

	private List<StyleFunction> functions;

	private Map<String, String> vars;

	/**
	 * Get the value of property {@code filename}.
	 *
	 * @return the filename
	 */
	public String getFilename() {
		return filename;
	}

	/**
	 * Set the value of property {@code filename}.
	 *
	 * @param filename the filename to set
	 */
	public void setFilename(String filename) {
		this.filename = filename;
	}

	/**
	 * Get the value of property {@code content}.
	 *
	 * @return the content
	 */
	public List<StyleRule> getContent() {
		return content;
	}

	/**
	 * Set the value of property {@code content}.
	 *
	 * @param content the content to set
	 */
	public void setContent(List<StyleRule> content) {
		this.content = content;
	}

	/**
	 * Get the value of property {@code mixins}.
	 *
	 * @return the mixins
	 */
	public List<StyleRule> getMixins() {
		return mixins;
	}

	/**
	 * Set the value of property {@code mixins}.
	 *
	 * @param mixins the mixins to set
	 */
	public void setMixins(List<StyleRule> mixins) {
		this.mixins = mixins;
	}

	/**
	 * Get the value of property {@code functions}.
	 *
	 * @return the functions
	 */
	public List<StyleFunction> getFunctions() {
		return functions;
	}

	/**
	 * Set the value of property {@code functions}.
	 *
	 * @param functions the functions to set
	 */
	public void setFunctions(List<StyleFunction> functions) {
		this.functions = functions;
	}

	/**
	 * Get the value of property {@code vars}.
	 *
	 * @return the vars
	 */
	public Map<String, String> getVars() {
		return vars;
	}

	/**
	 * Set the value of property {@code vars}.
	 *
	 * @param vars the vars to set
	 */
	public void setVars(Map<String, String> vars) {
		this.vars = vars;
	}
	
}
