package postgres_db;

import java.io.*;
import java.sql.*;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Inserimento_Automatico {

	public static void main(String args[]) {

		/** Dichiarazione delle variabili */
		// Oggetto anag di classe Anagrafica
		Anagrafica anag = new Anagrafica();
		// Variabile di controllo del ciclo while
		int fine = 1;
		// Contatore per fare l'auto-increment dell'ID
		int cont = 0;
		// Impostazioni dello standard input
		InputStreamReader input = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(input);

		// Variabili per la connessione:
		// database di tipo postgresql, di nome utenti
		String url = "jdbc:postgresql://localhost/utenti";
		String username = "postgres";
		String password = "mmsf22dp";

		/** Lettura da tastiera e inserimento record */
		// Leggo dato da tastiera e lo aggiungo all'opportuno
		// attributo dell'oggetto anag
		try {
			while (fine != 0) {
				cont++;
				System.out.println("*** IMMETTI I DATI DELL'UTENTE ***");
				anag.ID = cont;
				System.out.println("Cognome dell'utente:\t");
				anag.Cognome = br.readLine();
				System.out.println("Inserire il Nome:\t");
				anag.Nome = br.readLine();
				System.out.println("Data di Nascita:\t");
				DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy/MMM/d");
				anag.DataNascita = LocalDate.parse(br.readLine(), df); // N.B.: conversione da stringa a data
				System.out.println("Luogo:\t");
				anag.Luogo = br.readLine();
				System.out.println("Sesso:\t");
				anag.Sesso = br.readLine().charAt(0); // N.B.: conversione da stringa a char
				System.out.println("Via:\t");
				anag.Via = br.readLine();
				System.out.println("CAP:\t");
				anag.CAP = br.readLine();
				System.out.println("Città:\t");
				anag.Citta = br.readLine();
				System.out.println("Provincia:\t");
				anag.Provincia = br.readLine();
				System.out.println("Telefono:\t");
				anag.Telefono = br.readLine();
				System.out.println("Data Aggiornamento:\t");
				anag.DataAggio = LocalDate.parse(br.readLine());
				System.out.println("Codice Fiscale:\t");
				anag.CodiceFiscale = br.readLine();
				System.out.println("Banca:\t");
				anag.Banca = br.readLine();
				System.out.println("Agenzia:\t");
				anag.Agenzia = br.readLine();
				System.out.println("Numero Conto:\t");
				anag.NumeroConto = br.readLine();
				System.out.println("CAB:\t");
				anag.CAB = br.readLine();
				System.out.println("ABI:\t");
				anag.ABI = br.readLine();
				System.out.println("*** FINE IMMISSIONE DATI ***");

				// Connessione al Database
				Connection conn = DriverManager.getConnection(url, username, password); // diverso da null

				// Se la connessione è avvenuta con successo, conn avrà un valore != null
				if (conn != null)
					System.out.println("*** La connessione è avventua con successo!! ***");

				// Comando SQL
				String cmdSQL = "INSERT INTO Anag " + "(ID, Cognome, Nome, DataNascita, Luogo, "
						+ " Sesso, Via, CAP, Citta, Provincia, Telefono, DataAggio, "
						+ "CodiceFiscale, Banca, Agenzia, NumeroConto, CAB, ABI)"
						+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?, ?, ?, ?);";

				/** Utilizzo le Query parametrizzate */
				// Lo rendo un preparedstatement
				PreparedStatement pstmt = conn.prepareStatement(cmdSQL);
				// Setto i parametri
				pstmt.setInt(1, anag.ID);
				pstmt.setString(2, anag.Cognome);
				pstmt.setString(3, anag.Nome);
				pstmt.setObject(4, anag.DataNascita); // N.B. l'uso della setObject()
				pstmt.setString(5, anag.Luogo);
				pstmt.setString(6, String.valueOf(anag.Sesso));// attenzione per i caratteri
				pstmt.setString(7, anag.Via);
				pstmt.setString(8, anag.CAP);
				pstmt.setString(9, anag.Citta);
				pstmt.setString(10, anag.Provincia);
				pstmt.setString(11, anag.Telefono);
				pstmt.setObject(12, anag.DataAggio);
				pstmt.setString(13, anag.CodiceFiscale);
				pstmt.setString(14, anag.Banca);
				pstmt.setString(15, anag.Agenzia);
				pstmt.setString(16, anag.NumeroConto);
				pstmt.setString(17, anag.CAB);
				pstmt.setString(18, anag.ABI);

				// Eseguo il comando SQL
				pstmt.executeUpdate();
				System.out.println("** Record registrato! **");

				// Rilascio le risorse usate dal comando SQL
				pstmt.close();
				// Chiudo la connessione al Database
				conn.close();
			} // fine while lettura

		} // fine try
		catch (SQLException e) {
			System.err.println("Eccezione comando SQL");
			System.err.println(e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			System.err.println("Eccezione durante la lettura");
			System.err.println(e.getMessage());
			e.printStackTrace();
		} catch (NumberFormatException e) {
			System.err.println("Eccezione di tipo numerico");
			System.err.println(e.getMessage());
			e.printStackTrace();
		} catch (DateTimeException e) {
			System.err.println("Eccezione sulla data");
			System.err.println(e.getMessage());
			e.printStackTrace();
		} catch (Exception e) {
			System.err.println("Eccezione generica");
			System.err.println(e.getMessage());
			e.printStackTrace();
		}

	} // fine main
}

/** TEORIA: */
/*
 * 
 * Il metodo createStatement in genere serve per attivare semplici comandi SQL
 * che non contengono alcun parametro. JDBC mette a disposizione il metodo
 * prepareStatement, il quale crea un'istanza della classe PreparedStatement,
 * che è una sottoclasse di Statement, quindi ne eredita tutte le funzionalità.
 * 
 * 
 * Il metodo prepareStatement è utile quando si devono eseguire istruzioni SQL
 * con uno o più parametri, oppure istruzioni SQL semplici che perà devono
 * essere eseguite più volte. I parametri sono indicati nel comando SQL con un
 * punto di domanda.
 * 
 * Per assegnare poi i valori ai parametri si usano i metodi setXXX, sostituendo
 * a XXX uno dei tipi di dato previsti nel linguaggio Java, con l'indicazione
 * del numero del parametro da sostituire (i parametri indicati con il punto di
 * domanda nel comando SQL sono numerati da sinistra verso destra a partire da
 * 1).
 * 
 * Per eseguire il comando SQL uso il metodo executeUpdate()
 */
