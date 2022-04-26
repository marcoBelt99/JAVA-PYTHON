package METODO_1_IMPLEMENTS;
//PRIMO METODO PER CREARE UN THREAD
public class Esempio1 {
	
public static void main(String[] args) 
{
	EsempioRunnable e = new EsempioRunnable(); //Creo una nuova istanza della classe EsempioRunnable
	Thread t = new Thread(e); //la passo come argomento di ingresso al costruttore della classe Thread
	t.start(); //invoco il metod start():
		// 1) è creato un nuovo Thread, poi
		// 2) l'esecuzione passa alla 1° istanza del metodo run dell'oggetto passato come parametro d'ingresso
}

} //fine classe Esempio1
