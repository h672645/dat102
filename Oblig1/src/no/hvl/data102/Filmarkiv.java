package no.hvl.data102;

import no.hvl.data102.adt.*;

public class Filmarkiv implements FilmarkivADT {

	Film[] arkiv;
	int nesteledig;

	public Filmarkiv() {
	}

	public Filmarkiv(int n) {
		arkiv = new Film[n];
		nesteledig = 0;
	}

	public Film finnFilm(int nr) {
		for (int i = 0; i < arkiv.length; i++) {
			if (arkiv[i].getFilmnr() == nr) {
				return arkiv[i];
			}
		}
		return null;
	}

	public void leggTilFilm(Film nyFilm) {
		
		if(nesteledig == arkiv.length) {
			utvid();
		}
		
		arkiv[nesteledig] = nyFilm;
		nesteledig++;
	}

	public boolean slettFilm(int filmnr) {
		boolean sjekk = true;
		for (int i = 0; i < arkiv.length; i++) {
			if (arkiv[i].getFilmnr() == filmnr && arkiv[nesteledig - 1] != null) {
				arkiv[i] = arkiv[nesteledig - 1];
				return sjekk;
			}
		}
		return false;
	}

	public Film[] soekTittel(String delstreng) {
		
		Film[] filmer = new Film[arkiv.length];
		int antalltreff = 0;
		for (int i = 0; i < arkiv.length; i++) {
			if(arkiv[i].getTittel().substring(0, delstreng.length()-1).equals(delstreng)) {
				filmer[i]=arkiv[i];
				antalltreff++;
			}
		}
		
		Film[] tittelsok;
		tittelsok = new Film[antalltreff];
		int tittelsokplass = 0;
		for(int i = 0; i < filmer.length; i++) {
			if(filmer[i]!=null) {
				tittelsok[tittelsokplass] = filmer[i];
				tittelsokplass++;
			}
		}
		return tittelsok;
	}

	public int antall(Sjanger sjanger) {
		int antallisjanger = 0;
		for(int i = 0; i < arkiv.length; i++) {
			if(arkiv[i].getSjanger()==sjanger) {
				antallisjanger++;
			}
		}
		
		return antallisjanger;
	}

	public int antall() {

		return nesteledig - 1;

	}
	
	public void utvid() {
		Film[] nyttarkiv = new Film[arkiv.length*2];
		for(int i = 0; i < arkiv.length; i++) {
			nyttarkiv[i] = arkiv[i];
		}
		arkiv = nyttarkiv;
	}

}
