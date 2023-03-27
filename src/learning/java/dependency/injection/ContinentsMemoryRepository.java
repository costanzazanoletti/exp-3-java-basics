package learning.java.dependency.injection;

import java.util.ArrayList;
import java.util.List;

public class ContinentsMemoryRepository implements ContinentsRepositoryInterface {

  @Override
  public List<String> getContinents() {
    List<String> continents = new ArrayList<>();

    continents.add("Europe");
    continents.add("Antartica");
    continents.add("Africa");

    return continents;
  }
}
