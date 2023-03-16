package learning.java.exercises.animals;

public class Dog extends Animal {

  @Override
  public void makeNoise() {
    System.out.println("Wooof");
  }


  public void eat(Food food) {
    switch (food) {
      case MEAT:
      case BONES:
        System.out.println("Yum I like " + food);
        break;
      default:
        System.out.println("Bleah. I don't eat " + food);
        break;
    }
  }

  @Override
  public void eat(String food) {
    switch (food) {
      case "meat":
      case "bone":
        System.out.println("Yum I like " + food);
        break;
      default:
        System.out.println("Bleah. I don't eat " + food);
        break;
    }
  }

  @Override
  public String toString() {
    return "Dog";
  }
}
