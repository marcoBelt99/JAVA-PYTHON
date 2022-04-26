
// java RemoteHeadServer porta    
//                       args[0]
import java.io.*;
import java.net.*;

public class RemoteHeadServer {
    public static void main(String[] args) {
        // Controllo argomenti passati a linea di comando

        if (args.length != 1) {
            System.err.println("Uso: java RemoteHeadServer  porta");
            System.exit(1);
        }
        try {
            // Creo la socket passiva
            ServerSocket ss = new ServerSocket(Integer.parseInt(args[0]));

            // Ciclo while infinito di servizio
            for (;;) {
                // Creo la socket attiva e mi metto in attesa di richieste di connessione
                Socket s = ss.accept();

                // Devo leggere e scrivere dalla socket, quindi:
                // Ottengo i due estremi di I/O per fare lettura e scrittura da Socket
                // Per leggere e scrivere righe di testo UTF-8 devo fare così:
                BufferedReader netIn = new BufferedReader(new InputStreamReader(s.getInputStream(), "UTF-8"));
                BufferedWriter netOut = new BufferedWriter(new OutputStreamWriter(s.getOutputStream(), "UTF-8"));

                // Leggo il nome del file dalla socket
                String filename = netIn.readLine();

                // Ottenuto il filename, con gli oggetti di classe File posso controllare se il
                // file esiste o meno
                File f = new File(filename);
                // Controllo la sua esistenza
                if (f.exists()) {
                    // Se esiste, con il BufferedReader che incapsula il FileReader, riesco a
                    // leggere riga per riga
                    BufferedReader br = new BufferedReader(new FileReader(f));
                    String line;
                    int line_number = 1;
                    // Leggo dal file
                    while ((line = br.readLine()) != null && line_number <= 5) {
                        // e scrivo sulla socket le cose lette
                        netOut.write(line);
                        netOut.newLine();
                        netOut.flush();
                        line_number++;
                    }
                }
                s.close();

            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
            System.exit(2);
        }

    } // fine main
} // fine classe


/**
 * Mi assicuro che non ci sia nessuno in ascolto nella porta 51000, e lo vedo con
 * lsof -i :51000
 * Se non c'è nessuno, faccio partire il server:
 * java RemoteHeadServer 51000
 * Mi connetto al server in modo client, utilizzando netcat, al server:
 * netcat -6 localhost 51000
 * Digito quindi:
 * provami.txt
 * Mi connetto al server con il client: RemoteHeadClient:
 * java RemoteHeadClient localhost 51000 provami.txt 
 */
