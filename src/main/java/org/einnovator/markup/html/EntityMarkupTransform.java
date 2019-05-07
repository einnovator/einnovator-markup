package org.einnovator.markup.html;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.einnovator.markup.text.TextTransform;

/**
 * A {@code CDataMarkupTransform}.
 *
 * @author Jorge Simao, {@code jorge.simao@einnovator.org}
 */
public class EntityMarkupTransform implements TextTransform {

	private Map<String, String> entityMap = new HashMap<String, String>();
	
	private Pattern pattern;
	
	//
	// Constructors
	//
	
	/**
	 * Create instance of {@code SimpleMarkupExtractorTransform}.
	 *
	 */
	public EntityMarkupTransform() {
		init();
	}
	
	public EntityMarkupTransform(Map<String, String> entityMap) {
		this.entityMap = entityMap;
	}

	public void init() {
		entityMap.put("<", "lt");
		entityMap.put(">", "gt");
	}
	
	public void initPattern() {
		StringBuilder sb = new StringBuilder("[");
		for (String c: entityMap.keySet()) {
			sb.append(c);
		}
		sb.append("]");
		pattern = Pattern.compile(sb.toString());		
	}
	
	//
	// Getters and Setters
	//

	/**
	 * Get the value of property {@code entityMap}.
	 *
	 * @return the {@code entityMap}
	 */
	public Map<String, String> getEntityMap() {
		return entityMap;
	}

	/**
	 * Set the value of property {@code entityMap}.
	 *
	 * @param entityMap the {@code entityMap} to set
	 */
	public void setEntityMap(Map<String, String> entityMap) {
		this.entityMap = entityMap;
	}

	/**
	 * Get the value of property {@code pattern}.
	 *
	 * @return the {@code pattern}
	 */
	public Pattern getPattern() {
		return pattern;
	}

	/**
	 * Set the value of property {@code pattern}.
	 *
	 * @param pattern the {@code pattern} to set
	 */
	public void setPattern(Pattern pattern) {
		this.pattern = pattern;
	}
	
	//
	// TextTransform Implementation
	//	
	
	/**
	 * @see org.einnovator.markup.text.TextTransform#transform(java.lang.String)
	 */
	@Override
	public String transform(String text) {
		if (text==null) {
			return text;
		}
		if (pattern==null) {
			initPattern();
		}
		StringBuilder sb = new StringBuilder();
		int last = 0;
		Matcher matcher = pattern.matcher(text);
		while(matcher.find()) {
			sb.append(text.substring(last, matcher.start()));
			String entity = entityMap.get(matcher.group());
			sb.append("&");
			sb.append(entity);
			sb.append(";");
			last = matcher.end();
		}
		if (last<text.length()) {
			sb.append(text.substring(last));
		}
		return sb.toString();
	}

	
}
