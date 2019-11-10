package it.uniroma3.diadia.personaggi;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.*;
import java.util.*;

public class Strega extends AbstractPersonaggio{
	public Strega(String nome, String descrizione) {
		super(nome, descrizione);
	}
	
	@Override
	public String agisci(Partita partita) {
		List<Stanza> stanzeOrdinate = partita.getLabirinto().getStanzaCorrente().getStanzeOrdinatePerAttrezzi();
		if (haSalutato()) {
			Stanza stanzaMaggiore = stanzeOrdinate.get(stanzeOrdinate.size()-1);
			partita.getLabirinto().setStanzaCorrente(stanzaMaggiore);
		}
		else {
			Stanza stanzaMinore = stanzeOrdinate.get(0);
			partita.getLabirinto().setStanzaCorrente(stanzaMinore);
		}
		
		StringBuilder risposta = new StringBuilder("Ti ho rispostato in...");
		risposta.append(partita.getLabirinto().getStanzaCorrente().getNome());
		return risposta.toString();
	}
	
}
