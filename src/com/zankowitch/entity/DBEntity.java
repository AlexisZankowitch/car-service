package com.zankowitch.entity;

import java.util.HashMap;

public class DBEntity <P> {
	private HashMap<String, P> table = new HashMap<>();

	public HashMap<String, P> getTable() {
		return table;
	}
}
