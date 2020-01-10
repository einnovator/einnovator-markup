/**
 * 
 */
package org.einnovator.markup.sass;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class StyleRule extends StyleObject {

	private String extend;
	
	private List<String> selectors;

	private List<StyleProperty> properties;

	private List<StyleRule> rules;

	/**
	 * Create instance of {@code StyleRule}.
	 *
	 */
	public StyleRule() {
	}
	
	
	/**
	 * Create instance of {@code StyleRule}.
	 *
	 * @param line the line number
	 * @param column the column number
	 */
	public StyleRule(int line, int column) {
		super(line, column);
	}


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
	 * Get the value of property {@code properties}.
	 *
	 * @return the properties
	 */
	public List<StyleProperty> getProperties() {
		return properties;
	}

	/**
	 * Set the value of property {@code properties}.
	 *
	 * @param properties the properties to set
	 */
	public void setProperties(List<StyleProperty> properties) {
		this.properties = properties;
	}

	/**
	 * Get the value of property {@code rules}.
	 *
	 * @return the rules
	 */
	public List<StyleRule> getRules() {
		return rules;
	}

	/**
	 * Set the value of property {@code rules}.
	 *
	 * @param rules the rules to set
	 */
	public void setRules(List<StyleRule> rules) {
		this.rules = rules;
	}

	
	public void addSelector(String selector) {
		if (this.selectors==null) {
			this.selectors = new ArrayList<String>();
		}
		this.selectors.add(selector);
	}

	public void addProperty(StyleProperty property) {
		if (this.properties==null) {
			this.properties = new ArrayList<>();
		}
		this.properties.add(property);
	}
	
	public void addRule(StyleRule rule) {
		if (this.rules==null) {
			this.rules = new ArrayList<>();
		}
		this.rules.add(rule);
	}

	public void printTree(int n) {
		System.out.print((n>0 ? String.format("%" + (n*2) + "s", "") : ""));

		if (selectors!=null) {
			int i= 0;
			for (String selector: selectors) {				
				if (i>0) {
					System.out.print(", ");
				}
				System.out.print(selector);
			}
			System.out.print(" {");			
		}
		System.out.println();			

		if (properties!=null) {
			for (StyleProperty property: properties) {
				System.out.println(String.format("%" + ((n+1)*2) + "s", "") +  property.getName() + " : " +  (property.getExpr()!=null ? " " + property.getExpr() : ""));
			}
		}
		if (rules!=null) {
			for (StyleRule rule: rules) {				
				rule.printTree(n+1);
			}
		}
		System.out.println((n>0 ? String.format("%" + (n*2) + "s", "") : "") + "}");
	}


	public void printCss(PrintWriter writer, Stylesheet stylesheet) {
		printCss(null, writer, stylesheet);
	}

	public void printCss(String prefix, PrintWriter writer, Stylesheet stylesheet) {
		writer.println("/* line " + line + (stylesheet.getFilename()!=null ? ", " + stylesheet.getFilename() : "") + " */");
		if (selectors!=null) {
			int i= 0;
			for (String selector: selectors) {				
				if (i>0) {
					writer.print(", ");
				}
				if (prefix!=null) {
					writer.print(prefix);
					if (!selector.startsWith("&")) {
						writer.print(" ");						
					}
				}
				selector = expandSelector(selector, prefix);
				writer.print(selector);
			}
			writer.print(" {");			
		}
		writer.println();			

		if (properties!=null) {
			for (StyleProperty property: properties) {
				writer.println("  " +  property.getName() + " : " + stylesheet.evalAsString(property.getExpr()) + ";");
			}
		}
		writer.println("}");
		
		if (rules!=null) {
			if (selectors!=null) {
				for (String selector: selectors) {				
					for (StyleRule rule: rules) {				
						rule.printCss((prefix!=null ? prefix + " " : "") + selector, writer, stylesheet);
					}					
				}
			}
		}
	}
	
	private String expandSelector(String selector, String prefix) {
		if (selector.startsWith("&") && selector.length()>1) {
			if (prefix!=null) {
				selector = selector.substring(1);
			}
		}
		return selector;
	}


	public void evalAll(Stylesheet stylesheet) {
		if (properties!=null) {
			for (StyleProperty property: properties) {
				if (property.getExpr()!=null) {
					String value = stylesheet.evalAsString(property.getExpr());					
					if (value!=null) {
						property.setValue(value);
					}
				}
			}
		}
		if (rules!=null) {
			for (StyleRule rule: rules) {				
				rule.evalAll(stylesheet);
			}					
		}
	}

}
