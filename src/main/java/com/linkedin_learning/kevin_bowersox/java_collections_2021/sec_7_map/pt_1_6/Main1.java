// 7.6 - Iterating Maps
package com.linkedin_learning.kevin_bowersox.java_collections_2021.sec_7_map.pt_1_6;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

public class Main1 {
  public static void main(String[] args) {
    Room room1 = new Room("Piccadilly", "Guest Room", 3, 125.00);
		Room room2 = new Room("Oxford", "Suite", 5, 225.0);

		Guest guest1 = new Guest("John", "Doe", false);
		Guest guest2 = new Guest("Maria", "Doe", true);

		Map<Room, Guest> assignments = new HashMap<>();

		assignments.put(room2, guest2);
		assignments.put(room1, guest1);

    Set<Entry<Room, Guest>> collectionView = assignments.entrySet();

    collectionView.forEach(entry -> {
      Room room = entry.getKey();
      Guest guest = entry.getValue();

      System.out.format("room: %s - guest: %s%n", room.getName(), guest.getFirstName());
    });

    System.out.println("------------------------------------------------------------------------");

    for(Entry<Room, Guest> entry : assignments.entrySet()) {
      System.out.format(
        "room: %s - guest: %s%n", 
        entry.getKey().getName(), 
        entry.getValue().getFirstName()
      );
    }

    System.out.println("------------------------------------------------------------------------");

    assignments.entrySet().forEach(entry -> System.out.format("room: %s - guest: %s%n", entry.getKey().getName(), entry.getValue().getFirstName()));
  }
}
