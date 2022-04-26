from Corso import Corso # importo Corso dal modulo Corso

class Teoria(Corso): # classe Teoria che eredita da corso

    # COSTRUTTORE, esso:
    def __init__(self, codiceCorso, nomeCorso, docente, codiceAula, oreSettimanali, orePerLezione):
        super().__init__(codiceCorso, nomeCorso, docente) # chiama il costruttore della superclasse
        self._codiceAula = codiceAula   # ed assegna agli attributi _
        self._oreSettimanali = oreSettimanali
        self._orePerLezione = orePerLezione

    # METODI:
    def toString(self):
        return super().toString() + "teoria\t" + self._codiceAula + "\t" + \
               self._oreSettimanali + "\t" + self._orePerLezione + "\t-\t-\t-\t"
