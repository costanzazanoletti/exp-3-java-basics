package learning.java.exercises.events;

import java.util.Comparator;

public class EventComparatorByTitle implements Comparator<Event> {

  @Override
  public int compare(Event o1, Event o2) {
    return o1.getTitle().compareTo(o2.getTitle());
  }
}
