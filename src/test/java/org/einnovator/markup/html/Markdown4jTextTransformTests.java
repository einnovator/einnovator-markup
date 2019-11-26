/**
 * 
 */
package org.einnovator.markup.html;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author jsima
 *
 */
public class Markdown4jTextTransformTests {

	@Test
	public void test() {
		Markdown4jTextTransform transform = new Markdown4jTextTransform();
		
		System.out.println(transform.transform("<a href=\"https://test.org\"></a>"));
	}

}
