import java.util.*;
import java.io.*;

public class Studente {

	// Attributi
	private int matricola;
	private String nomeCognomeStudente;
	protected List<Esame> libretto; // memorizza delle coppie fatte da codiceCorso, Voto

	// Costruttore
	public Studente(int matricola, String nomeCognomeStudente) {
		this.matricola = matricola;
		this.nomeCognomeStudente = nomeCognomeStudente;
		this.libretto = new LinkedList<Esame>(); // Assegna a libretto una nuova linked list
													// di Esame che all'inizio sarà vuota
	}

	// Metodi
	public void addEsame(Esame e) {
		libretto.add(e);
	}

	// PUNTO 4: stampare per ogni studente nome, media esami, se 30L allora deve
	// convertirsi in 31
	// e il suo libretto, con codiceCorso e 30 e lode indicato come 30L

	public double getMedia() {
		double somma = 0;
		for (Esame e : libretto)
			somma = somma + e.getVotoAsInt();
		return somma / libretto.size();
	}

	public String toString() {
		return this.nomeCognomeStudente + "\t" + getMedia() + "\t" + libretto;
	} // in libretto ho la toString definita in Esame fatta così: [ ]

	// PUNTO 5: uso il metodo getter per ritornare la matricola
	public int getMatricola() {
		return this.matricola;
	}

	// ricerco il massimo in una lista
	public Esame votoMax() {
		int max = 0; // ha il voto massimo corrente
		Esame maxe = null; // ha l'esame associato a quel voto
		for (Esame e : libretto) {
			if (e.getVotoAsInt() > max) // se voto convertito (metodo nella classe dell'elenco)è maggiore del massimo
										// corrente
			{
				max = e.getVotoAsInt(); // allora aggiorno il massimo
				maxe = e; // ed aggiorno l'esame associato al voto massimo
			}
		}
		return maxe; // restituisco proprio l'esame con voto massimo
	}

	// metodo getter per la stampa nel punto 5
	public String getNomeCognomeStudente() {
		return this.nomeCognomeStudente;
	}

} // fine classe
