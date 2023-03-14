package learning.java.exceptions;

public class Rettangolo {

  private int base;
  private int altezza;

  public Rettangolo(int base, int altezza) throws IllegalArgumentException {
    if (base <= 0 || altezza <= 0) {
      throw new IllegalArgumentException("base o altezza <= 0");
    }
    this.base = base;
    this.altezza = altezza;
  }

  public int calcolaPerimetro() {
    return 2 * base + 2 * altezza;
  }
}
