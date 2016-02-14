package com.company.app.pojo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="book")
public class Book implements java.io.Serializable {
  
  private static final long serialVersionUID = 1L;
  
  private String author;
  private String title;
  
  public String getAuthor() {
    return author;
  }
  
  
  public void setAuthor(String author) {
    this.author = author;
  }
  public String getTitle() {
    return title;
  }
  
  public void setTitle(String title) {
    this.title = title;
  }
  
  

}
