package learning.java.composition;

public class Person {

  private int id;
  private String name;
  private Address address;

  public Person(int id, String name, Address address) {
    this.id = id;
    this.name = name;
    this.address = new Address(address.getStreet(), address.getNumber(), address.getCity());
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Address getAddress() {
    return address;
  }

  public void setAddress(Address address) {
    this.address = address;
  }

  @Override
  public String toString() {
    return "Person{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", address=" + address +
        '}';
  }
}
