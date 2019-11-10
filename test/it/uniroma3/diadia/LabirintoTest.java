package it.uniroma3.diadia;

import static org.junit.Assert.*;
import org.junit.Test;

import it.uniroma3.diadia.ambienti.Labirinto;

import org.junit.Before;

public class LabirintoTest {

	private Labirinto labirinto;
	
	@Before 
	public void setUp() {
		this.labirinto = new Labirinto();
	}
	
	@Test
	public void testGetStanzaIniziale() {
		assertEquals("Atrio", labirinto.getStanzaIniziale().getNome());
	}
	
	@Test
	public void testGetStanzaVincente() {
		assertEquals("Biblioteca", labirinto.getStanzaVincente().getNome());
	}

}
