package com.company.app.pojo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="library")
public class Library implements Serializable {

  private static final long serialVersionUID = 1L;

  @XmlElement(name="book",type=Book.class)
  private List<Book> bookList = new ArrayList<Book>();
  
  private String name;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<Book> getBookList() {
    return bookList;
  }

  public void setBookList(List<Book> list) {
    this.bookList = list;
  }
}
