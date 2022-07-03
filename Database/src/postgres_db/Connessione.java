package postgres_db;

import java.sql.*;

public class Connessione {

	/** Attributi */
	protected String url = "jdbc:postgresql://localhost/utenti";
	protected String username = "postgres";
	protected String password = "mmsf22dp";

	/** Costruttore/i */
	public Connessione(String url, String username, String password) {
		this.url = url;
		this.username = username;
		this.password = password;
	}

	public Connessione() {
	}

	/** Metodi */
	// Metodo di connessione al database: "utenti"
	public void Connetti(String url, String username, String password) {

		// Mettere tutto sempre dentro un blocco try-catch
		try (Connection conn = DriverManager.getConnection(url, username, password);) { // diverso da null

			// Se la connessione è avvenuta con successo, conn avrà un valore != null
			if (conn != null)
				System.out.println("*** La connessione è avventua con successo!! ***");
		} catch (SQLException e) {
			System.err.println("Errore di connessione");
			System.err.println(e.getMessage());
		}
	}

	/** Metodi Getters */
	public String getUrl() {
		return this.url;
	}

	public String getUsername() {
		return this.username;
	}

	public String getPassword() {
		return this.url;
	}

	/** Main */
	public static void main(String[] args) {
		// Creo un nuovo oggetto di classe Connessione (di fatto, della stessa classe)
		Connessione c = new Connessione();
		// Chiamata a metodo statico della classe
		c.Connetti(c.getUrl(), c.getUsername(), c.getPassword());
	}// fine main

} // fine classe

/** COME FUNZIONA? */
/*
 * Devo importare il driver per postgresql: tasto dx sul progetto > build path >
 * add external archive > scelgo il *.jar
 * 
 * Accedere, da linea di comando linux, con utente postgres: sudo su - postgres
 * 
 * 
 * Richiamare l'interfaccia di postgresql a linea di comando: psql
 * 
 * 
 * Utente: "postgres" Password: "mmsf22dp"
 * 
 * Vedere informazioni di connessione: \conninfo
 * 
 */
