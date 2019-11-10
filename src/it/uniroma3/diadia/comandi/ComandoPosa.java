package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPosa extends AbstractComando {
	private String nomeAttrezzo = this.getParametro();
	
	@Override
	public String esegui(Partita partita) {
		if (nomeAttrezzo == null)
			return "Quale attrezzo vuoi posare? ";
		else {
			Stanza stanzaCorrente = partita.getLabirinto().getStanzaCorrente();
			Attrezzo attrezzo = partita.getGiocatore().prendiDallaBorsa(nomeAttrezzo);
			if (attrezzo != null) {
				stanzaCorrente.addAttrezzo(attrezzo);
				return "Hai posato" + attrezzo.getNome();
			}

			else return "L'attrezzo non è nella borsa";
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
		return "Posa";
	}
}


