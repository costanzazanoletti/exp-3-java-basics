package learning.java.exercises.animals;

public abstract class Animal {

  public void sleep() {
    System.out.println("Zzzzz");
  }

  public abstract void makeNoise();

  public abstract void eat(String food);

  @Override
  public String toString() {
    return "Animal";
  }
}
