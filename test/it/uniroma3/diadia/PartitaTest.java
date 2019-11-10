package it.uniroma3.diadia;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;

public class PartitaTest {
	
	private Partita partita;

	@Before
	public void setUp() {
		this.partita = new Partita();
	}

	@Test 
	public void testIsFinita() {
		assertFalse(this.partita.isFinita());
	}
	
}
