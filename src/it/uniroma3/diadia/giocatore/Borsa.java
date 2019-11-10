package it.uniroma3.diadia.giocatore;

import java.util.*;

import it.uniroma3.diadia.attrezzi.Attrezzo;


public class Borsa {
	public final static int DEFAULT_PESO_MAX_BORSA = 10;
	private List<Attrezzo> attrezzi;
	private int pesoMax;
	
	public Borsa() {
		this(DEFAULT_PESO_MAX_BORSA);
	}
	
	public Borsa(int pesoMax) {
		this.attrezzi = new ArrayList<>();
		this.pesoMax = pesoMax;
	}
	
	public boolean addAttrezzo(Attrezzo attrezzo) {
		if(this.getPeso()+attrezzo.getPeso() <= this.pesoMax)
			return this.attrezzi.add(attrezzo);
		return false;
	}
	
	public int getPesoMax() {
		return pesoMax;
	}
	
	public Attrezzo getAttrezzo(String nomeAttrezzo) {
		for(Attrezzo a : attrezzi) {
			if(a.getNome().equals(nomeAttrezzo)) {
				return a;
			}
		}

		return null;
	}

	public int getPeso() {
		int pesoTotale = 0;
		for(Attrezzo a : attrezzi)
			pesoTotale += a.getPeso();

		return pesoTotale;
	}
	
	public boolean isEmpty() {
		return attrezzi.isEmpty();
	}
	
	public boolean hasAttrezzo(String nomeAttrezzo) {
		for(Attrezzo a : attrezzi) {
			if(a.getNome().equals(nomeAttrezzo)) 
				return true;
		}
		
		return false;
		
	}
	
	public Attrezzo removeAttrezzo(String nomeAttrezzo) {
		Attrezzo a = null;
		Iterator <Attrezzo> it = attrezzi.iterator();
		while(it.hasNext()) {
			a = it.next();
			if(a.getNome().equals(nomeAttrezzo)) 
				it.remove();
				return a;
		}
		
		return a;
	}
	
	public String toString() {
		Set<Attrezzo> attrezziOrdinati = this.getSortedSetOrdinatoPerPeso();
		StringBuilder s = new StringBuilder();

		if (!this.isEmpty()) {
			s.append("Contenuto borsa ("+this.getPeso()+"kg/"+this.getPesoMax()+"kg): ");
			for (Attrezzo a : attrezziOrdinati)
				s.append(a.toString()+" ");
		}
		else
			s.append("Borsa vuota");
		return s.toString();
	}
	
	public List<Attrezzo> getContenutoOrdinatoPerPeso() {
		class ComparatoreAttrezziPerPeso implements Comparator<Attrezzo> {
			@Override
			public int compare(Attrezzo a1, Attrezzo a2) {
				if(a1.getPeso() != a2.getPeso())
					return a1.getPeso() - a2.getPeso();
				else
					return a1.getNome().compareTo(a2.getNome());
			}
		}
		List<Attrezzo> attrezziOrdinati = new ArrayList<>(this.attrezzi);
		ComparatoreAttrezziPerPeso cmp = new ComparatoreAttrezziPerPeso();
		Collections.sort(attrezziOrdinati, cmp);
		return attrezziOrdinati;
	}
	
	public SortedSet<Attrezzo> getContenutoOrdinatoPerNome() {
		class ComparatoreAttrezziPerNome implements Comparator<Attrezzo> {
			@Override
			public int compare(Attrezzo a1, Attrezzo a2) {
				return a1.getNome().compareTo(a2.getNome());
			}
		}
		ComparatoreAttrezziPerNome cmp = new ComparatoreAttrezziPerNome();
		SortedSet<Attrezzo> attrezziOrdinati= new TreeSet<>(cmp);
		attrezziOrdinati.addAll(this.attrezzi);
		
		return attrezziOrdinati;

	}
	
	public Map<Integer, Set<Attrezzo>> getContenutoRaggruppatoPerPeso() {
		Attrezzo a = null;
		Map<Integer, Set<Attrezzo>> attrezziRaggruppati = new HashMap<>();
		Iterator <Attrezzo> it = this.attrezzi.iterator();
		while(it.hasNext()) {
			a = it.next();
			if(attrezziRaggruppati.containsKey(a.getPeso()))
				attrezziRaggruppati.get(a.getPeso()).add(a);
			else {
				Set<Attrezzo> gruppo = new HashSet<>();
				gruppo.add(a);
				attrezziRaggruppati.put(a.getPeso(), gruppo);
			}
			
		}
		
		return attrezziRaggruppati;
	}
	
	public SortedSet<Attrezzo> getSortedSetOrdinatoPerPeso() {
		class ComparatoreAttrezziPerPeso implements Comparator<Attrezzo> {
			@Override
			public int compare(Attrezzo a1, Attrezzo a2) {
				if(a1.getPeso() != a2.getPeso())
					return a1.getPeso() - a2.getPeso();
				else
					return a1.getNome().compareTo(a2.getNome());
			}
		}
		ComparatoreAttrezziPerPeso cmp = new ComparatoreAttrezziPerPeso();
		SortedSet<Attrezzo> attrezziOrdinati = new TreeSet<>(cmp);
		attrezziOrdinati.addAll(attrezzi);
		return attrezziOrdinati;
	}
	
	
}	
