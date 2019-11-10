package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPrendi extends AbstractComando {
	private String nomeAttrezzo = this.getParametro();
	
	@Override
	public String esegui(Partita partita) {
		if (nomeAttrezzo == null)
			return "Quale attrezzo vuoi prendere?";
		else {
			Stanza stanzaCorrente = partita.getLabirinto().getStanzaCorrente();
			Attrezzo attrezzo = stanzaCorrente.getAttrezzo(nomeAttrezzo);

			if (attrezzo != null) {
				if (partita.getGiocatore().mettiInBorsa(attrezzo))
					stanzaCorrente.removeAttrezzo(nomeAttrezzo);
					return "Hai preso " + attrezzo.getNome();
			} else
				return "L'attrezzo non è presente in questa stanza!";
		}
	}
	
	public void setParametro(String nomeAttrezzo) {
		this.nomeAttrezzo = nomeAttrezzo;
	}
	
	public String getParametro() {
		return this.nomeAttrezzo;
	}
	
	@Override
	public String getNome() {
		return "Prendi";
	}
	
}
