// 8.4 - Finding elements in a collection
package com.linkedin_learning.kevin_bowersox.java_collections_2021.sec_8_collections_utilities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main2 {
  public static void main(String[] args) {
    Room room1 = new Room("Piccadilly", "Guest Room", 3, 125.00);
		Room room2 = new Room("Cambridge", "Premiere Room", 4, 175.00);
		Room room3 = new Room("Oxford", "Suite", 5, 225.0);
		Room room4 = new Room("Oxford", "Guest Room", 5, 225.0);
		Room room5 = new Room("Victoria", "Suite", 5, 225.0);
		
		List<Room> rooms = new ArrayList<>(List.of(room1, room4, room2, room5, room3));
    
    System.out.println("\t~ Collections.binarySearch(rooms, room2, Room.RATE_COMPARATOR) ~\n");

    rooms.sort(Room.RATE_COMPARATOR);

		int index0 = Collections.binarySearch(rooms, room2, Room.RATE_COMPARATOR);
		
		System.out.println("room2 | index0: " + index0);

		System.out.format("%n-- List Contents --%n");

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

		System.out.println("\t~ Collections.binarySearch(rooms, room6, Room.RATE_COMPARATOR) ~\n");
    
		Room room6 = new Room("New London", "Suite", 5, 225.0);

		int index1 = Collections.binarySearch(rooms, room6, Room.RATE_COMPARATOR);

		System.out.println("room6 | index1: " + index1);

		System.out.format("%n-- List Contents --%n");

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

		rooms.add(Math.abs(++index1), room6);

		System.out.println("room6 | index1: " + index1);

		System.out.format("%n-- List Contents --%n");

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

		System.out.println("\t~ Collections.min() & Collections.max() ~\n");

		System.out.println("Min rate: " + Collections.min(rooms, Room.RATE_COMPARATOR).getName());
		System.out.println("Max rate: " + Collections.max(rooms, Room.RATE_COMPARATOR).getName());
  }
}
