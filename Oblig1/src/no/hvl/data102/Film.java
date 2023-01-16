package no.hvl.data102;

public class Film {

	private int filmnr;
	private String filmskaper;
	private String tittel;
	private int lansering;
	private Sjanger sjanger;
	private String filmselskap;
	
	public Film() {
	}
	
	public Film(int filmmnr, String filmskaper, String tittel, int lansering,
			Sjanger sjanger, String filmselskap) {
		
		this.filmnr = filmmnr;
		this.filmskaper = filmskaper;
		this.tittel = tittel;
		this.lansering = lansering;
		this.sjanger = sjanger;
		this.filmselskap = filmselskap;
		
	}
	
}
