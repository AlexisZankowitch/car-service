package com.zankowitch.pojo;

public class Car extends PojoBase {

	private String model;
	private String registration;
	private String constructor;
	private int horsePower;
	private int seats;

	private Driver driver;


	public Car(){}

	public Car(String model, int horsePower, String constructor, String registration, int seats) {
		this.seats = seats;
		this.setId(model+ constructor.hashCode());
		this.model = model;
		this.horsePower = horsePower;
		this.constructor = constructor;
		this.registration = registration;
	}

	public int getSeats() {
		return seats;
	}

	public void setSeats(int seats) {
		this.seats = seats;
	}

	public Driver getDriver() {
		return driver;
	}

	public void setDriver(Driver driver) {
		this.driver = driver;
	}

	public String getRegistration() {
		return registration;
	}

	public void setRegistration(String registration) {
		this.registration = registration;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public void setHorsePower(int horsePower) {
		this.horsePower = horsePower;
	}

	public String getModel() {
		return model;
	}

	public int getHorsePower() {
		return horsePower;
	}

	public String getConstructor() {
		return constructor;
	}

	public void setConstructor(String constructor) {
		this.constructor = constructor;
	}


	@Override
	public String toString() {
		return "Car{" +
			"id="+ getId() +
			", model='" + model + '\'' +
			", registration='" + registration + '\'' +
			", constructor='" + constructor + '\'' +
			", horsePower=" + horsePower +
			", seats= " + seats +
			", driver=" + driver +
			"}\n";
	}
}
