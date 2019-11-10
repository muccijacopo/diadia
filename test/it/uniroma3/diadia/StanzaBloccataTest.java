package it.uniroma3.diadia;

import it.uniroma3.diadia.ambienti.StanzaBloccata;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class StanzaBloccataTest {
	
	private StanzaBloccata stanzaBloccata;
	private Stanza stanzaNormale;
	private Attrezzo chiave;
	

	@Before
	public void setUp() {
		stanzaBloccata = new StanzaBloccata("DS1", "chiave", "nord");
		stanzaBloccata.impostaStanzaAdiacente("nord", stanzaNormale);
		chiave = new Attrezzo("chiave", 1);
	}
	
	@Test 
	public void testStanzaBloccata() {
		assertEquals(stanzaBloccata, stanzaBloccata.getStanzaAdiacente("nord"));
	}
	
	@Test
	public void testStanzaSbloccata() {
		stanzaBloccata.addAttrezzo(chiave);
		assertEquals(stanzaNormale, stanzaBloccata.getStanzaAdiacente("nord"));
	}

}
