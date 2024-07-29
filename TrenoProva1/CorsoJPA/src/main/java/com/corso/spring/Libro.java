package com.corso.spring;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Libro {
	
	private String titolo;

	@Override
	public String toString() {
		return "Libro [titolo=" + titolo + "]";
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}
	
	public Libro() {
		System.out.println("Libro Creato");
	}
	
}
