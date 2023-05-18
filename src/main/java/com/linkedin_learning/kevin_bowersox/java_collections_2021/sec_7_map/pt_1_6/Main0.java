/*
	7.1 - Map interface
	7.2 - Collection views
	7.3 - Map implementations
	7.4 - How a HashMap works
	7.5 - Map methods
*/
package com.linkedin_learning.kevin_bowersox.java_collections_2021.sec_7_map.pt_1_6;

import java.util.HashMap;
import java.util.Map;

public class Main0 {
	public static void main(String[] args) {
		Room room1 = new Room("Piccadilly", "Guest Room", 3, 125.00);
		Room room2 = new Room("Oxford", "Suite", 5, 225.0);

		Guest guest1 = new Guest("John", "Doe", false);
		Guest guest2 = new Guest("Maria", "Doe", true);

		Map<Room, Guest> assignments = new HashMap<>();
		
		assignments.put(room1, guest1);
		assignments.put(room2, guest2);

		System.out.println(
			"room1: " + room1.getName() + 
			" - guest1: " + assignments.get(room1) +
			" | room2: " + room2.getName() +
			" - guest2: " + assignments.get(new Room("Oxford", "Suite", 5, 225.0))
		);

		System.out.println("------------------------------------------------------------------------");
 
		/*
			- 1st, "assignments.remove(room2)" removes the value (guest2) that was 
				previously associated with the key (room2) & also returns guest2.
			
			- 2nd, "assignments.put(room1, assignments.remove(room2))" places guest2 returned 
				from remove() into room1 & also returns the value (guest1) that was previously 
				associated with the key (room1) & thus tempGuest is now assigned the value guest1.
				
			- 3rd, "assignments.putIfAbsent(room2, tempGuest)" places tempGuest (guest1) into
				room2, which has been emptied by the previous statement.
		*/
		Guest tempGuest = assignments.put(room1, assignments.remove(room2));
		assignments.putIfAbsent(room2, tempGuest);

		System.out.println(
			"room1: " + room1.getName() + 
			" - guest1: " + assignments.get(room1) +
			" | room2: " + room2.getName() +
			" - guest2: " + assignments.get(new Room("Oxford", "Suite", 5, 225.0))
		);
	}
}
