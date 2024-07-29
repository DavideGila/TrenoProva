package com.corso.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.*;

@Entity
public class Treno {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id_treno;
	
	@ManyToOne
	@JoinColumn(name="id_utente")
	private Utente id_utente;
	
	@ManyToOne
	@JoinColumn(name="sigla")
	private Fabbrica fabbrica;

	@Column(name="n_biglietti")
	private int biglietti;
	
	public int getBiglietti() {
		return biglietti;
	}

	public void setBiglietti(int biglietti) {
		this.biglietti = biglietti;
	}

	public int getId_treno() {
		return id_treno;
	}

	public void setId_treno(int id_treno) {
		this.id_treno = id_treno;
	}
	
	
	public Utente getId_utente() {
		return id_utente;
	}
	
	public void setId_utente(Utente id_utente) {
		this.id_utente = id_utente;
	}
	
	public Fabbrica getFabbrica() {
		return fabbrica;
	}

	public void setFabbrica(Fabbrica fabbrica) {
		this.fabbrica = fabbrica;
	}

	@Override
	public String toString() {
		return "Treno [id_treno=" + id_treno + ", id_utente=" + id_utente + ", fabbrica=" + fabbrica + ", biglietti="
				+ biglietti + "]";
	}
	
}
