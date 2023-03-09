package learning.java.variables;

import java.text.DecimalFormat;
import java.util.Scanner;

public class TrainTicket {
/*
* Consegna: Il programma dovrà chiedere all’utente il numero (intero) di chilometri che vuole percorrere
* e l’età del passeggero (numero intero).
* Sulla base di queste informazioni dovrà calcolare il prezzo totale del viaggio,
* secondo queste regole:
-il prezzo del biglietto è definito in base ai km (0.21 € al km)
-va applicato uno sconto del 20% per i minorenni
-va applicato uno sconto del 40% per gli over 65
* */

  public static void main(String[] args) {
    // COSTANTI
    double pricePerKm = 0.21;
    double discountUnderAge = 0.2;
    double discountOver65 = 0.4;

    Scanner scan = new Scanner(System.in);
    // INPUT
    System.out.println("WELCOME!");
    System.out.print("Number of km: ");
    // numero di km
    int km = Integer.parseInt(scan.nextLine());
    // età del passeggero
    System.out.print("Passenger age: ");
    int age = Integer.parseInt(scan.nextLine());

    System.out.println("Km " + km + " age " + age);

    // OUTPUT: prezzo finale
    // calcolo il prezzo base
    double price = pricePerKm * km;

    if (age < 18) {    // se age < 18 applico sconto under 18
      price -= price * discountUnderAge;
    } else if (age >= 65) { // se age >= 65 applico sconto over 65
      price -= price * discountOver65;
    }

    // per formattare il prezzo
    DecimalFormat df = new DecimalFormat("0.00€");
    // restituisco il prezzo calcolato
    System.out.println("Final price: " + df.format(price));

    scan.close();
  }
}
