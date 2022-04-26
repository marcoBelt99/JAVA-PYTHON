package METODO_2_EXTENDS;
//SECONDO METODO PER CREARE UN THREAD
public class SempliceThread extends Thread {
	
	public SempliceThread(String str)
	{
		super(str);
	}
	
	public static void main(String[] args) {
		SempliceThread st1 = new SempliceThread("Thread 1"); //creo il thread
		st1.start(); //avvio il thread
	}
	
	//Implemento il metodo run: esso fa quello che voglio far eseguire subito dopo aver creato il nuovo Thread
	public void run() //lo sovrascrivo
	{
		for(int i=0;i<10;i++)
		{
			System.out.println(i+" "+getName());
			try
			{
				sleep( (int)Math.random()*1000 );
			} catch (InterruptedException e) {}
		}
		System.out.println("FATTO! "+getName() );
	}

} //fine classe SempliceThread
