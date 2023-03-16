package learning.java.exercises.animals;

public class Duck extends Animal implements CanFly, CanSwim {

  @Override
  public void makeNoise() {
    System.out.println("Quack");
  }

  @Override
  public void eat(String food) {
    switch (food) {
      case "fish":
      case "whatever":
        System.out.println("I eat " + food);
        break;
      default:
        System.out.println("I don't eat " + food);
        break;
    }
  }

  @Override
  public void fly() {
    System.out.println("Duck is flying");
  }

  @Override
  public void swim() {
    System.out.println("Duck is swimming");
  }

  @Override
  public String toString() {
    return "Duck";
  }
}
