package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.personaggi.AbstractPersonaggio;

public class ComandoSaluta extends AbstractComando {
		@Override
		public String esegui(Partita partita) {
			AbstractPersonaggio personaggio = partita.getLabirinto().getStanzaCorrente().getPersonaggio();
			if(personaggio != null)
				return personaggio.saluta();
			else return "Non c'è nessuno da salutare qui.";
		}
		
		@Override
		public String getNome() {
			return "Comando saluta";
		}
}
