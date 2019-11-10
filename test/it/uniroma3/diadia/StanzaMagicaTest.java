package it.uniroma3.diadia;
import it.uniroma3.diadia.ambienti.StanzaMagica;
import it.uniroma3.diadia.attrezzi.Attrezzo;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class StanzaMagicaTest {
	
	StanzaMagica laboratorio;
	Attrezzo osso;
	Attrezzo lanterna;
	
	@Before
	public void setUp() {
		laboratorio = new StanzaMagica("Bagno", 1);
		osso = new Attrezzo("Osso", 2);
		lanterna = new Attrezzo("Lanterna", 3);
	}
	
	@Test
	public void testAddAttrezzoSenzaMagia() {
		this.laboratorio.addAttrezzo(osso);
		assertTrue(this.laboratorio.hasAttrezzo("Osso"));
	}
		
	@Test
	public void testAddAttrezzoConMagia() {
		this.laboratorio.addAttrezzo(osso);
		this.laboratorio.addAttrezzo(lanterna);
		assertTrue(this.laboratorio.hasAttrezzo("anretnaL"));
		assertEquals(6, this.laboratorio.getAttrezzo("anretnaL").getPeso());
		
	}

}
