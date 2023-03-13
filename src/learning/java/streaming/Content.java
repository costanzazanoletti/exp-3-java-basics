package learning.java.streaming;

public class Content {

  private String title;
  private String description;

  public Content(String title, String description) {
    this.title = title;
    this.description = description;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public void play() {
    System.out.println("Playing " + title);
  }

/*  @Override
  public String toString() {
    return title + " " + description;
  }*/
}
