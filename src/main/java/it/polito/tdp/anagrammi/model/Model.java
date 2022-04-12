package it.polito.tdp.anagrammi.model;

import java.util.*;

import it.polito.tdp.anagrammi.DAO.AnagrammiDAO;

public class Model {
	
	List<String> paroleAmmesse = new ArrayList<String>();
	Set<String> anagrammiTrovati = new HashSet<String>();
	
	public Model() {
		AnagrammiDAO dao = new AnagrammiDAO(); 
		this.paroleAmmesse = dao.getParoleAmmesse();
	}
	
	public Set<String> trovaAnagrammi(String s){
		
		anagrammiTrovati.clear();
		cerca("" , 0 , s);
		
		return anagrammiTrovati;
	}
	
	private void cerca(String parziale , int L , String rimanenti) {
		
		if(rimanenti.length()==0) {
			anagrammiTrovati.add(parziale);
		}else {
			for(int pos=0;pos<rimanenti.length();pos++) {
				String nuova_parziale = parziale + rimanenti.charAt(pos);
				String nuova_rimanenti = rimanenti.substring(0, pos) + rimanenti.substring(pos+1);
				cerca(nuova_parziale, L+1 , nuova_rimanenti);
			}
		}
	}
	
	public boolean isCorrect(String s) {
		if(this.paroleAmmesse.contains(s)) return true;
		else return false;
		
	}

}
