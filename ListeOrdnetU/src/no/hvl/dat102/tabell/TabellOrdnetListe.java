package no.hvl.dat102.tabell;

import no.hvl.dat102.adt.OrdnetListeADT;
import no.hvl.dat102.exceptions.EmptyCollectionException;
import no.hvl.dat102.listeklient.Person;

public class TabellOrdnetListe<T extends Comparable<T>> implements OrdnetListeADT<T> {

	private final static int STDK = 100;
	private final static int IKKE_FUNNET = -1;
	private int bak;
	private T[] liste;

	public TabellOrdnetListe() {
		this(STDK);
	}

	public TabellOrdnetListe(int startKapasitet) {
		bak = 0;
		liste = (T[]) (new Comparable[startKapasitet]);
	}

	@Override
	public T fjernSiste() {
		if (erTom()) 
			throw new EmptyCollectionException("ordnet liste");

		T resultat = null;
		
		resultat = liste[bak-1];
		liste[bak-1] = null;
		bak--;
		
		return resultat;
	}

	@Override
	public T fjernFoerste() {
		if (erTom())
			throw new EmptyCollectionException("ordnet liste");

		T resultat = null;
		
		resultat = liste[0];
		liste[0] = null;
		int forige;
		
		for(int i = 1; i < bak; i++) {
			forige = i-1;
			liste[forige]=liste[i];
		}
		
		bak--;
		
		return resultat;
	}

	@Override
	public T foerste() {
		if (erTom())
			throw new EmptyCollectionException("ordnet liste");

		T resultat = liste[0];
		return resultat;
	}

	@Override
	public T siste() {
		if (erTom())
			throw new EmptyCollectionException("ordnet liste");
		
		T resultat = liste[bak-1];
		return resultat;
	}

	@Override
	public boolean erTom() {
		return (bak == 0);
	}

	@Override
	public int antall() {
		return bak;
	}

	@Override
	public void leggTil(T element) {

		if(bak == liste.length) {
			utvid();
		}
		
		liste[bak] = element;
		bak++;
	}

	@Override
	public boolean inneholder(T element) {
		return (finn(element) != IKKE_FUNNET);
	}

	@Override
	public T fjern(T element) {
		
		int plass = finn(element);
		
		if(plass == -1) throw new EmptyCollectionException("ordnet liste");
		
		int forige;
		
		T kopi = liste[plass];
		liste[plass] = null;
		
		for(int i = plass+1; i < bak; i++) {
			forige = i-1;
			liste[forige]=liste[i];
		}
		
		bak--;
		liste[bak]=null;
		
		return kopi;

	}

	private int finn(T el) {
		int resultat = IKKE_FUNNET;
		
		for(int i = 0; i < bak+1; i++) {
			if(liste[i].equals(el)) {
				return i;
			}
		}
		
		return resultat;
	}

	public String toString() {
		
		String resultat = "TabellOrdnetListe: \n";
		
		if(erTom()) {
			System.out.println("ListenErTom");
		}
		
		T[] kopi = liste;
		T element;
		T swapTemp;
		int tellar = 0;
		
		while(kopi[0] != null) {
			
			swapTemp = null;
			element = fjern(kopi[0]);
			
			while(kopi[tellar] != null) {
				
				if(((Person)kopi[tellar]).compareTo((Person)element) < 0) {
					swapTemp = element;
					element = kopi[tellar];
					kopi[tellar] = swapTemp;
				} 
				
				tellar++;
			}
			
			tellar = 0;
			resultat += element.toString() + "\n";
		}
			
		
		
		
		return resultat;
	}

	private void utvid() {
		T[] hjelpeTabell = (T[]) (new Comparable[liste.length * 2]);

		for (int i = 0; i < liste.length; i++) {
			hjelpeTabell[i] = liste[i];
		}

		liste = hjelpeTabell;
	}
}// class
