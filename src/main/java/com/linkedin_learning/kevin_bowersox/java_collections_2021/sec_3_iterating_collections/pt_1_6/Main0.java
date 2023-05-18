/*
 3.1 - Iterating collection elements
 3.2 - Accessing collection elements with iterators
*/
package com.linkedin_learning.kevin_bowersox.java_collections_2021.sec_3_iterating_collections.pt_1_6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

public class Main0 {
	public static void main(String[] args) {
		Room room1 = new Room("Cambridge", "Premiere Room", 4, 175.00);
		Room room2 = new Room("Piccadilly", "Guest Room", 3, 125.00);
		Room room3 = new Room("Westminister", "Premiere Room", 4, 200.00);

		Collection<Room> rooms = new ArrayList<>(Arrays.asList(room2, room1, room3));

		Iterator<Room> roomsIterator0 = rooms.iterator();

		System.out.println("roomsIterator0.next().getName() -> " + roomsIterator0.next().getName());
		System.out.println("roomsIterator0.next().getName() -> " + roomsIterator0.next().getName());
		System.out.println("roomsIterator0.next().getName() -> " + roomsIterator0.next().getName());

		Iterator<Room> roomsIterator1 = rooms.iterator();
		System.out.println("roomsIterator1.next().getName() -> " + roomsIterator1.next().getName());

		System.out.println("------------------------------------------------------------------------");

		Iterator<Room> roomsIterator2 = rooms.iterator();

		while(roomsIterator2.hasNext()) {
			Room room = roomsIterator2.next();

			System.out.println("while(roomsIterator2.hasNext()) | roomsIterator2.next() -> " + room.getName());
		}

		System.out.println("------------------------------------------------------------------------");

		for(Room room : rooms) {
			System.out.println("for(Room room : rooms) -> " + room.getName());
		}
	}
}
