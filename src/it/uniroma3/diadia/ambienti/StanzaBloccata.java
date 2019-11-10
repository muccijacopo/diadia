package it.uniroma3.diadia.ambienti;

public class StanzaBloccata extends Stanza {
	private String nomeDirezioneBloccata;
	private String nomeAttrezzoSbloccante;

	public StanzaBloccata(String nome, String nomeAttrezzo, String nomeDirezione) {
		super(nome);
		this.nomeAttrezzoSbloccante = nomeAttrezzo;
		this.nomeDirezioneBloccata = nomeDirezione;
	}

	@Override
	public Stanza getStanzaAdiacente(String direzione) {
		if(this.nomeDirezioneBloccata.equals(direzione)) {
			if(this.hasAttrezzo(nomeAttrezzoSbloccante)) {
				return super.getStanzaAdiacente(direzione);
			}
			else {
				System.out.println("Impossibile procedere in questa direzione");
				return this;
			}
		}
		
		else {
			return super.getStanzaAdiacente(direzione);
		}
	}
	
	
}
