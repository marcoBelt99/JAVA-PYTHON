class Veicolo:
    # COSTRUTTORE
    def __init__(self, codiceVeicolo, tipoVeicolo, targaVeicolo, modelloVeicolo, marcaVeicolo):
        self._codiceVeicolo = codiceVeicolo
        self._tipoVeicolo = tipoVeicolo
        self._targaVeicolo = targaVeicolo
        self._modelloVeicolo = modelloVeicolo
        self._marcaVeicolo = marcaVeicolo

    # TOSTRING PUNTO 3
    def toString(self):
        return self._tipoVeicolo + "\t" + self._targaVeicolo + "\t" + str(self._codiceVeicolo) + \
               "\t" + self._modelloVeicolo + "\t" + self._marcaVeicolo

    # METODO PER PUNTO 4
    def getTipoVeicolo(self):
        return self._tipoVeicolo
