from Elenco import Elenco


class Posteggio:
    # COSTRUTTRE:
    def __init__(self, nomeCognomeCliente):
        self._nomeCognomeCliente = nomeCognomeCliente
        self._elenco = []

    # METODO DI AGGIUNTA IN LISTA DELL'ELENCO
    def addElenco(self, e):
        self._elenco.append(e)

    # METODO PER PUNTO 4: scansione eleco e somma di un attributo di esso
    def costoTotalePosteggio(self):
        somma = 0
        for e in self._elenco:
            if e.veicolo.getTipoVeicolo() == "auto":
                somma = somma + e.numGiorni * 10
            else:
                somma = somma + e.numGiorni * 15
        return somma

    # TOSTRING PUNTO 4
    def toString(self):
        return self._nomeCognomeCliente + " " + str(self.costoTotalePosteggio())

    #METODO PER OTTENERE L'ELENCO: utile per punto 5
    def getElenco(self):
        return self._elenco
