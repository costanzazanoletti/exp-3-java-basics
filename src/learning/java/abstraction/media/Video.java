package learning.java.abstraction.media;

public class Video extends Media implements Playable, HasVolume, HasBrightness {

  // CAMPI PROPRI DI VIDEO
  private int volume;
  private double brightness;

  public Video(String title) {
    super(title);
    this.volume = 5;
    this.brightness = 0.5;
  }

  @Override
  public void execute() {
    play();
  }

  @Override
  public void play() {
    String playString = getTitle();
    for (double i = 0.0; i < brightness; i += 0.1) {
      playString += "*";
    }
    for (int i = 0; i < volume; i++) {
      System.out.print(playString);
    }
    System.out.println();
  }

  @Override
  public void weaker() {
    if (volume > HasVolume.MIN_VOLUME) {
      volume--;
    } else {
      System.out.println("Reached min volume");
    }

  }

  @Override
  public void louder() {
    if (volume < HasVolume.MAX_VOLUME) {
      volume++;
    } else {
      System.out.println("Max volume reached");
    }
  }

  @Override
  public void printVolume() {
    System.out.println("Current volume: " + volume);
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
}
