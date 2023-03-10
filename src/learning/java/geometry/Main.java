package learning.java.geometry;

import java.util.Arrays;
import java.util.Random;

public class Main {

  public static void main(String[] args) {
    Random rand = new Random();
    Rectangle[] rectangles = new Rectangle[5];
    System.out.println(Arrays.toString(rectangles));

    for (int i = 0; i < rectangles.length; i++) {
      rectangles[i] = new Rectangle(rand.nextInt(1, 101), rand.nextInt(1, 101));
    }
    System.out.println(Arrays.toString(rectangles));

    int totalArea = 0;
    for (Rectangle r : rectangles) {
      totalArea += r.computeArea();
    }
    System.out.println("Total area " + totalArea);

    int max = Math.max(10, 100);

    /*Rectangle r1 = new Rectangle();
    System.out.println(r1.getBase() + " " + r1.getHeight());
    r1.setBase(10);
    r1.setHeight(12);
    System.out.println(r1.getBase() + " " + r1.getHeight());
    System.out.println("perimeter: " + r1.computePerimeter());
    System.out.println("area: " + r1.computeArea());

    Rectangle r2 = new Rectangle();
    r2.changeDimensions(50, 33);
    System.out.println(r2.getBase() + " " + r2.getHeight());
    System.out.println("perimeter: " + r2.computePerimeter());
    System.out.println("area: " + r2.computeArea());

    Rectangle r3 = new Rectangle(25, 90);

    System.out.println(r1);
    System.out.println(r2);
    System.out.println(r3);*/
  }
}