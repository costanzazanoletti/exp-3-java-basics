package learning.java.exercises.animals;

public class Dolphin extends Animal implements CanSwim {

  @Override
  public void makeNoise() {
    System.out.println("Click");
  }

  @Override
  public void eat(String food) {
    switch (food) {
      case "fish":
        System.out.println("Yum I like " + food);
        break;
      default:
        System.out.println("Bleah I don't like " + food);
        break;
    }
  }

  @Override
  public String toString() {
    return "Dolphin";
  }

  @Override
  public void swim() {
    System.out.println("Dolphin is swimming");
  }
}
