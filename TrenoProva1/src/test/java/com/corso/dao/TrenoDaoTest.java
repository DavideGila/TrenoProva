package com.corso.dao;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.corso.base.BaseTest;
import com.corso.config.Beans;
import com.corso.model.Treno;

public class TrenoDaoTest extends BaseTest{

	public static void main(String[] args) {
		
		testAddTrenoDao();
		
	}
	
	 public static void testAddTrenoDao() {
		   
		   stampa("2-testAddTrenoDao");
		   
		   BeanFactory factory = new AnnotationConfigApplicationContext(Beans.class);
		   TrenoDao dao = factory.getBean("trenoDao", TrenoDao.class); 
		   Treno treno = getTreno(dao); 
		   dao.add(treno);
		   System.out.println(treno);
		   
	  }   
	
}
