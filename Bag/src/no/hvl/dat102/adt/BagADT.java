package no.hvl.dat102.adt;

import no.hvl.dat102.exceptions.EmptyCollectionException;

public interface BagADT<T> {

	public void leggTil(T el);

	public T fjern(T el);

	public boolean inneholder(T el);

	public void nullstill();

	public int antall();

	public boolean erTom();

	public T[] tilTabell();

} 
