package it.uniroma3.diadia;

import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.comandi.*;

public class ComandoPrendiTest {
	
	private Partita partita;
	private AbstractComando comando;
	private Stanza N1;
	private Attrezzo osso;

	@Before
	public void setUp() {
		partita = new Partita();
		comando = new ComandoPrendi();
		N1 = new Stanza("N1");
		osso = new Attrezzo("osso", 1);
	}
	
	@Test
	public void testPrendiAttrezzoNonNullo() {
		N1.addAttrezzo(osso);
		partita.getLabirinto().setStanzaCorrente(N1);
		comando.setParametro("osso");
		comando.esegui(partita);
		assertTrue(this.partita.getGiocatore().getBorsa().hasAttrezzo("osso"));
	}
	
	@Test
	public void testPrendiAttrezzoNonEsistente() {
		comando.setParametro("lanterna");
		comando.esegui(partita);
		assertEquals(0, this.partita.getGiocatore().getBorsa().getPeso());
	}
	
	@Test
	public void testPrendiAttrezzoNullo() {
		comando.setParametro("");
		comando.esegui(partita);
		assertEquals(0, this.partita.getGiocatore().getBorsa().getPeso());
		
	}

}
