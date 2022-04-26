class Elenco:
    # COSTRUTTORE
    def __init__(self, veicolo, numGiorni):
        self.veicolo = veicolo  # non devo farli private
        self.numGiorni = numGiorni

    # METODI
    # getters
    def getVeicolo(self):
        return self._veicolo

    def getNumGiorni(self):
        return self._numGiorni

    # PER PUNTO 5
    def costo(self):
        if self.veicolo.getTipoVeicolo() == "auto":
            return 10 * self.numGiorni
        else:
            return 15 * self.numGiorni
# CTRL + ALT + L si mette bene l'indentazione
