package learning.java.exercises.shop;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class Carrello {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

    System.out.print("Quanti prodotti? ");
    int numProdotti = Integer.parseInt(scan.nextLine());

    Prodotto[] carrello = new Prodotto[numProdotti];

    for (int i = 0; i < numProdotti; i++) {
      boolean sceltaValida = false;
      do {
        System.out.println("Cosa vuoi inserire? 1-Smartphone 2-Televisore 3-Cuffie");
        String scelta = scan.nextLine();
        // se la scelta è valida procedo a chiedere le info prodotto
        sceltaValida = scelta.equals("1") || scelta.equals("2") || scelta.equals("3");
        if (sceltaValida) {
          // Dati comuni a tutti i prodotti
          System.out.print("Nome prodotto: ");
          String nome = scan.nextLine();
          System.out.print("Descrizione: ");
          String descrizione = scan.nextLine();
          System.out.print("Prezzo: ");
          BigDecimal prezzo = new BigDecimal(scan.nextLine());
          System.out.print("Iva: ");
          BigDecimal iva = new BigDecimal(scan.nextLine());

          switch (scelta) {
            case "1":
              // Smartphone
              System.out.print("IMEI: ");
              String imei = scan.nextLine();
              System.out.print("Quantità di memoria: ");
              int memoria = Integer.parseInt(scan.nextLine());
              carrello[i] = new Smartphone(nome, descrizione, prezzo, iva,
                  imei, memoria);
              break;
            case "2":
              // Televisore
              System.out.print("Dimensioni: ");
              int dimensioni = Integer.parseInt(scan.nextLine());
              System.out.print("Smart (s/n): ");
              boolean smart = scan.nextLine().equalsIgnoreCase("s");
              carrello[i] = new Televisore(nome, descrizione, prezzo, iva, dimensioni, smart);
              break;
            case "3":
              // Cuffie
              System.out.print("Colore: ");
              String colore = scan.nextLine();
              System.out.print("Wireless (s/n): ");
              boolean wireless = scan.nextLine().equalsIgnoreCase("s");
              carrello[i] = new Cuffie(nome, descrizione, prezzo, iva, colore, wireless);
              break;
            default:

              break;
          }
        } else {
          System.out.println("Input non valido");
        }

      } while (!sceltaValida);
    }

    // Stampo il riepilogo
    for (int i = 0; i < carrello.length; i++) {
      System.out.println("Prodotto " + (i + 1));
      System.out.println(carrello[i]);

      /*if (carrello[i].getClass().equals(Smartphone.class)) {
        // qui entro solo se Smartphone
        ((Smartphone) carrello[i]).getImei();
      }
      if (carrello[i] instanceof Smartphone) {
        // qui entro solo se Smartphone
      }*/
    }
    /* BONUS */
    System.out.print("Hai la carta fidelity? (s/n) ");
    // info se ha carta fedeltà e quindi se i prezzi sono da scontare
    boolean fidelity = scan.nextLine().equalsIgnoreCase("s");
    // calcolo il totale
    BigDecimal totale = new BigDecimal("0.00");
    for (Prodotto p : carrello) {
      if (fidelity) {
        // uso il prezzo scontato
        totale = totale.add(p.getPrezzoScontato(true));
      } else {
        // uso il prezzo normale
        totale = totale.add(p.getPrezzoIvato());
      }
    }
    System.out.println("TOTALE: " + totale.setScale(2, RoundingMode.HALF_EVEN) + "€");
  }
}
