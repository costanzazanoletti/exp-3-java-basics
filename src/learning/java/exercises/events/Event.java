package learning.java.exercises.events;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Event implements Comparable<Event> {

  // CAMPI
  private String title;
  private LocalDate date;
  private int seats;
  private int bookedSeats;

  // COSTRUTTORI
  public Event(String title, LocalDate date, int seats)
      throws IllegalArgumentException, NullPointerException {
    // verifico valore di seats
    if (seats <= 0) {
      throw new IllegalArgumentException("Seats must be a positive integer");
    }
    // verifico il valore di date
    checkValidDate(date);
    this.title = title;
    this.date = date;
    this.seats = seats;
    this.bookedSeats = 0;
  }

  // GETTER SETTER

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public LocalDate getDate() {
    return date;
  }

  public void setDate(LocalDate date) throws NullPointerException, IllegalArgumentException {
    checkValidDate(date);
    this.date = date;
  }

  public int getSeats() {
    return seats;
  }

  public int getBookedSeats() {
    return bookedSeats;
  }

  public int getAvailableSeats() {
    return seats - bookedSeats;
  }

  public String getFormattedDate() {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    return date.format(formatter);
  }

  // METODI
  private void checkValidDate(LocalDate date)
      throws NullPointerException, IllegalArgumentException {
    if (date == null) {
      throw new NullPointerException("Date must not be null");
    }
    if (date.isBefore(LocalDate.now())) {
      throw new IllegalArgumentException("Date must not be in the past");
    }
  }

  public void book() throws IllegalStateException {
    String message = "";
    if (getAvailableSeats() < 1) {
      message += "No available seats\n";
    }
    if (date.isBefore(LocalDate.now())) {
      message += "The event is expired";
    }
    if (message.length() > 0) {
      throw new IllegalStateException(message);
    }
    // se passo i controlli aggiungo un posto
    bookedSeats++;
  }

  // overload del metodo book
  public void book(int n) throws IllegalStateException {
    if (n <= getAvailableSeats()) {
      for (int i = 0; i < n; i++) {
        book();
      }
    } else {
      throw new IllegalArgumentException("There are no " + n + " available seats");
    }
  }

  public void cancel() {
    String message = "";
    if (bookedSeats < 1) {
      message += "No booked seats\n";
    }
    if (date.isBefore(LocalDate.now())) {
      message += "The event is expired";
    }
    if (message.length() > 0) {
      throw new IllegalStateException(message);
    }
    // se passo i controlli cancello 1 posto
    bookedSeats--;
  }


  @Override
  public String toString() {
    return getFormattedDate() + " - " + getTitle();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    Event event = (Event) o;

    if (getSeats() != event.getSeats()) {
      return false;
    }
    if (getBookedSeats() != event.getBookedSeats()) {
      return false;
    }
    if (getTitle() != null ? !getTitle().equals(event.getTitle()) : event.getTitle() != null) {
      return false;
    }
    return getDate().equals(event.getDate());
  }

  @Override
  public int hashCode() {
    int result = getTitle() != null ? getTitle().hashCode() : 0;
    result = 31 * result + getDate().hashCode();
    result = 31 * result + getSeats();
    result = 31 * result + getBookedSeats();
    return result;
  }

  @Override
  public int compareTo(Event o) {
    if (this.getDate().equals(o.getDate())) {
      return this.getTitle().compareTo(o.getTitle());
    } else {
      return this.getDate().compareTo(o.getDate());
    }

  }
}
