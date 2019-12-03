/**
 * 
 */
package org.einnovator.markup.markdown;

import static org.junit.Assert.*;

import org.einnovator.markup.html.MarkdownLinkProcessor;
import org.junit.Test;

/**
 * @author jsima
 *
 */
public class MarkdownLinkProcessorTests {

	@Test
	public void test() {
		MarkdownLinkProcessor processor = new MarkdownLinkProcessor("https://cnd.einnovator.org/doc");
		
		System.out.println(processor.transform("( abc )"));
		System.out.println(processor.transform("[ abc ]"));

		System.out.println(processor.transform("[abc]( abc.html )"));

	}

}
