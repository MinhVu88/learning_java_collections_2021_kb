package com.kevinbowersox.lil.learning_java_collections_2021.sec_2_foundations.pt_5_8;

import com.kevinbowersox.lil.learning_java_collections_2021.sec_1_intro.Room;

import java.util.ArrayList;
import java.util.Collection;

public class GenericTyping {
	public static void main(String[] args) {
		// a raw-type collection has no type info about the element it holds (not recommended)
		Collection c1 = new ArrayList<>();

		c1.add("some string");

		System.out.println("collection 1: " + c1);

		int digit = 7;
		c1.add(digit);

		c1.stream().forEach(element -> System.out.println("collection 1: " + element.getClass()));

		// Error: ClassCastException
		// c1.stream().forEach(element -> System.out.println(((Room) element).getName()));

		// a collection that uses generic typing to indicate the type of elements it holds (recommended)
		Collection<Room> c2 = new ArrayList<>();

		c2.add(new Room("Cambridge", "premiere", 4, 175.0));
		c2.add(new Room("Manchester", "suit", 4, 250.0));
		c2.add(new Room("Piccadilly", "guest", 4, 125.0));

		System.out.println("collection 2: " + c2);

		c2.stream().forEach(element -> System.out.print(element.getName() + " "));
	}
}
