package no.hvl.data102;

import no.hvl.data102.adt.*;

public class Filmarkiv2 implements FilmarkivADT {

	private LinearNode<Film> start;
	private int antall;

	public Filmarkiv2() {
		start = null;
		antall = 0;
	}

	public Film finnFilm(int nr) {
		if (start == null) {
			return null;
		}

		LinearNode<Film> temp = start;
		for (int i = 0; i < antall; i++) {
			if (start.getElement().getFilmnr() == nr) {
				return temp.getElement();
			} else {
				temp = temp.getNeste();
			}
		}

		return null;
	}

	public void leggTilFilm(Film nyFilm) {

		if (start == null) {
			start.setElement(nyFilm);
			antall++;
			return;
		}

		LinearNode<Film> temp = start;

		for (int i = 0; i < antall; i++) {
			if (temp.getNeste() == null) {
				temp.setElement(nyFilm);
			}
		}

	}

	public boolean slettFilm(int filmnr) {

		LinearNode<Film> temp = start;
		LinearNode<Film> forige = null;
		boolean sjekk = false;

		if(temp == null) {
			return false;
		}
		
		while (temp.getElement().getFilmnr() != filmnr) {
			forige = temp;
			temp = temp.getNeste();
		}

		if (forige == null) {
			temp = start.getNeste();
		} else {
			forige.setNeste(temp.getNeste());
			temp = null;
			sjekk = true;
		}

		return sjekk;
	}

	public Film[] soekTittel(String delstreng) {

		int antalltreff = 0;
		LinearNode<Film> temp = start;

		while (temp != null && temp.getElement().getTittel().substring(0, delstreng.length()).equals(delstreng)) {
			antalltreff++;
		}

		Film[] tittelsok;
		tittelsok = new Film[antalltreff];

		temp = start;
		while (temp != null && temp.getElement().getTittel().substring(0, delstreng.length()).equals(delstreng)) {
			antalltreff++;
		}

		return tittelsok;
	}

	public int antall(Sjanger sjanger) {

		LinearNode<Film> temp = start;
		int antallsjanger = 0;
		while (temp != null && temp.getNeste() != null) {
			if (temp.getElement().getSjanger().equals(sjanger)) {
				antallsjanger++;
			}
			temp = temp.getNeste();
		}

		return antallsjanger;
	}

	public int antall() {
		return antall;
	}
}
