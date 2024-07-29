package com.corso.spring;


import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.*;

import com.corso.spring.dao.CategoriaDao;
import com.corso.spring.dao.impl.CategoriaDaoImpl;


@Configuration   /*qui ci cono le istanze da creare e gestire con il container di Spring DI-IoC*/
@ComponentScan(basePackages="com.corso.spring.annotation")
@EnableTransactionManagement
public class Beans {
		
	@Bean(name="dataSource")
	public DataSource getDataSource () {
		DriverManagerDataSource ds = new DriverManagerDataSource(); 
		ds.setDriverClassName("org.mariadb.jdbc.Driver");
		ds.setUsername("root");
		ds.setPassword("corso");
		ds.setUrl("jdbc:mariadb://localhost:3307/corso_spring");
		return ds; 
	} 
	
	@Bean(name="libro01")
	@Scope("singleton")
	public Libro getLibro () {
		Libro l = new Libro(); 
		l.setTitolo("Prova di creazione " + System.currentTimeMillis());
		return l; 
	} 
	
	/**
	 
	 1- � un conteniner
	 2- � uan factory di bean 
	 3- gesdtisce la connessione 
	 4- 
	 * */
	
	
	@Bean(name="entityManager")
    public LocalContainerEntityManagerFactoryBean  getEntityManager(){
    	 LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
    	 // JDBC
    	 factory.setDataSource(getDataSource());  
    	 
    	 // imposta il dialogo tra JPA e hibernate
    	 factory.setJpaVendorAdapter(getJpaVendorAdapter()); // imposta il dialogo tra JPA e hibernate
    	 
    	 // impostare il luogo dove si trovano i bean
    	 factory.setPackagesToScan(this.getClass().getPackage().getName()); 
    	 // oppure "com.corso.spring...." al posto di this.getClass().getPackage().getName()
    	 return factory; 
    } 	
	
	private HibernateJpaVendorAdapter getJpaVendorAdapter() {
		HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
		adapter.setDatabase(Database.MYSQL);   // obbligatorio: serve per tradurre le query nel particolare Dialetto
		
		adapter.setGenerateDdl(true);          //facoltativo, attiva il DDL cio� hibernate creaer� le strutture nel DB se non sono gi� essitenti
		adapter.setShowSql(true);              // mostra l'SQL, comodo per i corsi e per il debug ma in produzione solitamente � a false 
		return adapter;
	}	
	
	/*** transazioni ***/
	

	
	@Bean
	public PlatformTransactionManager getTransactionManager(){
	      JpaTransactionManager transactionManager = new JpaTransactionManager();
	      transactionManager.setEntityManagerFactory(getEntityManager().getObject());
	      return transactionManager;
	}
	
	/**** sezione DAO ****/
	
	@Bean(name="categoriaDao") 
	public CategoriaDao getCategoriaDao (){
		CategoriaDao dao = new CategoriaDaoImpl();
		return dao; 
	}
	
	
}