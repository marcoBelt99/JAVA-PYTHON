import sys
import argparse  # mi serve per fare il parsing

# IMPORTO LE CLASSI
from Veicolo import Veicolo
from Auto import Auto
from Furgone import Furgone
from Posteggio import Posteggio
from Elenco import Elenco


class Gestione:
    # COSTRUTTORE:
    def __init__(self, arg):
        self._arg = arg

    # METODO MAIN
    def main(self):
        veicoli = []  # lista 1
        posteggi = []  # lista 2
        codVeicolo = {}  # mappa o dizionario

        try:  # LETTURA PRIMO FILE
            f = open("veicoli.txt", "r")
            line = f.readline().strip()  # leggo la prima linea
            while line != "":
                tok = line.split()  # spezzo la linea
                codiceVeicolo = int(tok[0])
                tipoVeicolo = tok[1]
                targaVeicolo = tok[2]
                line = f.readline().strip()  # a capo
                if tipoVeicolo == "auto":
                    tok = line.split()  # spezzo la linea
                    cilindrata = int(tok[0])
                    diesel = bool(tok[1])
                    line = f.readline().strip()  # a capo
                    modelloVeicolo = line
                    line = f.readline().strip()  # a capo
                    marcaVeicolo = line
                    line = f.readline().strip()  # a capo
                    # CREAZIONE NUOVO OGGETTO
                    auto = Auto(codiceVeicolo, tipoVeicolo, targaVeicolo, modelloVeicolo, marcaVeicolo, cilindrata,
                                diesel)
                    # AGGIUNTA IN LISTA
                    veicoli.append(auto)
                    # AGGIUNTA IN MAPPA
                    # nomeDizionario[k] = V
                    codVeicolo[codiceVeicolo] = auto
                else:
                    tok = line.split()  # spezzo la linea
                    categoria = tok[0]
                    line = f.readline().strip()  # a capo

                    tok = line.split()  # spezzo la linea
                    # problema del 'for input string in Java'
                    numeroPosti = int(tok[0])
                    line = f.readline().strip()  # a capo

                    modelloVeicolo = line
                    line = f.readline().strip()  # a capo
                    marcaVeicolo = line
                    line = f.readline().strip()  # a capo

                    # CREAZIONE NUOVO OGGETTO
                    furgone = Furgone(codiceVeicolo, tipoVeicolo, targaVeicolo, modelloVeicolo, marcaVeicolo, categoria,
                                      numeroPosti)
                    # AGGIUNTA IN LISTA
                    veicoli.append(furgone)
                    # AGGIUNTA IN MAPPA
                    # nomeDizionario[K] = V
                    codVeicolo[codiceVeicolo] = furgone
                # fine if
            # fine while
            f.close()
        # fine try
        except IOError as i:
            print("IO Error found")
            print(i)
        except Exception as e:
            print("Unexpected error:", sys.exc_info()[0])

        try:  # LETTURA SECONDO FILE
            f = open("posteggi.txt", "r")
            line = f.readline().strip()  # leggo prima linea
            while line != "":
                nomeCognomeCliente = line
                line = f.readline().strip()  # a capo
                post = Posteggio(nomeCognomeCliente)
                # GESTIONE ELENCO(su una riga)
                tok = line.split()
                for i in range(len(tok) // 2):
                    codice = int(tok[i * 2])
                    numGiorni = int(tok[i * 2 + 1])
                    # nomeDizionario[K] --> ottengo il valore
                    e = Elenco(codVeicolo[codice], numGiorni)
                    # Agginta elenco in lista
                    post.addElenco(e)
                posteggi.append(post)
                line = f.readline().strip()  # a capo
            # fine while
            f.close()
        # fine try
        except IOError as i:
            print(i)

        # PUNTO 3:
        print("tipo, targa, codice, modello, marca, cilindrata, diesel, categoria, numero di posti")
        for v in veicoli:
            print(v.toString())

        # PUNTO 4:
        print("\n")
        for p in posteggi:
            print(p.toString())

        # PUNTO 5:
        try:
            codiceLetto = int(self._arg)  # codice letto
            somma = 0
            for post in posteggi:
                for e in post.getElenco():
                    if (e.veicolo == codVeicolo[codiceLetto]):
                        somma = somma + e.costo()
        except IOError as i:
            print(i)
        print(str(codiceLetto) + " " + str(somma))


if __name__ == '__main__':
    parser = argparse.ArgumentParser()
    parser.add_argument('veicolo', action='store')
    pa = parser.parse_args()
    g = Gestione(pa.veicolo)
    g.main()
