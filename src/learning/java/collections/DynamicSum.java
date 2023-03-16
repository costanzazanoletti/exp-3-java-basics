package learning.java.collections;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DynamicSum {

  /*
   * Chiedere all'utente di dirmi dei numeri interi, di scegliere quando fermarsi,
   * aggiungo questi numeri ad una lista e ne calcolo la somma
   * Genero una nuova lista che contiene solo i numeri pari della lista di partenza
   * */
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    List<Integer> numbers = new ArrayList<>();
    System.out.println(numbers.isEmpty());
    System.out.println(numbers.size());

    boolean stop = false;
    while (!stop) {
      System.out.print("Next number: ");
      int n = Integer.parseInt(scan.nextLine());
      // aggiungo n alla lista
      numbers.add(n);
      System.out.print("Stop?(y/n): ");
      stop = scan.nextLine().equalsIgnoreCase("y");
    }

    System.out.println(numbers);
    System.out.println("Sum: " + sum(numbers));
    System.out.println("Even numbers: " + evenNumbers(numbers));
    numbers.remove(Integer.valueOf(120));
    System.out.println(numbers);
    System.out.println("Bye Bye");

    scan.close();
  }

  public static int sum(List<Integer> integers) {
    /*for (int i = 0; i < integers.size(); i++) {
      int current = integers.get(i);
    }*/

/*    Iterator<Integer> iterator = integers.iterator();
    while (iterator.hasNext()) {
      Integer current = iterator.next();
      System.out.println(current);
    }*/

    int sum = 0;
    for (int i : integers) {
      sum += i;
    }
    return sum;
  }

  public static List<Integer> evenNumbers(List<Integer> integers) {
    List<Integer> evens = new ArrayList<>();
    for (Integer i : integers) {
      if (i % 2 == 0) {
        evens.add(i);
      }
    }
    return evens;
  }
}
