package learning.java.snacks;

import java.util.Scanner;

public class Snacks12 {

  /*
  * **Snack1**

  L’utente inserisce due numeri in successione.
  Il software stampa il maggiore.

  **Snack2**
  L’utente inserisce due parole in successione.
  Il software stampa prima la parola più corta, poi la parola più lunga.

  * */
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    /*
    **Snack1**
    L’utente inserisce due numeri in successione.
    Il software stampa il maggiore.
    * */
    System.out.println("*** SNACK 1 ***");
    System.out.print("First number: ");
    int firstNumber = Integer.parseInt(scan.nextLine());
    System.out.print("Second number: ");
    int secondNumber = Integer.parseInt(scan.nextLine());
    System.out.println("The greater is " + Math.max(firstNumber, secondNumber));


    /*
    * **Snack2**
      L’utente inserisce due parole in successione.
      Il software stampa prima la parola più corta, poi la parola più lunga.
    * */
    System.out.println("*** SNACK 2 ***");
    System.out.print("First word: ");
    String firstWord = scan.nextLine();
    System.out.print("Second word: ");
    String secondWord = scan.nextLine();

    String shorterWord;
    if (firstWord.length() < secondWord.length()) {
      shorterWord = firstWord;
    } else {
      shorterWord = secondWord;
    }
    // lo stesso assegnamento fatto nell'if-else si può fare in un'unica espressione con l'operatore ternario
    shorterWord = firstWord.length() < secondWord.length() ? firstWord : secondWord;
    String longerWord = firstWord.equals(shorterWord) ? secondWord : firstWord;
    System.out.println(shorterWord);
    System.out.println(longerWord);

    scan.close();
  }
}
