import java.io.*;
import java.util.*;

public class Uni {
	// LISTE
	static List<Corso> corsi = new LinkedList<Corso>(); // Lista per i corsi
	static List<Studente> studenti = new LinkedList<Studente>(); // Lista per gli studenti

	// MAPPA
	static Map<Integer, String> nomeCorsi = new HashMap<Integer, String>();

	// Punto 1: memorizzazione dei corsi
	public static void main(String[] args) {

		try {
			BufferedReader br = new BufferedReader(new FileReader("corsi.txt"));
			String line = br.readLine(); // leggo la prima linea
			while (line != null) {
				StringTokenizer tok = new StringTokenizer(line); // risolve il problema degli spazi
				int codiceCorso = Integer.parseInt(tok.nextToken());
				String tipoCorso = tok.nextToken();
				line = br.readLine(); // vado a capo per leggere la prossima linea
				String nomeCorso = line;
				line = br.readLine(); // vado a capo per leggere la prossima linea
				String docente = line;

				nomeCorsi.put(codiceCorso, nomeCorso); // per punto 5:
				// con il metodo put aggiungo una coppia codice nome alla mappa nomeCorsi
				// così nella mappa ho coppie (chiave, valore) --> (codiceCorso, nomeCorso)

				line = br.readLine(); // vado a capo per leggere la prossima linea
				if (tipoCorso.equals("teoria")) {
					tok = new StringTokenizer(line);
					int codiceAula = Integer.parseInt(tok.nextToken());
					int oreSettimanali = Integer.parseInt(tok.nextToken());
					double orePerLezione = Double.parseDouble(tok.nextToken());

					Corso teoria = new Teoria(codiceCorso, nomeCorso, docente, codiceAula, oreSettimanali,
							orePerLezione);
					corsi.add(teoria); // Aggiungo questo corso alla lista dei corsi

				} else {
					// il tokenizer non serve perchè vado sempre a capo
					String nomeLaboratorio = line;
					line = br.readLine(); // vado a capo per leggere la prossima linea
					String nomeAssistente = line;
					line = br.readLine(); // vado a capo per leggere la prossima linea
					int postazioni = Integer.parseInt(line);

					Corso laboratorio = new Laboratorio(codiceCorso, nomeCorso, docente, nomeLaboratorio,
							nomeAssistente, postazioni);
					corsi.add(laboratorio); // Aggiungo questo corso alla lista dei corsi

				}
				line = br.readLine(); // Ho finito di leggere un Corso e vado a capo
				line = br.readLine(); // una riga vuota separa i dati relativi ai diversi corsi
			}
			br.close(); // chiudo il file
		} catch (IOException e) {
			System.err.println(e); // size + ctrl + invio
		} catch (Exception e) {
			System.err.println(e);
		}

		// Punto 2: Lettura di tutti gli studenti:
		try {
			BufferedReader br = new BufferedReader(new FileReader("studenti.txt"));
			String line = br.readLine();
			while (line != null) {
				int matricola = Integer.parseInt(line);
				line = br.readLine();
				String nomeCognomeStudente = line;
				Studente stud = new Studente(matricola, nomeCognomeStudente);

				studenti.add(stud); // Aggiungo qesto studente alla lista degli studenti
				line = br.readLine(); // vado a capo per leggere la prossima linea
				// Sotto forma di elenco: devo scandire questo elenco che ha lunghezza variabile
				while (line != null && !line.equals("")) {
					// null vuol dire che il puntatore non punta da nessuna parte. Non è lecita la
					// stringa
					// invece stringa vuota "" il puntatore punta a questa stringa lecita
					StringTokenizer tok = new StringTokenizer(line);
					int codiceCorso = Integer.parseInt(tok.nextToken());
					String voto = tok.nextToken();

					Esame e = new Esame(codiceCorso, voto); //
					// devo aggiungere questo esame alla lista degli studenti:
					// allora, in Studente aggiungo un metodo addEsame().
					stud.addEsame(e); // aggiungo l'esame nella lista degli studenti
					line = br.readLine(); // continuo finchè
				}
				line = br.readLine(); // vado a leggere la prossima linea
			}
			br.close(); // chiudo il file

		} catch (IOException e) {
			System.err.println(e);
		} catch (Exception e) {
			System.err.println(e);
		}

		// PUNTO 3: stampare l'elenco di tutti i corsi
		System.out.println("nome, codice, docente, tipo, aula, ore sett., ore/lez., lab., assistente, postazioni\n");
		for (Corso c : corsi)
			System.out.println(c); // --> fare la toString in classe base e classi derivate

		System.out.println();

		// PUNTO 4: stampare l'elenco degli studenti
		for (Studente s : studenti)
			System.out.println(s); // --> fare la toString in classe Studente e classe dell'elenco

		System.out.println(); // salto uno spazio

		// PUNTO 5: leggere da riga di comando il codice di uno studente e stampare il
		// nome e cognome
		// dello studente, il nome del corso in cui ha preso il voto più alto e il voto

		// per leggere da linea di comando uso gli argomenti --> args[0], args[1], .....
		int matricola = Integer.parseInt(args[0]);
		for (Studente s : studenti) { // scandisco la lista degli studenti
			if (s.getMatricola() == matricola) // se matricola inserita corrisponde a quella della lista
			{
				Esame maxe = s.votoMax();
				int codc = maxe.getCorso();
				System.out
						.println(s.getNomeCognomeStudente() + " " + nomeCorsi.get(codc) + " " + maxe.getVotoAsString());

				// PER STAMPARE IL NOME DEL CORSO: ( io del corso conosco il codice, ma non
				// conosco il nome
				// potrei o fare un ciclo sull'elenco dei corsi ed andare a vedere, per ogni
				// corso se il
				// codice è uguale a quello che ho io: se è uguale prendo il nome e così via).

				// OPPURE: costruisco una mappa che va dal codice del corso al suo nome,
				// quindi una mappa da intero a stringa che si chiama nomeCorsi:
				// implementata come una hashMap: leggere come è implementata e il metodo
				// mappa.put()
				// col metodo mappa.get() ottengo il valore associato alla chiave codc
				// ossia ottengo il nome del corso
			}
		}

	} // fine main

} // fine classe
