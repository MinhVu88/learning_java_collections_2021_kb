/*
 2.5 - Creating a collection
 2.6 - Generic typing
 2.7 - Object comparison
 2.8 - The equals method
*/
package com.linkedin_learning.kevin_bowersox.java_collections_2021.sec_2_foundations.pt_5_8;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CreatingACollection {
	public static void main(String[] args) {
		// Error: the Collection type can't be instantiated as it doesn't have any direct implementation
		// Collection c1 = new Collection();

		// this works
		Collection c2 = new HashSet<>();

		// Error: List isn't compatible with HashSet 
		// (or HashSet doesn't implement the List interface)
		// List c3 = new HashSet<>();

		// this works as HashSet implements the Set interface
		Set c4 = new HashSet<>();

		// this works
		List c5 = new ArrayList();

		// RECOMMENDED: avoid using concrete implementation as a variable type (ArrayList),
		// instead use the most abstract types such as List or Collection, 
		// so that the implementation can be switched easily
		ArrayList<String> c6 = new ArrayList<>();
		Collection<String> c7 = new ArrayDeque<>();

		Collection<String> names = new ArrayList<>();

		names.add("Maynard Keenan");
		names.add("Adam Jones");
		names.add("Justin Chancellor");
		names.add("Paul D'Amour");
		names.add("Dan Carey");
		names.add("Maynard Keenan");

		System.out.println("\n\tnames: " + names + "\n");

		Collection<String> toolBand = new HashSet<>(names);

		System.out.println("\n\tTool: " + toolBand + "\n");
	}
}
