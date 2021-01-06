/**
 * 
 */
package org.einnovator.markup.html;

import static org.junit.Assert.*;

import org.junit.Test;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

/**
 * @author jsima
 *
 */
public class JSoupTests {

	@Test
	public void test() {
		Document doc = new Document("");
		Element html = doc.createElement("html");
		html.attr("style", "height: 100%");
		Element head = html.appendElement("head");
		Element body = html.appendElement("body");
		body.appendElement("div");
		System.out.println(html.outerHtml());
		
	}

}
