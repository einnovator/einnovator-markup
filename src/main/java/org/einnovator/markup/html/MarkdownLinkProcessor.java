/**
 * 
 */
package org.einnovator.markup.html;

import org.einnovator.util.PathUtil;
import org.springframework.util.StringUtils;

/**
 * A {@code MarkdownLinkProcessor}.
 *
 * @author support@einnovator.org
 */
public class MarkdownLinkProcessor implements MarkupProcessor {

	
	private String baseUri = null;


	//
	// Constructors
	//
	
	/**
	 * Create instance of {@code MarkdownLinkProcessor}.
	 *
	 */
	public MarkdownLinkProcessor(String baseUri) {
		this.baseUri = baseUri;
	}

	
	//
	// MarkupProcessor implementation
	//

	/**
	 * @see org.einnovator.markup.text.TextTransform#transform(java.lang.String)
	 */
	@Override
	public String transform(String text) {
		StringBuilder sb = new StringBuilder();
		int i = 0;
		while (i<text.length()) {
			int i2 = text.indexOf("[", i);
			if (i2<0) {
				sb.append(text.substring(i));
				break;
			} else {
				int i02 = text.indexOf("]", i2);
				if (i02>0 && i02<text.length()-2) {
					int i3 = text.indexOf("(", i02);
					if (i3==i02+1) {
						int i4 = text.indexOf(")", i3);
						if (i4>0) {
							String uri = text.substring(i3+1, i4).trim();
							if (!isUrl(uri)) {
								uri = PathUtil.concat(baseUri, uri);
							}
							sb.append(text.substring(i, i3+1));
							sb.append(uri);
							sb.append(")");
							i = i4+1;
							continue;
						}
					}
					if (i3>0) {
						sb.append(text.substring(i, i3+1));
						i = i3+1;						
						continue;
					}
					sb.append(text.substring(i, i2+1));
					i = i2+1;
					continue;
				}
				sb.append(text.substring(i));
				break;
			}
		}
		return sb.toString();
	}
	
	public boolean isUrl(String uri) {
		if (StringUtils.hasText(uri)) {
			uri = uri.trim();
			return uri.contains("://");
		}
		return false;
	}


}
