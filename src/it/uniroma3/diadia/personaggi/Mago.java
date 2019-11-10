package it.uniroma3.diadia.personaggi;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.*;

public class Mago extends AbstractPersonaggio {
	
	private static final String MESSAGGIO_DONO = "Sei un vero simpaticone, con una mia magica azione, troverai un nuovo oggetto per il tuo borsone! ";
	private static final String MESSAGGIO_SCUSE = "Mi spiace, ma non ho più nulla..";
	private Attrezzo attrezzo;
	
	public Mago(String nome, String presentazione, Attrezzo attrezzo) {
		super(nome, presentazione);
		this.attrezzo = attrezzo;
	}
	
	@Override 
	public String agisci(Partita partita) {
		String messaggio;
		if(this.attrezzo!=null) {
			partita.getLabirinto().getStanzaCorrente().addAttrezzo(attrezzo);
			this.attrezzo = null;
			messaggio = MESSAGGIO_DONO;
		}
		else messaggio = MESSAGGIO_SCUSE;
		
		return messaggio;
	}
}
