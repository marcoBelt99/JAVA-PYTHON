package postgres_db;

import java.sql.Date;
import java.time.LocalDate;

/** Classe che descrive la tabella 'anag' del database utenti di postgresql */
public class Anagrafica {

	// Attributi
	protected int ID;
	protected String Cognome;
	protected String Nome;
	protected LocalDate DataNascita;
	protected String Luogo;
	protected char Sesso;
	protected String Via;
	protected String CAP;
	protected String Citta;
	protected String Provincia;
	protected String Telefono;
	protected LocalDate DataAggio;
	protected String CodiceFiscale;
	protected String Banca;
	protected String Agenzia;
	protected String NumeroConto;
	protected String CAB;
	protected String ABI;

}
