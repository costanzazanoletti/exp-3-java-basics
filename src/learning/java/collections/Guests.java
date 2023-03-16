package learning.java.collections;

import java.util.HashSet;
import java.util.Set;

public class Guests {

  public static void main(String[] args) {
    /*Scanner scan = new Scanner(System.in);
    Set<String> guests = new HashSet<>();
    guests.add("John");
    guests.add("Jean");
    guests.add("Will");
    guests.add("Max");
    guests.add("Max");
    guests.add("Max");
    System.out.println(guests);

    System.out.print("Your name: ");
    String name = scan.nextLine();
    System.out.println(guests.contains(name) ? "Welcome" : "Goodbye");*/

    Set<Person> guests = new HashSet<>();
    guests.add(new Person("John", 23));
    guests.add(new Person("Jane", 28));
    guests.add(new Person("John", 23));
    guests.add(new Person("Max", 30));

    // Objects.equals("ciao", "ciao");

    System.out.println(guests);

    Person p = new Person("test", 10);
    System.out.println(p.equals(new Person("test", 10)));
    System.out.println(p.equals(new Person("test1", 11)));
    System.out.println(p.equals("ciao"));
    System.out.println(p.equals(Integer.valueOf(5)));
  }

}
