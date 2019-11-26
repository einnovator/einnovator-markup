/**
 * 
 */
package org.einnovator.markup.markdown;

import org.junit.Test;

/**
 *
 */
public class FlexmarkTextProcessorTests {
	FlexmarkTextProcessor processor = new FlexmarkTextProcessor();

	@Test
	public void test() {
		
		flexmark("## ABC");

		flexmark("## ABC{class=\"xx\"}");

		flexmark("[AAA](https://cms.einnovator.org/quickguide/spring-4-dependency-injection-annotations){target=\"_blank\"}");
	
		flexmark("a --- b");
		flexmark("'text'");
		flexmark("a ...");

		flexmark("<a href=\"https://test.org\"></a>");
		flexmark("[Test](https://test.org){title=\"abc\"}");
		flexmark("https://test.org");
		
		flexmark("!!! note \"Title\"\nXXX ");
		flexmark("!V[Text](https://abc.video.org)");
		flexmark("xx <<<amacro>>>\n\n"+
		">>>amacro\n"+
		"**bold** text\n"+
		"<<<");
		
		flexmark(":octocat:");


	}
	
	public void flexmark(String text) {
		System.out.println(processor.transform(text));
	}

}
