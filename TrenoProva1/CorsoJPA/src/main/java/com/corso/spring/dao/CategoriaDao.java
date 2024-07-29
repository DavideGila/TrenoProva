package com.corso.spring.dao;



import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.corso.spring.model.*;

@Transactional

public interface CategoriaDao {
	
	public void add(Categoria categoria);
	
	public void update(Categoria categoria);

	public Categoria find(Integer id);

	public List<Categoria> all();

	public List<Categoria> filterCategoriaByName(String name);

	public void delete(int id);

	public void delete(Categoria categoria);
	
	public void deleteDetached(Categoria categoria);

	public Categoria provaTutti(Integer id); 
}
