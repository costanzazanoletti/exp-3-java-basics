package learning.java.exercises.shop;

import java.math.BigDecimal;

public class Main {

  public static void main(String[] args) {
    Prodotto p = new Prodotto();
    p.setNome("iphone SE");
    p.setDescrizione("Il muletto di Apple");
    p.setPrezzo(new BigDecimal("679.99"));
    p.setIva(new BigDecimal("0.22"));
    System.out.println(p);
    System.out.println("prezzo di : " + p.getNomeEsteso() + ": " + p.getPrezzo() + " - con iva: "
        + p.getPrezzoIvato());
  }
}
