
public class Impiegato extends Thread // classe che crea il Thread col 2° modo
{
	//Attributi
	private String nome;
	private BankAccount conto;
	private static final int NUM_DI_DEPOSITI = 30;
	private static final int QUANTITA_PER_DEPOSITO = 100;
	
	//Costrutture
	public Impiegato(String nome, BankAccount conto) 
	{
		this.nome = nome;
		this.conto = conto;
	}
	
	//Metodi
	public void run() //qui gestisco l'incremento
	{
		try
		{
			for( int i=1; i <= NUM_DI_DEPOSITI; i++)
			{
				Thread.sleep( 500 ); //aspeto 500 millisecondi
				this.conto.increase( QUANTITA_PER_DEPOSITO ); //incremento il c/c di 100
			}
			System.out.println("Impiegato: " + this.nome + " ha versato un totale di: " +
								NUM_DI_DEPOSITI * QUANTITA_PER_DEPOSITO );
		}
		catch (InterruptedException e) { }
	} //fine metodo run
} //fine classe Impiegato
