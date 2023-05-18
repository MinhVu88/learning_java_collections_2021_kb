package com.linkedin_learning.kevin_bowersox.java_collections_2021.sec_2_foundations.challenges.pt10;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Collection;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RoomServiceTest {
	RoomService service;

	Room room1 = new Room("Cambridge", "Premiere Room", 4, 175.00);
	Room room2 = new Room("Manchester", "Suite", 5, 250.00);
	Room room3 = new Room("Piccadilly", "Guest Room", 3, 125.00);
	Room room4 = new Room("Oxford", "Suite", 5, 225.0);
	Room room5 = new Room("Victoria", "Suite", 5, 225.00);
	Room room6 = new Room("Westminister", "Premiere Room", 4, 200.00);

	@BeforeEach
	void setUp() throws Exception {
		this.service = new RoomService();

		this.service.createRoom("Piccadilly", "Guest Room", 3, 125.00);
		this.service.createRoom("Cambridge", "Premiere Room", 3, 175.00);
		this.service.createRoom("Victoria", "Suite", 5, 225.00);
		this.service.createRoom("Westminister", "Premiere Room", 4, 200.00);
	}

	@Test
	void testHasRoom() {
		assertFalse(this.service.hasRoom(this.room2));
		assertTrue(this.service.hasRoom(this.room1));
	}

	@Test
	void testAsArray() {
		Room[] rooms = this.service.asArray();

		assertEquals(4, rooms.length);
		assertEquals(this.room3, rooms[0]);
		assertEquals(this.room1, rooms[1]);
		assertEquals(this.room5, rooms[2]);
		assertEquals(this.room6, rooms[3]);
	}

	@Test
	void testGetByType() {
		Collection<Room> guestRooms = this.service.getByType("Premiere Room");

		assertEquals(2, guestRooms.size());

		assertTrue(
			guestRooms.stream()
								.allMatch(
									room -> room.getType().equals("Premiere Room")
								)
		);

		assertEquals(4, this.service.getInventory().size());
	}
}
