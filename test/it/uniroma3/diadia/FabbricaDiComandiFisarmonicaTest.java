package it.uniroma3.diadia;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.comandi.*;

public class FabbricaDiComandiFisarmonicaTest {
	
	private AbstractComando comando;
	private FabbricaDiComandi factory;

	@Before
	public void test() {
		factory = new FabbricaDiComandiFisarmonica();
	}
	
	@Test
	public void testComandoVai() {
		comando = factory.costruisciComando("vai nord");
		assertEquals("Vai", comando.getNome());
		assertEquals("nord", comando.getParametro());
	}
	
	@Test
	public void testComandoPrendi() {
		comando = factory.costruisciComando("prendi attrezzo");
		assertEquals("Prendi", comando.getNome());
		assertEquals("attrezzo", comando.getParametro());
	}
	
	@Test
	public void testComandoPosa() {
		comando = factory.costruisciComando("posa attrezzo");
		assertEquals("Posa", comando.getNome());
		assertEquals("attrezzo", comando.getParametro());
	}
	
	@Test
	public void testComandoGuarda() {
		comando = factory.costruisciComando("guarda");
		assertEquals("Guarda", comando.getNome());
		assertNull(comando.getParametro());
	}
	
	@Test
	public void testComandoNonValido() {
		comando = factory.costruisciComando("xyz");
		assertEquals("Non valido", comando.getNome());
		assertNull(comando.getParametro());
	}
	
	@Test
	public void testComandoAiuto() {
		comando = factory.costruisciComando("aiuto");
		assertEquals("Aiuto", comando.getNome());
		assertNull(comando.getParametro());
	}
	
	

}
