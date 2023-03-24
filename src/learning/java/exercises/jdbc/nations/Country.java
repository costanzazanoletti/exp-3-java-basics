package learning.java.exercises.jdbc.nations;

import java.util.Set;

public class Country {


  private String name;
  private int id;
  private String region;
  private String continent;
  private Set<String> languages;

  private Set<Stats> stats;
  private Stats mostRecentStats;

  public Country(String name, int id, String region, String continent, Set<String> languages,
      Set<Stats> stats, Stats mostRecentStats) {
    this.name = name;
    this.id = id;
    this.region = region;
    this.continent = continent;
    this.languages = languages;
    this.stats = stats;
    this.mostRecentStats = mostRecentStats;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getRegion() {
    return region;
  }

  public void setRegion(String region) {
    this.region = region;
  }

  public String getContinent() {
    return continent;
  }

  public void setContinent(String continent) {
    this.continent = continent;
  }

  public Set<String> getLanguages() {
    return languages;
  }

  public void setLanguages(Set<String> languages) {
    this.languages = languages;
  }

  public Set<Stats> getStats() {
    return stats;
  }

  public void setStats(Set<Stats> stats) {
    this.stats = stats;
  }

  public Stats getMostRecentStats() {
    return mostRecentStats;
  }

  public void setMostRecentStats(Stats mostRecentStats) {
    this.mostRecentStats = mostRecentStats;
  }
}
