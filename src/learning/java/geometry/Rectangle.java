package learning.java.geometry;

/*
 * classe che gestisce i rettangoli, caratterizzati dalle due dimensioni: base e altezza
 * di un rettangolo devo poter calcolare perimetro e area
 * */
public class Rectangle {

  private final static int MAX_DIMENSION = 100;
  private static int counter = 0;


  // CAMPI
  private int base;
  private int height;

  // COSTRUTTORI
  public Rectangle() {
    base = 1;
    height = 1;
    counter++;
    System.out.println("Rectangle n. " + counter);


  }

  public Rectangle(int base, int height) {
    this.base = base;
    this.height = height;
    counter++;
    System.out.println("Rectangle n. " + counter);

  }

  // GETTER e SETTER
  public int getBase() {
    return base;
  }

  public void setBase(int base) {
    if (base < 1) {
      // restituisco un errore
      System.out.println("Invalid  value");
    }
    this.base = base;
  }

  public int getHeight() {
    return height;
  }

  public void setHeight(int height) {
    this.height = height;
  }

  // METODI
  public int computePerimeter() {
    return 2 * base + 2 * height;
  }

  public int computeArea() {
    return base * height;
  }

  public void changeDimensions(int base, int height) {
    this.base = base;
    this.height = height;
  }

  public String toString() {
    return "base: " + base + ", height: " + height;
  }
}
