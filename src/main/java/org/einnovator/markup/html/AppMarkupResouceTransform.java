package org.einnovator.markup.html;

import org.einnovator.markup.text.CompositeTextTransform;
import org.einnovator.markup.text.TextTransform;
import org.einnovator.markup.text.TextTransformRegistry;

public class AppMarkupResouceTransform implements TextTransform {

	private TextTransformRegistry registy = new TextTransformRegistry();
	
	TextTransform transform;
	
	public AppMarkupResouceTransform() {
		//registy.add(new EInnovatorDocumentTransform(), "www.jpalace.org", "static.jpalace.org");		
		transform = new CompositeTextTransform(
				new CDataMarkupTransform(new EntityMarkupTransform())
				, new SimpleBodyExtractorTransform());
		registy.setDefaultTranform(transform);
	}
	
	
	@Override
	public String transform(String text) {
		//if (text.indexOf("EInnovator")>0) {
		//	return transform("www.jpalace.org", text);
		//}
		//return transform("", text);
		return transform.transform(text);
	}

	String transform(Object key, String text) {
		return registy.transform(key, text);
	}


	
}
