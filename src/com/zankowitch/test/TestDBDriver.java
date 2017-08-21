package com.zankowitch.test;

import com.zankowitch.base.DBDriver;
import com.zankowitch.entity.DBEntity;
import com.zankowitch.pojo.Driver;

public class TestDBDriver {

	public static void main(String[] args) {
		DBDriver dbDriver = new DBDriver(new DBEntity<>());
		System.out.println(dbDriver.list());

		Driver driver1 = new Driver("Alxis", "Zankowitch");
		Driver driver2 = new Driver("Georg", "Hackenberg");
		dbDriver.put(driver1, driver1.getId());
		dbDriver.put(driver2, driver2.getId());

		System.out.println(dbDriver.list());
		System.out.println("Wrong spelling name driver 1");

		dbDriver.get(driver1.getId()).setName("Alexis");
		System.out.println(dbDriver.list());
		System.out.println("Name has been corrected");

		System.out.println("test remove 0 = nop 1 = yep");
		System.out.println("can't remove because Alexis has booked a car: ");
		dbDriver.get(driver1.getId()).setHasBooked(true);
		System.out.println(dbDriver.delete(driver1.getId()));
		System.out.println(dbDriver.list());

		System.out.println("Set hasbooked to false and remove again: ");
		dbDriver.get(driver1.getId()).setHasBooked(false);
		System.out.println(dbDriver.delete(driver1.getId()));
		System.out.println(dbDriver.list());
		System.out.println("Alexis has been removed");

	}
}
