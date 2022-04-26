import java.util.*;

// import esame.Elenco;

public class Posteggio {
	private String nomeCognomeCliente;
	// attributo elenco
	List <Elenco> elenco;
	
	public Posteggio(String nomeCognomeCliente)
	{
		this.nomeCognomeCliente = nomeCognomeCliente;
		this.elenco = new LinkedList<Elenco>();
	}
	
	//metodo di aggiunta in lista
	public void addElenco( Elenco e)
	{
		elenco.add( e );
	}
	
	// metodo propedeutico per la toString che scandisce l'elenco
	public float costoTotalePosteggio()
	{
		float somma = 0;
		for( Elenco e: elenco )
		{
			if( e.veicolo.getTipoVeicolo().equals("auto") )
				somma = somma + e.numGiorni * 10;
			else
				somma = somma + e.numGiorni * 15;
		} // fine for
		return somma;
	} // fine funzione
	
	// toString per punto 4
	public String toString()
	{
		return this.nomeCognomeCliente +" "+ this.costoTotalePosteggio();
	}
}
