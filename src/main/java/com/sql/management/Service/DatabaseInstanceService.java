package com.sql.management.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sql.management.Model.DatabaseInstance;

public interface DatabaseInstanceService {

	List<DatabaseInstance> findAllInstances();

}
