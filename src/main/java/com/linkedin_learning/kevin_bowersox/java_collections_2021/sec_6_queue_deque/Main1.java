/* 
	6.3 - Deque interface
	6.4 - Using an ArrayDeque as a stack
*/
package com.linkedin_learning.kevin_bowersox.java_collections_2021.sec_6_queue_deque;

import java.util.ArrayDeque;
import java.util.Deque;

public class Main1 {
	public static void print(Deque<String> deque) {
		System.out.format("%n--Deque Contents--%n");

		int x = 0;

		for(String msg : deque) {
			System.out.format(
				"%x: %s %s %n", 
				x++, 
				msg, 
				x == 1 ? "(Top)" : ""
			);
		}
		
		System.out.println("");
	}
	
	public static void main(String[] args) {
		System.out.println("\t\t[ The push() method ]");
		
		Deque<String> messageStack0 = new ArrayDeque<>();

		messageStack0.push("message 1");
		print(messageStack0);

		messageStack0.push("message 2");
		print(messageStack0);

		messageStack0.push("message 3");
		print(messageStack0);

		messageStack0.push("message 4");
		print(messageStack0);

		System.out.println("------------------------------------------------------------------------");

		System.out.println("\t\t[ The pop() & peek() methods ]");

		Deque<String> messageStack1 = new ArrayDeque<>();

		messageStack1.push("message 5");
		messageStack1.push("message 6");
		messageStack1.push("message 7");

		print(messageStack1);

		System.out.println(
			"messageStack1.pop() -> " + messageStack1.pop() +
			" | messageStack1.pop() -> " + messageStack1.pop() +
			" | messageStack1.peek() -> " + messageStack1.peek()
		);

		print(messageStack1);

		System.out.println("------------------------------------------------------------------------");

		Deque<String> messageStack2 = new ArrayDeque<>();

		messageStack2.push("message 8");
		messageStack2.push("message 9");
		messageStack2.push("message 10");
		messageStack2.push("message 11");

		print(messageStack2);

		System.out.println(
			"messageStack2.pop() -> " + messageStack2.pop() +
			" | messageStack2.pop() -> " + messageStack2.pop()
		);

		print(messageStack2);

		messageStack2.push("message 12");

		System.out.println("messageStack2.peek() -> " + messageStack2.peek());

		print(messageStack2);
	}
}
