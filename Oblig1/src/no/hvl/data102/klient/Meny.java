package no.hvl.data102.klient;
import no.hvl.data102.adt.*;
import no.hvl.data102.Film;

public class Meny {
	private Tekstgrensesnitt tekstgr;
	private FilmarkivADT filmarkiv;

	public Meny(FilmarkivADT filmarkiv) {
		tekstgr = new Tekstgrensesnitt();
		this.filmarkiv = filmarkiv;
	}

	public void start() {
		Film terminator = new Film();
		Film titanic = new Film();
		Film avatar = new Film();
	}

}