package learning.java.dates;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Main {

  public static void main(String[] args) {
    LocalDate today = LocalDate.now();
    System.out.println(today);
    LocalDate holiday = LocalDate.of(2023, 03, 22);
    holiday = LocalDate.parse("2023-01-22");
    System.out.println(holiday);
    System.out.println("holiday is over: " + holiday.isBefore(today));
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    System.out.println(today.format(formatter));
  }
}
