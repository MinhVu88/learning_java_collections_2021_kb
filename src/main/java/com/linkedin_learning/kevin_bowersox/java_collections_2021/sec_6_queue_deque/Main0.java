/* 
	6.1 - Queue interface
	6.2 - Queue implementations
*/
package com.linkedin_learning.kevin_bowersox.java_collections_2021.sec_6_queue_deque;

import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main0 {
	public static void print(Queue<Guest> queue) {
		System.out.format("%n--Queue Contents--%n");

		int x = 0;

		for(Guest guest : queue) {
			System.out.format(
				"%x: %s %s %n", 
				x++, 
				guest.toString(), 
				x == 1 ? "(Head)" : ""
			);
		}
		
		System.out.println("");		
	}

	public static void main(String[] args) {
		Guest guest1 = new Guest("John", "Doe", false);
		Guest guest2 = new Guest("Bob", "Doe", false);
		Guest guest3 = new Guest("Sonia", "Doe", true); //loyalty program
		Guest guest4 = new Guest("Siri", "Doe", true); //loyalty program

		System.out.println("\t\t[ ArrayDeque (F.I.F.O order) ]\n");
		System.out.println("\t\t~ The remove() & poll() methods ~\n");

		Queue<Guest> checkinQueue1 = new ArrayDeque<>();

		try {
			Guest extractedGuest1 = checkinQueue1.remove();
			System.out.println(extractedGuest1);
		} catch(Exception e) {
			System.out.println("Guest extractedGuest1 = checkinQueue1.remove() | extractedGuest1 | ERROR: " + e);
		}

		Guest extractedGuest2 = checkinQueue1.poll();
		System.out.println("Guest extractedGuest2 = checkinQueue1.poll() | extractedGuest2 -> " + extractedGuest2);

		System.out.println("------------------------------------------------------------------------");

		System.out.println("\t\t~ The offer() method ~");

		// add() would throw IllegalStateException if too many elements were added to a bounded queue
		// checkinQueue.add(guest1); 
		checkinQueue1.offer(guest1);
		checkinQueue1.offer(guest2);
		print(checkinQueue1);

		Guest extractedGuest3 = checkinQueue1.poll();
		System.out.println("extractedGuest3 | poll() -> " + extractedGuest3);
		print(checkinQueue1);

		System.out.println("------------------------------------------------------------------------");

		System.out.println("\t\t~ The peek() method ~");

		checkinQueue1.offer(guest3);
		checkinQueue1.offer(guest4);
		print(checkinQueue1);

		Guest extractedGuest4 = checkinQueue1.peek();
		System.out.println("extractedGuest4 | peek() -> " + extractedGuest4);
		print(checkinQueue1);

		System.out.println("------------------------------------------------------------------------");

		System.out.println("\t\t~ The add() & element() methods ~");

		Queue<Guest> checkinQueue2 = new ArrayDeque<>();
		
		checkinQueue2.add(guest1);
		checkinQueue2.add(guest2);
		checkinQueue2.add(guest3);
		checkinQueue2.add(guest4);
		print(checkinQueue2);

		Guest extractedGuest5 = checkinQueue2.remove();
		System.out.println("extractedGuest5 | remove() -> " + extractedGuest5);
		print(checkinQueue2);

		Guest extractedGuest6 = checkinQueue2.element();
		System.out.println("extractedGuest6 | element() -> " + extractedGuest6);
		print(checkinQueue2);

		System.out.println("------------------------------------------------------------------------");

		System.out.println("\t\t[ PriorityQueue ]");

		Comparator<Guest> guestComparator = Comparator.comparing(Guest::isLoyaltyProgramMember).reversed();

		Queue<Guest> checkinQueue3 = new PriorityQueue<>(guestComparator);

		checkinQueue3.add(guest1);
		checkinQueue3.add(guest2);
		checkinQueue3.add(guest3);
		checkinQueue3.add(guest4);
		print(checkinQueue3);

		Guest extractedGuest7 = checkinQueue3.remove();
		System.out.println("extractedGuest7 | remove() -> " + extractedGuest7);
		print(checkinQueue3);

		Guest extractedGuest8 = checkinQueue3.element();
		System.out.println("extractedGuest8 | element() -> " + extractedGuest8);
		print(checkinQueue3);
	}
}
