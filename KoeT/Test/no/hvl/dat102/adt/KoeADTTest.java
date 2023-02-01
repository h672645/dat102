package no.hvl.dat102.adt;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import no.hvl.dat102.exceptions.EmptyCollectionException;
import no.hvl.dat102.adt.KoeADT;

/**
 * Test for KoeADT.
 * 
 * @author TBD
 */
public abstract class KoeADTTest {

	// Referanse til Koe
	private KoeADT<Integer> koe;

	// Testdata
	private Integer e0 = 1;
	private Integer e1 = 2;
	private Integer e2 = 3;
	private Integer e3 = 4;
	private Integer e4 = 5;

	protected abstract KoeADT<Integer> reset();

	/**
	 * Hent en ny koe for hver test.
	 * 
	 * @return
	 */
	@BeforeEach
	public void setup() {
		koe = reset();
	}

	/*
	 * Tester om koen er tom.
	 */
	@Test
	public void testErIkkeTom() {
		koe.innKoe(e0);
		koe.innKoe(e1);
		assertFalse(koe.erTom());
	}

	/*
	 * Tester om koen ikke er tom.
	 */
	@Test
	public void testErTom() {
		assertTrue(koe.erTom());
	}

	/*
	 * Tester om foerste plass i 
	 * koen er null-referanse.
	 */
	@Test
	public void testFoersteErNull() {
		String foersteException = "koe";

		try {
			koe.foerste();
		} catch (EmptyCollectionException e) {
			if (foersteException.equals(e.getMessage())) {
				assertTrue(true);
			}
		}
	}

	/*
	 * Tester at foerste plass i koen har 
	 * en referanse.
	 */
	@Test
	public void testFoerste() {
		koe.innKoe(e0);
		assertTrue(koe.foerste() != null);
	}

	/*
	 * Teste at noe blir lagt til i koen.
	 */
	@Test
	public void testInnKoe() {

		koe.innKoe(e0);
		assertTrue(!koe.erTom());
	}

	/*
	 * Tester at noe blir tatt ut foerst i koen.
	 */
	@Test
	public void testUtKoe() {
		koe.innKoe(e0);
		koe.innKoe(e1);
		koe.innKoe(e2);

		Integer element = koe.utKoe();
		assertTrue(element == e0);
		element = koe.utKoe();
		assertTrue(element == e1);
		element = koe.utKoe();
		assertTrue(element == e2);
	}

	/*
	 * Tester om koen returnerer en 
	 * EmptyCollectionException "e" 
	 * dersom den er tom.
	 */
	@Test
	public void testUtKoeErTom() {
		String utKoeException = "koe";

		try {
			koe.utKoe();
		} catch (EmptyCollectionException e) {
			if(koe.erTom() && utKoeException.equals(e.getMessage())) {
				assertTrue(true);
			}
		}
	}
	
	/*
	 * Tester at toString metoden skriver ut i
	 * samme format.
	 */
	@Test
	public void testToString() {
		String test = e0 + "\n" + e1 + "\n" + e2 + "\n"
				+ e3 + "\n" + e4 + "\n";
		koe.innKoe(e0);
		koe.innKoe(e1);
		koe.innKoe(e2);
		koe.innKoe(e3);
		koe.innKoe(e4);
		String string = koe.toString();
		
		assertTrue(test.equals(string));
	}
	
	/*
	 * Teste om tostring metoden skriver ut den
	 * tomme "" verdien dersom koen er tom.
	 */
	@Test
	public void testToStringErTom() {
		String string = koe.toString();
		assertTrue(koe.erTom() && "".equals(string));
	}
}
