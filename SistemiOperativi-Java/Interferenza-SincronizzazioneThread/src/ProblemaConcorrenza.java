
//Esempio di problema di accesso concorrente alla medesima risorsa. Due thread devono effettuare
// 30 versamenti di 100€ sullo stesso conto corrente
import java.lang.*;

public class ProblemaConcorrenza {
	public static void main(String[] args) {

		BankAccount ba = new BankAccount(0); // creo un unico c/c --> RISORSA

		Impiegato imp1 = new Impiegato("Marco", ba);// ho 2 clienti
		Impiegato imp2 = new Impiegato("Mattia", ba);

		imp1.start(); // + 3000 €
		imp2.start(); // + 3000 €
	} // fine main

} // fine classe ProblemaConcorrenza

/*
 * Il Problema è che: alla fine ho un saldo di 4600€ a fronte di 2 versamenti da
 * 3000 ciascuno questo è un problema di interferenza, chiamato anche race
 * condition = situazione di corsa
 * 
 * Soluzione: sincronizzazione tramite modificatore syncronized e tramite
 * primitive: wait(), notify() e notifyAll() (e concurrency utilities) con la
 * syncronized posso imporre l'accesso esclusivo: metto un lock su un oggetto.
 * Definisco la syncronized sul metodo Dunque, ad ogni oggetto viene assegnato
 * un solo lock. Due thread non possono accedere contmporaneamente a due
 * metodi/blocchi synchronized diversi di uno stesso oggetto.
 * 
 * 
 * Tuttavia è possibile che: syncronized a volte non è sufficiente: Es) se
 * dentro un metodo synchronized, il thread cerca di accedere a un altro metodo
 * di un altro oggetto synchronized che è già in uso da un altro thread
 * 
 * Soluzione: uso di wait(): Il thread che ha un lock di un oggetto, che invoca
 * wait(): si blocca in attesa che un altro thread invochi notify() o
 * notifyAll() per quell'oggetto deve essere in possesso del lock sull'oggetto
 * al momento della invocazione rilascia il lock
 * 
 * notify(): Il thread che la invoca risveglia uno dei Thread in attesa scelto
 * arbitrariamente notifyAll(): il Thread che la invoca risveglia tutti i thread
 * in attesa: essi competeranno per l'accesso all'oggetto
 * 
 */
