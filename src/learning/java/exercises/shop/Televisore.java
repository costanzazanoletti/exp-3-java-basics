package learning.java.exercises.shop;

import java.math.BigDecimal;

public class Televisore extends Prodotto {

  private int dimensioni;
  private boolean smart;

  public Televisore(String nome, String descrizione, BigDecimal prezzo,
      BigDecimal iva, int dimensioni, boolean smart) {
    super(nome, descrizione, prezzo, iva);
    this.dimensioni = dimensioni;
    this.smart = smart;
  }

  public int getDimensioni() {
    return dimensioni;
  }

  public void setDimensioni(int dimensioni) {
    this.dimensioni = dimensioni;
  }

  public boolean isSmart() {
    return smart;
  }

  public void setSmart(boolean smart) {
    this.smart = smart;
  }

  @Override
  public BigDecimal getPrezzoScontato(boolean ivato) {
    BigDecimal prezzoDaScontare = ivato ? getPrezzoIvato() : getPrezzo();
    if (!smart) {
      return prezzoDaScontare.subtract(prezzoDaScontare.multiply(new BigDecimal("0.1")));
    }
    return super.getPrezzoScontato(ivato);
  }

  @Override
  public String toString() {
    return "Televisore{" +
        super.toString() + '\'' +
        "dimensioni=" + dimensioni +
        ", smart=" + smart +
        '}';
  }
}
