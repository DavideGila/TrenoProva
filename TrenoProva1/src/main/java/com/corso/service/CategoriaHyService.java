package com.corso.service;


import java.sql.SQLException;

import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.corso.dao.CategoriaDao;
import com.corso.dao.CategoriaHyDao;


public interface CategoriaHyService {
	
	@Transactional(
			rollbackFor = {Throwable.class}, 
			propagation = Propagation.REQUIRED,
			isolation = Isolation.READ_COMMITTED)
	
	public void archivia (Integer id) throws Exception;
	
	public void setcDao(CategoriaDao cDao);
	public void setcHyDao(CategoriaHyDao cHyDao);
	
	
	public void addCategoriaMANDATORY(Integer id);   
	
	public void addCategoriaNOT_SUPPORTED(Integer id);   
	
}