package org.einnovator.markup.html;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.XMLStreamWriter;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.einnovator.util.StringUtil;
import org.einnovator.markup.text.TextTransform;
import org.springframework.util.StringUtils;

public class XMLProcessor implements TextTransform {

	XMLInputFactory fin;

	XMLOutputFactory fout;

	private final Log logger = LogFactory.getLog(getClass());
	
	private boolean ignoreDtd;
	
	private boolean ignoreStartDocument;
	
	private boolean ignorePI;
	
	private boolean ignoreComments;
	
	private boolean ignoreSpaces;
	
	private boolean trimSpaces;
	
	public XMLProcessor() {
		fin = XMLInputFactory.newInstance();
		fout = XMLOutputFactory.newInstance();
		//fin.setProperty("report-cdata-event", Boolean.TRUE);
	}

	//
	// Getters an Setters
	//	
	/**
	 * Get the value of property {@code ignoreDtd}.
	 *
	 * @return the {@code ignoreDtd}
	 */
	public boolean isIgnoreDtd() {
		return ignoreDtd;
	}

	/**
	 * Set the value of property {@code ignoreDtd}.
	 *
	 * @param ignoreDtd the {@code ignoreDtd} to set
	 */
	public void setIgnoreDtd(boolean ignoreDtd) {
		this.ignoreDtd = ignoreDtd;
	}

	/**
	 * Get the value of property {@code ignoreStartDocument}.
	 *
	 * @return the {@code ignoreStartDocument}
	 */
	public boolean isIgnoreStartDocument() {
		return ignoreStartDocument;
	}

	/**
	 * Set the value of property {@code ignoreStartDocument}.
	 *
	 * @param ignoreStartDocument the {@code ignoreStartDocument} to set
	 */
	public void setIgnoreStartDocument(boolean ignoreStartDocument) {
		this.ignoreStartDocument = ignoreStartDocument;
	}

	/**
	 * Get the value of property {@code ignorePI}.
	 *
	 * @return the {@code ignorePI}
	 */
	public boolean isIgnorePI() {
		return ignorePI;
	}

	/**
	 * Set the value of property {@code ignorePI}.
	 *
	 * @param ignorePI the {@code ignorePI} to set
	 */
	public void setIgnorePI(boolean ignorePI) {
		this.ignorePI = ignorePI;
	}

	/**
	 * Get the value of property {@code ignoreComments}.
	 *
	 * @return the {@code ignoreComments}
	 */
	public boolean isIgnoreComments() {
		return ignoreComments;
	}

	/**
	 * Set the value of property {@code ignoreComments}.
	 *
	 * @param ignoreComments the {@code ignoreComments} to set
	 */
	public void setIgnoreComments(boolean ignoreComments) {
		this.ignoreComments = ignoreComments;
	}

	/**
	 * Get the value of property {@code ignoreSpaces}.
	 *
	 * @return the {@code ignoreSpaces}
	 */
	public boolean isIgnoreSpaces() {
		return ignoreSpaces;
	}

	/**
	 * Set the value of property {@code ignoreSpaces}.
	 *
	 * @param ignoreSpaces the {@code ignoreSpaces} to set
	 */
	public void setIgnoreSpaces(boolean ignoreSpaces) {
		this.ignoreSpaces = ignoreSpaces;
	}
	
	/**
	 * Get the value of property {@code trimSpaces}.
	 *
	 * @return the {@code trimSpaces}
	 */
	public boolean isTrimSpaces() {
		return trimSpaces;
	}

	/**
	 * Set the value of property {@code trimSpaces}.
	 *
	 * @param trimSpaces the {@code trimSpaces} to set
	 */
	public void setTrimSpaces(boolean trimSpaces) {
		this.trimSpaces = trimSpaces;
	}

	//
	// TextTransform Implementation
	//
	

	public String transform(String text) {
		try {
			return transformInternal(text);
		} catch (XMLStreamException e) {
			throw new RuntimeException(e);
		}
	}


	
	public String transformInternal(String text) throws XMLStreamException {
		ByteArrayInputStream in = new ByteArrayInputStream(text.getBytes());
		ByteArrayOutputStream out = new ByteArrayOutputStream(text.length());
		return transformInternal(in, out);
	}

	public String transformInternal(InputStream in, OutputStream out) throws XMLStreamException {
		XMLStreamReader reader = fin.createXMLStreamReader(in);
		XMLStreamWriter writer = null;

		boolean ignore = false;
		String ignoredElementLocalName = null;
		String ignoredElementPrefix = null;
		String ignoredElementNamespace = null;	
		while(reader.hasNext()) {
			int ev = reader.getEventType();
			switch (ev) {
			case XMLStreamReader.START_DOCUMENT:
				writer = fout.createXMLStreamWriter(out, reader.getEncoding());
				if (ignoreStartDocument) {
					break;
				}
				if ((logger.isTraceEnabled())) {
					logger.trace(String.format("transformInternal[START_DOCUMENT]:  %s %s", reader.getEncoding(), reader.getVersion()));					
				}				
				writer.writeStartDocument(reader.getEncoding(), reader.getVersion());
				break;
			case XMLStreamReader.END_DOCUMENT:
				if (ignoreStartDocument) {
					break;
				}
				if ((logger.isTraceEnabled())) {
					logger.trace(String.format("transformInternal[END_DOCUMENT]"));					
				}
				writer.writeEndDocument();
				break;

			case XMLStreamReader.START_ELEMENT: {
				if (ignore) {
					break;
				}
				if (ignoreTree(reader.getPrefix(), reader.getLocalName(), reader.getNamespaceURI())) {		
					ignore = true;
					ignoredElementLocalName = reader.getLocalName();
					ignoredElementPrefix = reader.getPrefix();
					ignoredElementNamespace = reader.getNamespaceURI();
					break;
				}
				if (!ignoreElement(reader.getPrefix(), reader.getLocalName(), reader.getNamespaceURI())) {
					writeStartElement(reader, writer);
					break;
				}
				break;
			}
			case XMLStreamReader.END_ELEMENT:
				if (ignore) {
					if (StringUtil.equals(ignoredElementLocalName, reader.getLocalName()) &&
						StringUtil.equals(ignoredElementPrefix, reader.getPrefix()) &&
						StringUtil.equals(ignoredElementNamespace, reader.getNamespaceURI())) {
						ignore = false;
					}
					break;
				}

				if ((logger.isTraceEnabled())) {
					logger.trace(String.format("transformInternal[END_ELEMENT]: %s %s %s", reader.getPrefix(), reader.getLocalName(), reader.getNamespaceURI()));					
				}
				if (!ignoreElement(reader.getPrefix(), reader.getLocalName(), reader.getNamespaceURI())) {
					writer.writeEndElement();					
				}
				break;
			case XMLStreamReader.ATTRIBUTE: {
				if (ignore) {
					break;
				}
				if ((logger.isTraceEnabled())) {
					logger.trace(String.format("transformInternal[ATTRIBUTE]: %s", reader.getAttributeCount()));					
				}
				break;
			}
			case XMLStreamReader.NAMESPACE: {
				if (ignore) {
					break;
				}
				if ((logger.isTraceEnabled())) {
					logger.trace(String.format("transformInternal[NAMESPACE]: %s", reader.getNamespaceCount()));					
				}
				for (int i=0; i<reader.getNamespaceCount(); i++) {
					if ((logger.isTraceEnabled())) {
						logger.trace(String.format("transformInternal[NAMESPACE]: %s", reader.getNamespacePrefix(i), reader.getNamespaceURI(i)));					
					}
					writer.writeNamespace(reader.getNamespacePrefix(i), reader.getNamespaceURI(i));
				}
				break;
			}
			case XMLStreamReader.CHARACTERS:
				if (ignore) {
					break;
				}
				String text = reader.getText();
				if (ignoreSpaces && !StringUtils.hasText(text)) {
					break;
				}
				/*if (trimSpaces) {
					text = text.trim();
				}*/
				if ((logger.isTraceEnabled())) {
					logger.trace(String.format("transformInternal[CHARACTERS]: %s", text));
				}
				writer.writeCharacters(text);
				break;
			case XMLStreamReader.CDATA: {
				if (ignore) {
					break;
				}
				if ((logger.isTraceEnabled())) {
					logger.trace(String.format("transformInternal[CDATA]: %s", reader.getText()));					
				}
				String cdata = reader.getText();
				if (cdata.startsWith("\n")) {
					cdata.substring(1);
				}
				if (cdata.endsWith("\n")) {
					cdata.substring(0, cdata.length()-1);
				}
				writer.writeCData(cdata);
				break;
			}
			case XMLStreamReader.COMMENT:
				if (ignore) {
					break;
				}
				if (ignore || ignoreComments) {
					break;
				}
				if ((logger.isTraceEnabled())) {
					logger.trace(String.format("transformInternal[COMMENT]: %s", reader.getText()));					
				}
				String comment = reader.getText();
				writer.writeComment(comment);
				break;
			case XMLStreamReader.SPACE: {
				if (ignore || ignoreSpaces) {
					break;
				}
				if ((logger.isTraceEnabled())) {
					logger.trace(String.format("transformInternal[SPACE]: %s", reader.getText()));					
				}
				writer.writeCharacters(reader.getText());
				break;
			}
			case XMLStreamReader.PROCESSING_INSTRUCTION:
				if (ignore || ignorePI) {
					break;
				}
				if ((logger.isTraceEnabled())) {
					logger.trace(String.format("transformInternal[PROCESSING_INSTRUCTION]: %s", reader.getText()));					
				}
				writer.writeProcessingInstruction(reader.getPITarget(), reader.getPIData());
				break;
			case XMLStreamReader.ENTITY_REFERENCE:
				if (ignore) {
					break;
				}
				if ((logger.isTraceEnabled())) {
					logger.trace(String.format("transformInternal[ENTITY_REFERENCE]: %s", reader.getText()));
				}
				writer.writeEntityRef(reader.getText());
				break;
			case XMLStreamReader.DTD:
				if (ignore || ignoreDtd) {
					break;
				}
				if ((logger.isTraceEnabled())) {
					logger.trace(String.format("transformInternal[DTD]: %s", reader.getText()));
				}
				writer.writeDTD(reader.getText());
				break;
			}

			reader.next();
		}
		reader.close();
		writer.close();
		return out.toString();
	}
	
	protected void writeStartElement(XMLStreamReader reader, XMLStreamWriter writer) throws XMLStreamException {
		if ((logger.isTraceEnabled())) {
			logger.trace(String.format("transformInternal[START_ELEMENT]: %s %s %s", reader.getPrefix(), reader.getLocalName(), reader.getNamespaceURI()));
		}
		if (!StringUtils.isEmpty(reader.getNamespaceURI())) {
			writer.writeStartElement(reader.getPrefix(), reader.getLocalName(), reader.getNamespaceURI());					
		} else {
			if (!StringUtils.isEmpty(reader.getPrefix())) {
				writer.writeStartElement(reader.getPrefix(), reader.getLocalName());						
			} else {
				writer.writeStartElement(reader.getLocalName());						
			}
		}
		for (int i=0; i<reader.getAttributeCount(); i++) {
			writeAttribute(writer, reader.getPrefix(), reader.getLocalName(), reader.getNamespaceURI(),
					reader.getAttributePrefix(i), reader.getAttributeNamespace(i),
					reader.getAttributeLocalName(i), reader.getAttributeValue(i));
		}
	}
	
	protected boolean ignoreElement(String elementPrefix, String elementLocalName, String elementNamespaceURI) {
		return false;
	}

	protected boolean ignoreTree(String elementPrefix, String elementLocalName, String elementNamespaceURI) {
		return false;
	}

	protected void writeAttribute(XMLStreamWriter writer,
			String elementPrefix, String elementLocalName, String elementNamespaceURI, 
			String attributePrefix, String attributeNamespace, String attributeLocalName,  String attributeValue) throws XMLStreamException {
		String value = processAttributeValue(elementPrefix, elementLocalName, elementNamespaceURI, 
				attributePrefix, attributeNamespace, attributeLocalName, attributeValue);
		if ((logger.isTraceEnabled())) {
			logger.trace(String.format("transformInternal[ATTRIBUTE]: %s %s %s %s %s", attributePrefix, attributeNamespace,
					attributeLocalName, attributeValue, value));						
		}
		if (value!=null) {
			if (!StringUtils.isEmpty(attributeNamespace)) {
				writer.writeAttribute(attributePrefix, attributeNamespace, attributeLocalName, value);
			} else {
				if (!StringUtils.isEmpty(attributePrefix)) {
					writer.writeAttribute(attributePrefix, attributeLocalName, value);
				} else {
					writer.writeAttribute(attributeLocalName, value);
				}
			}			
		}
	}

	protected String processAttributeValue(String elementPrefix, String elementLocalName, String elementNamespaceURI, 
			String attributePrefix,  String attributeNamespaceURI, String attributeLocalName, String value) {
		return value;
	}
	
}
