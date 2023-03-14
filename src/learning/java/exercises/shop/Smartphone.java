package learning.java.exercises.shop;

import java.math.BigDecimal;

public class Smartphone extends Prodotto {

  private String imei;
  private int memoria;

  public Smartphone(String nome, String descrizione, BigDecimal prezzo,
      BigDecimal iva, String imei, int memoria) {
    super(nome, descrizione, prezzo, iva);
    this.imei = imei;
    this.memoria = memoria;
  }

  public String getImei() {
    return imei;
  }

  public void setImei(String imei) {
    this.imei = imei;
  }

  public int getMemoria() {
    return memoria;
  }

  public void setMemoria(int memoria) {
    this.memoria = memoria;
  }

  @Override
  public BigDecimal getPrezzoScontato(boolean ivato) {
    BigDecimal prezzoDaScontare = ivato ? getPrezzoIvato() : getPrezzo();
    if (memoria < 32) {
      return prezzoDaScontare.subtract(prezzoDaScontare.multiply(new BigDecimal("0.05")));
    }
    return super.getPrezzoScontato(ivato);
  }

  @Override
  public String toString() {
    return "Smartphone{" + '\'' +
        super.toString() +
        "imei='" + imei + '\'' +
        ", memoria=" + memoria +
        '}';
  }
}
