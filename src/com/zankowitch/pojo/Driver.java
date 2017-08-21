package com.zankowitch.pojo;

public class Driver extends PojoBase {
	private String name;
	private String lastName;
	private Boolean hasBooked = false;
	private CarWishes carWishes;

	public Driver(){}

	public Driver(String name, String lastName) {
		this.setId(name+lastName.hashCode());
		this.name = name;
		this.lastName = lastName;
	}

	public CarWishes getCarWishes() {
		return carWishes;
	}

	public void setCarWishes(CarWishes carWishes) {
		this.carWishes = carWishes;
	}

	public Boolean getHasBooked() {
		return hasBooked;
	}

	public void setHasBooked(Boolean hasBooked) {
		this.hasBooked = hasBooked;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getName() {
		return name;
	}

	public String getLastName() {
		return lastName;
	}

	@Override
	public String toString() {
		return "Driver{" +
			"id='" + getId() + '\''  +
			"name='" + name + '\'' +
			", lastName='" + lastName + '\'' +
			", hasBooked=" + hasBooked +
			", carWishes=" + carWishes +
			"}\n";
	}
}
