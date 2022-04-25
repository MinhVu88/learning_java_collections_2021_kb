/*
	1.1 - Solving everyday problems with data
	1.2 - Data structures
	1.3 - Collections framework architecture
	1.4 - Working with a collection
	1.5 - Beyond the array
*/
package com.kevinbowersox.lil.learning_java_collections_2021.sec_1_intro;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		Room room1 = new Room("Cambridge", "premiere", 4, 175.0);
		Room room2 = new Room("Manchester", "suit", 4, 250.0);
		Room room3 = new Room("Piccadilly", "guest", 4, 125.0);
		Room room4 = new Room("Oxford", "suit", 4, 225.0);

		Collection<Room> rooms0 = List.of(room1, room2, room3, room4);
		double potentialRevenue0 = getPotentialRevenue(rooms0);
		System.out.println("\nrooms0 | potential revenue: " + potentialRevenue0 + "\n");

		Collection<Room> rooms1 = new ArrayList<>(List.of(room1, room2));
		rooms1.add(room3);
		rooms1.add(room4);
		double potentialRevenue1 = getPotentialRevenue(rooms1);
		System.out.println("\nrooms1 | potential revenue: " + potentialRevenue1 + "\n");

		Room[] rooms2 = new Room[3];
		rooms2[0] = room1;
		rooms2[1] = room2;
		rooms2[2] = room3;

		Room[] rooms3 = new Room[4];
		System.arraycopy(rooms2, 0, rooms3, 0, rooms2.length);
		rooms3[rooms3.length - 1] = room4;

		double potentialRevenue2 = getPotentialRevenue(List.of(rooms3));
		System.out.println("\nrooms3 | potential revenue: " + potentialRevenue2 + "\n");
	}

	private static double getPotentialRevenue(Collection<Room> rooms) {
		return rooms.stream()
								.mapToDouble(room -> room.getRate())
								.sum();
	}
}
