from Esame import Esame
class Studente:

    # COSTRUTTORE
    def __init__(self, matricola , nomeStudente):
        self._matricola = matricola # _ vuol dire che attributo è privato
        self._nomeStudente = nomeStudente
        # lkl = LinkedList()
        # self._libretto = lkl
        self._libretto = [] # libretto dello studente nella forma di un elenco di corsi
        # lo assegno a lista vuota perchè al momento non ci sono esami

    # METODI
    def getMatricola(self):
        return self._matricola

    def getNome(self):
        return self._nomeStudente

    def addEsame(self , e): # e e' un oggetto della classe Esame
        self._libretto.append( e ) # aggiungo l'esame al libretto usando append

    # PUNTO 4: per arrivare a fare la toString
    def getMedia(self):
        tot = 0
        for e in self._libretto: # scandisco tutti gli esami e nel libretto
            tot = tot + e.getVotoAsInt() # per ogni esame chiamo il metodo getVotoAsInt()
        return ( tot/len( self._libretto ) ) # totale voti / lunghezza elenco

    def librString(self): # questo metodo traduce il libretto in una stringa
        res = "" # il risultato inizialmente e' la stringa vuota
        for e in self._libretto: # scandisco tutti gli esami del libretto
            res = res + e.toString() # aggiungo la conversione dell'esaeme al risultato
        return  res # restituisco il risultato

    def toString(self):
        media = self.getMedia()
        libretto = self.librString()
        return self._nomeStudente + "\t" + str(media) + "\t" + str(libretto)

    # PUNTO 5:
    def votoMax(self):
        maxVote = 0 # inizializzo il voto massimo a zero
        for e in self._libretto: # scandisco gli esami del libretto
            if( e.getVotoAsInt() > maxVote ): # prendo il voto come un intero e lo confronto maxVote
                maxVote = e.getVotoAsInt() # assegno maxVote al voto ottenuto come intero
                maxe = e # assegno e a maxe
        return maxe # ritorno maxe
