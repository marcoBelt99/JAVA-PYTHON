import java.util.*;

public class Corso {
	// Attributi
	protected int codiceCorso;
	// protected String tipo; --> per modellare il tipo, lo faccio nel main
	protected String nomeCorso;
	protected String docente;

	// Costruttore
	public Corso(int codiceCorso, String nomeCorso, String docente) {
		this.codiceCorso = codiceCorso;
		this.nomeCorso = nomeCorso;
		this.docente = docente;
	}

	// Metodi

	// PUNTO 3: toString
	public String toString() {
		return this.nomeCorso + "\t" + this.codiceCorso + "\t" + this.docente + "\t";
	}

} // fine classe
