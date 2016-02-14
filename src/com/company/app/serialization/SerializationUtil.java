package com.company.app.serialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializationUtil {

  public static void serialize(Object o, String path) {
    try {
      FileOutputStream fileOut = new FileOutputStream(path,false);
      ObjectOutputStream out = new ObjectOutputStream(fileOut);
      out.writeObject(o);
      out.close();
      fileOut.close();
      System.out.println("Serialized data is saved in "+path+"\n");
    } catch (IOException i) {
      i.printStackTrace();
    }

  }

  public static Object unserialize(String path) {
    Object e = null;
    try {
      FileInputStream fileIn = new FileInputStream(path);
      ObjectInputStream in = new ObjectInputStream(fileIn);
      e = in.readObject();
      in.close();
      fileIn.close();
    } catch (IOException i){
      i.printStackTrace();
    } catch (ClassNotFoundException c) {
      System.out.println("Employee class not found");
      c.printStackTrace();
    }
    return e;
  }

}
