package learning.java.dependency.injection;

import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    System.out.print("Database or memory?");
    String choice = scan.nextLine();
    ShowContinents sc = new ShowContinents(choice);
    sc.show();
  }


}
