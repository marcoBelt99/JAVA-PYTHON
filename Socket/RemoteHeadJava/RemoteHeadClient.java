// java RemoteHeadClient hostname   porta   nomefile
//                       args[0]    args[1] args[2]

import java.io.*;
import java.net.*;

class RemoteHeadClient {
    // Main
    public static void main(String[] args) {
        // Controllo il numero di argomenti passati a linea di comando
        if (args.length != 3) {
            System.err.println("Uso: java RemoteHeadClient hostname   porta   nomefile ");
            System.exit(1);
        }
        // Devo sempre, all'inizio, gestire le eccezioni!
        try {

            // Creo la socket
            Socket s = new Socket(args[0], Integer.parseInt(args[1]));
            // Ottengo i due estremi di I/O per fare lettura e scrittura da Socket
            // Per leggere e scrivere righe di testo UTF-8 devo fare così:
            BufferedReader netIn = new BufferedReader(new InputStreamReader(s.getInputStream(), "UTF-8"));
            BufferedWriter netOut = new BufferedWriter(new OutputStreamWriter(s.getOutputStream(), "UTF-8"));

            // Mando il nome del file, faccio una newline, ed il flush
            netOut.write(args[2]);
            netOut.newLine();
            netOut.flush();

            String line;
            int line_number = 1;
            // Ciclo while di letture:
            // Leggo dati dal server e li mando a video
            while ((line = netIn.readLine()) != null && line_number <= 5)
                System.out.println(line);

            // Ho finito, quindi posso chiudere la socket
            s.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
            System.exit(2);
        }
    } // fine main
} // fine classe

/* !!!! Da Java 10 in poi posso usare anche: var x = 10 !!!!! */

/* All'inizio devo sempre gestire le eccezioni */

/* Per debuggare uso: */
// lsof -i :51000
// nc6 -l -p 51000
// java RemoteHeadClient localhost 51000 server.rb

// Per testare i Client e Server uso prima un linguaggio di programmazione
// semplice, poi uso un linguaggio
// più 'complesso' come C e Java