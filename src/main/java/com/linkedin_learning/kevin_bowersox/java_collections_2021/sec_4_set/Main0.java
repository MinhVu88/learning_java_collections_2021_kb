/*
	4.1 - Set
	4.2 - HashSet
*/
package com.linkedin_learning.kevin_bowersox.java_collections_2021.sec_4_set;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class Main0 {
	public static void main(String[] args) {
		Room room1 = new Room("Piccadilly", "Guest Room", 3, 125.00);
		Room room2 = new Room("Oxford", "Suite", 5, 225.0);
		Room room_2 = new Room("Oxford", "Suite", 5, 225.0);
		Room room3 = new Room("Victoria", "Suite", 5, 225.00);

		Set<Room> uniquelyUnorderedRooms = new HashSet<>();

		uniquelyUnorderedRooms.add(room1);
		uniquelyUnorderedRooms.add(room2);
		uniquelyUnorderedRooms.add(room2);
		uniquelyUnorderedRooms.add(room_2);

		uniquelyUnorderedRooms.stream()
													.map(Room::getName)
													.forEach(System.out::println);

		System.out.println("------------------------------------------------------------------------");

		Set<Room> uniquelyOrderedRooms = new LinkedHashSet<>();

		uniquelyOrderedRooms.add(room1);
		uniquelyOrderedRooms.add(room2);
		uniquelyOrderedRooms.add(room2);
		uniquelyOrderedRooms.add(room_2);

		uniquelyOrderedRooms.stream()
												.map(Room::getName)
												.forEach(System.out::println);

		System.out.println("------------------------------------------------------------------------");

		// the of() method
		Set<Room> immutableSet = Set.of(room1, room2);

		// UnsupportedOperationException
		// immutableSet.add(room3);

		System.out.println("------------------------------------------------------------------------");

		// the copyOf() method
		Set<Room> immutableCopiedSet0 = Set.copyOf(uniquelyUnorderedRooms);

		immutableCopiedSet0.stream()
											 .map(Room::getName)
											 .forEach(System.out::println);

		System.out.println();

		uniquelyOrderedRooms.add(room3);

		Set<Room> immutableCopiedSet1 = Set.copyOf(uniquelyOrderedRooms);

		immutableCopiedSet1.stream()
											 .map(Room::getName)
											 .forEach(System.out::println);
	}
}
