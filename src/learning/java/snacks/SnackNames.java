package learning.java.snacks;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class SnackNames {

  /*
   * Generatore di “nomi cognomi” casuali: il Grande Gatsby ha una lista di nomi e una
   * lista di cognomi, e da queste vuole mostrare a video una falsa lista di invitati con nome e cognome.
   * */
  public static void main(String[] args) {

    String[] firstNames = {"Mario", "Luisa", "Giovanni", "Paola"};
    String[] lastNames = {"Rossi", "Bianchi", "Verdi", "Blu", "Viola", "Neri"};

    // Genero nome e cognome presi con lo stesso indice
  /*  for (int i = 0; i < firstNames.length; i++) {
      System.out.println(firstNames[i] + " " + lastNames[i]);
    }*/

    // estraggo un numero random compreso tra 0 e la lunghezza dell'array
    Random rand = new Random();

    // chiedo all'utente quanti invitati vuole
    Scanner scan = new Scanner(System.in);
    System.out.print("How many guests? ");
    int numberOfGuests = Integer.parseInt(scan.nextLine());
    // genero un array di stringhe vuoto della dimensione scelta dall'utente
    String[] guests = new String[numberOfGuests];
    for (int i = 0; i < guests.length; i++) {
      // per ogni posizione dell'array genero un nome-cogome casuale
      int randomIndexFirstNames = rand.nextInt(firstNames.length);
      int randomIndexLastNames = rand.nextInt(lastNames.length);
      String generatedGuest =
          firstNames[randomIndexFirstNames] + " " + lastNames[randomIndexLastNames];
      // aggiungo questa stringa all'array
      guests[i] = generatedGuest;
    }

    System.out.println(Arrays.toString(guests));

    scan.close();

  }
}
