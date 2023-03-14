package learning.java.exercises.shop;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Random;

public class Prodotto {

  // ATTRIBUTI
  private int codice;
  private String nome;
  private String descrizione;
  private BigDecimal prezzo;
  private BigDecimal iva;

  // COSTRUTTORI
  public Prodotto() {
    codice = generaCodice();
  }

  public Prodotto(String nome, String descrizione, BigDecimal prezzo, BigDecimal iva) {
    codice = generaCodice();
    this.nome = nome;
    this.descrizione = descrizione;
    this.prezzo = prezzo;
    this.iva = iva;
  }

  // METODI

  // GETTER e SETTER
  public int getCodice() {
    return codice;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getDescrizione() {
    return descrizione;
  }

  public void setDescrizione(String descrizione) {
    this.descrizione = descrizione;
  }

  public BigDecimal getPrezzo() {
    return prezzo;
  }

  public void setPrezzo(BigDecimal prezzo) {
    this.prezzo = prezzo;
  }

  public BigDecimal getIva() {
    return iva;
  }

  public void setIva(BigDecimal iva) {
    this.iva = iva;
  }

  public BigDecimal getPrezzoIvato() {
    // prezzo + prezzo * iva
    BigDecimal ivaSulPrezzo = prezzo.multiply(iva);
    return prezzo.add(ivaSulPrezzo).setScale(2, RoundingMode.HALF_EVEN);
  }

  public BigDecimal getPrezzoScontato(boolean ivato) {
    BigDecimal prezzoDaScontare = ivato ? getPrezzoIvato() : prezzo;
    return prezzoDaScontare.subtract(prezzoDaScontare.multiply(new BigDecimal("0.02")));
  }

  public String getNomeEsteso() {
    return getCodiceFormattato() + "-" + nome;
  }

  private int generaCodice() {
    Random random = new Random();
    return random.nextInt(1, 10000);
  }

  public String getCodiceFormattato() {
    // tratto il numero come stringa
    // continuo ad aggiungere 0 in testa alla stringa fino a che la stringa è lunga 8
    String codiceString = String.valueOf(codice);
    while (codiceString.length() < 8) {
      codiceString = "0" + codiceString;
    }
    return codiceString;
  }

  @Override
  public String toString() {
    return
        "codice=" + getCodiceFormattato() +
            ", nome='" + nome + '\'' +
            ", descrizione='" + descrizione + '\'' +
            ", prezzo=" + prezzo +
            ", iva=" + iva +
            ", prezzo con iva=" + getPrezzoIvato();
  }
}
