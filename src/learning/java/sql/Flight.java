package learning.java.sql;

import java.time.LocalDateTime;

public class Flight {

  private String number;
  private LocalDateTime departureDateTime;
  private String departureAirport;
  private LocalDateTime arrivalDateTime;
  private String arrivalAirport;

  public Flight(String number, LocalDateTime departureDateTime, String departureAirport,
      LocalDateTime arrivalDateTime, String arrivalAirport) {
    this.number = number;
    this.departureDateTime = departureDateTime;
    this.departureAirport = departureAirport;
    this.arrivalDateTime = arrivalDateTime;
    this.arrivalAirport = arrivalAirport;
  }

  public String getNumber() {
    return number;
  }

  public LocalDateTime getDepartureDateTime() {
    return departureDateTime;
  }

  public String getDepartureAirport() {
    return departureAirport;
  }

  public LocalDateTime getArrivalDateTime() {
    return arrivalDateTime;
  }

  public String getArrivalAirport() {
    return arrivalAirport;
  }
}
