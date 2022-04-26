import java.util.*;
import java.io.*;

public class Gestione {

	// LISTE
	static List<Veicolo> veicoli = new LinkedList<Veicolo>();
	static List<Posteggio> posteggi = new LinkedList<Posteggio>();
	// MAPPE
	static Map<Integer, Veicolo> codVeicolo = new HashMap<Integer, Veicolo>();

	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new FileReader("veicoli.txt"));
			String line = br.readLine(); // leggo la prima riga
			while (line != null) {
				StringTokenizer tok = new StringTokenizer(line);
				int codiceVeicolo = Integer.parseInt(tok.nextToken());
				String tipoVeicolo = tok.nextToken();
				String targaVeicolo = tok.nextToken();
				line = br.readLine(); // a capo
				if (tipoVeicolo.equals("auto")) {
					tok = new StringTokenizer(line);
					int cilindrata = Integer.parseInt(tok.nextToken());
					boolean diesel = Boolean.parseBoolean(tok.nextToken());
					line = br.readLine();// a capo
					String modelloVeicolo = line;
					line = br.readLine();// a capo
					String marcaVeicolo = line;
					line = br.readLine(); // a capo
					// Creazione nuovo oggetto
					Veicolo auto = new Auto(codiceVeicolo, tipoVeicolo, targaVeicolo, modelloVeicolo, marcaVeicolo,
							cilindrata, diesel);
					// aggiunta in lista
					veicoli.add(auto);
					// aggiunta in mappa
					codVeicolo.put(codiceVeicolo, auto);
				} else {
					tok = new StringTokenizer(line);// provo a vedere string eventualmente contenente spazi
					String categoria = tok.nextToken();
					line = br.readLine(); // a capo

					tok = new StringTokenizer(line);
					// visto che avevo: stringa eventualmente contenente spazi, allora:
					int numeroPosti = Integer.parseInt(tok.nextToken()); // problema del : for input string "9 " --> ci
																			// ho messo un tokenizer
					line = br.readLine(); // capo

					// tok = new StringTokenizer(line);
					String modelloVeicolo = line;// tok.nextToken();
					line = br.readLine();// a capo

					// tok = new StringTokenizer(line);
					String marcaVeicolo = line;
					line = br.readLine(); // a capo

					// Creazione nuovo oggetto
					Veicolo furgone = new Furgone(codiceVeicolo, tipoVeicolo, targaVeicolo, modelloVeicolo,
							marcaVeicolo, categoria, numeroPosti);
					// aggiunta in lista
					veicoli.add(furgone);
					// aggiunta in mappa
					codVeicolo.put(codiceVeicolo, furgone);
				}
			} // fine while
			br.close(); // chiusura file
		} // fine try
		catch (IOException e) {
			System.err.println(e);
		} catch (Exception e) {
			System.err.println(e);
		}

		try {
			BufferedReader br = new BufferedReader(new FileReader("posteggi.txt"));
			String line = br.readLine(); // leggo la prima riga
			while (line != null) {
				String nomeCognomeCliente = line;
				line = br.readLine();// a capo
				Posteggio post = new Posteggio(nomeCognomeCliente);
				// Gestione dell'elenco
				StringTokenizer tok = new StringTokenizer(line); // spezzo la linea in tokens
				while (tok.hasMoreTokens()) {
					int codiceVeicolo = Integer.parseInt(tok.nextToken());
					int numGiorni = Integer.parseInt(tok.nextToken());

					// Creazione elenco
					Elenco e = new Elenco(codVeicolo.get(codiceVeicolo), numGiorni); // gli passo i parametri così
					// aggiunta elenco in lista
					post.addElenco(e);
				}
				// Aggiunta oggetto in lista
				posteggi.add(post);

				line = br.readLine(); // a capo

			} // fine while
			br.close(); // chiusura file
		} // fine try
		catch (IOException e) {
			System.err.println(e);
		} catch (Exception e) {
			System.err.println(e);
		}

		// PUNTO 3:
		System.out.println("tipo, targa, codice, modello, marca, cilindrata, diesel, categoria, numero di posti");
		for (Veicolo v : veicoli)
			System.out.println(v);

		System.out.println();
		// PUNTO 4:
		for (Posteggio p : posteggi)
			System.out.println(p);

		System.out.println();
		// PUNTO 5:
		int codiceLetto = Integer.parseInt(args[0]); // codiceletto
		float somma = 0;
		for (Posteggio p : posteggi) {
			for (Elenco e : p.elenco) {
				if (e.veicolo == codVeicolo.get(codiceLetto))
					somma = somma + e.costo();
			}
		}
		System.out.println(codiceLetto + " " + somma);

	} // fine main

} // fine classe
