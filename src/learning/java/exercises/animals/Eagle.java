package learning.java.exercises.animals;

public class Eagle extends Animal implements CanFly {

  @Override
  public void makeNoise() {
    System.out.println("Screeech");
  }

  @Override
  public void eat(String food) {
    switch (food) {
      case "mouse":
      case "rabbit":
        System.out.println("I'm eating " + food);
        break;
      default:
        System.out.println("I don't eat this stuff " + food);
        break;
    }
  }

  @Override
  public String toString() {
    return "Eagle";
  }

  @Override
  public void fly() {
    System.out.println("Eagle is flying");
  }
}
