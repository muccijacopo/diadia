package it.uniroma3.diadia.ambienti;

public class StanzaBuia extends Stanza {

	private String nomeAttrezzoLuminoso;
	
	public StanzaBuia(String nome, String nomeAttrezzo) {
		super(nome);
		this.nomeAttrezzoLuminoso = nomeAttrezzo;
	}
	
	
	@Override
	public String getDescrizione() {
		if(this.hasAttrezzo(nomeAttrezzoLuminoso)) {
			return super.getDescrizione();
		}
		else {
			return "Qui c'è un buio pesto";
		}
	}
	
	
}
