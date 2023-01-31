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
 * Test for StabelADT.
 * 
 * @author Ole Olsen
 */
public abstract class KoeADTTest {

	// Referanse til stabel
	private KoeADT<Integer> koe;

	// Testdata
	private Integer e0 = 1;
	private Integer e1 = 2;
	private Integer e2 = 3;
	private Integer e3 = 4;
	private Integer e4 = 5;

	protected abstract KoeADT<Integer> reset();

	/**
	 * Hent en ny stabel for hver test.
	 * 
	 * @return
	 */
	@BeforeEach
	public void setup() {
		koe = reset();
	}

	@Test
	public void testErTom() {
		koe.innKoe(e0);
		koe.innKoe(e1);
		assertFalse(koe.erTom());
	}

	@Test
	public void testErIkkeTom() {
		assertTrue(koe.erTom());
	}

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

	@Test
	public void testFoerste() {
		koe.innKoe(e0);
		assertTrue(koe.foerste() != null);
	}

	@Test
	public void testInnKoe() {

		koe.innKoe(e0);
		assertTrue(!koe.erTom());
	}

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

	@Test
	public void testUtKoeErTom() {
		String utKoeException = "koe";

		try {
			koe.utKoe();
		} catch (EmptyCollectionException e) {
			if(utKoeException.equals(e.getMessage())) {
				assertTrue(true);
			}
		}
	}
	
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
	
	@Test
	public void testToStringErTom() {
		String string = koe.toString();
		assertTrue("".equals(string));
	}

//	@Test
//	public void foersteFromEmptyIsUnderflowed() {
//		/*
//		 * Assertions.assertThrows(EmptyCollectionException.class, new Executable() {
//		 * 
//		 * @Override public void execute() throws Throwable { stabel.pop(); } });
//		 */
//
//		Assertions.assertThrows(EmptyCollectionException.class, () -> {
//			koe.foerste();
//		});
//	}

}
