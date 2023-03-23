package learning.java.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AirportSQL {

  private final static String URL = System.getenv(
      "DB_URL"); //"jdbc:mysql://localhost:3306/db_airport";
  private final static String USER = System.getenv("DB_USER");// "root";
  private final static String PASSWORD = System.getenv("DB_PASSWORD"); //"rootpassword";


  public static void main(String[] args) {

    Scanner scan = new Scanner(System.in);

    // chiedo a DriverManager di aprire una connessione con i parametri passati
    try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
      // System.out.println(connection.isClosed());
      String query = """
          select number, departure_datetime, ad.code as departure_airport, arrival_datetime, aa.code as arrival_airport
          from flights f
          join airports ad on f.departure_airport_id = ad.id
          join airports aa on f.arrival_airport_id = aa.id
          where departure_datetime >= ? and departure_datetime <= ?
          order by departure_datetime desc;
          """;

      System.out.print("Insert date (yyyy-MM-dd): ");
      LocalDate date = LocalDate.parse(scan.nextLine());

      // chiedo alla connection di preparare uno statement SQL a partire dalla query passata come parametro
      try (PreparedStatement ps = connection.prepareStatement(query,
          ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)) {
        // faccio il parameter binding di tutti i parametri
        // ps.setDate(0, Date.valueOf(date));
        ps.setTimestamp(1, Timestamp.valueOf(date.atStartOfDay()));
        ps.setTimestamp(2, Timestamp.valueOf(date.atTime(23, 59, 59)));

        List<Flight> result = new ArrayList<>();

        // eseguo la query e metto il risultato nel ResultSet (stream di byte da chiudere)
        try (ResultSet rs = ps.executeQuery()) {
          // System.out.println(rs.getMetaData());

          if (!rs.next()) {
            System.out.println("No flight departed on this date");
          } else {
            // devo tornare indietro per recuperare la prima riga
            rs.beforeFirst();
          }
          // parso il ResultSet
          while (rs.next()) {

            String number = rs.getString("number");
            Timestamp departureDatetime = rs.getTimestamp("departure_datetime");
            String departureAirport = rs.getString("departure_airport");
            Timestamp arrivalDatetime = rs.getTimestamp("arrival_datetime");
            String arrivalAirport = rs.getString("arrival_airport");

            Flight temp = new Flight(number, departureDatetime.toLocalDateTime(), departureAirport,
                arrivalDatetime.toLocalDateTime(), arrivalAirport);
            result.add(temp);

          }

          for (Flight f : result) {
            printResultSetLine(f.getNumber(), Timestamp.valueOf(f.getDepartureDateTime()),
                f.getDepartureAirport(), Timestamp.valueOf(f.getArrivalDateTime()),
                f.getArrivalAirport());
          }
        }
      }


    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  private static void printResultSetLine(String number, Timestamp departureDatetime,
      String departureAirport,
      Timestamp arrivalDatetime, String arrivalAirport) {
    String stringPattern = "%15s";
    String dateTimePattern = "%10s%te/%<tm/%<tY %<tH:%<tM";
    System.out.printf(stringPattern, number);
    System.out.printf(dateTimePattern, " ", departureDatetime);
    System.out.printf(stringPattern, departureAirport);
    System.out.printf(dateTimePattern, " ", arrivalDatetime);
    System.out.printf(stringPattern + "\n", arrivalAirport);
  }
}
