package com.company.app.parse.sax.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SaxParserUtil {

  
  public static void readXMLDocumentWithSAX() {
    try {

      SAXParserFactory factory = SAXParserFactory.newInstance();
      SAXParser saxParser = factory.newSAXParser();

      DefaultHandler handler = new DefaultHandler() {

        boolean author  = false;

        boolean title  = false;

        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
          
          if (qName.equalsIgnoreCase("book")) {
            System.out.println("\n");
          }
          
          System.out.println("Start Element:" + qName);
          
          if (qName.equalsIgnoreCase("author")) {
            author = true;
          }

          if (qName.equalsIgnoreCase("title")) {
            title = true;
          }
        }

        public void endElement(String uri, String localName, String qName) throws SAXException {
          
          System.out.println("End Element :" + qName);
          
          if (qName.equalsIgnoreCase("book")) {
            System.out.println("\n");
          }

        }

        public void characters(char ch[], int start, int length) throws SAXException {

//          System.out.println(new String(ch, start, length));

          if (author) {
            System.out.println("Author : " + new String(ch, start, length));
            author = false;
          }

          if (title) {
            System.out.println("Title : " + new String(ch, start, length));
            title = false;
          }
        }

      };

      File file = new File("./xml/library.xml");
      InputStream inputStream = new FileInputStream(file);
      Reader reader = new InputStreamReader(inputStream, "UTF-8");

      InputSource is = new InputSource(reader);
      is.setEncoding("UTF-8");

      saxParser.parse(is, handler);

    } catch (Exception e) {
      e.printStackTrace();
    }

  }
}
