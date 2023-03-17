package learning.java.exercises.christmas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    List<String> wishes = new ArrayList<>();
    boolean stop = false;
    while (!stop) {
      System.out.print("What do you want to do? Add a wish (1) Exit (2)");
      String choice = scan.nextLine();
      switch (choice) {
        case "1":
          // add a wish
          System.out.print("Your wish: ");
          String wish = scan.nextLine();
          wishes.add(wish);
          System.out.println("You have " + wishes.size() + " wishes");
          break;
        case "2":
          // exit;
          stop = true;
          break;
        default:
          // invalid choice
          System.out.println("Invalid choice");
          break;
      }
    }

    //sort the list
    Collections.sort(wishes);
    System.out.println(wishes);
    // create an istance of ChristmasLetter
    System.out.print("Your name: ");
    String name = scan.nextLine();
    System.out.print("Your address: ");
    String address = scan.nextLine();

    ChristmasLetter letter = new ChristmasLetter(name, address, wishes);
    try {
      letter.send();
    } catch (GreedyException e) {
      System.out.println(e.getMessage());
    } catch (NaughtyException e) {
      System.out.println(e.getMessage());
    }

  }
}
