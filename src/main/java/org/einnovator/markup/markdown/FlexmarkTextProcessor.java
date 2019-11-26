/**
 * 
 */
package org.einnovator.markup.markdown;

import java.util.Arrays;

import org.einnovator.markup.text.TextTransform;

import com.vladsch.flexmark.ext.abbreviation.AbbreviationExtension;
import com.vladsch.flexmark.ext.admonition.AdmonitionExtension;
import com.vladsch.flexmark.ext.attributes.AttributesExtension;
import com.vladsch.flexmark.ext.autolink.AutolinkExtension;
import com.vladsch.flexmark.ext.definition.DefinitionExtension;
import com.vladsch.flexmark.ext.emoji.EmojiExtension;
import com.vladsch.flexmark.ext.enumerated.reference.EnumeratedReferenceExtension;
import com.vladsch.flexmark.ext.footnotes.FootnoteExtension;
import com.vladsch.flexmark.ext.macros.MacrosExtension;
import com.vladsch.flexmark.ext.tables.TablesExtension;
import com.vladsch.flexmark.ext.typographic.TypographicExtension;
import com.vladsch.flexmark.ext.youtube.embedded.YouTubeLinkExtension;
import com.vladsch.flexmark.html.HtmlRenderer;
import com.vladsch.flexmark.parser.Parser;
import com.vladsch.flexmark.parser.ParserEmulationProfile;
import com.vladsch.flexmark.util.ast.Node;
import com.vladsch.flexmark.util.data.MutableDataSet;

/**
 *
 */
public class FlexmarkTextProcessor implements TextTransform {

	private Parser parser;
	private HtmlRenderer renderer;
	
	
	/**
	 * Create instance of {@code FlexmarkTextProcessor}.
	 *
	 */
	public FlexmarkTextProcessor() {
		 MutableDataSet options = new MutableDataSet();
	      options.setFrom(ParserEmulationProfile.KRAMDOWN);		
	      options.set(Parser.EXTENSIONS, Arrays.asList(
                AbbreviationExtension.create(),
                DefinitionExtension.create(),
                FootnoteExtension.create(),
                TablesExtension.create(),
                TypographicExtension.create(),
                AutolinkExtension.create(),
                AttributesExtension.create(),
                MacrosExtension.create(),
                AdmonitionExtension.create(),
                EmojiExtension.create(),
                EnumeratedReferenceExtension.create(),
                YouTubeLinkExtension.create()
        ));
	    options.set(EmojiExtension.ROOT_IMAGE_PATH, "https://www.webfx.com/tools/emoji-cheat-sheet/graphics/emojis/");
		parser = Parser.builder(options).build();

		renderer = HtmlRenderer.builder(options).build();
	}
	
	/**
	 * Get the value of property {@code parser}.
	 *
	 * @return the parser
	 */
	public Parser getParser() {
		return parser;
	}

	/**
	 * Set the value of property {@code parser}.
	 *
	 * @param parser the value of property parser
	 */
	public void setParser(Parser parser) {
		this.parser = parser;
	}

	/**
	 * Get the value of property {@code renderer}.
	 *
	 * @return the renderer
	 */
	public HtmlRenderer getRenderer() {
		return renderer;
	}

	/**
	 * Set the value of property {@code renderer}.
	 *
	 * @param renderer the value of property renderer
	 */
	public void setRenderer(HtmlRenderer renderer) {
		this.renderer = renderer;
	}

	@Override
	public String transform(String text) {
		 Node document = parser.parse(text);
	     return renderer.render(document);
	}

}
