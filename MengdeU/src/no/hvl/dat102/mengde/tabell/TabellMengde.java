package no.hvl.dat102.mengde.tabell;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Random;

import no.hvl.dat102.exception.EmptyCollectionException;
import no.hvl.dat102.mengde.adt.MengdeADT;

public class TabellMengde<T> implements MengdeADT<T> {
	// ADT-en Mengde implementert som tabell
	//
	private final static Random tilf = new Random();
	private final static int STDK = 100;
	private int antall;
	private T[] tab;

	public TabellMengde() {
		this(STDK);
	}

	public TabellMengde(int start) {
		antall = 0;
		tab = (T[]) (new Object[start]);
	}

	@Override
	public int antall() {
		return antall;
	}

	@Override
	public boolean erTom() {
		return (antall == 0);
	}
	
	public T elementITab(int plass){
		return tab[plass];
	}

	@Override
	public void leggTil(T element) {
		if (!inneholder(element)) {
			if (antall == tab.length) {
				utvidKapasitet();
			}
			tab[antall] = element;
			antall++;
		}
	}

	@Override
	public void leggTilAlle(MengdeADT<T> m2) {
		Iterator<T> teller = m2.iterator();
		while (teller.hasNext())
			leggTil(teller.next());
	}

	private void utvidKapasitet() {
		T[] hjelpetabell = (T[]) (new Object[2 * tab.length]);
		for (int i = 0; i < tab.length; i++) {
			hjelpetabell[i] = tab[i];
		}
		tab = hjelpetabell;
	}

	@Override
	public T fjernTilfeldig() {
		if (erTom())
			throw new EmptyCollectionException("mengde");

		T svar = null;
		int indeks = tilf.nextInt(antall);
		svar = tab[indeks];
		tab[indeks] = tab[antall - 1];
		tab[antall - 1] = null;
		antall--;

		return svar;
	}

	@Override
	public T fjern(T element) {

		// S�ker etter og fjerner element. Returnerer null-ref ved ikke-funn

		if (erTom())
			throw new EmptyCollectionException("mengde");

		boolean funnet = false;
		T svar = null;
		
		for (int i = 0; (i < antall && !funnet); i++) {
			if (tab[i].equals(element)) {
				svar = tab[i];
				tab[i] = tab[antall - 1];
				// tab[antall-1] = null;
				antall--;
				funnet = true;

			}
		}
		return svar;
	}

	@Override
	public boolean inneholder(T element) {
		boolean funnet = false;

		for (int i = 0; (i < antall) && (!funnet); i++) {
			if (tab[i].equals(element)) {
				funnet = true;
			}
		}

		return (funnet);
	}

	/*
	 * N�r vi overkj�rer (override) equals- meteoden er det anbefalt at vi ogs�
	 * overkj�rer hascode-metoden da en del biblioterker burker hascode sammen med
	 * equals. Vi kommer tilbake til forklaring og bruk av hascode senere i faget.
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + antall;
		result = prime * result + Arrays.deepHashCode(tab);
		return result;
	}

	@Override
	public boolean equals(Object m2) {

		boolean likeMengder = true;

		System.out.println(this.getClass() + " " + m2.getClass());
		
		if (tab == null) {
			return false;
		}

		if (this.getClass() != m2.getClass()) {
			System.out.println("false");
			return false;
		}
		
		if(this.antall != ((TabellMengde<T>)m2).antall()) {
			return false;
		}

		for (int i = 0; i < antall; i++) {
			if (!(((TabellMengde<T>)m2).inneholder(tab[i]))) {
				likeMengder = false;
			}

		}

		return likeMengder;
	}

	/*
	 * Denne versjonen av unionen er lite effektiv
	 * 
	 * @Override 
	 * public MengdeADT<T> union(MengdeADT<T> m2) { TabellMengde<T> begge
	 * = new TabellMengde<T>(); for (int i = 0; i < antall; i++) {
	 * begge.leggTil(tab[i]); } Iterator<T> teller = m2.oppramser();
	 * 
	 * while (teller.hasNext()) { begge.leggTil(teller.next()); } return
	 * (MengdeADT<T>)begge; }
	 */
	@Override

	public MengdeADT<T> union(MengdeADT<T> m2) {
		// TODO - Lage en mer effektiv kode
		MengdeADT<T> begge = new TabellMengde<T>();
		Iterator<T> mTo = m2.iterator();
		T element = null;

		for (int i = 0; i < antall; i++) {
			((TabellMengde<T>)begge).settInn(tab[i]);
			System.out.println("Setter inn: " + tab[i]);
		}

		while (mTo.hasNext()) {
			element = mTo.next();
			if (!((TabellMengde<T>)begge).inneholder(element)) {
				((TabellMengde<T>)begge).settInn(element);
				System.out.println("Setter inn: " + element);
			}
		}

		return begge;
	}//

	@Override
	public MengdeADT<T> snitt(MengdeADT<T> m2) {

		MengdeADT<T> snittM = new TabellMengde<T>();
		
		for (int i = 0; i < antall; i++) {

			if (((TabellMengde<T>)m2).inneholder(tab[i])) {
				((TabellMengde<T>)snittM).settInn(tab[i]);
			}
		}

		return snittM;
	}

	@Override
	public MengdeADT<T> differens(MengdeADT<T> m2) {
		
		MengdeADT<T> differensM = new TabellMengde<T>();

		for (int i = 0; i < antall; i++) {

			if (!((TabellMengde<T>)m2).inneholder(tab[i])) {
				((TabellMengde<T>) differensM).settInn(tab[i]);
			}
		}
		
		return differensM;
	}

	@Override
	public boolean undermengde(MengdeADT<T> m2) {
		
		MengdeADT<T> snittM = new TabellMengde<T>();
		boolean erUnderMengde = false;
		
		if(antall() <= m2.antall()) {
			return false;
		}
		
		snittM = snitt(m2);
		if(snittM.equals(m2) && antall() > m2.antall()) {
			erUnderMengde = true;
		}
		
		return erUnderMengde;
	}

	@Override
	public Iterator<T> iterator() {
		return new TabellIterator<T>(tab, antall);
	}

	private void settInn(T element) {
		if (antall == tab.length) {
			utvidKapasitet();
		}
		tab[antall] = element;
		antall++;
	}
	
	@Override
	public String toString() {
		
		T[] aktuell = tab;
		String txt = "{";
		
		for(int i = 0; i < antall; i++) {
			txt += aktuell[i].toString() + ",";
		}
		
		txt += "}";
		
		return txt;
	}

}// class
