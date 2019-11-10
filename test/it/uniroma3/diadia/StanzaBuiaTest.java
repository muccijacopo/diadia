package it.uniroma3.diadia;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.ambienti.StanzaBuia;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;


public class StanzaBuiaTest {
	
	private StanzaBuia ripostiglio;
	private Attrezzo lanterna;


	@Before
	public void setUp() {
		this.ripostiglio = new StanzaBuia("ripostiglio", "lanterna");
	}
	
	@Test
	public void testStanzaBuiaSenzaAttrezzoLuminoso() {
		assertSame("Qui c'è un buio pesto", this.ripostiglio.getDescrizione());
	}
	
	@Test
	public void testStanzaBuiaConAttrezzoLuminoso() {
		lanterna = new Attrezzo("lanterna",1);
		this.ripostiglio.addAttrezzo(lanterna);
		assertNotSame("Qui c'è un buio pesto", this.ripostiglio.getDescrizione());
	}

}
