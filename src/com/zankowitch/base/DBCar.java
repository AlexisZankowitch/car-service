package com.zankowitch.base;

import com.zankowitch.entity.DBEntity;
import com.zankowitch.pojo.Car;

public class DBCar extends DBBase<Car> {
	public DBCar(DBEntity<Car> pojo) {
		super(pojo);
	}
}
