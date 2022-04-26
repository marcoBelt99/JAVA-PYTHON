class Esame: # memorizza coppie codice voto

    # COSTRUTTORE
    def __init__(self, codice, voto):
        self._codice = codice
        self._voto = voto

    # METODI
    def getVotoAsInt(self):
        if  self._voto == "30L" :
            return 31
        else:
            return int(self._voto)

    def getVotoAsString(self):
        return self._voto

    def getCorso(self):
        return self._codice

    # per punto 4 degli studenti
    def toString(self):
        return "(" + str(self._codice) + "," + str(self._voto) + ")"
