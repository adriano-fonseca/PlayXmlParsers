package com.company.app.parse.dom.test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.UnsupportedEncodingException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.FactoryConfigurationError;
import javax.xml.stream.XMLStreamException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;
import org.xml.sax.SAXException;


/*
 *  
  I think you should not consider any specific parser implementation. Java API for XML Processing lets you use any conforming parser implementation in a standard way. The code should be much more portable, and when you realise that a specific parser has grown too old, you can replace it with another without changing a line of your code (if you do it correctly).
  
  Basically there are three ways of handling XML in a standard way:
  
  SAX This is the simplest API. You read the XML by defining a Handler class that receives the data inside elements/attributes
  when the XML gets processed in a serial way. It is faster and simpler if you only plan to read some attributes/elements and/or
  write some values back (your case).
  
  DOM This method creates an object tree which lets you modify/access it randomly so it is better for complex XML manipulation and
  handling.
  
  StAX This is in the middle of the path between SAX and DOM. You just write code to pull the data from the parser you are 
  interested in when it is processed.
  
  JaxB To make bind to xml to pojo 

 */
public class PlayWithDomParserReading {
  
  /*DOM - Document object model - Tree based
   * reads entire document
   * can add and remove nodes
   * */
  public static void main(String[] args) {
    try {
     DomParserUtil.readXMLDocumentWithDom();
    } catch (TransformerFactoryConfigurationError e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
}
