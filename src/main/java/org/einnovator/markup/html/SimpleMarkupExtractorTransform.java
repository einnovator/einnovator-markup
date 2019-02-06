package org.einnovator.markup.html;

import org.einnovator.markup.text.TextTransform;

/**
 * A {@code SimpleMarkupExtractorTransform}.
 *
 *
 *
 */
public class SimpleMarkupExtractorTransform implements TextTransform {

	private String tag;
	
	private String styleClass;
	
	//
	// Constructors
	//
	
	/**
	 * Create instance of {@code SimpleMarkupExtractorTransform}.
	 *
	 */
	public SimpleMarkupExtractorTransform() {
	}
	
	/**
	 * Create instance of {@code SimpleMarkupExtractorTransform}.
	 *
	 * @param tag
	 * @param styleClass
	 */
	public SimpleMarkupExtractorTransform(String tag, String styleClass) {
		this.tag = tag;
		this.styleClass = styleClass;
	}


	/**
	 * Create instance of {@code SimpleMarkupExtractorTransform}.
	 *
	 * @param tag
	 */
	public SimpleMarkupExtractorTransform(String tag) {
		this.tag = tag;
	}

	//
	// Getters and Setters
	//
	

	/**
	 * Get the value of property {@code tag}.
	 *
	 * @return the tag
	 */
	public String getTag() {
		return tag;
	}

	/**
	 * Set the value of property {@code tag}.
	 *
	 * @param tag the tag to set
	 */
	public void setTag(String tag) {
		this.tag = tag;
	}

	/**
	 * Get the value of property {@code styleClass}.
	 *
	 * @return the styleClass
	 */
	public String getStyleClass() {
		return styleClass;
	}

	/**
	 * Set the value of property {@code styleClass}.
	 *
	 * @param styleClass the styleClass to set
	 */
	public void setStyleClass(String styleClass) {
		this.styleClass = styleClass;
	}
	
	
	//
	// TextTransform Implementation
	//	
	
	/**
	 * @see org.einnovator.text.TextTransform#transform(java.lang.String)
	 */
	@Override
	public String transform(String text) {
		if (text==null) {
			return null;
		}
		while (!text.isEmpty()) {
			int i = text.indexOf("<" + tag);
			if (i<0) {
				return text;
			}
			String text2 = text.substring(i);
			int i2 = text2.indexOf(">");
			if (i2<0) {
				return text;
			}
			boolean matchClass = false;
			if (styleClass!=null) {
				matchClass = false;
				String e = text2.substring(0, i2);
				i = e.indexOf(" class=\"");
				if (i>0) {
					e = e.substring(i + " class=\"".length());
					i = e.indexOf("\"");
					if (i>0) {
						String eClass = e.substring(0, i);
						if (eClass.equals(styleClass)) {
							matchClass = true;
						}
					}
				}
			}
			if (i2+1>=text2.length()) {
				return text;
			}
			text2 = text2.substring(i2+1);

			if (matchClass) {
				text = text2;
				int deep = 0;
				i = 0;
				while (!text2.isEmpty()) {
					int j1 = text2.indexOf("<" + tag);
					int j2 = text2.indexOf("</" + tag + ">");
					if (j1>=0 && j1<j2) {
						deep++;
						i+= j1;
						if (j1>=text2.length()) {
							return text;
						}
						text2 = text2.substring(j1 + ("<" + tag).length());
					} else {
						if (deep==0) {
							if (i<0) {
								return text;
							}	
							if (i>=text2.length()) {
								return text;
							}
							return text.substring(0, i);							
						} else {
							text2 = text2.substring(j2 + ("</" + tag + ">").length()); 
							deep--;
						}
					}
				}
				return text;
			} else {
				i = text2.indexOf("</" + tag + ">");
				if (styleClass==null) {
					if (i>0) {
						text = text2.substring(0, i);										
					}
					return text;
				}
				int i1 = i +("</" + tag + ">").length();
				if (i1==text2.length()) {
					return text;
				}
				text = text2.substring(i1);
			}
		}
		return "";
	}
}
