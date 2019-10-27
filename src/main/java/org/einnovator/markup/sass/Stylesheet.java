/**
 * 
 */
package org.einnovator.markup.sass;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.einnovator.script.model.JExpr;
import org.einnovator.script.model.JLiteral;
import org.einnovator.script.model.JVarRef;

/**
 *
 */
public class Stylesheet {

	private String filename;
	
	private List<StyleRule> rules;

	private List<StyleRule> mixins;

	private List<StyleFunction> functions;

	private Map<String, StyleVariable> vars;

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
	public Map<String, StyleVariable> getVars() {
		return vars;
	}

	/**
	 * Set the value of property {@code vars}.
	 *
	 * @param vars the vars to set
	 */
	public void setVars(Map<String, StyleVariable> vars) {
		this.vars = vars;
	}
	
	//StyleRules


	public StyleRule findStyleRule(StyleRule rule) {
		if (rule!=null && rules!=null) {
			for (StyleRule rule0: rules) {
				if (rule0.equals(rule)) {
					return rule;
				}
			}
		}
		return null;
	}
	
	
	public void addStyleRule(StyleRule rule) {
		if (this.rules == null) {
			this.rules = new ArrayList<>();
		}
		this.rules.add(rule);
	}
	
	
	public void addVariable(StyleVariable var) {
		if (this.vars == null) {
			this.vars = new LinkedHashMap<String, StyleVariable>();
		}
		this.vars.put(var.getName(), var);
	}
	
	public StyleVariable getVariable(String name) {
		if (this.vars == null) {
			return null;
		}
		return this.vars.get(name);
	}

	public StyleRule removeStyleRule(StyleRule rule) {
		if (rule!=null && rules!=null) {
			for (int i=0; i<rules.size(); i++) {
				StyleRule rule0 = rules.get(i);
				if (rule0.equals(rule)) {
					rules.remove(i);
					return rule0;
				}
			}
		}
		return null;
	}

	public void printTree() {
		printTree(0);
	}

	
	public void printTree(int n) {
		if (vars!=null) {
			for (Map.Entry<String, StyleVariable> e: vars.entrySet()) {
				System.out.println((n>0 ? String.format("%" + (n*2) + "s", "") : "") + "$" + e.getKey() + " = " + e.getValue().getValue() + "; " + e.getValue().getExpr());
			}
		}
		if (rules!=null) {
			for (StyleRule rule: rules) {
				rule.printTree(n);
			}
		}
		if (mixins!=null) {
			for (StyleRule rule: mixins) {
				rule.printTree(n);
			}
		}
		if (functions!=null) {
			for (StyleFunction function: functions) {
				function.printTree(n);
			}
		}

		
	}
	
	


	public void printCss(PrintWriter writer) {
		if (rules!=null) {
			for (StyleRule rule: rules) {
				rule.printCss(writer, this);
			}
		}
		
	}
	
	public void printCss() {
		PrintWriter writer = new PrintWriter(System.out);
		printCss(writer);
		writer.flush();
		
	}
	
	public void evalAll() {
		if (vars!=null) {
			for (Map.Entry<String, StyleVariable> e: vars.entrySet()) {
				StyleVariable var = e.getValue();
				if (var.getExpr()!=null) {
					String value = evalAsString(var.getExpr());
					if (value!=null) {
						var.setValue(value);
					}
				}
			}
		}
		if (rules!=null) {
			for (StyleRule rule: rules) {
				rule.evalAll(this);
			}
		}
		
	}
	
	public String evalAsString(JExpr expr) {
		Object value = eval(expr);
		if (value==null) {
			return null;
		}
		return value.toString();
	}

	public Object eval(JExpr expr) {
		if (expr instanceof JLiteral) {
			return ((JLiteral)expr).getValue();
		}
		if (expr instanceof JVarRef) {
			String name = ((JVarRef)expr).getName();
			StyleVariable var = getVariable(name);
			if (var!=null) {
				String value = var.getValue();
				if (value!=null) {
					return value;
				}				
			}
		}
		return null;
	}

}
