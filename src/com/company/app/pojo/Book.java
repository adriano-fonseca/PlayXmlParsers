package com.company.app.pojo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="book")
public class Book implements java.io.Serializable {
  
  private static final long serialVersionUID = 1L;
  
  @XmlAttribute
  private Long id;
  
  @XmlElement(name="author_name")
  private String author;
  private String title;
  
  public Book(){
    super();
  }
  
  public Book(Long idBook, String author, String title){
    super();
    this.setId(idBook);
    this.setAuthor(author);
    this.setTitle(title);
  }
  
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
  
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  @Override
  public String toString() {
    return "Book [idBook=" + id + ", author=" + author + ", title=" + title + "]";
  }
  
  
}
