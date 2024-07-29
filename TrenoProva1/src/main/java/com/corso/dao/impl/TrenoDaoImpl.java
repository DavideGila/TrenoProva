package com.corso.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.corso.dao.TrenoDao;
import com.corso.model.Fabbrica;
import com.corso.model.Treno;
import com.corso.model.Utente;

public class TrenoDaoImpl implements TrenoDao{
	
	@PersistenceContext // figlia di Autowired
	
	private EntityManager manager; 
	
	@Override
	public Treno add(Treno treno) {
		manager.persist(treno);
		return treno;
	}

	@Override
	public Utente find(int id) {
		return manager.find(Utente.class, id);
	}

	@Override
	public Fabbrica find(String sigla) {
		return manager.find(Fabbrica.class, sigla);
	}
	
	

}
