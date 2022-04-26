from Veicolo import Veicolo


class Auto(Veicolo):
    # COSTRUTTORE
    def __init__(self, codiceVeicolo, tipoVeicolo, targaVeicolo, modelloVeicolo, marcaVeicolo,
                 cilindrata, diesel):
        super().__init__(codiceVeicolo, tipoVeicolo, targaVeicolo, modelloVeicolo, marcaVeicolo)
        self._cilindrata = cilindrata
        self._diesel = diesel

    # TOSTRING PUNTO 3
    def toString(self):
        return super().toString() + str(self._cilindrata) + "\t" + str(self._diesel) + "\t-\t-\t"
