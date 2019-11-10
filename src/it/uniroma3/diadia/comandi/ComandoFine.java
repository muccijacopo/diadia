package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

/**
 * Comando "Fine".
 */
public class ComandoFine extends AbstractComando {
	public static final String MESSAGGIO_FINALE = "Grazie di aver giocato";
	
	public String esegui(Partita partita) {
		return MESSAGGIO_FINALE;
	}
	
	@Override
	public String getNome() {
		return "Fine";
	}
}
