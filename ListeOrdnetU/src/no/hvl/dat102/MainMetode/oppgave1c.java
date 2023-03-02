package no.hvl.dat102.MainMetode;
import java.util.Scanner;

import no.hvl.dat102.kjedet.KjedetOrdnetListe;
import no.hvl.dat102.listeklient.*;
import no.hvl.dat102.tabell.*;

public class oppgave1c {

	public static Person lesPerson() {
		
		Scanner sc = new Scanner(System.in);
		Person newGuy = new Person();
		System.out.print("Fødselsår: ");
		newGuy.setFoedselsaar(sc.nextInt());
		System.out.print("Etternavn: ");
		newGuy.setEtternavn(sc.nextLine());
		System.out.print("Fornavn: ");
		newGuy.setFornavn(sc.nextLine());
		
		return newGuy;
	}
	
	public static KjedetOrdnetListe<Person> lagKjedet(Person person1, Person person2, Person person3, Person person4){
		
		KjedetOrdnetListe<Person> liste = new KjedetOrdnetListe<Person>();
		
		liste.leggTil(person1);
		liste.leggTil(person2);
		liste.leggTil(person3);
		liste.leggTil(person4);
		
		return liste;
	}
	
	public static TabellOrdnetListe<Person> lagTabell(Person person1, Person person2, Person person3, Person person4){
		
		TabellOrdnetListe<Person> tabell = new TabellOrdnetListe();
		
		tabell.leggTil(person1);
		tabell.leggTil(person2);
		tabell.leggTil(person3);
		tabell.leggTil(person4);
		
		return tabell;
	}
	
	public static void main(String[] args) {
		
		Person olav = new Person("Olav", "Devik", 1995);
		Person jobjorn = new Person("Jobjorn", "Myren", 2001);
		Person martin = new Person("Martin", "TBD", 2001);
		Person moussa = new Person("Moussa", "TBD", 1995);
		
		TabellOrdnetListe<Person> tabell = lagTabell(olav, jobjorn, martin, moussa);
		System.out.println(tabell.toString());
	}
	
}
