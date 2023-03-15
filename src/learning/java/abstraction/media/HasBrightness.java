package learning.java.abstraction.media;

public interface HasBrightness {

  public static final double MIN_BRIGHTNESS = 0.0;
  public static final double MAX_BRIGHTNESS = 0.9;


  void darker();

  void lighter();

  void printBrightness();
}
