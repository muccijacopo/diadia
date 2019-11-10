package it.uniroma3.diadia;

import static org.junit.Assert.*;
import org.junit.Test;

import it.uniroma3.diadia.giocatore.Giocatore;

import org.junit.Before;

public class GiocatoreTest {
	
	private Giocatore giocatore;

	@Before
	public void setUp() {
		this.giocatore = new Giocatore();
	}

	@Test
	public void TestGetCfuIniziali() {
		assertEquals(20, this.giocatore.getCfu());
	}

	@Test 
	public void TestSetCfu() {
		this.giocatore.setCfu(25);
		assertEquals(25, this.giocatore.getCfu());
	}

	@Test 
	public void TestSetCfuNegativi() {
		this.giocatore.setCfu(-3);
		assertEquals(-3, this.giocatore.getCfu());
	}

	@Test
	public void TestSetCfuZero() {
		this.giocatore.setCfu(0);
		assertEquals(0, this.giocatore.getCfu());
	}


}
