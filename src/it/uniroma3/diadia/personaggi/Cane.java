package it.uniroma3.diadia.personaggi;

import it.uniroma3.diadia.Partita;

public class Cane extends AbstractPersonaggio{
	private static final String MORSO = "BAU! BAU! \n Hai perso dei CFU.";
	public Cane(String nome, String presentazione) {
		super(nome, presentazione);
	}
	@Override
	public String agisci(Partita partita) {
		partita.getGiocatore().setCfu(partita.getGiocatore().getCfu()-1);
		return MORSO;
		
	}
	
}
