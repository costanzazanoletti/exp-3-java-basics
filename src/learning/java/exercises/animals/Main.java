package learning.java.exercises.animals;

import java.util.Arrays;

public class Main {

  public static void main(String[] args) {
    System.out.println(Arrays.toString(Food.values()));
    Dog tester = new Dog();
    tester.eat("MEAT");

    Animal[] animals = new Animal[]{new Dog(), new Eagle(), new Dolphin(), new Sparrow(),
        new Duck()};
    for (Animal animal : animals) {
      System.out.println(animal.toString());
      animal.sleep();
      animal.eat("fish");
      animal.makeNoise();
      if (animal instanceof CanSwim) {
        makeSwim((CanSwim) animal);
      }
      if (animal instanceof CanFly) {
        makeFly((CanFly) animal);
      }
    }
  }

  private static void makeFly(CanFly flyingObj) {
    flyingObj.fly();
  }

  private static void makeSwim(CanSwim swimmingObj) {
    swimmingObj.swim();
  }
}
