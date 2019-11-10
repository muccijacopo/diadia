package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.personaggi.*;
import java.util.*;

/**
 * Classe Stanza - una stanza in un gioco di ruolo. Una stanza e' un luogo
 * fisico nel gioco. E' collegata ad altre stanze attraverso delle uscite. Ogni
 * uscita e' associata ad una direzione.
 * 
 * @author docente di POO
 * @see Attrezzo
 * @version base
 */

public class Stanza {

	private String nome;
	private List<Attrezzo> attrezzi;
	private Map<String, Stanza> uscite;
	private AbstractPersonaggio personaggio;
	

	/**
	 * Crea una stanza. Non ci sono stanze adiacenti, non ci sono attrezzi.
	 * 
	 * @param nome
	 *            il nome della stanza
	 */
	public Stanza(String nome) {
		this.nome = nome;
		this.uscite = new HashMap<>();
		this.attrezzi = new ArrayList<>();
	}

	/**
	 * Imposta una stanza adiacente.
	 *
	 * @param direzione
	 *            direzione in cui sara' posta la stanza adiacente.
	 * @param stanza
	 *            stanza adiacente nella direzione indicata dal primo parametro.
	 */
	public void impostaStanzaAdiacente(String direzione, Stanza stanza) {
		this.uscite.put(direzione, stanza);
	}

	/**
	 * Restituisce la stanza adiacente nella direzione specificata
	 * 
	 * @param direzione
	 */
	public Stanza getStanzaAdiacente(String direzione) {
		return this.uscite.get(direzione);
	}
	
	/**
	 * Restituisce il nome della stanza.
	 * 
	 * @return il nome della stanza
	 */
	public String getNome() {
		return this.nome;
	}

	/**
	 * Restituisce la descrizione della stanza.
	 * 
	 * @return la descrizione della stanza
	 */
	public String getDescrizione() {
		return this.toString();
	}

	/**
	 * Restituisce la collezione di attrezzi presenti nella stanza.
	 * 
	 * @return la collezione di attrezzi nella stanza.
	 */
	public List<Attrezzo> getAttrezzi() {
		return this.attrezzi;
	}

	/**
	 * Mette un attrezzo nella stanza.
	 * 
	 * @param attrezzo
	 *            l'attrezzo da mettere nella stanza.
	 * @return true se riesce ad aggiungere l'attrezzo, false atrimenti.
	 */
	public boolean addAttrezzo(Attrezzo attrezzo) {
		
		return attrezzi.add(attrezzo);
	}

	/**
	 * Restituisce una rappresentazione stringa di questa stanza, stampadone la
	 * descrizione, le uscite e gli eventuali attrezzi contenuti
	 * 
	 * @return la rappresentazione stringa
	 */
	public String toString() {
		StringBuilder risultato = new StringBuilder();
		risultato.append("Ti trovi in ");
		risultato.append(this.nome + "\n");
		risultato.append("Uscite: ");
		Set<String> direzioni = this.uscite.keySet();
		for (String direzione : direzioni)
			risultato.append(direzione + " ");
		risultato.append("\n");
		risultato.append("Attrezzi nella stanza: ");
		for (Attrezzo a : attrezzi) {
			risultato.append(a.toString() + " ");
		}
		return risultato.toString();
	}

	/**
	 * Controlla se un attrezzo esiste nella stanza (uguaglianza sul nome).
	 * 
	 * @return true se l'attrezzo esiste nella stanza, false altrimenti.
	 */
	public boolean hasAttrezzo(String nomeAttrezzo) {
		for(Attrezzo a : attrezzi) {
			if(a.getNome().equals(nomeAttrezzo)) 
				return true;
		}
		
		return false;
	}

	/**
	 * Restituisce l'attrezzo nomeAttrezzo se presente nella stanza.
	 * 
	 * @param nomeAttrezzo
	 * @return l'attrezzo presente nella stanza. null se l'attrezzo non e' presente.
	 */
	public Attrezzo getAttrezzo(String nomeAttrezzo) {
		for(Attrezzo a : attrezzi) {
			if(a.getNome().equals(nomeAttrezzo)) 
				return a;
		}
		
		return null;
	}

	/**
	 * Rimuove un attrezzo dalla stanza (ricerca in base al nome).
	 * 
	 * @param nomeAttrezzo
	 * @return true se l'attrezzo e' stato rimosso, false altrimenti
	 */
	public boolean removeAttrezzo(String nomeAttrezzo) {
		Iterator <Attrezzo> it = attrezzi.iterator();
		Attrezzo a = null;
		while(it.hasNext()) {
			a = it.next();
			if(a.getNome().equals(nomeAttrezzo)) 
				it.remove();
				return true;
		}
		
	return false;
	}
	
	/**
	 * @return Un insieme delle direzioni possibili
	 */

	public Set<String> getDirezioni() {
		return this.uscite.keySet();
	}
	/**
	 * 
	 * @return Una collezione contenete tutte le stanze adiacenti
	 */
	public Collection<Stanza> getStanzeAdiacenti() {
		return this.uscite.values();
	}
	/**
	 * Imposta il personaggio presente nella stanza
	 * @param AbstractPersonaggio
	 */
	public void setPersonaggio(AbstractPersonaggio personaggio) {
		this.personaggio = personaggio;
	}
	
	/**
	 * Restituisce il personaggio presente nella stanza
	 * @return Personaggio presente nella stanza
	 */
	public AbstractPersonaggio getPersonaggio() {
		return this.personaggio;
	}
	
	public List<Stanza> getStanzeOrdinatePerAttrezzi() {
		class ComparatoreStanzePerAttrezzi implements Comparator<Stanza> {
			public int compare(Stanza s1, Stanza s2) {
				return s1.getAttrezzi().size() - s2.getAttrezzi().size();
			}
		}
		
		ComparatoreStanzePerAttrezzi cmp = new ComparatoreStanzePerAttrezzi();
		List<Stanza> stanzeOrdinate = new ArrayList<>(this.getStanzeAdiacenti());
		Collections.sort(stanzeOrdinate, cmp);
		
		return stanzeOrdinate;
	}

}