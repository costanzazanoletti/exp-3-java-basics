package learning.java.abstraction.media;

public abstract class Media {

  private String title;

  public Media(String title) {
    this.title = title;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public abstract void execute();
}
