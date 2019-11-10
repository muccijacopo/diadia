package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

public class ComandoGuarda extends AbstractComando {
	@Override
	public String esegui(Partita partita) {
		StringBuilder risposta = new StringBuilder();
		 risposta.append(partita.getLabirinto().getStanzaCorrente().getDescrizione());
		risposta.append("CFU: " + partita.getGiocatore().getCfu());
		risposta.append(partita.getGiocatore().getBorsa().toString());
		
		return risposta.toString();
	}
	
	@Override
	public String getNome() {
		return "Guarda";
	}
	
}
