package learning.java.exercises.jdbc.nations;

import java.math.BigDecimal;

public class Stats {

  private int year;
  private BigDecimal population;
  private BigDecimal gdp;

  public Stats(int year, BigDecimal population, BigDecimal gdp) {
    this.year = year;
    this.population = population;
    this.gdp = gdp;
  }

  public int getYear() {
    return year;
  }

  public void setYear(int year) {
    this.year = year;
  }

  public BigDecimal getPopulation() {
    return population;
  }

  public void setPopulation(BigDecimal population) {
    this.population = population;
  }

  public BigDecimal getGdp() {
    return gdp;
  }

  public void setGdp(BigDecimal gdp) {
    this.gdp = gdp;
  }
}
