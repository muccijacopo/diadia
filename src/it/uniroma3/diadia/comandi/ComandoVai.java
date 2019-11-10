package it.uniroma3.diadia.comandi;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;

/**
 * Cerca di andare in una direzione. Se c'e' una stanza ci entra e ne stampa il
 * nome, altrimenti stampa un messaggio di errore
 */
public class ComandoVai extends AbstractComando {
	private String direzione = this.getParametro();

	@Override 
	public String esegui(Partita partita) {
	
		if (this.direzione == null)
			return "Dove vuoi andare ?";
		else {
			Stanza prossimaStanza = null;
			prossimaStanza = partita.getLabirinto().getStanzaCorrente().getStanzaAdiacente(this.direzione);
			if (prossimaStanza == null) {
				return "Direzione inesistente";
			}
			else {
				partita.getLabirinto().setStanzaCorrente(prossimaStanza);
				partita.getGiocatore().setCfu(partita.getGiocatore().getCfu()-1);
			}
			return partita.getLabirinto().getStanzaCorrente().getDescrizione();
		}
	}
	
	public void setParametro(String direzione) {
		this.direzione = direzione;
	}
	
	public String getParametro() {
		return this.direzione;
	}
	
	@Override
	public String getNome() {
		return "Vai";
	}
}
