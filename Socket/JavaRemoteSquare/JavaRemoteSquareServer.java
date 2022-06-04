import java.io.*;
import java.net.*;

/**
 * JavaRemoteSquareServer:
 * 
 * 
 * java RemoteSquareServer porta
 * argv[0]
 */
public class JavaRemoteSquareServer {

    /**
     * MAIN
     * 
     * @param args
     */
    public static void main(String[] args) {

        /**
         * CONTROLLO CORRETTEZZA PARAMETRI LINEA DI COMANDO
         */
        if (args.length != 1) {
            System.err.println("Uso: java RemoteSquareServer porta\n");
            System.exit(1);
        }
        System.out.println("Server in ascolto nella porta:\t" + args[0]);
        /**
         * DICHIARAZIONE DELLE VARIABILI
         */
        int numero = 0; // Numero da riceveree

        /**
         * OPERAZIONE CON SOCKET: Creazione socket lato Server.
         */
        /**
         * Creazione Socket Passiva: La creo e la lego alla porta della macchina server.
         * In C avrei fatto: getAddrInfo(), socket(), bind(), connect()
         */
        try {
            ServerSocket ss = new ServerSocket(Integer.parseInt(args[0]));
            while (true) {

                /**
                 * Creazione Socket Attiva: mi metto in attesa di nuove richieste di
                 * connessione.
                 */
                Socket s = ss.accept();
                /**
                 * LETTURA DA SOCKET:
                 * TODO: specificare sempre l'encoding "UTF-8".
                 * Creazione reader e wrapping per buffering,
                 * 's.getInputStream()' resisce InputStream per leggere byte dalla socket.
                 * Lettura da socket con br
                 */
                try {
                    System.out.println("Lettura numero dall'estremo in lettura della socket:");
                    BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream(), "UTF-8"));
                    numero = Integer.parseInt(br.readLine());
                } catch (IOException e) {
                    System.err.println(e);
                    System.exit(2);
                } catch (NumberFormatException e) {
                    /* Controllo che sia effettivamento un numero intero */
                    if (numero != (int) numero)
                        System.err.println("Numero non intero");
                    System.err.println(e);
                    System.exit(3);
                } catch (Exception e) {
                    System.err.println(e);
                    System.exit(4);
                }

                try {
                    /**
                     * SCRITTURA SU SOCKET: Ci scrivo (numero)
                     * Creazione writer e wrapping per buffering.
                     * TODO: specificare sempre l'encoding "UTF-8".
                     * 's.getOutputStream()' resisce OutputStream per scrivere byte sulla socket.
                     * Scrittura su socket con bw
                     */
                    System.out.println("Ricevuto il numero:\t" + numero);
                    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream(), "UTF-8"));
                    bw.write((numero * numero) + "");
                    bw.newLine();
                    bw.flush();

                    /**
                     * CHIUSURA SOCKET e disconnetto il Server dal server
                     */
                    s.close();
                } catch (IOException e) {
                    System.err.println("Errore di I/O:\t" + e.getMessage());
                } catch (Exception e) {
                    System.err.println("Errore generico");
                }

            } // fine while true
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    } // fine main

} // fine classe