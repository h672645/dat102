package no.hvl.data102.klient;

import no.hvl.data102.adt.FilmarkivADT;
import no.hvl.data102.Film;
import no.hvl.data102.Sjanger;
import static javax.swing.JOptionPane.*;

public class Tekstgrensesnitt {
	// lese opplysningene om en FILM fra tastatur
	public Film lesFilm() {
		int filmnr = java.lang.Integer.parseInt(showInputDialog("Skriv inn Filmnummer(TALL)"));

		String filmskaper = showInputDialog("Skriv inn Filmskaper");

		String tittel = showInputDialog("Skriv inn Tittel");

		int lansering = java.lang.Integer.parseInt(showInputDialog("Skriv inn Lansering(ÅR)"));

		Sjanger sjanger = Sjanger.finnSjanger(showInputDialog("Skriv inn Sjanger"));

		String filmselskap = showInputDialog("Skriv inn Filmselskap");

		Film lestfilm = new Film(filmnr, filmskaper, tittel, lansering, sjanger, filmselskap);
		return lestfilm;
	}

	// vise en film med alle opplysninger på skjerm (husk tekst for sjanger)
	public void visFilm(Film film) {
		showMessageDialog(null, film.toString());
	}

	// Skrive ut alle Filmer med en spesiell delstreng i tittelen
	public void skrivUtFilmDelstrengITittel(FilmarkivADT filma, String delstreng) {
		Film[] filmer = filma.soekTittel(delstreng);
		for (Film utfilm : filmer) {
			utfilm.toString();
		}
	}

	// Skriver ut alle Filmer av en produsent / en gruppe
	public void skrivUtFilmProdusent(FilmarkivADT filma, String delstreng) {
		String utTxt = "Filmer fra denne produsenten:\n\n";
		
		for(int i = 1; i <= filma.antall(); i++) {
			
			Film test = filma.finnFilm(i);
			String filmselskap = test.getFilmselskap();
			
			if(filmselskap.substring(0, delstreng.length()).equals(delstreng)) {
				utTxt += test.toString() + "\n\n";
			}
		}
		
		if(utTxt.equals("Filmer fra denne produsenten:")) {
			System.out.println("Ingen filmer funnet");
		}
		
		System.out.println(utTxt);
	}

	// Skrive ut en enkel statistikk som inneholder antall Filmer totalt
	// og hvor mange det er i hver sjanger
	public void skrivUtStatistikk(FilmarkivADT filma) {
		int antall = filma.antall();
		String utTxt = "Antall filmer: " + antall + "\n";
		
		for(Sjanger sj : Sjanger.values()) {
			utTxt += "Antall filmer i sjanger: " + sj + " " + 
		+ filma.antall(sj) + "\n";
		}
		
		
		showMessageDialog(null, utTxt);
	}

}
