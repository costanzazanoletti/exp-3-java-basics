package learning.java.files.person;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class FileHandler {

  private final static String FILE_PATH = "./people.txt";

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    System.out.print("How many? ");
    int n = Integer.parseInt(scan.nextLine());
    Person[] list = new Person[n];

    for (int i = 0; i < n; i++) {
      System.out.print("Name: ");
      String name = scan.nextLine();
      System.out.print("Age: ");
      int age = Integer.parseInt(scan.nextLine());
      Person p = new Person(name, age);
      list[i] = p;
    }
    scan.close();
    System.out.println(Arrays.toString(list));

    /******* persisto l'array di persone su file ************/
    FileWriter myWriter = null;
    try {
      myWriter = new FileWriter(FILE_PATH, true);
      for (Person currentPerson : list) {
        myWriter.write(currentPerson.toString() + "\n");
      }
    } catch (IOException e) {
      System.out.println("Unable to create file");
      System.out.println(e.getMessage());
    } finally {
      // da qui ci passo sempre e chiudo il FileWriter
      if (myWriter != null) {
        try {
          myWriter.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }

    }

    /********* leggo il file **********/
    Scanner fileScanner = null;
    try {
      fileScanner = new Scanner(new File(FILE_PATH));
      while (fileScanner.hasNext()) {
        String line = fileScanner.nextLine();
        System.out.println(line);
      }
    } catch (FileNotFoundException e) {
      throw new RuntimeException(e);
    } finally {
      if (fileScanner != null) {
        try {
          fileScanner.close();
        } catch (IllegalStateException ise) {
          ise.printStackTrace();
        }
      }
    }
  }
}
