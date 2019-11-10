package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.personaggi.*;
import java.util.*;


public class Labirinto {

	private Stanza stanzaCorrente;
	private Stanza stanzaIniziale;
	private Stanza stanzaVincente;
	private Set<String> attrezziLabirinto;

	public Labirinto() {
		
		/**
		 * Crea tutte le stanze e le porte di collegamento
		 */

		/* crea gli attrezzi */
		Attrezzo lanterna = new Attrezzo("lanterna", 3);
		Attrezzo osso = new Attrezzo("osso", 1);
		Attrezzo bacchetta = new Attrezzo("bacchetta", 2);
		
		/* crea i personaggi */
		AbstractPersonaggio merlino = new Mago("Merlino", "Sono il mago più saggio e potente di tutti", bacchetta);
		AbstractPersonaggio rocky = new Cane("Rocky", "Sono il cane più aggressivo che c'è.");
		AbstractPersonaggio malefica = new Strega("Malefica", "Sono la strega più cattiva che c'è.");

		/* crea stanze del labirinto */
		Stanza atrio = new Stanza("Atrio");
		Stanza aulaN11 = new Stanza("Aula N11");
		Stanza aulaN10 = new Stanza("Aula N10");
		Stanza laboratorio = new Stanza("Laboratorio Campus");
		Stanza biblioteca = new Stanza("Biblioteca");

		/* collega le stanze */
		atrio.impostaStanzaAdiacente("nord", biblioteca);
		atrio.impostaStanzaAdiacente("est", aulaN11);
		atrio.impostaStanzaAdiacente("sud", aulaN10);
		atrio.impostaStanzaAdiacente("ovest", laboratorio);
		aulaN11.impostaStanzaAdiacente("est", laboratorio);
		aulaN11.impostaStanzaAdiacente("ovest", atrio);
		aulaN10.impostaStanzaAdiacente("nord", atrio);
		aulaN10.impostaStanzaAdiacente("est", aulaN11);
		aulaN10.impostaStanzaAdiacente("ovest", laboratorio);
		laboratorio.impostaStanzaAdiacente("est", atrio);
		laboratorio.impostaStanzaAdiacente("ovest", aulaN11);
		biblioteca.impostaStanzaAdiacente("sud", atrio);

		/* pone gli attrezzi nelle stanze */
		aulaN10.addAttrezzo(lanterna);
		atrio.addAttrezzo(osso);
		
		/* Posiziona i personaggi */
		atrio.setPersonaggio(merlino);
		aulaN10.setPersonaggio(rocky);
		aulaN11.setPersonaggio(malefica);
		

		// il gioco comincia nell'atrio
		stanzaIniziale = atrio;
		stanzaVincente = biblioteca;
		stanzaCorrente = stanzaIniziale;
	}
	
	public Set<String> getAttrezziLabirinto() {
		return attrezziLabirinto;
	}

	public Stanza getStanzaIniziale() {
		return stanzaIniziale;
	}

	public Stanza getStanzaVincente() {
		return stanzaVincente;
	}

	public void setStanzaCorrente(Stanza stanzaCorrente) {
		this.stanzaCorrente = stanzaCorrente;
	}

	public Stanza getStanzaCorrente() {
		return this.stanzaCorrente;
	}

}
