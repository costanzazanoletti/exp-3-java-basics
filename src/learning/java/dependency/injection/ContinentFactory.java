package learning.java.dependency.injection;

public class ContinentFactory {

  public static ContinentsRepositoryInterface getContinentRepository(String type) {
    if (type.equals("database")) {
      return new ContinentDatabaseRepository();
    } else {
      return new ContinentsMemoryRepository();
    }

  }
}
