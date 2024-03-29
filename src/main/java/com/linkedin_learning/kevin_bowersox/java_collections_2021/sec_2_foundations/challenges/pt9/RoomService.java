package com.linkedin_learning.kevin_bowersox.java_collections_2021.sec_2_foundations.challenges.pt9;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;

public class RoomService {
	// 1. Declare a Collection to store Room Inventory
	private Collection<Room> inventory;

	public RoomService() {
		// 2. Initialize Collection & assign it to the Room Inventory
		this.inventory = new HashSet<>();
	}

	public Collection<Room> getInventory() {
		// 3. Return the Room Inventory
		// use a conversion constructor to create a copy of the inventory collection.
		// this prevents the collection from being directly modified.
		return new HashSet<>(this.inventory);
	}

	public void createRoom(
		String name,
		String type,
		int capacity,
		double rate
	) {
		// 4. Add a new Room to the Room Inventory using the provided parameters
		this.inventory.add(new Room(name, type, capacity, rate));
	}

	public void createRooms(Room[] rooms) {
		// 5. Add the Rooms provided in the Array to the Room Inventory
		// 1st, convert the rooms array into a collection, then pass it to addAll()
		this.inventory.addAll(List.of(rooms));
	}

	public void removeRoom(Room room) {
		// 6. Remove the provided Room from the Room Inventory
		this.inventory.remove(room);
	}
}
