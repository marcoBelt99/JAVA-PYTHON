
class Corso:
    #### Gli attributi della classe sono questi _attributo ####

    # COSTRUTTORE
    def __init__(self, codiceCorso, nomeCorso, docente):
        self._codiceCorso = codiceCorso
        self._nomeCorso = nomeCorso
        self._docente = docente
    # _ indica che sono attributi ad uso interno, che non dovrebbero essere usati per
    # l'accesso dall'esterno

    #  METODI

    def toString(self):
        return self._nomeCorso + "\t" + str(self._codiceCorso) + "\t" + \
               self._docente + "\t"
    # con \ mi fa andare a capo col codice senza problemi
