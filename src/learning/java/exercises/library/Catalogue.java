package learning.java.exercises.library;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Catalogue {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    System.out.print("How many books? ");
    int n = Integer.parseInt(scan.nextLine());

    Book[] books = new Book[n];
    for (int i = 0; i < books.length; i++) {
      System.out.println("Book n. " + (i + 1));
      String title = "";
      do {
        System.out.print("Title: ");
        title = scan.nextLine();
        if (title.length() == 0) {
          System.out.println("Title must not be empty");
        }
      } while (title.length() == 0);
      String author = "";
      do {
        System.out.print("Author: ");
        author = scan.nextLine();
        if (author.length() == 0) {
          System.out.println("Author must not be empty");
        }
      } while (author.length() == 0);
      String publisher = "";
      do {
        System.out.print("Publisher: ");
        publisher = scan.nextLine();
        if (publisher.length() == 0) {
          System.out.println("Publisher must not be empty");
        }
      } while (publisher.length() == 0);
      int numPages = 0;
      do {
        System.out.print("Number of pages: ");
        numPages = Integer.parseInt(scan.nextLine());
        if (numPages <= 0) {
          System.out.println("Number of pages must be greater than zero");
        }
      } while (numPages <= 0);

      books[i] = new Book(title, numPages, author, publisher);

    }
    scan.close();

    System.out.println(Arrays.toString(books));

    System.out.println("Writing books to file...");
    try (FileWriter writer = new FileWriter("./books.txt")) {
      for (Book book : books) {
        writer.write(book.toString() + "\n");
      }
    } catch (IOException e) {
      e.printStackTrace();
    }

    System.out.println("Reading books from file...");
    try (Scanner reader = new Scanner(new File("./books.txt"))) {
      while (reader.hasNext()) {
        System.out.println(reader.nextLine());
      }
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }

  }
}
