package learning.java.streaming;

public class Series extends Content {

  int numEpisodes;
  int season;

  public Series(String title, String description, int numEpisodes, int season) {
    super(title, description);
    this.numEpisodes = numEpisodes;
    this.season = season;
  }

  public int getNumEpisodes() {
    return numEpisodes;
  }

  public void setNumEpisodes(int numEpisodes) {
    this.numEpisodes = numEpisodes;
  }

  public int getSeason() {
    return season;
  }

  public void setSeason(int season) {
    this.season = season;
  }

  @Override
  public void play() {
    System.out.println(
        "Playing Series " + getTitle() + " season " + season + " episodes " + numEpisodes);
  }
}
