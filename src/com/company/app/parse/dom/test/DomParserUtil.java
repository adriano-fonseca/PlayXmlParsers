package com.company.app.parse.dom.test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;

public class DomParserUtil {

  public static void writeXMLDocumentWithDom() throws ParserConfigurationException, TransformerFactoryConfigurationError, FileNotFoundException, TransformerException {
    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    DocumentBuilder builder = factory.newDocumentBuilder();
    Document doc = builder.newDocument();

    Element library = doc.createElement("library"); //root

    /*Create First Book*/
    Element book = doc.createElement("book"); //element
    Element author = doc.createElement("author"); // element attribute
    Element title = doc.createElement("title"); // element attribute
    Text authorBookText = doc.createTextNode("Adriano Fonseca"); // attribute value
    Text titleBookText = doc.createTextNode("Learning XML DOM Parsing"); // attribute value

    author.appendChild(authorBookText); //link value to atribute
    title.appendChild(titleBookText); //link value to atribute

    book.appendChild(author); //link attribute to element
    book.appendChild(title); //link attribute to element
    library.appendChild(book);
    
    // set attribute to book element
    // shorten way
    book.setAttribute("id", "1");

    /*Create Second Book*/
    Element book2 = doc.createElement("book"); //element
    Element author2 = doc.createElement("author"); // element attribute
    Element title2 = doc.createElement("title"); // element attribute
    Text authorBookText2 = doc.createTextNode("Katy Sierra"); // attribute value
    Text titleBookText2 = doc.createTextNode("Learning Java"); // attribute value

    author2.appendChild(authorBookText2); //link value to atribute
    title2.appendChild(titleBookText2); //link value to atribute
    book2.appendChild(author2); //link attribute to element
    book2.appendChild(title2); //link attribute to element

    /*Append Elements*/
    library.appendChild(book2);
    Attr attr2 = doc.createAttribute("id");
    attr2.setValue("2");
    book2.setAttributeNode(attr2);

    doc.appendChild(library);
    Transformer transformer = TransformerFactory.newInstance().newTransformer();
    transformer.setOutputProperty(OutputKeys.INDENT, "yes");
    transformer.setOutputProperty(OutputKeys.METHOD, "xml");
    transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
    //    transformer.setOutputProperty(OutputKeys.DOCTYPE_SYSTEM, "roles.dtd");
    transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
    transformer.transform(new DOMSource(doc), new StreamResult(new FileOutputStream("./xml/library.xml")));

    System.out.println("XML Criado");
  }

  public static void readXMLDocumentWithDom() {
    try {

      File fXmlFile = new File("./xml/library.xml");
      DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
      DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
      Document doc = dBuilder.parse(fXmlFile);

      //optional, but recommended
      //read this - http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
      doc.getDocumentElement().normalize();

      NodeList nList = doc.getElementsByTagName("book");
      System.out.println("Total of elements : " + nList.getLength());
      System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
      System.out.println("----------------------------");

      for (int temp = 0; temp < nList.getLength(); temp++) {
        Node nNode = nList.item(temp);
        System.out.println("\nCurrent Element :" + nNode.getNodeName());
        if (nNode.getNodeType() == Node.ELEMENT_NODE) {
          Element eElement = (Element) nNode;
          System.out.println("Book id : " + eElement.getAttribute("id"));
          System.out.println("Author : " + eElement.getElementsByTagName("author").item(0).getTextContent());
          System.out.println("Title : " + eElement.getElementsByTagName("title").item(0).getTextContent());
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
