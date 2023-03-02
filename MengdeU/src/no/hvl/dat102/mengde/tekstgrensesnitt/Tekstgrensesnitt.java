package no.hvl.dat102.mengde.tekstgrensesnitt;
import java.util.Scanner;
import no.hvl.dat102.mengde.kjedet.*;
import no.hvl.dat102.mengde.klient.*;

public class Tekstgrensesnitt {

	public static Medlem lesMedlem() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Navn: ");
		Medlem medlem = new Medlem(sc.nextLine());
		System.out.print("Hobby 1: ");
		Hobby hobby1 = new Hobby(sc.nextLine());
		System.out.print("Hobby 2: ");
		Hobby hobby2 = new Hobby(sc.nextLine());
		System.out.print("Hobby 3: ");
		Hobby hobby3 = new Hobby(sc.nextLine());
		
		medlem.leggTilHobby(hobby1);
		medlem.leggTilHobby(hobby2);
		medlem.leggTilHobby(hobby3);
		
		
		return medlem;
	}
	
	public static void skrivHobbyListe(Medlem medlem) {
		
		System.out.println(medlem.toString());
		
	}
	
	public static void skrivParListe(Datakontrakt arkiv) {
		
		String parliste = arkiv.parliste();
		System.out.println(parliste);
		
	}
	
	public static void main (String[] args) {
		
		Medlem olav = lesMedlem();
		Medlem jobjorn = lesMedlem();
		Medlem martin = lesMedlem();
		Medlem moussa = lesMedlem();
		
		Datakontrakt arkiv = new Datakontrakt(4);
		arkiv.leggTil(olav);
		arkiv.leggTil(jobjorn);
		arkiv.leggTil(martin);
		arkiv.leggTil(moussa);
		
		
		arkiv.finnPartnerFor("olav");
		System.out.println("Jobjorn sin ideks: " + arkiv.finnMedlemsIndeks("jobjorn"));
		arkiv.finnPartnerFor("martin");
		
		System.out.println(olav.getKoblet());
		System.out.println(jobjorn.getKoblet());
		System.out.println(martin.getKoblet());
		
		
		skrivHobbyListe(olav);
		skrivParListe(arkiv);
		boolean sjekk = arkiv.tilbakestillStatusIndeks("olav");
		System.out.println(sjekk + "\n" + olav.getKoblet());
		System.out.println(sjekk + "\n" + jobjorn.getKoblet());
	}
	
}
