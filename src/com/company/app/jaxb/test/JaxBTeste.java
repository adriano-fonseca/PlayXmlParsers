package com.company.app.jaxb.test;

import java.io.FileNotFoundException;

import javax.xml.bind.JAXBException;

import com.company.app.pojo.Book;
import com.company.app.pojo.Library;

public class JaxBTeste {
  
  public static void main(String[] args) throws FileNotFoundException, JAXBException{
    Library lib = JaxBUtil.readXML("./xml/library.xml");
//    lib.setName("Public Library");
    int index = 1;
    for(Book book : lib.getBookList()){
      System.out.println(book.getId());
      System.out.println(book.getAuthor());
      System.out.println(book.getTitle());
      index++;
    }
//    JaxBUtil.writeXML(lib);
  }
  
}
