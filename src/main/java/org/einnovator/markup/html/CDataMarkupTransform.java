package org.einnovator.markup.html;

import org.einnovator.markup.text.TextTransform;

/**
 * A {@code CDataMarkupTransform}.
 *
 * @author  {@code support@einnovator.org}
 */
public class CDataMarkupTransform implements TextTransform {

	private TextTransform cdataTransform;
	
	//
	// Constructors
	//
	
	/**
	 * Create instance of {@code SimpleMarkupExtractorTransform}.
	 *
	 */
	public CDataMarkupTransform(TextTransform cdataTransform) {
		this.cdataTransform = cdataTransform;
	}

	//
	// Getters and Setters
	//


	/**
	 * Get the value of property {@code cdataTransform}.
	 *
	 * @return the {@code cdataTransform}
	 */
	public TextTransform getCDataTransform() {
		return cdataTransform;
	}

	/**
	 * Set the value of property {@code cdataTransform}.
	 *
	 * @param cdataTransform the {@code cdataTransform} to set
	 */
	public void setCDataTransform(TextTransform cdataTransform) {
		this.cdataTransform = cdataTransform;
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
			return null;
		}
		StringBuilder sb = new StringBuilder();
		while (text.length()>0) {
			int i = text.indexOf("<![CDATA[");
			if (i<0) {
				break;
			}
			sb.append(text.substring(0, i));
			text = text.substring(i+"<![CDATA[".length());
			i = text.indexOf("]]>");
			String cdata = i> 0 ? text.substring(text.startsWith("\n") && text.length()>1 ? 1 : 0, i) : text;
			cdata = cdataTransform.transform(cdata);
			sb.append(cdata);
			if (i<0) {
				break;
			}
			final int l = "]]>".length();
			if (i+l>=text.length()) {
				text = "";
				break;
			}
			text = text.substring(i+l + (i+l<text.length() && text.charAt(i+l)=='\n' ? 1 : 0));
		}
		sb.append(text);
		return sb.toString();
	}
	
}
