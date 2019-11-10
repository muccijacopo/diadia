package it.uniroma3.diadia;

import static org.junit.Assert.*;

import java.util.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;

public class BorsaTest {
	
	private int pesoMax = 100;
	private Borsa borsa;
	private Attrezzo lanterna;
	private Attrezzo osso;
	
	@Before
	public void setUp() {
		
		this.borsa = new Borsa(pesoMax);
		this.lanterna = new Attrezzo("lanterna", 2);
		this.osso = new Attrezzo("osso", pesoMax+1);
	}
	
	@Test
	public void testIsEmpty() {
		assertTrue(this.borsa.isEmpty());
	}
	
	@Test
	public void testGetPesoMax() {
		assertEquals(pesoMax, this.borsa.getPesoMax());
	}
	
	@Test
	public void testAddAttrezzoConSuccesso() {
		assertTrue(this.borsa.addAttrezzo(lanterna));
	}
	
	@Test 
	public void testAddAttrezzoTroppoPesante() {
		assertFalse(this.borsa.addAttrezzo(osso));
	}
	
	@Test 
	public void testGetAttrezzo() {
		this.borsa.addAttrezzo(lanterna);
		assertEquals(lanterna, this.borsa.getAttrezzo("lanterna"));
	}
	
	@Test
	public void testGetAtrezzoNonEsistente() {
		assertNull(this.borsa.getAttrezzo("lanterna"));
	}
	
	@Test
	public void testRemoveAttrezzoEsistente() {
		this.borsa.addAttrezzo(lanterna);
		assertEquals(lanterna, this.borsa.removeAttrezzo("lanterna"));
	}
	
	@Test
	public void testRemoveAttrezzoNonEsistente() {
		assertNull(this.borsa.removeAttrezzo("lanterna"));
	}
	
	@Test 
	public void testGetContenutoOrdinatoPerPeso() {
		Attrezzo piombo = new Attrezzo("piombo", 10);
		Attrezzo ps = new Attrezzo("ps", 5);
		Attrezzo piuma = new Attrezzo("piuma",1);
		Attrezzo libro = new Attrezzo("libro,", 5);
		
		this.borsa.addAttrezzo(piombo);
		this.borsa.addAttrezzo(ps);
		this.borsa.addAttrezzo(piuma);
		this.borsa.addAttrezzo(libro);
		
		List<Attrezzo> attrezziOrdinati = new ArrayList<>(this.borsa.getContenutoOrdinatoPerPeso());
		Iterator <Attrezzo> it = attrezziOrdinati.iterator();
		assertEquals(piuma, it.next());
		assertEquals(libro, it.next());
		assertEquals(ps, it.next());
		assertEquals(piombo, it.next());
	}
	
	@Test
	public void testGetContenutoOrdinatoPerNome() {
		Attrezzo piombo = new Attrezzo("piombo", 10);
		Attrezzo ps = new Attrezzo("ps", 5);
		Attrezzo piuma = new Attrezzo("piuma",1);
		Attrezzo libro = new Attrezzo("libro,", 5);
		
		this.borsa.addAttrezzo(piombo);
		this.borsa.addAttrezzo(ps);
		this.borsa.addAttrezzo(piuma);
		this.borsa.addAttrezzo(libro);
		
		Set<Attrezzo> attrezziOrdinati = this.borsa.getContenutoOrdinatoPerNome();
		Iterator<Attrezzo> it = attrezziOrdinati.iterator();
		assertEquals(libro, it.next());
		assertEquals(piombo, it.next());
		assertEquals(piuma, it.next());
		assertEquals(ps, it.next());	
	}
	
	@Test
	public void testGetContenutoRaggruppatoPerPeso() {
		Attrezzo piombo = new Attrezzo("piombo", 10);
		Attrezzo ps = new Attrezzo("ps", 5);
		Attrezzo piuma = new Attrezzo("piuma",1);
		Attrezzo libro = new Attrezzo("libro,", 5);
		
		this.borsa.addAttrezzo(piombo);
		this.borsa.addAttrezzo(ps);
		this.borsa.addAttrezzo(piuma);
		this.borsa.addAttrezzo(libro);
		
		Map<Integer, Set<Attrezzo>> attrezzi = this.borsa.getContenutoRaggruppatoPerPeso();
		assertTrue(attrezzi.get(1).contains(piuma));
		assertTrue(attrezzi.get(5).contains(libro));
		assertTrue(attrezzi.get(5).contains(ps));
		assertTrue(attrezzi.get(10).contains(piombo));
	} 
	

}
