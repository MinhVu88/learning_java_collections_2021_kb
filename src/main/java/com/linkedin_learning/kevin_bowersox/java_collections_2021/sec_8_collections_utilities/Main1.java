// 8.3 - Comparators
package com.linkedin_learning.kevin_bowersox.java_collections_2021.sec_8_collections_utilities;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main1 {
  public static void main(String[] args) {
    Room room1 = new Room("Piccadilly", "Guest Room", 3, 125.00);
		Room room2 = new Room("Cambridge", "Premiere Room", 4, 175.00);
		Room room3 = new Room("Oxford", "Suite", 5, 225.0);
		Room room4 = new Room("Oxford", "Guest Room", 5, 225.0);
		Room room5 = new Room("Victoria", "Suite", 5, 225.0);
		
		List<Room> rooms = new ArrayList<>(List.of(room1, room4, room2, room5, room3));

    System.out.println("\t~ rooms.sort(Comparator.naturalOrder()) ~\n");

    rooms.sort(Comparator.naturalOrder());

		rooms.stream()
				 .forEach(
						room -> System.out.format(
							"%-15s %-15s %-10f %n", 
							room.getName(), 
							room.getType(), 
							room.getRate()
						)
				 );

    System.out.println("------------------------------------------------------------------------");
    
    System.out.println("\t~ rooms.sort(Room.RATE_COMPARATOR) ~\n");

    rooms.sort(Room.RATE_COMPARATOR);

    rooms.stream()
				 .forEach(
						room -> System.out.format(
							"%-15s %-15s %-10f %n", 
							room.getName(), 
							room.getType(), 
							room.getRate()
						)
				 );

    System.out.println("------------------------------------------------------------------------");
    
    System.out.println("\t~ rooms.sort(Room.RATE_COMPARATOR.reversed()) ~\n");
     
    rooms.sort(Room.RATE_COMPARATOR.reversed());
     
    rooms.stream()
				 .forEach(
						room -> System.out.format(
							"%-15s %-15s %-10f %n", 
							room.getName(), 
							room.getType(), 
							room.getRate()
						)
				 );     
  }
}
