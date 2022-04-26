
public class Furgone extends Veicolo{
	private String categoria;
	private int numPosti;

	public Furgone(int codiceVeicolo, String tipoVeicolo, String targaVeicolo, String modelloVeicolo,String marcaVeicolo,
			String categoria, int numPosti)
	{
		super(codiceVeicolo, tipoVeicolo, targaVeicolo, modelloVeicolo, marcaVeicolo);
		this.categoria = categoria;
		this.numPosti = numPosti;
	} 
	
	// metodi
	public String toString()
	{
		return super.toString() + "\t-\t-\t" + this.categoria +"\t"+ this.numPosti;
	}
	
}
