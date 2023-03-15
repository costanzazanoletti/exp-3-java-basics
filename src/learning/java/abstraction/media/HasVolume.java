package learning.java.abstraction.media;

public interface HasVolume {

  public static final int MIN_VOLUME = 0;
  public static final int MAX_VOLUME = 10;

 
  void weaker();

  void louder();

  void printVolume();
}
