package no.hvl.dat102.mengde.kjedet;
import no.hvl.dat102.mengde.klient.Hobby;

import java.util.Iterator;

import no.hvl.dat102.mengde.adt.MengdeADT;
import no.hvl.dat102.mengde.tabell.*;

public class Medlem {

	private String navn;
	private KjedetMengde<Hobby> hobbyer;
	private int statusindeks;
	
	public Medlem(String navn) {
		this.navn = navn;
		hobbyer = new KjedetMengde<Hobby>();
		statusindeks = -1;
	}
	
	public String getNavn() {
		return navn;
	}
	
	public void setNavn(String navn) {

		this.navn = navn;
	}
	
	public KjedetMengde<Hobby> getHobbyer(){
		return hobbyer;
	}
	
	public void setHobbyer(KjedetMengde<Hobby> hobbyer) {
		this.hobbyer = hobbyer;
	}
	
	public int getKoblet() {
		return statusindeks;
	}
	
	public void setKoblet(int parNr) {
		statusindeks = parNr;
	}
	
	public void removeKoblet() {
		statusindeks = -1;
	}
	
	public void leggTilHobby(Hobby hobby) {
		hobbyer.leggTil(hobby);
	}
	
	public boolean passerTil(Medlem medlem2) {
		MengdeADT<Hobby> aktuell = hobbyer;
		boolean sjekk = false;
		
		if(aktuell.snitt(medlem2.getHobbyer()).equals(hobbyer)) {
			sjekk = true;
		}
		
		return sjekk;
	}
	
	@Override
	public String toString() {
		String txt = "Medlem: " + navn + "\n" + hobbyer.toString() + " ParNr: " + statusindeks + "\n";
		
		return txt;
	}
	
}
