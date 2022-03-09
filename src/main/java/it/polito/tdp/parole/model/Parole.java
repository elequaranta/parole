package it.polito.tdp.parole.model;

import java.util.*;
import java.util.List;

public class Parole {
	
	LinkedList<String> elenco = new LinkedList<String>();
	ArrayList<String> elencoArray = new ArrayList<String>();
	
	public Parole() {
	}
	
	public void addParola(String p) {
	//	elencoArray.add(p);
	//	Collections.sort(elencoArray);
		elenco.add(p);
		Collections.sort(elenco);
	}
	
	public List<String> getElenco() {
	//	return elencoArray;
		return elenco;
	}
	
	public void reset() {
	//	elencoArray.clear();
		elenco.clear();
	}
	
	public List<String> cancella(String daCancellare){
	//	elencoArray.remove(daCancellare);
	//	return elencoArray;
		elenco.remove(daCancellare);
		return elenco;
	}

}
