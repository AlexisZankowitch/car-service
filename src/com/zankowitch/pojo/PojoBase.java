package com.zankowitch.pojo;

import java.util.Date;

public abstract class PojoBase {
	private String id;
	private Date creationDate;
	private Date lastChange;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Date getLastChange() {
		return lastChange;
	}

	public void setLastChange(Date lastChange) {
		this.lastChange = lastChange;
	}

	public void setValues(String id, Date creationDate, Date lastChange){
		this.id = id;
		this.creationDate = creationDate;
		this.lastChange = lastChange;
	}
}
