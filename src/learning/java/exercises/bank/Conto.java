package learning.java.exercises.bank;

import java.math.BigDecimal;

public class Conto {

  // ATTRIBUTI
  private int numeroConto;
  private String proprietario;
  private BigDecimal saldo;

  // COSTRUTTORE
  public Conto(int numeroConto, String proprietario) {
    this.numeroConto = numeroConto;
    this.proprietario = proprietario;
    this.saldo = new BigDecimal("0.00");
  }

  // GETTER e SETTER

  public int getNumeroConto() {
    return numeroConto;
  }

  public String getProprietario() {
    return proprietario;
  }

  public void setProprietario(String proprietario) {
    this.proprietario = proprietario;
  }

  public BigDecimal getSaldo() {
    return saldo;
  }

  // metodo per versare una somma di denaro
  public boolean versa(BigDecimal somma) {
    if (somma.compareTo(new BigDecimal("0")) > 0) { // testo che la somma non sia <= 0
      saldo = saldo.add(somma);
      return true;
    } else {
      return false;
    }
  }

  // metodo per prelevare una somma di denaro
  public boolean preleva(BigDecimal somma) {
    // se la somma da prelevare è <= al saldo procedo
    if (somma.compareTo(saldo)
        <= 0) { // il compateTo ritorna -1 (somma < saldo) o 0 (somma == saldo)
      saldo = saldo.subtract(somma);
      return true;
    } else {
      return false;
    }
  }
}
