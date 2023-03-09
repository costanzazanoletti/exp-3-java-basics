package learning.java.variables;

import java.util.Scanner;

public class FizzBuzz {

  /*Scrivi un programma che stampi i numeri da 1 a 100, ma per i multipli di 3 stampi “Fizz”
  al posto del numero e per i multipli di 5 stampi “Buzz”.
  Per i numeri che sono sia multipli di 3 che di 5 stampi “FizzBuzz”.

  invece che 100, chiedere all’utente quanti numeri vuole stampare
  (il valore inserito dall’utente deve essere maggiore di 0 e minore di 1000)
  * */
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int n = 100;
    boolean validInput = false; // dichiaro un flag
    while (!validInput) { // continuo a iterare fino a che il flag diventa vero
      System.out.print("Number (> 0 and < 1000): ");
      n = Integer.parseInt(scanner.nextLine());
      if (n > 0 && n < 1000) {
        validInput = true;
      } else {
        System.out.println("Not valid input. Try again.");
      }
    }

    // creo un ciclo che fa 100 iterazioni
    for (int i = 1; i <= n; i++) {

      if (i % 3 == 0 && i % 5 == 0) {// se multiplo di 3 e 5 FizzBuzz
        System.out.println("FizzBuzz");
      } else if (i % 5 == 0) {
        System.out.println("Buzz");// se multiplo di 5 Buzz
      } else if (i % 3 == 0) {
        System.out.println("Fizz");// se multiplo di 3 Fizz
      } else {
        System.out.println(i);
      }


    }

    scanner.close();
  }
}
