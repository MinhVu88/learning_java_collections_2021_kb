/*
	2.1 - Interfaces
	2.2 - Collection types
	2.3 - The Collection interface
	2.4 - Collection methods
*/
package com.linkedin_learning.kevin_bowersox.java_collections_2021.sec_2_foundations.pt_1_4;

public class Main {
	public static void main(String[] args) {
		Contract1 contract = new Implementation();

		printTerms(contract);
	}

	private static void printTerms(Contract1 contract) {
		contract.processTerm1();
		contract.processTerm2();
		contract.processTerm3();
	}
}
