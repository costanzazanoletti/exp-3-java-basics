package learning.java.streaming;

public class Main {

  public static void main(String[] args) {
    Content content = new Content("First content", "The first content of the platform");
    /*content.setTitle("First content");
    content.setDescription("The first content of the platform");*/
    content.play();

    Movie avatar2 = new Movie("Avatar 2", "Second episode of the Avatar saga", "James Cameron", 300,
        new String[]{"Kate Winslett", "Sigourney Weaver"});

    avatar2.play();

    System.out.println(content);
    System.out.println(avatar2);
  }
}
