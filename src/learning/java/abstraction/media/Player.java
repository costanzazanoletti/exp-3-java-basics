package learning.java.abstraction.media;

import java.util.Scanner;

public class Player {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

    Media[] playlist = new Media[5];
    for (int i = 0; i < playlist.length; i++) {
      boolean validChoice = false;
      while (!validChoice) {
        System.out.println("Title: ");
        String title = scan.nextLine();

        System.out.println("What media? V-Video A-Audio I-Image");
        String choice = scan.nextLine();
        switch (choice) {
          case "V":
            validChoice = true;
            // creo un Video
            playlist[i] = new Video(title);
            break;
          case "A":
            validChoice = true;
            // creo un Audio
            playlist[i] = new Audio(title);
            break;
          case "I":
            validChoice = true;
            // creao una Image
            playlist[i] = new Image(title);
            break;
          default:
            System.out.println("Invalid choice");
            break;
        }
      }
    }
    int n = 0;
    do {
      System.out.println("Number [1-5], 0 to exit");
      n = Integer.parseInt(scan.nextLine());
      if (n <= playlist.length) {
        Media mediaToExecute = playlist[n - 1];
        System.out.println("Executing Media " + n);
        mediaToExecute.execute();
        if (mediaToExecute instanceof HasVolume) {
          System.out.println("Increase(+)/Decrease volume(-)");
          String volumeChoice = scan.nextLine();
          if (volumeChoice.equals("+")) {
            ((HasVolume) mediaToExecute).louder();
          } else if (volumeChoice.equals("-")) {
            ((HasVolume) mediaToExecute).weaker();
          }
        }
        if (mediaToExecute instanceof HasBrightness) {
          System.out.println("Increase(+)/Decrease brighntess(-)");
          String volumeChoice = scan.nextLine();
          if (volumeChoice.equals("+")) {
            ((HasBrightness) mediaToExecute).lighter();
          } else if (volumeChoice.equals("-")) {
            ((HasBrightness) mediaToExecute).darker();
          }
        }

      }


    } while (n > 0);

    scan.close();


  }
}
