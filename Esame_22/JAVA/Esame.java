
public class Esame {
	// Attributi
	protected int codice;
	protected String voto;

	// Costruttore
	public Esame(int codice, String voto) {
		this.codice = codice;
		this.voto = voto;
	}

	// Metodi
	// PUNTO 4: toString

	// conversione voto come intero per richiesta sul comando dell'esercizio 4
	public int getVotoAsInt() {
		if (this.voto.equals("30L"))
			return 31;
		else
			return Integer.parseInt(this.voto);
	}

	public String toString() {
		return "(" + codice + "," + voto + ")"; // guardare bene nell'output come fare
	}

	// PUNTO 5: metodo getter per la stampa nel punto 5
	public int getCorso() {
		return this.codice;
	}

	public String getVotoAsString() {
		return this.voto;
	}

} // fine classe
