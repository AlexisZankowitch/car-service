package com.zankowitch.base;


import com.zankowitch.crud.CrudEntity;
import com.zankowitch.entity.DBEntity;

import java.util.Collection;

public abstract class DBBase<P> implements CrudEntity<P> {

	private DBEntity<P> entity;


	DBBase(DBEntity<P> pojo) {
		this.entity = pojo;
	}

	@Override
	public Collection<P> list() {
		return entity.getTable().values();
	}

	@Override
	public P get(String id) {
		return entity.getTable().get(id);
	}

	@Override
	public P put(P p, String id) {
		int l1 = entity.getTable().size();
		entity.getTable().put(id, p);
		int l2 = entity.getTable().size();
		return (l1 < l2) ? p : null;
	}

	@Override
	public int delete(String id) {
		return (entity.getTable().remove(id) != null)?1:0;
	}
}
