package learning.java.exercises.christmas;

import java.util.ArrayList;
import java.util.List;

public class ChristmasLetter {

  public final static int MAX_WISHES_SIZE = 5;

  private String name;
  private String address;
  private List<String> wishes;

  public ChristmasLetter(String name, String address, List<String> wishes) {
    this.name = name;
    this.address = address;
    this.wishes = new ArrayList<>();
    this.wishes.addAll(wishes);
  }

  public void send() throws GreedyException, NaughtyException {
    if (wishes.size() > MAX_WISHES_SIZE) {
      throw new GreedyException("Your list of " + wishes.size() + " wishes is too long!");
    }
    if (Math.random() < 0.5) {
      throw new NaughtyException("You've been naughty. No presents for you.");
    }
    System.out.println(
        "Your letter has been sent to Santa!\n Presents will be delivered to " + name + " at "
            + address);
  }
}
