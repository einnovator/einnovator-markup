package org.einnovator.markup.html;

/**
 * A {@code AppDocumentTransform}.
 *
 *
 *
 */
public class AppDocumentTransform extends SimpleMarkupExtractorTransform {

	/**
	 * Create instance of {@code AppDocumentTransform}.
	 *
	 */
	public AppDocumentTransform() {
		super("div", "doc");
	}
	
	@Override
	public String transform(String text) {
		text = super.transform(text);
		int i = text.indexOf("<td class=\"social-container\"");
		if (i>0) {
			text = text.substring(0, i);
		}
		i = text.lastIndexOf("</div>");
		if (i>0) {
			i += "</div>".length();
			if (i<text.length()) {
				text = text.substring(0, i);
			}
		}
		return text;
	}
	
}
