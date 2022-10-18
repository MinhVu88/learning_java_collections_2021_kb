// 3.3 - Modifying collections while iterating
package com.linkedin_learning.kevin_bowersox.java_collections_2021.sec_3_iterating_collections.pt_1_6;

import com.linkedin_learning.kevin_bowersox.java_collections_2021.sec_3_iterating_collections.Room;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

public class Main1 {
	public static void main(String[] args) {
		Room room1 = new Room("Cambridge", "Premiere Room", 4, 175.00);
		Room room2 = new Room("Manchester", "Suite", 5, 250.00);
		Room room3 = new Room("Oxford", "Suite", 5, 225.0);
		Room room4 = new Room("Victoria", "Suite", 5, 225.00);

		Collection<Room> rooms = new ArrayList<>(Arrays.asList(room1, room3, room4, room2));

		room3.setPetFriendly(true);
		room4.setPetFriendly(true);

		// without Iterator
		Collection<Room> petFriendlyRooms = new ArrayList<>();

		for(Room room : rooms) {
			if(room.isPetFriendly()) {
				// rooms.remove(room);

				petFriendlyRooms.add(room);
			}
		}

		rooms.removeAll(petFriendlyRooms);

		rooms.stream().forEach(
			room -> System.out.println(
				"room: " + room.getName() +
				" | is pet friendly? -> " + room.isPetFriendly()
			)
		);

		System.out.println("------------------------------------------------------------------------");

		// with Iterator
		Iterator<Room> roomsIterator = rooms.iterator();

		while(roomsIterator.hasNext()) {
			Room room = roomsIterator.next();

			if(room.isPetFriendly()) {
				roomsIterator.remove();
			}
		}

		rooms.forEach(
			room -> System.out.println(
				"room: " + room.getName() +
				" | is pet friendly? -> " + room.isPetFriendly()
			)
		);
	}
}
