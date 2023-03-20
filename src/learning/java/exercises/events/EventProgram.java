package learning.java.exercises.events;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class EventProgram {

  private String name;
  private List<Event> events;

  public EventProgram(String name) {
    this.name = name;
    this.events = new ArrayList<>();
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void addEvent(Event e) {
    if (e == null) {
      throw new IllegalArgumentException("Event must not be null");
    }
    events.add(e);
  }

  public boolean removeEvent(Event e) {
    return events.remove(e);

  }

  public List<Event> filterEventsByDate(LocalDate date) {
    List<Event> filteredEvents = new ArrayList<>();
    for (Event e : events) {
      if (e.getDate().equals(date)) {
        filteredEvents.add(e);
      }
    }
    return filteredEvents;
  }

  public int getNumberOfEvents() {
    return events.size();
  }

  public void clearEvents() {
    events.clear();
  }

  public void sortEvents(Comparator<Event> comparator) {
    events.sort(comparator);
  }


  @Override
  public String toString() {
    String string = getName() + "\n";
    List<Event> orderedEvents = new ArrayList<>();
    orderedEvents.addAll(events);
    // ordino gli eventi utilizzando il compareTo di Event
    // Collections.sort(orderedEvents);
    EventComparatorByDateAsc comparator = new EventComparatorByDateAsc();
    orderedEvents.sort(comparator);
    // appendo gli eventi ordinati per data
    for (Event e : orderedEvents) {
      string += e.toString() + "\n";
    }
    return string;
  }
}
