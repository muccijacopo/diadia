package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

public class ComandoGuarda extends AbstractComando {
	@Override
	public String esegui(Partita partita) {
		StringBuilder risposta = new StringBuilder();
		risposta.append(partita.getLabirinto().getStanzaCorrente().getDescrizione());
		risposta.append("Hai ancora " + partita.getGiocatore().getCfu() + " CFU \n");
		risposta.append(partita.getGiocatore().getBorsa().toString());
		
		return risposta.toString();
	}
	
	@Override
	public String getNome() {
		return "Guarda";
	}
	
}
