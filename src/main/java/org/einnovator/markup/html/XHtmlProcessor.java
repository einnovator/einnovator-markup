package org.einnovator.markup.html;


public class XHtmlProcessor extends XMLProcessor  {

	public XHtmlProcessor() {
	}

	//
	// Getters an Setters
	//

	//
	// XMLProcessor Implementation
	//
	
	@Override
	protected String processAttributeValue(String elementPrefix,
			String elementLocalName, String elementNamespaceURI,
			String attributePrefix, String attributeNamespaceURI, 
			String attributeLocalName, String value) {
		if ("a".equals(elementLocalName)) {
			if ("href".equals(attributeLocalName)) {
				value = processUrl(value);
			}
		}
		if ("img".equals(elementLocalName)) {
			if ("src".equals(attributeLocalName)) {
				value = processUrl(value);
			}
		}
		if ("link".equals(elementLocalName)) {
			if ("href".equals(attributeLocalName)) {
				value = processUrl(value);
			}
		}

		return value;
	}

	protected String processUrl(String value) {
		return value;
	}
	
	
}
