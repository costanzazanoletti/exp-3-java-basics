package learning.java.abstraction.media;

public class Audio extends Media implements HasVolume, Playable {

  private int volume;

  public Audio(String title) {
    super(title);
    volume = 5;
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
  public void execute() {
    play();
  }

  @Override
  public void play() {
    for (int i = 0; i < volume; i++) {
      System.out.print(getTitle());
    }
    System.out.println();
  }
}
