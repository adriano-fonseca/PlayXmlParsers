package com.company.app.jaxb.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.xml.sax.InputSource;

import com.company.app.pojo.Library;

public class JaxBUtil {

  public static Library readXML(String path) {
    File file = new File(path);
    FileInputStream fis = null;
    JAXBContext jaxbContext = null;
    Library lib = null;

    try {
      fis = new FileInputStream(file);
      InputSource is = new InputSource(fis);
      is.setEncoding("UTF-8");
      jaxbContext = JAXBContext.newInstance(Library.class);
      Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
      lib = (Library) jaxbUnmarshaller.unmarshal(is);
    } catch (FileNotFoundException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (JAXBException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

    return lib;
  }

  public static void writeXML(Library lib) {

    try {
      File file = new File("./xml/libraryJaxB.xml");
      JAXBContext jaxbContext = JAXBContext.newInstance(Library.class);
      Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

      // output pretty printed
      jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

      jaxbMarshaller.marshal(lib, file);
      jaxbMarshaller.marshal(lib, System.out);

    } catch (JAXBException e) {
      e.printStackTrace();
    }

  }

}
