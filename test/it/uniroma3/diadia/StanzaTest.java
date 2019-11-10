package it.uniroma3.diadia;

import static org.junit.Assert.*;
import org.junit.Test;

import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

import org.junit.Before;

public class StanzaTest {
	
	private Stanza N1;
	private Stanza N2;
	private Stanza N3;
	private Attrezzo osso;
	
	@Before
	public void setUp() {
	this.N1 = new Stanza("N1");
	this.N2 = new Stanza("N2");
	this.N3 = new Stanza("N3");
	this.osso = new Attrezzo("osso", 1);
	
	}
	
	@Test 
	public void testStanzaSenzaAdiacenze() {
		assertNull(this.N1.getStanzaAdiacente("nord"));
		assertNull(this.N1.getStanzaAdiacente("sud"));
		assertNull(this.N1.getStanzaAdiacente("est"));
		assertNull(this.N1.getStanzaAdiacente("ovest"));
	}
	
	@Test
	public void testStanzaConAdiacenze() {
		N1.impostaStanzaAdiacente("nord",  N2);
		assertEquals(N2, N1.getStanzaAdiacente("nord"));
	}
	
	@Test 
	public void testImpostaStanzeAdiacentiNellaStessaDirezione() {
		this.N1.impostaStanzaAdiacente("nord", N2);
		this.N1.impostaStanzaAdiacente("nord", N3);
		assertEquals(1, this.N1.getDirezioni().size());
		
	}
	
	@Test
	public void testStanzaConPiùAdiacenze() {
		N1.impostaStanzaAdiacente("nord", N2);
		N1.impostaStanzaAdiacente("sud", N3);
		assertEquals(N2, N1.getStanzaAdiacente("nord"));
		assertEquals(N3, N1.getStanzaAdiacente("sud"));
	}
	
	@Test
	public void testStanzaConAdiacenzaNonTrovata() {
		N1.impostaStanzaAdiacente("nord", N2);
		assertNull(N1.getStanzaAdiacente("sud"));
	}
	
	@Test
	public void testAggiornaStanzaAdiacente() {
		N1.impostaStanzaAdiacente("nord", N2);
		N1.impostaStanzaAdiacente("nord", N3);
		assertEquals(N3, N1.getStanzaAdiacente("nord"));
	}
	
	@Test 
	public void testAddAttrezzo() {
		assertTrue(this.N1.addAttrezzo(osso));
	}
	
	@Test 
	public void testHasAttrezzo() {
		this.N1.addAttrezzo(osso);
		assertTrue(N1.hasAttrezzo("osso"));
	}
	
	@Test 
	public void TestHasNotAttrezzo() {
		assertFalse(N1.hasAttrezzo("lanterna"));
	}
	
	@Test 
	public void TestGetAttrezzoNonNullo() {
		N1.addAttrezzo(osso);
		assertEquals(osso, this.N1.getAttrezzo("osso"));
		
	}
	
	@Test 
	public void TestGetAttrezzoNullo() {
		assertNull(this.N1.getAttrezzo("osso"));
	}
	
	@Test 
	public void TestRemoveAttrezzo() {
		N1.addAttrezzo(osso);
		N1.removeAttrezzo("osso");
		assertFalse(N1.hasAttrezzo("osso"));
	}

}
