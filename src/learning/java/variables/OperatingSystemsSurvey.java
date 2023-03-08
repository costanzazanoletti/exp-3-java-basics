package learning.java.variables;

public class OperatingSystemsSurvey {

  public static void main(String[] args) {
    /*
     *   definire quanti utenti per ogni OS
     *   calcolare la percentuale di ciascun OS sul totale
     * */
    // INPUT
    int linuxUsers = 90;
    int macUsers = 90;
    int windowsUsers = 13;

    // li sovrascrivo con lo scanner
   /* Scanner scan = new Scanner(System.in);
    System.out.print("Number of linux users: ");
    linuxUsers = Integer.parseInt(scan.nextLine());
    System.out.print("Number of mac users: ");
    macUsers = Integer.parseInt(scan.nextLine());
    System.out.print("Number of windows users: ");
    windowsUsers = Integer.parseInt(scan.nextLine());*/

    int totalUsers = linuxUsers + macUsers + windowsUsers;
    System.out.println("total users: " + totalUsers);

    // percentuale sul totale: numero/totale*100

    double percLinux = ((double) linuxUsers / totalUsers) * 100;
    double percMac = ((double) macUsers / totalUsers) * 100;
    double percWin = ((double) windowsUsers / totalUsers) * 100;

    // OUTPUT
    System.out.println("% linux: " + percLinux);
    System.out.println("% mac: " + percMac);
    System.out.println("% windows: " + percWin);
    System.out.println(percLinux + percMac + percWin);

    // 1) calcolo la perc max
    double maxPercMacLinux = Math.max(percMac, percLinux);
    double maxPercMacLinuxWin = Math.max(maxPercMacLinux, percWin);
    System.out.println(maxPercMacLinuxWin);
    String outputMessage = "The winner is";
    // 2) testo se linux == perc max
    if (percLinux == maxPercMacLinuxWin) {
      outputMessage += " linux";
    }
    // 3) testo se mac == perc max
    else if (percMac == maxPercMacLinuxWin) {
      outputMessage += " mac";
    }
    // 4) testo se windows == perc max
    else if (percWin == maxPercMacLinuxWin) {
      outputMessage += " windows";
    }
    System.out.println(outputMessage);


  }

}
