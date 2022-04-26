public class Veicolo {
	protected int codiceVeicolo;
	protected String tipoVeicolo;
	protected String targaVeicolo;

	protected String modelloVeicolo;
	protected String marcaVeicolo;

	public Veicolo(int codiceVeicolo, String tipoVeicolo, String targaVeicolo, String modelloVeicolo,
			String marcaVeicolo) {
		this.codiceVeicolo = codiceVeicolo;
		this.tipoVeicolo = tipoVeicolo;
		this.targaVeicolo = targaVeicolo;
		this.modelloVeicolo = modelloVeicolo;
		this.marcaVeicolo = marcaVeicolo;
	}
	// Metodi

	// toString punto 3
	public String toString() {
		return this.tipoVeicolo + "\t" + this.targaVeicolo + "\t" + this.codiceVeicolo + "\t" + this.modelloVeicolo
				+ "\t" + this.marcaVeicolo + "\t";
	}

	// metodo per punto 4
	public String getTipoVeicolo() {
		return this.tipoVeicolo;
	}
}
