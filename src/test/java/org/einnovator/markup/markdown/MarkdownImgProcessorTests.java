/**
 * 
 */
package org.einnovator.markup.markdown;

import static org.junit.Assert.*;

import org.einnovator.markup.html.MarkdownImgProcessor;
import org.junit.Test;

/**
 * @author jsima
 *
 */
public class MarkdownImgProcessorTests {

	@Test
	public void test() {
		MarkdownImgProcessor processor = new MarkdownImgProcessor("https://cnd.einnovator.org/", "/doc");
		
		System.out.println(processor.transform("( abc )"));

		System.out.println(processor.transform("![abc]( abc.png )"));

	}

}
