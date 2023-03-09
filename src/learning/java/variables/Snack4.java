package learning.java.variables;

import java.util.Scanner;

public class Snack4 {
/*
* Snack4
 In un array sono contenuti i nomi degli invitati alla festa del grande Gatsby,
* chiedi all’utente il suo nome e comunicagli se può partecipare o no alla festa.
* */

  public static void main(String[] args) {
    String[] invited = {"Will", "Dustin", "Max", "Demogorgone"};

    Scanner scan = new Scanner(System.in);
    System.out.print("What's your name? ");
    String name = scan.nextLine();
    boolean found = false;
    for (int i = 0; i < invited.length && !found; i++) {
      if (name.equalsIgnoreCase(invited[i]))
        // ti ho trovato
        found = true;

    }

    System.out.println(found ? "Welcome!" : "Go home");
  }
}
