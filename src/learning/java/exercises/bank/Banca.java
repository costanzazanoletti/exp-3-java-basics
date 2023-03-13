package learning.java.exercises.bank;

import java.math.BigDecimal;
import java.util.Random;
import java.util.Scanner;

public class Banca {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    Random rand = new Random();
    // saluto e creo il conto
    System.out.println("Benvenuto in Java Bank");
    System.out.print("A chi è intestato il conto? ");
    String proprietario = scan.nextLine();
    Conto c = new Conto(rand.nextInt(1, 1000), proprietario);
    System.out.println("Ho creato il conto " + c.getNumeroConto() + " con saldo " + c.getSaldo());

    // menu interattivo
    boolean esci = false;
    while (!esci) {
      System.out.print("Cosa vuoi fare? 1-prelievo 2-versamento 3-uscire ");
      String scelta = scan.nextLine();
      switch (scelta) {
        case "1":
          // gestire il prelievo
          System.out.println("PRELIEVO");
          System.out.print("Quanto vuoi prelevare? ");
          BigDecimal somma = new BigDecimal(scan.nextLine());
          boolean risultato = c.preleva(somma);
          if (risultato) {
            System.out.println("Prelievo andato a buon fine. Il tuo saldo è " + c.getSaldo());
          } else {
            System.out.println(
                "Il tuo saldo " + c.getSaldo() + " non è sufficiente per prelevare " + somma);
          }
          break;
        case "2":
          // gestire il versamento
          System.out.println("VERSAMENTO");
          System.out.print("Quanto vuoi versare? ");
          BigDecimal versamento = new BigDecimal(scan.nextLine());
          if (c.versa(versamento)) {
            System.out.println("Versamento andato a buon fine, il tuo saldo è " + c.getSaldo());
          } else {
            System.out.println("Importo non valido per il versamento");
          }
          break;
        case "3":
          // gestire l'uscita
          System.out.println("Grazie e arrivederci");
          esci = true;
          break;
        default:
          // gestire scelta non valida
          System.out.println("Scelta non valida");
          break;
      }
    }
  }
}
