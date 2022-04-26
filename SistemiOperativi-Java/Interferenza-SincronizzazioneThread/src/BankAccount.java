
public class BankAccount {
	// Attributi
	private int value;

	// Costruttore
	public BankAccount(int initialValue) {
		// TODO Auto-generated constructor stub
		this.value = initialValue;
	}

	// Metodi
	public synchronized void increase(int amount) {
		int temp = this.value;
		Simulate.HWinterrupt(); // simulo un interrupt hardware (predispongo una classe che lo fa). Quindi, dopo 200 millisecondi
		this.value = temp + amount;
		System.out.println("Nuovo saldo: " + this.value);
	}

} // fine classe BankAccount

/* La JVM supporta la definizione di lock sui singoli oggetti tramite la keyword syncronized
 * Il modificatore synchronized permette l' accesso in mutua esclusione al
 * blocco modificato
 */
