package com.linkedin_learning.kevin_bowersox.java_collections_2021.sec_3_iterating_collections.challenges.pt7;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.Collection;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.linkedin_learning.kevin_bowersox.java_collections_2021.sec_3_iterating_collections.pt_1_6.Room;

class RoomServiceTest {
	RoomService service;
	Room[] rooms;

	@BeforeEach
	void setUp() throws Exception {
		Room room1 = new Room("Cambridge", "Premiere Room", 4, 175.00);
		Room room2 = new Room("Manchester", "Suite", 5, 250.00);
		Room room3 = new Room("Piccadilly", "Guest Room", 3, 125.00);
		Room room4 = new Room("Oxford", "Suite", 5, 225.0);
		Room room5 = new Room("Victoria", "Suite", 5, 225.00);
		Room room6 = new Room("Westminister", "Premiere Room", 4, 200.00);

		this.rooms = new Room[] { room1, room2, room3, room4, room5, room6 };

		this.service = new RoomService();

		this.service.createRooms(rooms);
	}

	@Test
	void testApplyDiscount() {
		this.service.applyDiscount(.10);

		assertEquals(157.5, rooms[0].getRate());
		assertEquals(225, rooms[1].getRate());
		assertEquals(112.5, rooms[2].getRate());
		assertEquals(202.5, rooms[3].getRate());
		assertEquals(202.5, rooms[4].getRate());
		assertEquals(180, rooms[5].getRate());
	}

	@Test
	void testGetRoomsByCapacity() {
		Collection<Room> roomsWithCapacity = this.service.getRoomsByCapacity(4);

		assertTrue(
			roomsWithCapacity.containsAll(
				Arrays.asList(
					rooms[0], 
					rooms[1], 
					rooms[3], 
					rooms[4], 
					rooms[5]
				)
			)
		);
	}

	@Test
	void testgetRoomByRateAndType() {
		Collection<Room> roomsWithRateAndType = this.service.getRoomByRateAndType(190.00, "Premiere Room");

		assertTrue(roomsWithRateAndType.contains(rooms[0]));

		assertFalse(roomsWithRateAndType.contains(rooms[1]));
		assertFalse(roomsWithRateAndType.contains(rooms[2]));
		assertFalse(roomsWithRateAndType.contains(rooms[3]));
		assertFalse(roomsWithRateAndType.contains(rooms[4]));
		assertFalse(roomsWithRateAndType.contains(rooms[5]));
	}
}
