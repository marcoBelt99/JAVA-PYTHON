import java.io.*;
import java.net.*;

/**
 * JavaRemoteSquareClient:
 * 
 * 
 * java RemoteSquareClient hostname porta
 * argv[0] argv[1] argv[2]
 */
public class JavaRemoteSquareClient {

    /**
     * MAIN
     * 
     * @param args
     */
    public static void main(String[] args) {

        /**
         * CONTROLLO CORRETTEZZA PARAMETRI LINEA DI COMANDO
         */
        if (args.length != 2) {
            System.err.println("Uso: java RemoteSquareServer hostname porta\n");
            System.exit(1);
        }

        /**
         * DICHIARAZIONE DELLE VARIABILI
         */
        int numeroDaInviare = 0; // Numero da inviare
        String fine = ""; // Stringa sentinella
        String risposta = ""; // Risposta del server

        /**
         * LETTURA DA STDIN: leggo e parsifico in intero la stringa letta da terminale
         */
        while (fine.equals("fine") == false) {
            try {
                System.out.println("Inserire un numero: ");
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                numeroDaInviare = Integer.parseInt(br.readLine());
            } catch (IOException e) {
                System.err.println(e);
                System.exit(2);
            } catch (NumberFormatException e) {
                if (numeroDaInviare != (int) numeroDaInviare)
                    System.err.println("Numero non intero");
                System.err.println(e);
                System.exit(3);
            } catch (Exception e) {
                System.err.println(e);
                System.exit(4);
            }

            /**
             * OPERAZIONE CON SOCKET: Creazione socket lato client,
             * scrittura su socket,
             * lettura risposta del server.
             */
            try {
                /**
                 * CREAZIONE SOCKET LATO CLIENT: la lego a una porta locale e la connetto alla
                 * socket del server.
                 * In C avrei fatto: getAddrInfo(), socket(), bind(), connect()
                 */
                Socket s = new Socket(args[0], Integer.parseInt(args[1]));
                System.out.println("Connesso al server di host: " + args[0] + " e porta: " + args[1]);
                /**
                 * SCRITTURA SU SOCKET:
                 * Creazione writer e wrapping per buffering.
                 * TODO: specificare sempre l'encoding "UTF-8".
                 * 's.getOutputStream()' restituisce OutputStream per scrivere byte sulla
                 * socket.
                 * Scrittura su socket con bw
                 */
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream(), "UTF-8"));
                bw.write(numeroDaInviare + "");
                bw.newLine();
                bw.flush();

                /**
                 * LETTURA DA SOCKET:
                 * TODO: specificare sempre l'encoding "UTF-8".
                 * Creazione reader e wrapping per buffering,
                 * 's.getInputStream()' restituisce InputStream per leggere byte dalla socket.
                 * Lettura da socket con br
                 */
                BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream(), "UTF-8"));
                risposta = br.readLine();
                System.out.println("Quadrato del numero:\t" + risposta);

                /**
                 * CHIUSURA SOCKET e disconnetto il Client dal server
                 */
                s.close();
            } catch (IOException e) {
                System.err.println("Errore di I/O:\t" + e.getMessage());
            } catch (Exception e) {
                System.err.println("Errore generico");
            }

            /**
             * Controllo se l'utente vuole continuare oppure uscire dall'applicazione
             */
            try {
                System.out.println("Inserire qualsiasi carattere per continuare. Per terminare digitare: 'fine'");
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                fine = br.readLine();
            } catch (IOException e) {
                System.err.println(e);
                System.exit(2);
            }

        } // fine while
        System.out.println("Chiusura connessione con server");

    } // fine main

} // fine classe