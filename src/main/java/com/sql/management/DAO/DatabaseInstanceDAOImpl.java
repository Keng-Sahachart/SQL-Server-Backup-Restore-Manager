package com.sql.management.DAO;

import java.util.List;

import com.sql.management.Model.*;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

@Repository("DatabaseInstanceDAO") 
public class DatabaseInstanceDAOImpl extends AbstractDAO <Integer, DatabaseInstance> implements DatabaseInstanceDAO {

	
	private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
	
	
	@Override
	public DatabaseInstance findInstance() {
		
		return null;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<DatabaseInstance> getAllInstances() {	
		Criteria criteria = createEntityCriteria().addOrder(Order.asc("id"));
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//To avoid duplicates.
        
		List<DatabaseInstance> instanceList = (List<DatabaseInstance>) criteria.list();
		return instanceList;
	}

}
