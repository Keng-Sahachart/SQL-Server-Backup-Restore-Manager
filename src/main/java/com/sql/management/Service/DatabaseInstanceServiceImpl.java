package com.sql.management.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sql.management.DAO.DatabaseInstanceDAO;
import com.sql.management.Model.DatabaseInstance;

@Service("DatabaseInstanceService")
@Transactional
@Component
public class DatabaseInstanceServiceImpl implements DatabaseInstanceService {

	@Autowired
    private DatabaseInstanceDAO dao;
	
	
	@Override
	public List<DatabaseInstance> findAllInstances() {
		
		return dao.getAllInstances();
	}



}
