package com.sql.management.DAO;

import java.util.List;

import com.sql.management.Model.DatabaseInstance;

public interface DatabaseInstanceDAO {
	
	DatabaseInstance findInstance();
	
	List<DatabaseInstance> getAllInstances();

}
