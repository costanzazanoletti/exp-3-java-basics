package learning.java.exercises.animals;

public class Sparrow extends Animal implements CanFly {

  @Override
  public void makeNoise() {
    System.out.println("Cheep Cheep");
  }

  @Override
  public void eat(String food) {
    switch (food) {
      case "seeds":
      case "worms":
        System.out.println("I like " + food);
        break;
      default:
        System.out.println("I don't like " + food);
    }
  }

  @Override
  public String toString() {
    return "Sparrow";
  }

  @Override
  public void fly() {
    System.out.println("Sparrow is flying");
  }
}
