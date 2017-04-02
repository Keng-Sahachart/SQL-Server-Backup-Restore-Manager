package com.sql.management.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="database_instances")
public class DatabaseInstance {
	
	@Id
	@Column(name="iddatabase_instances")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	

	@Column(name="database_name")
	private String name;
	
	@Column(name="database_isOnline")
	private boolean isOnline;
	
	@Column(name="database_lastZipApplied")
	private String zipApplied;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isOnline() {
		return isOnline;
	}
	public void setOnline(boolean isOnline) {
		this.isOnline = isOnline;
	}
	public String getZipApplied() {
		return zipApplied;
	}
	public void setZipApplied(String zipApplied) {
		this.zipApplied = zipApplied;
	}

}
