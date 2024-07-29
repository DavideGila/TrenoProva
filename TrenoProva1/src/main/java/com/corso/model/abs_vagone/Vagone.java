package com.corso.model.abs_vagone;

public abstract class Vagone {

	protected int id_vagone;
	
	protected double prezzo;
	
	protected double lunghezza;
	
	protected double peso;

	public Vagone(double prezzo, double lunghezza, double peso) {
		this.prezzo = prezzo;
		this.lunghezza = lunghezza;
		this.peso = peso;
	}
	
}
