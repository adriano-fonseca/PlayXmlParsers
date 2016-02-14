package com.company.app.serialization;

import com.company.app.pojo.Book;
import com.company.app.pojo.Library;

public class SerializationUtilTest {

  public static void main(String[] args) {
   
//   Book book = new Book();
//   book.setAuthor("Adriano Fonseca");
//   book.setTitle("Serializing Objects in JAVA");
   String path = "./files/book.ser";
//   
//   Library lib = new Library();
//   lib.setName("Public Library");
//   lib.getBookList().add(book);
//   SerializationUtil.serialize(lib,path);
   

   Library libUnserialized = (Library) SerializationUtil.unserialize(path);
   Book bookUnserialized = libUnserialized.getBookList().get(0);
   
   System.out.println("Library Name: "+libUnserialized.getName());
   System.out.println("Author: "+bookUnserialized.getAuthor());
   System.out.println("Title: "+bookUnserialized.getTitle());
   
   libUnserialized.getBookList().add(addBook());
   SerializationUtil.serialize(libUnserialized,path);
   libUnserialized = (Library) SerializationUtil.unserialize(path);
   System.out.println("List Size: "+libUnserialized.getBookList().size());
  }
  
  public static Book addBook(){
    Book book = new Book();
    book.setAuthor("Adriano Fonseca");
    book.setTitle("Serializing Objects in JAVA");
    return book;
  }
  
}
