import java.util.*;

public class Laboratorio extends Corso {
	// Attributi
	private String nomeLaboratorio;
	private String nomeAssistente;
	private int postazioni;

	// Costruttore
	public Laboratorio(int codiceCorso, String nomeCorso, String docente, String nomeLaboratorio, String nomeAssistente,
			int postazioni) {
		super(codiceCorso, nomeCorso, docente);
		this.nomeLaboratorio = nomeLaboratorio;
		this.nomeAssistente = nomeAssistente;
		this.postazioni = postazioni;
	}

	// Metodi
	// PUNTO 3: toString()
	public String toString() {
		return super.toString() + "lab" + "\t-\t-\t-\t" + this.nomeLaboratorio + "\t" + this.nomeAssistente + "\t"
				+ this.postazioni;
	}

} // fine classe
