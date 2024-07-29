package com.corso.spring.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.corso.spring.dao.Dao;


public class DaoImpl implements Dao {
	
	@PersistenceContext
	EntityManager manager;
	
	
	@Override
	public  List<?> all(Class c) {
		String jpql = "from Prodotto";  
	    Query q =  manager.createQuery(jpql,c);
		@SuppressWarnings("unchecked")
		List<?> l = q.getResultList();
		return l;
	}

	
	@Override
	public Object find(Class c, Integer id) {
		// TODO Auto-generated method stub
		return null;
	}
}
