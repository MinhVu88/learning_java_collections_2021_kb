package com.linkedin_learning.kevin_bowersox.java_collections_2021.sec_5_list.challenges.pt4;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import com.linkedin_learning.kevin_bowersox.java_collections_2021.sec_5_list.pt_1_2_3.Guest;
import com.linkedin_learning.kevin_bowersox.java_collections_2021.sec_5_list.pt_1_2_3.Room;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GuestServiceTest {
	GuestService service;

	Room room1 = new Room("Piccadilly", "Guest Room", 3, 125.00);
	Room room2 = new Room("Cambridge", "Premiere Room", 4, 175.00);
	Room room3 = new Room("Westminister", "Premiere Room", 4, 175.00);
	Room room4 = new Room("Oxford", "Suite", 5, 225.0);
	Room room5 = new Room("Victoria", "Suite", 5, 225.0);
	Room room6 = new Room("Manchester", "Suite", 5, 225.0);

	Guest guest1, guest2, guest3, guest4, guest5;

	@BeforeEach
	void setUp() throws Exception {
		this.service = new GuestService();

		guest1 = new Guest("John", "Doe", false);
		guest1.getPreferredRooms().addAll(List.of(room4, room5, room6));

		guest2 = new Guest("Maria", "Doe", true);
		guest2.getPreferredRooms().addAll(List.of(room2, room4));

		guest3 = new Guest("Sonia", "Doe", true);
		guest3.getPreferredRooms().addAll(List.of(room2));

		guest4 = new Guest("Siri", "Doe", true);

		guest5 = new Guest("Bob", "Doe", false);
	}

	@Test
	void testFilterByFavoriteRoom() {
		assertTrue(
			GuestService.filterByFavoriteRoom(
				List.of(guest1, guest2, guest3, guest4, guest5), room2
			).containsAll(List.of(guest2, guest3))
		);

		assertFalse(
			GuestService.filterByFavoriteRoom(
				List.of(guest1, guest2, guest3, guest4, guest5), room2
			).containsAll(List.of(guest1, guest4, guest3))
		);

		assertTrue(
			GuestService.filterByFavoriteRoom(
				List.of(guest1, guest2, guest3, guest4, guest5), room4
			).containsAll(List.of(guest1))
		);

		assertFalse(
			GuestService.filterByFavoriteRoom(
				List.of(guest1, guest2, guest3, guest4, guest5), room4
			).containsAll(List.of(guest2, guest3, guest4, guest5))
		);

		assertTrue(
			GuestService.filterByFavoriteRoom(
				List.of(guest1, guest2, guest3, guest4, guest5), room5
			).isEmpty()
		);
	}

	@Test
	void testSwapPosition() {
		this.service.checkIn(guest5);
		this.service.checkIn(guest2);
		this.service.checkIn(guest3);
		this.service.checkIn(guest1);
		this.service.checkIn(guest4);

		this.service.swapPosition(guest2, guest1);
		this.service.swapPosition(guest4, guest5);

		List<Guest> guests = this.service.getCheckInList();
		
		assertEquals(4, guests.indexOf(guest2));
		assertEquals(1, guests.indexOf(guest3));
		assertEquals(3, guests.indexOf(guest4));
		assertEquals(2, guests.indexOf(guest5));
		assertEquals(0, guests.indexOf(guest1));
	}

	@Test
	void testCheckIn() {
		this.service.checkIn(guest5);
		this.service.checkIn(guest2);
		this.service.checkIn(guest3);
		this.service.checkIn(guest1);
		this.service.checkIn(guest4);

		List<Guest> guests = this.service.getCheckInList();

		assertEquals(0, guests.indexOf(guest2));
		assertEquals(1, guests.indexOf(guest3));
		assertEquals(2, guests.indexOf(guest4));
		assertEquals(3, guests.indexOf(guest5));
		assertEquals(4, guests.indexOf(guest1));
	}
}