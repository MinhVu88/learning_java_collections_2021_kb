package com.linkedin_learning.kevin_bowersox.java_collections_2021.sec_7_map.challenges.pt7;

import java.util.HashMap;
import java.util.Map;

public class BookingService {
	// private double totalRevenue;
	private Map<Room, Guest> bookings = new HashMap<>();

	public boolean book(Room room, Guest guest) {
		/*
		 * 1. The provided Guest is placed in the bookings Map and
		 * associated with the provided room, only if no other guest
		 * is associated with the room.
		 * 
		 * Returns a boolean that indicates if the Guest was
		 * successfully placed in the room.
		 */

		// approach #1 
		// this.bookings.putIfAbsent(room, guest);
		// return this.bookings.containsValue(guest);

		// approach #2:  
		/* 
			- putIfAbsent() won't create an association in the map, 
			  if a value already exists for the provided key.
				
			- In other words, if the provided room here is already associated with a guest in the map, 
			  there won't be any association established between these entities.

			- If that were the case, then putIfAbsent() would return 
			  the current value associated with the provided key.

			- If a new association were established, then null would be returned.
		*/
		return this.bookings.putIfAbsent(room, guest) == null;
	}

	public double totalRevenue() {
		/*
		 * 2. Returns a double that totals the rate of each Room booked
		 * in the bookings Map.
		 */

		// approach #1
		/* 
		this.bookings.keySet().forEach(key -> {
			this.totalRevenue += key.getRate();
			key.setRate(0.0);
		});
		*/

		/*
		// ConcurrentModificationException
		bookings.entrySet().forEach(entry -> {
			if(book(entry.getKey(), entry.getValue())) {
				totalRevenue += entry.getKey().getRate();
				entry.getKey().setRate(0);
			}
		});
		*/

		// System.out.println("total revenue: " + this.totalRevenue);

		// return this.totalRevenue;

		// approach #2
		return this.bookings.keySet()
												.stream()
												.mapToDouble(Room::getRate)
												.sum();
	}
	
	public Map<Room, Guest> getBookings() {
		return bookings;
	}
}
