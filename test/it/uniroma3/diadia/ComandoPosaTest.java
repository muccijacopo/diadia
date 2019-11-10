package it.uniroma3.diadia;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.comandi.*;


import org.junit.Before;
import static org.junit.Assert.*;

import org.junit.Test;

public class ComandoPosaTest {
	
	private Partita partita;
	private AbstractComando comando;
	private Attrezzo lanterna;

	@Before
	public void setUp() {
		partita = new Partita();
		comando = new ComandoPosa();
		lanterna = new Attrezzo("lanterna", 1);
		
	}
	
	@Test 
	public void testPosaAttrezzo() {
		this.partita.getGiocatore().mettiInBorsa(lanterna);
		comando.setParametro("lanterna");
		comando.esegui(partita);
		assertTrue(this.partita.getLabirinto().getStanzaCorrente().hasAttrezzo("lanterna"));
	}
	
	

}
