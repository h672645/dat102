package no.hvl.data102;

import no.hvl.data102.adt.Film;
import no.hvl.data102.adt.Sjanger;

public class Filmarkiv implements FilmarkivADT {

	Film finnFilm(int nr);

	public void leggTilFilm(Film nyFilm);

	public boolean slettFilm(int filmnr);

	public Film[] soekTittel(String delstreng) {
		Film[] film = new Film();
		return film;
	}

	public int antall(Sjanger sjanger) {
		return 1;
	}

	public int antall() {
		return 1;
	}

}
