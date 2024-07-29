package com.corso.spring.dao.impl;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;
import javax.transaction.Transactional;

import com.corso.spring.dao.CategoriaDao;
import com.corso.spring.model.Categoria;


public class CategoriaDaoImpl  implements CategoriaDao{

	@PersistenceContext
	//@PersistenceContext(type=PersistenceContextType.TRANSACTION) // opzioni EXTENDED o TRANSACTION (default)
	//@PersistenceContext(type=PersistenceContextType.EXTENDED) // opzioni EXTENDED o TRANSACTION (default)
	
	EntityManager manager;  
	
	@Override
	public Categoria find(Integer id) {
		return manager.find(Categoria.class,id);
	}	
	
	@Override
	public List<Categoria> all() {
		Query q = manager.createQuery("from Categoria", Categoria.class);
		@SuppressWarnings("unchecked")
		List<Categoria> l = q.getResultList();
		return l;
	}		
	
	
	
	@Override
	//@Transactional
	public void add(Categoria categoria) {
		
		categoria.setId(59);
		
		Categoria cat = manager.merge(categoria);
		
		cat.setDescrizione("modificata nel metodo dao");
		//cat.setId(59);
	}


	@Transactional
	public void add2(Categoria categoria) {
		
		// Transient
		categoria.setId(100);
		categoria.setDescrizione("dvxgv");
		
		manager.persist(categoria);
		// Entity -> Managed Bean (per Hibernate oggetti Persistenti)
		// da questo momento in poi tutto si rifletterà sul DB
		categoria.setDescrizione("sdfsxgv"); 
		categoria.setId(12);  // vietato
		categoria.setNome(null); // vietato se il nome è not null
		
		
		
		
		
		
	}

	
	
	
	@Override
	public List<Categoria> filterCategoriaByName(String name) {
		Query q = manager.createQuery("from Categoria where nome=:name", Categoria.class);
		q.setParameter("name", name);
		@SuppressWarnings("unchecked")
		List<Categoria> l = q.getResultList();
		return l;
	}

	@Override
	@Transactional
	public void update(Categoria categoria) {
		manager.merge(categoria);
	}	
	
	@Override
	@Transactional
	public void delete(int id) {
		Categoria c = this.find(id); 
		if (c!=null)
			manager.remove(c);
	}	
	
	@Override
	@Transactional
	public void deleteDetached(Categoria categoria) {
		manager.remove(categoria);
	}	
	

	@Override
	@Transactional
	public void delete(Categoria categoria) {
		manager.remove(manager.merge(categoria));
	}		
	
	@Override
	@Transactional
	public Categoria provaTutti( Integer id) {
		try {
			//manager.getTransaction().begin();
				
			Categoria c = this.find(id);
			c.setDescrizione("Cambia la descrizione");
			this.update(c);
			c.setDescrizione("Cambia la descrizione 2");
			this.update(c);
			//this.delete(c);
			
			if(true) throw new RuntimeException(); 
			
		//manager.getTransaction().commit();
		} catch (RuntimeException e) {
			//manager.getTransaction().rollback();
		}
		return null; 
	} 

}
