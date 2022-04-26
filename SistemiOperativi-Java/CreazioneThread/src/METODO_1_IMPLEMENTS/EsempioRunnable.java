package METODO_1_IMPLEMENTS;
//PRIMO METODO PER CREARE UN THREAD
public class EsempioRunnable implements Runnable{ //Creo una classe che implementa Runnable
	
	public void run() //Ci metto il metodo run()
	{
		for(int i=1;i<=10;i++)
			System.out.println(i + " " + i*i);
	}
} //fine classe EsempioRunnable
