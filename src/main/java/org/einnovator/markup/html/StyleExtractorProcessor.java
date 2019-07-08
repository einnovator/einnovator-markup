/**
 * 
 */
package org.einnovator.markup.html;

import java.util.LinkedHashMap;
import java.util.Map;

import org.einnovator.markup.text.TextTransform;

/**
 * A {@code CssMapProcessor}.
 *
 * @author Jorge Simao {@code {jorge.simao@einnovator.org}}
 */
public class StyleExtractorProcessor implements TextTransform {

	
	private Map<String,String> cssMap;
	
	//
	// Constructors
	//
	
	/**
	 * Create instance of {@code RootMarkupProcessor}.
	 *
	 */
	public StyleExtractorProcessor() {	
	}
	
	

	/**
	 * Get the value of property {@code cssMap}.
	 *
	 * @return the cssMap
	 */
	public Map<String, String> getCssMap() {
		return cssMap;
	}



	/**
	 * Set the value of property {@code cssMap}.
	 *
	 * @param cssMap the cssMap to set
	 */
	public void setCssMap(Map<String, String> cssMap) {
		this.cssMap = cssMap;
	}



	@Override
	public String transform(String text) {
		int i0 = text.indexOf("<style");
		if (i0>=0) {
			int i00 = text.indexOf(">", i0);
			if (i00<0) {
				return text;
			}
			i00++;
			if (i00>=text.length()) {
				return text;
			}
			int i1 = text.indexOf("</style>", i00);
			if (i1<0) {
				i1 = text.length();
			}
			String style = text.substring(i00, i1);
			cssMap = makeCssMap(style);
			text = (i0>0 ? text.substring(0, i0) : "") + (i1<text.length() ? text.substring(i1+"</style>".length()) : "");
		}
		return text;
	}



	public Map<String, String> makeCssMap(String css) {
		Map<String, String> map = new LinkedHashMap<String, String>();
		css = css.replaceAll("/\\*.*?\\*/", "").replaceAll("\\s+", " ");
		int i = 0;
		while (i<css.length()) {
			int i0 = css.indexOf("{", i);
			if (i0<0) {
				break;
			}
			String selectors = css.substring(i, i0).trim();
			int i1 = css.indexOf("}", i0);
			if (i1<0) {
				break;
			}
			String css1 = css.substring(i0+1, i1).trim();
			String sel[] = selectors.split(",");
			for (int k=0; k<sel.length; k++) {
				sel[k] = sel[k].trim();
				map.put(sel[k],css1);
			}
			i = i1+1;
		}
		return map;
	}

	
}
