package learning.java.dependency.injection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ContinentDatabaseRepository implements ContinentsRepositoryInterface {

  private final static String DB_URL = "jdbc:mysql://localhost:3306/db_nations";
  private final static String DB_USER = "root";
  private final static String DB_PASSWORD = "rootpassword";

  private final static String QUERY = "select name from continents";

  @Override
  public List<String> getContinents() {
    try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
      try (PreparedStatement ps = conn.prepareStatement(QUERY)) {
        try (ResultSet rs = ps.executeQuery()) {
          List<String> continents = new ArrayList<>();
          while (rs.next()) {
            continents.add(rs.getString("name"));
          }
          return continents;
        }
      }
    } catch (SQLException e) {
      e.printStackTrace();
      return null;
    }
  }
}
