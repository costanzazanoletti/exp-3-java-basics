package learning.java.composition;

public class Main {

  public static void main(String[] args) {
    int id = 23;
    String name = "John";
    Address address1 = new Address("Pecan st", 43, "Springfield");
    Person john = new Person(id, name, address1);
    System.out.println(john);

    address1.setStreet("Ananas bv");
    address1.setNumber(133);
    address1.setCity("Malibu");
    Person jane = new Person(55, "Jane", address1);
    System.out.println(jane);

    System.out.println(john);
  }
}
