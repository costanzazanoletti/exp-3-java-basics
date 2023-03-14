package learning.java.files;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class Main {

  public static void main(String[] args) {
    File filePath = new File(".");
    System.out.println(filePath.exists());
    System.out.println(filePath.getAbsolutePath());
    System.out.println(filePath.isDirectory());
    File[] files = filePath.listFiles();
    for (int i = 0; i < files.length; i++) {
      System.out.println(files[i]);
      if (files[i].isDirectory()) {
        System.out.println(Arrays.toString(files[i].listFiles()));
      }
    }

    File resources = new File("./resources/temp.txt");
    try {
      resources.createNewFile();
    } catch (IOException e) {
      System.out.println("Impossibile creare il file");
    }
  }
}
