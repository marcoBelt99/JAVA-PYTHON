
public class Elenco {
	protected Veicolo veicolo;
	protected int numGiorni;
	
	public Elenco(Veicolo veicolo, int numGiorni)
	{
		this.veicolo = veicolo;
		this.numGiorni = numGiorni;
	}
	//metodi
	

	public int costo() {
		if( veicolo.getTipoVeicolo().equals("auto") )
			return 10*this.numGiorni;
		else
			return 15*this.numGiorni;
	}
	
	
} // fine classe
