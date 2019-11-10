package it.uniroma3.diadia;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.comandi.*;

public class ComandoVaiTest {
	private Partita partita;
	private AbstractComando comando = null;

	@Before
	public void setUp() {
		partita = new Partita();
		comando = new ComandoVai(); 
	}
	
	
	@Test
	public void TestEseguiComandoVaiNord() {
		comando.setParametro("nord");
		comando.esegui(this.partita);
		assertTrue(this.partita.isFinita());
	}
	
	@Test 
	public void TestEseguiComandoVaiNullo() {
		comando.setParametro("");
		assertEquals("Atrio", this.partita.getLabirinto().getStanzaCorrente().getNome());
		
	}
	
	

}
