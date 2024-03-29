// 3.6 - Stream operations
package com.linkedin_learning.kevin_bowersox.java_collections_2021.sec_3_iterating_collections.pt_1_6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

public class Main3 {
	public static void main(String[] args) {
		Room room1 = new Room("Cambridge", "Premiere Room", 4, 175.00);
		Room room2 = new Room("Manchester", "Suite", 5, 250.00);
		Room room3 = new Room("Oxford", "Suite", 5, 225.0);
		Room room4 = new Room("Victoria", "Suite", 5, 225.00);

		Collection<Room> rooms = new ArrayList<>(Arrays.asList(room1, room3, room4, room2));

		room3.setPetFriendly(true);
		room4.setPetFriendly(true);

		Collection<Room> petFriendlyRooms0 = new ArrayList<>();

		/* NOT RECOMMENDED! 
			- We're doing 2 things here: we're passing in an external object (petFriendlyRooms0)
				& we're modifying it within the stream.
			- In general, within a stream, it's ok to either work with external objects or modify them.
			- But we should never do both inside of a stream.
		*/
		rooms.stream()
				 .filter(Room::isPetFriendly)
				 .forEach(room -> petFriendlyRooms0.add(room));

		petFriendlyRooms0.stream().forEach(room -> System.out.println(room.getName()));

		System.out.println("------------------------------------------------------------------------");

		System.out.println("\t\t[ Operations 1 & 2: collect (terminal op) & map ]\n");

		Collection<Room> petFriendlyRooms1 = rooms.stream()
																						  .filter(Room::isPetFriendly)
																						  .collect(Collectors.toList());

		petFriendlyRooms1.stream()
										 .map(room -> room.getName())
										 .forEach(System.out::println);

		System.out.println("------------------------------------------------------------------------");

		System.out.println("\t\t[ Operations 3 & 4: mapToDouble & sum ]\n");

		double totalRevenues = petFriendlyRooms1.stream()
																					  .mapToDouble(Room::getRate)
																					  .sum();

		System.out.println("total revenues of pet friendly rooms: " + totalRevenues);
	}
}
