/* Object comparison: 
	- Identity-based: determines if 2 objects are the same object in memory (Ex: obj1 == obj2).
	- Value-based: determines if 2 objects are logically equivalent, meaning they're equal in value
	  (Ex: obj1.equals(obj2)).
*/
package com.linkedin_learning.kevin_bowersox.java_collections_2021.sec_2_foundations.pt_5_8;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

public class CarComparisonTests {
	Collection<Car> cars;
	Car car1, car2, car3;

	@BeforeEach
	public void setUp(TestInfo info) throws Exception {
		System.out.format("%nPerforming %s%n", info.getTestMethod().get().getName());

		this.cars = new ArrayList<>();
		
		this.car1 = new Car("Subaru", "Impreza", 52000);
		this.car2 = new Car("Tesla", "Model S", 10000);
		this.car3 = new Car("Honda", "Civic", 25000);

		this.cars.addAll(Arrays.asList(this.car1, this.car2, this.car3));
	}

	@AfterEach
	public void tearDown() throws Exception {
		System.out.format("%nResults%n");

		this.cars.stream()
						 .map(c -> String.format("\t%s %s", c.getMake(), c.getModel()))
						 .forEach(System.out::println);
	}

	@Test
	public void removeTest() {
		this.cars.remove(car3);
		this.cars.remove(new Car("Subaru", "Impreza", 52000));

		assertEquals(1, this.cars.size());
	}

	@Test
	public void containsTest() {
		assertTrue(this.cars.contains(new Car("Tesla", "Model S", 10000)));
		assertTrue(this.cars.contains(car3));
		assertTrue(this.cars.contains(car1));
	}

	@Test
	public void removeAllIdentityTest() {
		this.cars.removeAll(Arrays.asList(
			this.car1,
			this.car2,
			new Car("Honda", "Civic", 25000)
		));

		assertTrue(this.cars.isEmpty());
	}
}
