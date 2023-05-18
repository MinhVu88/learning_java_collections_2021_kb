package com.linkedin_learning.kevin_bowersox.java_collections_2021.sec_8_collections_utilities;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class BookingService {
	private Map<Room, Guest> bookings = new HashMap<>();
	private RoomService roomService;

	public BookingService(RoomService roomService) {
		this.roomService = roomService;
	}

	public void book(List<Guest> guests) {
		List<Room> availableRooms = this.roomService.getInventory()
																								.stream()
																								.filter(room -> !bookings.containsKey(room))
																								.collect(Collectors.toList());

		List<Room> preferredRooms = guests.stream()
																			.flatMap(guest -> guest.getPreferredRooms().stream())
																			.collect(Collectors.toList());

		availableRooms.sort(Comparator.comparingInt(room -> preferredRooms.indexOf(room)));

		for (Guest guest : guests) {
			boolean booked = false;

			for(Room room : guest.getPreferredRooms()) {
				if(this.roomService.hasRoom(room)) {
					if(bookings.putIfAbsent(room, guest) == null) {
						booked = true;
						availableRooms.remove(room);
						break;
					}
				}
			}

			if(!booked) {
				this.bookings.putIfAbsent(availableRooms.remove(0), guest);
			}
		}
	}

	public Map<Room, Guest> getBookings() {
		return bookings;
	}
}
