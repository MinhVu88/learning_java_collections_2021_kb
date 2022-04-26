package com.linkedin_learning.kevin_bowersox.java_collections_2021.sec_2_foundations.pt_5_8;

public class Car {
	private String make;
	private String model;
	private int mileage;

	public Car(String make, String model, int mileage) {
		super();
		this.make = make;
		this.model = model;
		this.mileage = mileage;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getMileage() {
		return mileage;
	}

	public void setMileage(int mileage) {
		this.mileage = mileage;
	}

	@Override
	public String toString() {
		return "Car make: " + make + " | model: " + model;
	}

	@Override
	public int hashCode() {
		final int prime = 31;

		int result = 1;

		result = prime * result + ((make == null) ? 0 : make.hashCode());

		result = prime * result + ((make == null) ? 0 : model.hashCode());

		return result;
	}

	@Override
	public boolean equals(Object object) {
		Car car1 = (Car) object;

		System.out.format("Comparing %s %s with %s %s %n", this.make, this.model, car1.make, car1.model);

		if(this == object) {
			return true;
		}

		if(object == null) {
			return false;
		}

		if(getClass() != object.getClass()) {
			return false;
		}

		Car car2 = (Car) object;

		if(make == null) {
			if(car2.make != null) {
				return false;
			}
		}else if(!make.equals(car2.make)) {
			return false;
		}

		if(model == null) {
			if(car2.model != null) {
				return false;
			}
		}else if(!model.equals(car2.model)) {
			return false;
		}

		return true;
	}
}
