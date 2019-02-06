package org.einnovator.markup.html;

import org.einnovator.util.StringUtil;

public class AppXHtmlProcessor extends XHtmlProcessor  {

	String[] ignoreElements = {"html", "body"};
	String[] ignoreElementTree = {"head"};
	
	public AppXHtmlProcessor() {
		setIgnoreComments(true);
		setIgnoreDtd(true);
		setIgnoreStartDocument(true);
	}

	//
	// Getters an Setters
	//

	//
	// XMLProcessor Implementation
	//
	
	@Override
	protected boolean ignoreElement(String elementPrefix,
			String elementLocalName, String elementNamespaceURI) {
		return StringUtil.contains(ignoreElements, elementLocalName);
	}
	
	@Override
	protected boolean ignoreTree(String elementPrefix, String elementLocalName,
			String elementNamespaceURI) {
		return StringUtil.contains(ignoreElementTree, elementLocalName);
	}
}
