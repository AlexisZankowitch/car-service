package com.zankowitch.pojo;

public class CarWishes extends PojoBase {
	private int horsePower;
	private int seats;

	public CarWishes(int horsePower, int seats) {
		this.horsePower = horsePower;
		this.seats = seats;
	}

	public int getHorsePower() {
		return horsePower;
	}

	public void setHorsePower(int horsePower) {
		this.horsePower = horsePower;
	}

	public int getSeats() {
		return seats;
	}

	public void setSeats(int seats) {
		this.seats = seats;
	}

	@Override
	public String toString() {
		return "CarWishes{" +
			"horsePower=" + horsePower +
			", seats=" + seats +
			'}';
	}
}
