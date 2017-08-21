package com.zankowitch.test;

import com.zankowitch.base.DBCar;
import com.zankowitch.entity.DBEntity;
import com.zankowitch.pojo.Car;

public class TestCar {
	public static void main(String[] args) {
		DBCar dbCar = new DBCar(new DBEntity<>());
		System.out.println(dbCar.list());

		Car car1 = new Car("C3", 7, "Citroen", "1A7ER", 2);
		Car car2 = new Car("Golf", 14, "Volkswagen", "189AE", 4);
		dbCar.put(car1, car1.getId());
		dbCar.put(car2, car2.getId());
		System.out.println(dbCar.list());
	}
}
