package learning.java.variables;

import java.util.Arrays;

public class ArrayExercises {

  public static void main(String[] args) {
    String[] weekDays = {"Mon", "Tue", "Wen", "Thu", "Fri", "Sat", "Sun"};
    System.out.println(Arrays.toString(weekDays));

    weekDays[0] = "12";
    System.out.println(Arrays.toString(weekDays));
    System.out.println(weekDays[weekDays.length - 1]);

    int[] numbers = new int[10];
    System.out.println(Arrays.toString(numbers));
    String[] empty = new String[3];
    System.out.println(Arrays.toString(empty));

    System.out.println("Week days:");

    for (int i = 0; i < weekDays.length; i++) { // i = i + 1
      System.out.println(weekDays[i]);
    }

    for (String current : weekDays) {
      System.out.println(current);
    }

    for (int i = weekDays.length - 1; i >= 0; i--) {
      System.out.println(weekDays[i]);
    }

    String hi = "Hello Java";
    char[] hiChars = hi.toCharArray();
    for (int i = 0; i < hiChars.length; i++) {
      System.out.println(hiChars[i]);
    }

    int x = 5;
    System.out.println("*************");
    while (x > 5) {
      System.out.println("Sono nel ciclo while");
      x--;
    }

    int y = 5;
    System.out.println("*************");
    do {
      System.out.println("Sono nel ciclo do-while");
      y--;
    } while (y > 5);
  }
}
