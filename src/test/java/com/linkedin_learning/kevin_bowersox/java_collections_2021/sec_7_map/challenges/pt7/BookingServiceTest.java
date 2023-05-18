package com.linkedin_learning.kevin_bowersox.java_collections_2021.sec_7_map.challenges.pt7;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BookingServiceTest {
	BookingService bookingService;
	Room room1, room2, room3, room4, room5, room6;
	Guest guest1, guest2, guest3, guest4, guest5, guest6;

	@BeforeEach
	void setUp() throws Exception {
		this.bookingService = new BookingService();
		
		room1 = new Room("Piccadilly", "Guest Room", 3, 125.00);
		room2 = new Room("Cambridge", "Premiere Room", 4, 175.00);
		room3 = new Room("Westminister", "Premiere Room", 4, 200.00);
		room4 = new Room("Oxford", "Suite", 5, 225.0);
		room5 = new Room("Victoria", "Suite", 5, 225.0);
		room6 = new Room("Manchester", "Suite", 5, 250.0);
		
		guest1 = new Guest("John", "Doe", false);
		guest2 = new Guest("Maria", "Doe", true);
		guest3 = new Guest("Sonia", "Doe", true);
		guest4 = new Guest("Siri", "Doe", true);
		guest5 = new Guest("Bob", "Doe", false);
		guest6 = new Guest("Sandra", "Doe", false);
	}

	@Test
	void testBook() {
		assertTrue(this.bookingService.book(room2, guest5));
		assertTrue(this.bookingService.book(room4, guest2));
		assertTrue(this.bookingService.book(room5, guest3));
		assertFalse(this.bookingService.book(room2, guest4));
		assertFalse(this.bookingService.book(room2, guest6));
		assertFalse(this.bookingService.book(room4, guest1));
		assertFalse(this.bookingService.book(room5, guest1));
	}
	
	@Test
	void testTotalRevenue() {
		this.bookingService.book(room1, guest1);
		this.bookingService.book(room4, guest2);
		this.bookingService.book(room6, guest4);
		this.bookingService.book(room5, guest3);

		assertEquals(825, this.bookingService.totalRevenue());
		
		this.bookingService.book(room2, guest6);

		assertEquals(1000, this.bookingService.totalRevenue());
	}
}
