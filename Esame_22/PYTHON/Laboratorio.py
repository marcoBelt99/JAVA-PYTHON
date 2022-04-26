from Corso import Corso

class Laboratorio(Corso): # classe Laboratorio che eredita da Corso

    # COSTRUTTORE
    def __init__(self, codiceCorso, nomeCorso, docente, nomeLaboratorio, nomeAssistente, postazioni ):
        super().__init__(codiceCorso, nomeCorso, docente)
        self._nomeLaboratorio = nomeLaboratorio
        self._nomeAssistente = nomeAssistente
        self._postazioni = postazioni

    # METODI
    def toString(self):
        return super().toString() + "lab" +  "\t-\t-\t-\t" + self._nomeLaboratorio + \
               "\t" + self._nomeAssistente + "\t" + str(self._postazioni)




