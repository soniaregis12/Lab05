package it.polito.tdp.anagrammi.model;

import java.util.ArrayList;
import java.util.List;

import it.polito.tdp.anagrammi.db.AnagrammiDAO;

public class Model {
	
	private List<Parola> soluzione;
	AnagrammiDAO dao = new AnagrammiDAO();
	
	
	public List<Parola> soluzione(String parola){
		
		this.soluzione = new ArrayList<Parola>();
		String parziale = "";
		int livello = 0;
		List<Character> daUsare = new ArrayList<Character>();
		
		parola.toUpperCase();
		
		for(int i=0; i<parola.length(); i++) {
			daUsare.add(parola.charAt(i));
		}
		
		ricorsiva(parziale, livello, daUsare);
		
		return this.soluzione;
	}
	
	public void ricorsiva(String parziale, int livello, List<Character> daUsare) {
		
		if(daUsare.size() == 0) {
			if(isCorrect(parziale)) {
				Parola p = new Parola(parziale, true);
				this.soluzione.add(p);
			}else {
				Parola p = new Parola(parziale, false);
				this.soluzione.add(p);
			}
		}
		
		for(Character ch : daUsare) {
			String tentativo = parziale + ch;
			List<Character> rimanenti = new ArrayList<Character>(daUsare);
			rimanenti.remove(ch);
			ricorsiva(tentativo, livello+1, rimanenti);
		}
	}
	
	public boolean isCorrect(String anagramma) {
		return dao.isCorrect(anagramma);
	}

	public List<Parola> getSoluzione() {
		return this.soluzione;
	}

	public void clearParole() {
		this.soluzione.clear();
	}

}
