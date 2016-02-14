package com.company.app.parse.sax.test;

import javax.xml.transform.TransformerFactoryConfigurationError;


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
public class PlayWithSaxParserReading {
  
  /*DOM - Document object model - Tree based
   * reads entire document
   * can add and remove nodes
   * */
  public static void main(String[] args) {
    try {
     SaxParserUtil.readXMLDocumentWithSAX();
    } catch (TransformerFactoryConfigurationError e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
}
