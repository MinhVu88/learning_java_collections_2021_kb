/*
	5.1 - List interface
	5.2 - List implementations
	5.3 - ArrayList
*/
package com.linkedin_learning.kevin_bowersox.java_collections_2021.sec_5_list.pt_1_2_3;

import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void print(List<Guest> list) {
		System.out.format("%n--List Contents--%n");

		for(int x = 0; x < list.size(); x++) {
			Guest guest = list.get(x);

			System.out.format("%x: %s %n", x, guest.toString());
		}
	}

	public static void main(String[] args) {
		Guest guest1 = new Guest("John", "Doe", false);
		Guest guest2 = new Guest("Maria", "Doe", false);
		Guest guest3 = new Guest("Sonia", "Doe", true);
		Guest guest4 = new Guest("Siri", "Doe", true);

		List<Guest> checkinList = new ArrayList<>(100);

		checkinList.add(guest1);
		checkinList.add(guest2);
		print(checkinList);

		checkinList.add(0, guest3);
		print(checkinList);

		checkinList.get(2).setLoyaltyProgramMember(true);

		checkinList.addAll(1, List.of(guest2, guest4));
		print(checkinList);

		checkinList.remove(checkinList.size() - 1);
		print(checkinList);

		System.out.println(
			"\n" + guest1.getFirstName() + "'s index position in the list: " + 
			checkinList.indexOf(guest1)
		);
	}
}
