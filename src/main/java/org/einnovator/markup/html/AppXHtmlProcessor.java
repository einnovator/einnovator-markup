package org.einnovator.markup.html;

import org.einnovator.util.StringUtil;
import org.einnovator.util.UriUtils;

public class AppXHtmlProcessor extends XHtmlProcessor  {

	String[] ignoreElements = {"html", "body"};
	String[] ignoreElementTree = {"head"};
	
	private String urlPrefix;
	
	public AppXHtmlProcessor() {
		setIgnoreComments(true);
		setIgnoreDtd(true);
		setIgnoreStartDocument(true);
	}

	public AppXHtmlProcessor(String urlPrefix) {
		this.urlPrefix = urlPrefix;
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
	
	@Override
	protected String processUrl(String uri) {
		return UriUtils.qualify(uri, urlPrefix);
	}
}
