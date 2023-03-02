package no.hvl.dat102.mengde.klient;

public class Hobby {

	private String hobbyNavn;
	
	public Hobby(String hobby) {
		hobbyNavn = hobby;
	}
	
	public String getHobbyNavn() {
		return hobbyNavn;
	}
	
	@Override
	public String toString() {
		
		String txt = hobbyNavn;
		return txt;
	}
	
	@Override
	public boolean equals (Object hobby2) {
		Hobby hobbyDenAndre = (Hobby)hobby2;
		return(hobbyNavn.equals(hobbyDenAndre.getHobbyNavn()));
	}

}
