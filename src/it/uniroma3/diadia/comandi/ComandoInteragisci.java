package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.personaggi.*;

public class ComandoInteragisci extends AbstractComando{
	private String messaggio;
	private static final String MESSAGGIO_CON_CHI = "Con chi dovrei interagire?";
	
	@Override 
	public String esegui(Partita partita) {
		AbstractPersonaggio personaggio;
		personaggio = partita.getLabirinto().getStanzaCorrente().getPersonaggio();
		if(personaggio != null) {
			this.messaggio = personaggio.agisci(partita);
			return this.messaggio;
		}
		else return MESSAGGIO_CON_CHI;
	}
	
	public String getMessaggio() {
		return this.messaggio;
	}
	
	@Override
	public String getNome() {
		return "Comando Interagisci";
	}
}
