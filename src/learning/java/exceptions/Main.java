package learning.java.exceptions;

import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int base = 0;

    System.out.print("Base: ");
    String baseString = scan.nextLine();
    if (isValid(baseString))
      base = Integer.parseInt(baseString);

    int altezza = 0;

    System.out.print("Altezza: ");
    String altezzaString = scan.nextLine();
    if (isValid(altezzaString))
      altezza = Integer.parseInt(altezzaString);

    try {
      Rettangolo r = new Rettangolo(base, altezza);
      System.out.println("Perimetro: " + r.calcolaPerimetro());
    } catch (IllegalArgumentException e) {
      System.out.println("Base e altezza devono essere > 0");
    } finally {
      System.out.println("Grazie e arrivederci");
    }
  }

  private static boolean isValid(String input) {
    try {
      Integer.parseInt(input);
      return true;
    } catch (NumberFormatException e) {
      return false;
    }
  }

}
