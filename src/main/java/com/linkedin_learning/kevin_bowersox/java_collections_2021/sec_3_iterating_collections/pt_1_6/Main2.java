/*
 3.4 - Accessing collection elements with streams
 3.5 - Lambda expressions
*/
package com.linkedin_learning.kevin_bowersox.java_collections_2021.sec_3_iterating_collections.pt_1_6;

import com.linkedin_learning.kevin_bowersox.java_collections_2021.sec_3_iterating_collections.Room;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Main2 {
	public static void main(String[] args) {
		Room room1 = new Room("Cambridge", "Premiere Room", 4, 175.00);
		Room room2 = new Room("Manchester", "Suite", 5, 250.00);
		Room room3 = new Room("Oxford", "Suite", 5, 225.0);
		Room room4 = new Room("Victoria", "Suite", 5, 225.00);

		Collection<Room> rooms = new ArrayList<>(Arrays.asList(room1, room3, room4, room2));

		room3.setPetFriendly(true);
		room4.setPetFriendly(true);

		// without Lambda expressions
		rooms.stream()
				 .filter(new Predicate<Room>() {
						@Override
						public boolean test(Room room) {
							System.out.format(
								"%nis %s pet friendly? -> %b",
								room.getName(),
								room.isPetFriendly()
							);

							return room.isPetFriendly();
						}
				 })
				 .forEach(new Consumer<Room>() {
						@Override
						public void accept(Room room) {
							System.out.print(" => " + room.getName() + " removed");
						}
				 });

		System.out.println("\n------------------------------------------------------------------------");

		// with Lambda expressions (without method references)
		rooms.stream()
				 .filter(room -> room.isPetFriendly())
				 .forEach(room -> System.out.println(room.getName()));

		System.out.println("------------------------------------------------------------------------");

		// with Lambda expressions & method references
		rooms.stream()
				 .filter(Room::isPetFriendly)
				 .forEach(System.out::println);
	}
}
