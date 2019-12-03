/**
 * 
 */
package org.einnovator.markup.markdown;

import static org.junit.Assert.*;

import org.einnovator.markup.html.AppXHtmlProcessor;
import org.einnovator.markup.html.MarkdownImgProcessor;
import org.einnovator.markup.html.MarkdownLinkProcessor;
import org.einnovator.markup.text.CompositeTextTransform;
import org.einnovator.markup.text.TextTransform;
import org.junit.Test;

/**
 *
 */
public class MarkdownTests {

	@Test
	public void test() {

		FlexmarkTextProcessor markdownProcess = new FlexmarkTextProcessor();
		
		MarkdownImgProcessor imgProcessor = new MarkdownImgProcessor("https://cnd.einnovator.org/", "/doc");
		String basePath = "https://test.einnovator.org/pub";
		MarkdownLinkProcessor linkProcessor = new MarkdownLinkProcessor(basePath);
		TextTransform processor = new CompositeTextTransform(imgProcessor, linkProcessor, markdownProcess);
		
		
		System.out.println(markdownProcess.transform("/( abc /)"));
		System.out.println(markdownProcess.transform("xxx /( abc /) yyy"));
		System.out.println(markdownProcess.transform("xxx ( abc ) yyy"));
		System.out.println(markdownProcess.transform("\\( \\)"));

		System.out.println(processor.transform("/( abc /)"));
		System.out.println(processor.transform("xxx /( abc /) yyy"));
		System.out.println(processor.transform("xxx ( abc ) yyy"));
		System.out.println(processor.transform("\\( \\)"));

		
	}

}
