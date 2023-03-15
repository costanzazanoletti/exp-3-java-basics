package learning.java.streaming;

public class Main {

  public static void main(String[] args) {
    Content content = new Movie("First content", "The first content of the platform", "director",
        120, new String[]{"actor1", "actor2"});
    content.setTitle("First content");
    content.setDescription("The first content of the platform");
    content.play();

    Movie avatar2 = new Movie("Avatar 2", "Second episode of the Avatar saga", "James Cameron", 300,
        new String[]{"Kate Winslett", "Sigourney Weaver"});

    avatar2.play();

    System.out.println(content);
    System.out.println(avatar2);

    Content[] playlist = new Content[2];
    playlist[0] = content;
    playlist[1] = avatar2;
    for (int i = 0; i < playlist.length; i++) {
      playlist[i].getTitle();
      playlist[i].play();
    }
  }
}
