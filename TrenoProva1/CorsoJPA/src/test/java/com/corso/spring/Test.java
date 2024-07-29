package com.corso.spring;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.corso.spring.dao.CategoriaDao;
import com.corso.spring.model.Categoria;

public class Test {

	public static void main(String[] args) {
		testAddCategoriaDao();

	}
	
	
	  
	  public static void testLibro() {
		   stampa("0-testLibro");
		   
		   BeanFactory factory = new AnnotationConfigApplicationContext(Beans.class); /* Container di Spring */ 
		   
		   Libro libro0 = factory.getBean("libro01", Libro.class); 
		   System.out.println(libro0);
		   libro0.setTitolo("Titolo nel Main");
		   
		   Libro libro1 = factory.getBean("libro01", Libro.class); 
		   System.out.println(libro1);
		   
		   Libro libro2 = factory.getBean("libro01", Libro.class); 
		   System.out.println(libro2);
		   
	   }	
	
	  public static void testDataSource() {
		   stampa("1-testDataSource");
		   
		   AnnotationConfigApplicationContext factory = new AnnotationConfigApplicationContext(Beans.class); 
		   
		   DataSource ds = factory.getBean("dataSource", DataSource.class); 
		   
		   Connection connection=null;
		   try {
			   connection = (Connection)ds.getConnection();
		   } catch (SQLException e) {
				e.printStackTrace();
		   }
		   System.out.println(connection);
		   
		   
		   DataSource ds2 = factory.getBean("dataSource", DataSource.class); 
		   System.out.println(ds);
		   
		   System.out.println(ds2);
		   
		   factory.close();    
      }	
	  
		  
	  

	  
	  public static void testAddCategoriaDao() {
		   
		   stampa("3-testAddCategoriaDao");
		   
		   BeanFactory factory = new AnnotationConfigApplicationContext(Beans.class);
		   CategoriaDao dao = factory.getBean("categoriaDao", CategoriaDao.class); 
		   Categoria categoria = getCategoria(); 
		   dao.add(categoria);
		   System.out.println(categoria);
		   
		   
	  }   	  
	  
	  
	  
	   private static void stampa(String nomeMetodoTest) {
		   System.out.println("-----------------------------------------------------------");
		   System.out.println("invocazione del metodo: " + nomeMetodoTest + "()");
		   System.out.println("-----------------------------------------------------------");
	   }

	   
		private static Categoria getCategoria() {
			   Categoria categoria = new Categoria();
			   categoria.setId(50);
			   categoria.setNome("Nome Categoria TD " + System.currentTimeMillis());
			   categoria.setDescrizione("Categoria di libri TD");
			   return categoria;
		   }	   
	   
}
