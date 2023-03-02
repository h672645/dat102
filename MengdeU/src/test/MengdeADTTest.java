package test;
import no.hvl.dat102.mengde.kjedet.*;
import no.hvl.dat102.mengde.tabell.*;
import no.hvl.dat102.mengde.adt.*;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Iterator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public abstract class MengdeADTTest {
	
	MengdeADT<Integer> mengde1, mengde2, begge, fasit;
	private Integer e0 = 0;
	private Integer e1 = 1;
	private Integer e2 = 2;
	private Integer e3 = 3;
	private Integer e4 = 4;
	
	protected abstract MengdeADT<Integer> reset();
	
	@BeforeEach
	public void setup() {
		mengde1 = reset();
		mengde2 = reset();
		fasit = reset();
		begge = reset();
	}
	
	
	@Test
	void testUnion() {
		mengde2.leggTil(e3);
		
		mengde1.leggTil(e2);
		mengde1.leggTil(e1);
		mengde1.leggTil(e4);
		
		fasit.leggTil(e3);
		fasit.leggTil(e2);
		fasit.leggTil(e1);
		fasit.leggTil(e4);
		
		begge = mengde2.union(mengde1);
		
		assertTrue(begge.equals(fasit));
	}
	
	@Test
	void testUnionErUlik() {
		mengde2.leggTil(e3);
		mengde2.leggTil(e3);
		
		mengde1.leggTil(e2);
		mengde1.leggTil(e1);
		mengde1.leggTil(e4);
		
		fasit.leggTil(e3);
		fasit.leggTil(e2);
		
		begge = mengde2.union(mengde1);
		
		assertFalse(begge.equals(fasit));
	}

	@Test
	void testSnitt() {
		mengde2.leggTil(e2);
		mengde2.leggTil(e3);
		mengde2.leggTil(e4);
		
		mengde1.leggTil(e2);
		mengde1.leggTil(e1);
		mengde1.leggTil(e0);
		
		fasit.leggTil(e2);
		
		begge = mengde2.snitt(mengde1);
		
		assertTrue(begge.equals(fasit));
	}
	
	@Test
	void testIngenSnitt() {
		mengde2.leggTil(e2);
		mengde2.leggTil(e3);
		mengde2.leggTil(e4);
		
		mengde1.leggTil(e1);
		mengde1.leggTil(e1);
		mengde1.leggTil(e0);
		
		fasit.leggTil(e2);
		
		begge = mengde2.snitt(mengde1);
		
		assertFalse(begge.equals(fasit));
	}

	@Test
	void testDifferens() {
		mengde2.leggTil(e2);
		mengde2.leggTil(e3);
		mengde2.leggTil(e4);
		
		mengde1.leggTil(e2);
		mengde1.leggTil(e1);
		mengde1.leggTil(e0);
		
		fasit.leggTil(e3);
		fasit.leggTil(e4);
		
		begge = mengde2.differens(mengde1);
		
		assertTrue(begge.equals(fasit));
	}

	@Test
	void testUndermengde() {
		mengde2.leggTil(e2);
		mengde2.leggTil(e3);
		mengde2.leggTil(e4);
		mengde2.leggTil(e1);
		mengde2.leggTil(e0);
		
		mengde1.leggTil(e2);
		mengde1.leggTil(e1);
		mengde1.leggTil(e0);
		
		assertTrue(mengde2.undermengde(mengde1));
	}
	
	@Test
	void testIngenUndermengde() {
		mengde2.leggTil(e3);
		mengde2.leggTil(e4);
		mengde2.leggTil(e1);
		mengde2.leggTil(e0);
		
		mengde1.leggTil(e2);
		mengde1.leggTil(e1);
		mengde1.leggTil(e0);
		
		assertFalse(mengde2.undermengde(mengde1));
	}


}
