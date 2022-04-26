
public class Auto extends Veicolo{
	private int cilindrata;
	private boolean diesel;
	
	public Auto(int codiceVeicolo, String tipoVeicolo, String targaVeicolo, String modelloVeicolo,String marcaVeicolo,
			int cilindrata, boolean diesel)
	{
		super(codiceVeicolo, tipoVeicolo, targaVeicolo, modelloVeicolo, marcaVeicolo);
		this.cilindrata = cilindrata;
		this.diesel = diesel;
	}
	//metodi
	public String toString()
	{
		return super.toString() + this.cilindrata +"\t"+ this.diesel +"\t-\t-\t";
	}
}
