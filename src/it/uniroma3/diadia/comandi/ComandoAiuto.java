package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

/**
 * Stampa informazioni di aiuto.
 */
public class ComandoAiuto extends AbstractComando {
	static final private String[] elencoComandi = { "vai", "prendi", "posa", "guarda", "aiuto", "fine" };
	
	@Override
	public String esegui(Partita partita) {
		StringBuilder risposta = new StringBuilder("ELENCO COMANDI: \n");
		for (int i = 0; i < elencoComandi.length; i++)
			risposta.append(elencoComandi[i] + " ");
		
		return risposta.toString();
	}
	
	@Override
	public String getNome() {
		return "Aiuto";
	}
	
}
