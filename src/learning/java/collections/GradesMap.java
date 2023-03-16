package learning.java.collections;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class GradesMap {

  public static void main(String[] args) {
    /* mappa che tiene traccia del voto di esame (int) di ciascun studente (nome)*/
    Map<String, Integer> grades = new HashMap<>();
    System.out.println(grades.size());
    System.out.println(grades.isEmpty());

    grades.put("Gino", 24);
    grades.put("Paola", 23);
    grades.put("Pietro", 30);
    grades.put("Nina", 28);

    System.out.println(grades.size());
    System.out.println(grades.isEmpty());
    System.out.println(grades);

    grades.put("Paola", 26);

    System.out.println(grades);
    Set<String> students = grades.keySet();
    System.out.println(students);

    System.out.println("Gino ha preso: " + grades.get("Gino"));
    grades.containsKey("Gino");
    grades.remove("Gino");
    System.out.println(grades);

  }
}
