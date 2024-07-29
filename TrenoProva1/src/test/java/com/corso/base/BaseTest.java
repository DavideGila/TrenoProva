package com.corso.base;

import com.corso.dao.TrenoDao;
import com.corso.dao.UtenteDao;
import com.corso.model.Fabbrica;
import com.corso.model.Treno;
import com.corso.model.Utente;

public class BaseTest {

protected static void stampa(String nomeMetodoTest) {
		   System.out.println("-----------------------------------------------------------");
		   System.out.println("invocazione del metodo: " + nomeMetodoTest + "()");
		   System.out.println("-----------------------------------------------------------");
	   }
   
		protected static Utente getUtente() {
			   Utente utente = new Utente();
			   utente.setNome("Paolo");
			   utente.setCognome("Verdi");
			   utente.setEmail("paolo@");
			   utente.setUsername("paolo_verdi");
			   utente.setPassword("abcd");
			   return utente;
		   }	
		   
		protected static Treno getTreno(TrenoDao dao) {
			   Treno treno = new Treno();
			   treno.setId_utente(dao.find(1));
			   treno.setFabbrica(dao.find("IT"));
			   treno.setBiglietti(94);
	
			   return treno;
	   }		
		
		protected static Fabbrica getFabbrica() {
			Fabbrica fabbrica = new Fabbrica();
			fabbrica.setSigla("TN");
			fabbrica.setFabbrica("Trenord");
			
			return fabbrica;
		}
		
		protected static void getSetTreni(Utente utente) {
			System.out.println(utente.getTreni());
		   }	
}


