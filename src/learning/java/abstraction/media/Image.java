package learning.java.abstraction.media;

public class Image extends Media implements HasBrightness {


  private double brightness;

  public Image(String title) {
    super(title);
    brightness = 0.5;
  }


  public void show() {
    String playString = getTitle();
    for (double i = 0.0; i < brightness; i += 0.1) {
      playString += "*";
    }
    System.out.println(playString);
  }

  @Override
  public void darker() {
    if (brightness > HasBrightness.MIN_BRIGHTNESS) {
      brightness -= 0.1;
    } else {
      System.out.println("Min brightness reached");
    }
  }

  @Override
  public void lighter() {
    if (brightness < HasBrightness.MAX_BRIGHTNESS) {
      brightness += 0.1;
    } else {
      System.out.println("Max brightness reached");
    }
  }

  @Override
  public void printBrightness() {
    System.out.println("Current brightness: " + brightness);
  }

  @Override
  public void execute() {
    show();
  }
}
