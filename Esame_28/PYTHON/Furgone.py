from Veicolo import Veicolo


class Furgone(Veicolo):
    # COSTRUTTORE
    def __init__(self, codiceVeicolo, tipoVeicolo, targaVeicolo, modelloVeicolo, marcaVeicolo,
                 categoria, numPosti):
        super().__init__(codiceVeicolo, tipoVeicolo, targaVeicolo, modelloVeicolo, marcaVeicolo)
        self._categoria = categoria
        self._numPosti = numPosti

    # TOSTRING PUNTO 3
    def toString(self):
        return super().toString() + "\t-\t-\t" + self._categoria + "\t" + str(self._numPosti)
