package learning.java.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Scanner;

public class LiveCoding {

  public static void main(String[] args) {
    String URL = "jdbc:mysql://localhost:3306/db_airport";
    String USER = "root";
    String PASSWORD = "rootpassword";

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
      /*
      ESEMPIO DI SQL INJECTION
      String id = "10 -- ";
      String taxCode = "RI-707-74-3798-3";
      String queryInjection =
          "select * from passengers where id = " + id + " and tax_code = '" + taxCode + "';";

      try (PreparedStatement psInjection = connection.prepareStatement(queryInjection)) {
        try (ResultSet rs = psInjection.executeQuery()) {
          if (rs.next()) {
            System.out.println("You logged in");
          } else {
            System.out.println("Login failed");
          }
        }
      }
*/
/*      System.out.print("Insert date (yyyy-MM-dd): ");
      LocalDate date = LocalDate.parse(scan.nextLine());

      // chiedo alla connection di preparare uno statement SQL a partire dalla query passata come parametro
      try (PreparedStatement ps = connection.prepareStatement(query)) {
        // faccio il parameter binding di tutti i parametri
        // ps.setDate(0, Date.valueOf(date));
        ps.setTimestamp(1, Timestamp.valueOf(date.atStartOfDay()));
        ps.setTimestamp(2, Timestamp.valueOf(date.atTime(23, 59, 59)));

        // eseguo la query e metto il risultato nel ResultSet (stream di byte da chiudere)
        try (ResultSet rs = ps.executeQuery()) {
          // System.out.println(rs.getMetaData());
          // parso il ResultSet
          while (rs.next()) {

            String number = rs.getString("number");
            Timestamp departureDatetime = rs.getTimestamp("departure_datetime");
            String departureAirport = rs.getString("departure_airport");
            Timestamp arrivalDatetime = rs.getTimestamp("arrival_datetime");
            String arrivalAirport = rs.getString("arrival_airport");
            System.out.println(
                number + " " + departureDatetime + " " + departureAirport + " " + arrivalDatetime
                    + " " + arrivalAirport);
          }
        }
      }*/

      // INSERT airport
      System.out.println("INSERT AIRPORT");
      System.out.print("Code: ");
      String airportCode = scan.nextLine();
      System.out.println("City: ");
      String airportCity = scan.nextLine();
      System.out.println("Name: ");
      String airportName = scan.nextLine();
      String sqlInsert = "INSERT INTO airports (code, name, city, created_at, updated_at) VALUES(?,?,?,?,?);";
      Timestamp now = Timestamp.valueOf(LocalDateTime.now());
      try (PreparedStatement psInsert = connection.prepareStatement(sqlInsert)) {
        psInsert.setString(1, airportCode);
        psInsert.setString(2, airportName);
        psInsert.setString(3, airportCity);
        psInsert.setTimestamp(4, now);
        psInsert.setTimestamp(5, now);

        // execute update
        int affectedRows = psInsert.executeUpdate();
        System.out.println(affectedRows == 1 ? "success" : "error");
      }

    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
}
