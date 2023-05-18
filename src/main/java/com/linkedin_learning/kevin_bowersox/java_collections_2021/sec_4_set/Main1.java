// 4.3 - TreeSet
package com.linkedin_learning.kevin_bowersox.java_collections_2021.sec_4_set;

import java.util.Arrays;
import java.util.List;
import java.util.NavigableSet;
import java.util.TreeSet;

public class Main1 {
	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(500, 1500, 2500, 1000, 2000, 3000);

		System.out.println("\t\t[ Interface: NavigableSet | Implementation: TreeSet ]\n");

		NavigableSet<Integer> numberTree = new TreeSet<>(numbers);

		numberTree.stream().forEach(System.out::println);

		System.out.println("------------------------------------------------------------------------");

		System.out.println("\t\t[ The descendingSet() method ]\n");

		numberTree.descendingSet().stream().forEach(System.out::println);

		System.out.println("------------------------------------------------------------------------");

		System.out.println("\t\t[ The headSet() method ]\n");

		// headSet(some_value) => all values below some_value
		numberTree.headSet(1750).stream().forEach(System.out::println);

		System.out.println("------------------------------------------------------------------------");

		System.out.println("\t\t[ The tailSet() method ]\n");

		// tailSet(some_value) => all values above some_value
		numberTree.tailSet(1750).stream().forEach(System.out::println);

		System.out.println("------------------------------------------------------------------------");

		System.out.println("\t\t[ The subSet() method ]\n");

		// subSet(value_1, value_2) => all values between value_1 & value_2
		numberTree.subSet(1750, 2750).stream().forEach(System.out::println);

		System.out.println("------------------------------------------------------------------------");

		System.out.println("\t\t[ The lower() & higher() methods ]\n");

		// lower(some_value) => a value that's right below some_value
		// higher(some_value) => a value that's right above some_value
		System.out.println(
			"numberTree.lower(750) => " + numberTree.lower(750) +
			" | numberTree.higher(750) => " + numberTree.higher(750)
		);
	}
}
