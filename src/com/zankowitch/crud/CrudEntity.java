package com.zankowitch.crud;

import java.util.Collection;

public interface CrudEntity <P> {
	Collection<P> list();

	P get( String id);

	P put(P p, String id);

	int delete(String id);
}
