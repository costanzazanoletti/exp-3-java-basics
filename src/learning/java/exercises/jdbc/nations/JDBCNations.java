package learning.java.exercises.jdbc.nations;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class JDBCNations {

  // parametri di connessione al database
  private final static String DB_URL = "jdbc:mysql://localhost:3306/db_nations";
  private final static String DB_USER = "root";
  private final static String DB_PASSWORD = "rootpassword";

  private final static String FORMAT_TABLE = "%4s%45s%30s%30s\n";

  private final static String QUERY_NATIONS = """
      select c.name , c.country_id, r.name as region, c2.name as continent
      from countries c
      left join regions r on c.region_id = r.region_id
      left join continents c2 on r.continent_id = c2.continent_id
      where c.name like ?
      order by c.name;
      """;
  private final static String QUERY_LANGUAGES = """
      select l.`language`\s
      from country_languages cl\s
      join languages l on cl.language_id = l.language_id\s
      where cl.country_id = ?
      order by l.`language` ;
      """;

  private final static String QUERY_STATS = """
      select `year`, population , gdp\s
      from country_stats cs\s
      where cs.country_id = ?
      order by `year` desc
      limit 1;
      """;

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    // chiedo il termine di ricerca
    System.out.print("Search: ");
    String search = scan.nextLine();

    // apro una connection
    try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
      boolean hasResults = false; // tiene traccia del risultato della query nations

      try (PreparedStatement ps = conn.prepareStatement(QUERY_NATIONS)) {
        // faccio parameter binding
        ps.setString(1, "%" + search + "%");
        // eseguo il prepared statement
        try (ResultSet rs = ps.executeQuery()) {
          if (rs.next()) {
            hasResults = true;
            do {
              String name = rs.getString(1);
              int id = rs.getInt(2);
              String region = rs.getString(3);
              String continent = rs.getString(4);
              System.out.printf(FORMAT_TABLE, id, name, region, continent);
            } while (rs.next());

          } else {
            System.out.println("No countries found");
          }

        }
      } catch (SQLException e) {
        System.out.println("Unable execute query");
      }

      if (hasResults) {
        // BONUS - lingue e statistiche
        System.out.print("Choose a country id: ");
        int countryId = Integer.parseInt(scan.nextLine());
        System.out.println("Details for country " + countryId);

        try (PreparedStatement psLang = conn.prepareStatement(QUERY_LANGUAGES)) {
          psLang.setInt(1, countryId);
          try (ResultSet rsLang = psLang.executeQuery()) {
            System.out.print("Languages: ");
            while (rsLang.next()) {
              System.out.print(rsLang.getString(1));
              if (!rsLang.isLast()) {
                System.out.print(", ");
              } else {
                System.out.println();
              }
            }
          }

        }

        try (PreparedStatement psStats = conn.prepareStatement(QUERY_STATS)) {
          psStats.setInt(1, countryId);
          try (ResultSet rsStats = psStats.executeQuery()) {
            if (rsStats.next()) {
              int year = rsStats.getInt(1);
              BigDecimal population = rsStats.getBigDecimal(2);
              BigDecimal gdp = rsStats.getBigDecimal(3);
              System.out.println("Stats for year " + year + ":");
              System.out.println("Population: " + population);
              System.out.println("GDP: " + gdp);
            }
          }
        }
      }

    } catch (SQLException e) {
      System.out.println("Unable to connect to database");
    }
  }
}
