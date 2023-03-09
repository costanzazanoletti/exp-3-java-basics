package learning.java.snacks;

import java.util.Scanner;

public class Snack3 {

  /*
  **Snack3**
  Il software deve chiedere per 10 volte all’utente di inserire un numero.
  Il programma stampa la somma di tutti i numeri inseriti.
  * */
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int sum = 0;
    for (int i = 0; i < 10; i++) {

      System.out.print("Number: ");
      int n = Integer.parseInt(scan.nextLine());
      sum += n;
    }

    System.out.println("Sum: " + sum);
  }

}
