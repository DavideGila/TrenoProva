package com.corso.dao;

import javax.transaction.Transactional;

import com.corso.model.Fabbrica;
import com.corso.model.Treno;
import com.corso.model.Utente;

@Transactional
public interface TrenoDao {
	 
	public Treno add(Treno treno);
	
	public Utente find(int id);
	
	public Fabbrica find(String sigla);
}
