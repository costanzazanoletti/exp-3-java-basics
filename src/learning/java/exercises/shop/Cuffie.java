package learning.java.exercises.shop;

import java.math.BigDecimal;

public class Cuffie extends Prodotto {

  private String colore;
  private boolean wireless;

  public Cuffie(String nome, String descrizione, BigDecimal prezzo,
      BigDecimal iva, String colore, boolean wireless) {
    super(nome, descrizione, prezzo, iva);
    this.colore = colore;
    this.wireless = wireless;
  }

  public String getColore() {
    return colore;
  }

  public void setColore(String colore) {
    this.colore = colore;
  }

  public boolean isWireless() {
    return wireless;
  }

  public void setWireless(boolean wireless) {
    this.wireless = wireless;
  }

  @Override
  public BigDecimal getPrezzoScontato(boolean ivato) {
    BigDecimal prezzoDaScontare = ivato ? getPrezzoIvato() : getPrezzo();
    if (!wireless) {
      return prezzoDaScontare.subtract(prezzoDaScontare.multiply(new BigDecimal("0.07")));
    }
    return super.getPrezzoScontato(ivato);
  }

  @Override
  public String toString() {
    return "Cuffie{" +
        super.toString() + '\'' +
        "colore='" + colore + '\'' +
        ", wireless=" + wireless +
        '}';
  }
}
