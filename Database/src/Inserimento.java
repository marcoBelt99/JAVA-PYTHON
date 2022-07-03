
/* Inserimento di un nuovo record */
import java.sql.*;

public class Inserimento {

	public static void main(String[] args) {
		// Crea un URL specificando il DNS (data source name) di ODBC
		String url = "jdbc:odbc:db1";
		Connection con;
		String cmdSQL = "INSERT INTO Anag " + "(ID, Cognome, Nome, DataNascita, Luogo, Sesso, "
				+ " Via, CAP, Citta, Provincia, Telefono, DataAggio "
				+ " CodiceFiscale, Banca, Agenzia, NumeroConto, CAB, ABI) "
				+ " VALUES (005, 'Rossi', 'Angelo','12/02/65','Bologna', "
				+ " 'M', 'Via Lunga 7', '023411', 'Milano', 'MI', '02/2828217', "
				+ " '13/05/01', 'RSSNGL65B12R342Z','BIPOP','BO2','23456', " + " '078977', '023411')";

		Statement stmt;
		// Connessione al database
		try {
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		} catch (ClassNotFoundException e) {
			System.err.println("ClassNotFoundException: ");
			System.err.println(e.getMessage());
		}

		try {
			con = DriverManager.getConnection(url, "", "");
			stmt = con.createStatement();
			// Esegue il comando SQL
			stmt.executeUpdate(cmdSQL);
			System.out.println("Record registrato");
			stmt.close();
			con.close();
		} catch (SQLException ex) {
			System.err.println("SQLException: ");
			System.err.println(ex.getMessage());
		}

	} // fine main

} // fine classe
