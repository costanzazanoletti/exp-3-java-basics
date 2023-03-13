package learning.java.streaming;

public class Movie extends Content {

  String director;
  String[] cast;

  long lenght;


  public Movie(String title, String description, String director, long length, String[] cast) {
    super(title, description);
    this.director = director;
    this.lenght = length;

    this.cast = new String[cast.length];
    for (int i = 0; i < cast.length; i++) {
      this.cast[i] = cast[i];
    }
  }


  public String getDirector() {
    return director;
  }

  public void setDirector(String director) {
    this.director = director;
  }

  public String[] getCast() {
    return cast;
  }

  public void setCast(String[] cast) {
    this.cast = cast;
  }

  public long getLenght() {
    return lenght;
  }

  public void setLenght(long lenght) {
    this.lenght = lenght;
  }

  @Override
  public void play() {
    System.out.println("Playing movie " + getTitle() + " of length " + lenght);
  }
}
