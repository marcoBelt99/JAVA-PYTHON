package postgres_db;

import java.sql.*;


public class Inserimento {
	// Inserisco i dati di una nuova persona nella tabella delle anagrafiche
	public static void main(String args[]) {
		// Crea un URL specificando il DNS (data source name) di postgresql
		String url = "jdbc:postgresql://localhost/utenti";
		// Username: utente "postgres"
		String username = "postgres";
		// Password: "mmsf22dp"
		String password = "mmsf22dp";

		// Connessione
		// Mettere tutto sempre dentro un blocco try-catch
		try (Connection conn = DriverManager.getConnection(url, username, password);) { // diverso da null

			// Se la connessione è avvenuta con successo, conn avrà un valore != null
			if (conn != null)
				System.out.println("*** La connessione è avventua con successo!! ***");

			// Comando SQL
			String cmdSQL = "INSERT INTO Anag " + "(ID, Cognome, Nome, DataNascita, Luogo, Sesso, "
					+ "Via, CAP, Citta, Provincia, Telefono, DataAggio, "
					+ "CodiceFiscale, Banca, Agenzia, NumeroConto, CAB, ABI)"
					+ "VALUES (005, 'Rossi', 'Angelo', '12/02/65', 'Bologna', "
					+ "'M', 'Via Lunga 7', '20102', 'Milano', 'MI', '3403183848', "
					+ "'13/05/01', 'RSSNGL65B12R342Z', 'BIPOP','BO2', '23456', " + "'070897', '023411');";

			// Lo rendo uno statement
			Statement stmt;
			stmt = conn.createStatement();

			// Eseguo il comando SQL
			stmt.executeUpdate(cmdSQL);
			System.out.println("** Record registrato! **");
			stmt.close();
			conn.close();

		} catch (SQLException e) {
			System.err.println("Errore di connessione");
			System.err.println(e.getMessage());
		}
		// Fine connessione

	} // fine main
}
