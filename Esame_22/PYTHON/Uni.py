import sys
import argparse # mi serve per fare il parsing

# IMPORTO LE CLASSI
from Corso import Corso # from Modulo import Classe
from Teoria import Teoria
from  Laboratorio import  Laboratorio
from Studente import  Studente
from Esame import  Esame


# Definisco il programma dentro una CLASSE, usando la tecnica di trasformare un modulo
# in un programma mettendolo alla fine del codice con l'if
class Uni:
    #COSTRUTTORE
    def __init__(self, arg): # prende un argomento e lo memorizza in _arg
        self._arg = arg

    def main(self): # CREO IL METODO MAIN che poi richiamo in fondo
        corsi = [] # definisco i corsi e gli studenti come liste inizialmente vuote
        studenti = []
        nomeCorsi = {} # dizionario che associa i codici del corso al loro nome
        # Il dizionario serve per rispondere alla domanda 5 --> nome del corso in cui si è preso il voto + alto

        try:
            f = open("corsi.txt","rt")
            line = f.readline().strip() # readline() restituisce una linea con l'accapo
                                        # il metodo strip() rimuove l'accapo finale
            while line != "" : # Python finisce di leggere le righe quando restituisce la riga vuota
                tok = line.split() # con split posso memorizzare le parole di una riga in una lista
                codiceCorso = int(tok[0]) ##cast esplicito##
                tipoCorso = tok[1]
                line = f.readline().strip() # leggo la nuova riga gestendo l'accapo
                nomeCorso = line
                line = f.readline().strip() # leggo la nuova riga gestendo l'accapo
                docente = line

                nomeCorsi[codiceCorso] = nomeCorso # aggiungo questa associazione (codice,nome)
                                                   # al dizionario nomeCorsi --> MAPPA
                line = f.readline().strip() # leggo la nuova riga gestendo l'accapo
                if tipoCorso == "teoria":
                    tok = line.split()
                    codiceAula = tok[0]
                    oreSettimanali = tok[1]
                    orePerLezione = tok[2]
                                                # creo oggetto
                    corsoT = Teoria(codiceCorso, nomeCorso, docente, codiceAula, oreSettimanali,orePerLezione)
                    corsi.append( corsoT ) # aggiungo in LISTA
                else:
                    nomeLaboratorio = line
                    line = f.readline().strip()
                    nomeAssistente = line
                    line = f.readline().strip()
                    postazioni = int(line)

                    corsoL = Laboratorio(codiceCorso, nomeCorso, docente, nomeLaboratorio, nomeAssistente, postazioni)
                    corsi.append( corsoL )
                line = f.readline().strip() # leggo riga vuota
                line = f.readline().strip() # leggo la prossima riga per tornare al ciclo while
            f.close() # chiudo il file
        except IOError:
            print("IO Error found")
        except:
            print("Unexpected error:", sys.exc_info()[0] )
            raise # rilancia l'eccezione

        try:
            f = open("studenti.txt","rt")
            line = f.readline().strip()
            while line!= "":
                matricola = int(line)
                line = f.readline().strip()
                nomeStudente = line

                stud = Studente(matricola,nomeStudente)
                studenti.append(stud)
                line = f.readline().strip()
                while line != "" and line != "\n":
                    tok = line.split()
                    codice = int(tok[0])
                    voto = tok[1]
                    e = Esame(codice, voto)
                    stud.addEsame(e)
                    line = f.readline().strip()
                line = f.readline().strip()
            f.close() #
        except(IOError):
            print("IO Error found.")
        except:
            print("Unexpected error:", sys.exc_info()[0])

        # PUNTO 3
        print("nome, codice, docente, tipo, aula, ore sett., ore/lez., lab., assistente, postazioni")
        for c in corsi:
            print( c.toString() )

        # PUNTO 4
        for s in studenti:
            print( s.toString() )
        print("\n")

        # PUNTO 5: leggere da riga di comando il codice, e stampare nome e cognome dello studente , nome del corso
        # in cui ha preso il voto più alto e il voto
        for s in studenti:
            if( s.getMatricola() == int(self._arg) ): # ottengo la matricola dello studente e la confronto
                                                      # con l'intero presente in self._arg passato come argomento
                maxe = s.votoMax()
                codc = maxe.getCorso()
                print(s.getNome() + " " + nomeCorsi[codc] + " " + maxe.getVotoAsString() )

# Se nome = main --> sto eseguendo il codice da riga di comando
# chiamo il metodo ArgumentParser() del modulo argparse per restituire un parser
# aggiungo l'argomento matricola con l'azione di memorizzare l'argomento
# chiamo il metodo parse_args() e metto il risultato in matr
# creo un oggetto di classe Uni passandogli la matricola
# chiamo il main della classe Uni
if __name__ == '__main__':
    parser = argparse.ArgumentParser()
    parser.add_argument('matricola', action='store')
    matr = parser.parse_args()
    u = Uni(matr.matricola) # self._arg è la matricola che ho letto da tastiera e che ho passato al costruttore
                            # init che l'ha messa nella variabile arg
    u.main()
# --> Per il punto 5: vuol dire che il codice dello studente viene passato come matricola
# e viene messo dal costruttore Uni() dentro la variabile arg definita all'inizio, quindi
