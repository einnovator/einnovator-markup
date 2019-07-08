package org.einnovator.markup.html;

import java.util.Map;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.XMLStreamWriter;

public class CssXMLProcessor extends XMLProcessor {

	private Map<String, String> cssMap;
	
	/**
	 * Create instance of {@code CssXMLProcessor}.
	 *
	 */
	public CssXMLProcessor(Map<String, String> cssMap) {
		this.cssMap = cssMap;
	}
	
	//
	// Getters an Setters
	//	

	//
	// TextTransform Implementation
	//

	protected void writeStartElement(XMLStreamReader reader, XMLStreamWriter writer) throws XMLStreamException {
		super.writeStartElement(reader, writer);
		StringBuilder sb = null;
		String s= cssMap.get(reader.getLocalName());
		if (s!=null) {
			sb = new StringBuilder();
			sb.append(s);
		}
		for (int i=0; i<reader.getAttributeCount(); i++) {
			String name = reader.getAttributeLocalName(i);
			String value = reader.getAttributeValue(i);
			if ("style".equals(name)) {
				if (sb==null) {
					sb = new StringBuilder();
				} else if (sb.length()>0) {
					sb.append(";");
				}
				sb.append(value);
			} else if ("class".equals(name)) {
				s = cssMap.get("."+value);
				if (s!=null) {
					if (sb==null) {
						sb = new StringBuilder();
					} else if (sb.length()>0) {
						sb.append(";");
					}
					sb.append(s);
				}
			}  else if ("id".equals(name)) {
				s = cssMap.get("#"+value);
				if (s!=null) {
					if (sb==null) {
						sb = new StringBuilder();
					} else if (sb.length()>0) {
						sb.append(";");
					}
					sb.append(s);
				}
			}
		}
		if (sb!=null && sb.length()>0) {
			writer.writeAttribute("style", sb.toString());			
		}
		

	}

	protected String processAttributeValue(String elementPrefix, String elementLocalName, String elementNamespaceURI, 
			String attributePrefix,  String attributeNamespaceURI, String attributeLocalName, String value) {
		return "style".equals(attributeLocalName) ? null : value;
	}
	
}
