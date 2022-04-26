import java.util.*;

public class Teoria extends Corso {

	// Attributi
	private int codiceAula;
	private int oreSettimanali;
	private double orePerLezione;

	// Costruttore
	public Teoria(int codiceCorso, String nomeCorso, String docente, int codiceAula, int oreSettimanali,
			double orePerLezione) {
		super(codiceCorso, nomeCorso, docente);
		this.codiceAula = codiceAula;
		this.oreSettimanali = oreSettimanali;
		this.orePerLezione = orePerLezione;
	}

	// Metodi
	// PUNTO 3: toString
	public String toString() {
		return super.toString() + "teoria" + "\t" + this.codiceAula + "\t" + this.oreSettimanali + "\t"
				+ this.orePerLezione + "\t-\t-\t-\t";
	}
}
