package com.corso.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.corso.dao.CategoriaDao;
import com.corso.dao.CategoriaHyDao;
import com.corso.model.Categoria;
import com.corso.model.CategoriaHy;
import com.corso.service.CategoriaHyService;

public class CategoriaHyServiceImpl implements CategoriaHyService{
	
	public CategoriaDao getcDao() {
		return cDao;
	}

	public void setcDao(CategoriaDao cDao) {
		this.cDao = cDao;
	}

	public CategoriaHyDao getcHyDao() {
		return cHyDao;
	}

	public void setcHyDao(CategoriaHyDao cHyDao) {
		this.cHyDao = cHyDao;
	}

	CategoriaDao cDao = null;// (CategoriaDao) factory.getBean("categoriaDao"); 
	
	CategoriaHyDao cHyDao = null;//(CategoriaHyDao) factory.getBean("categoriaHyDao"); 
		
	public void archivia (Integer id) throws Exception {
		
		
		Categoria c = cDao.find(id);
		
		if (c != null) {
			CategoriaHy ch = new CategoriaHy();
			
			BeanUtils.copyProperties(c, ch); 
			
			ch.setDescrizione("(Ex. "+c.getId()+" )" + ch.getDescrizione());
			
			ch = cHyDao.add(ch);			
			//if(true) throw new Exception("esempio di Throwable che si verifica internamente ad una transazione");
			
			cDao.delete(c);
			
			//if (true) throw new Exception("esempio REQUIRES");
			
			
		}

	} 
	
	public void archiviaEsempioRequired_NEW (Integer id) throws Exception {
		
	Categoria c = cDao.find(id);
	
	if (c != null) {
		CategoriaHy ch = new CategoriaHy();
		
		BeanUtils.copyProperties(c, ch); 
		
		ch.setDescrizione("(Ex. "+c.getId()+" )" + ch.getDescrizione());
		
		ch = cHyDao.add(ch);			
		//if(true) throw new Exception("esempio di Throwable che si verifica internamente ad una transazione");
		cDao.delete(c);
		
		if (true) throw new Exception("esempio REQUIRES_NEW");
	}
} 
	
	public void archiviaDoppio(Integer id, Categoria altra) throws Exception {
		Categoria c = cDao.find(id);
		
		if (c != null) {
			CategoriaHy ch = new CategoriaHy();
			
			BeanUtils.copyProperties(c, ch); 
			
			ch.setDescrizione("(Ex. "+c.getId()+" )" + ch.getDescrizione());
			
			
			
			//if(true) throw new Exception("esempio di Throwable che si verifica internamente ad una transazione");
			ch = cHyDao.add(ch);			
			Categoria c2 = cDao.add(altra);			
			cDao.add(c2);
			
			
			// SAVEPOINT
			// NESTED + ERRORE
			cDao.delete(c);
			
			 
		}
	} 
	
	
	public void addCategoriaMANDATORY (Integer id) {
		Categoria c = cDao.find(id);
		
		if (c != null) {
			CategoriaHy ch = new CategoriaHy();
			BeanUtils.copyProperties(c, ch); 
			
			ch.setDescrizione("(Ex. "+c.getId()+" )" + ch.getDescrizione());
			
			cHyDao.add(ch);

			}
	}

	public void addCategoriaNOT_SUPPORTED (Integer id) {
		Categoria c = cDao.find(id);
		
		if (c != null) {
			CategoriaHy ch = new CategoriaHy();
			BeanUtils.copyProperties(c, ch); 
			ch.setId(608);
			
			ch.setDescrizione("(Ex. "+c.getId()+" NS )" + ch.getDescrizione());
			
			cHyDao.addNS(ch);

			}
	}
}