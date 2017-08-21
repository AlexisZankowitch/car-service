package com.zankowitch.base;

import com.zankowitch.entity.DBEntity;
import com.zankowitch.pojo.Driver;

public class DBDriver extends DBBase<Driver> {

	public DBDriver(DBEntity<Driver> pojo) {
		super(pojo);
	}

	@Override
	public int delete(String id) {
		if (null != get(id) && get(id).getHasBooked())
			return 0;
		return super.delete(id);
	}
}
