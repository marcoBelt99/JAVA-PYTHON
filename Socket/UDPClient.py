# Includo il m odulo socket,  base di tutte le comunicazioni di rete in Python
from socket import *

# Assegno alla variabile di tipo stringa il nome dell'host (indirizzo IP del Server, es: "128.138.32.126")
serverName = 'hostname'

# Assegno alla variabile di tipo intero il valore 1200
serverPort = 1200

# Creo la socket lato client, memorizzandone un riferimento in una variabile chiamata clientSocket
#   primo parametro:    indica la famiglia di indirizzi:    AF_INET = IPv4
#   secondo parametro:  indica che la socket è di tipo UDP: SOCK_DGRAM
clientSocket = socket(AF_INET, SOCK_DGRAM)

# Creo un messaggio da inviare attraverso la porta del processo client
message = input('Frase in minuscolo')

# Invio il messaggio attraverso la socket all'host di destinazione:
#   converto il messaggio da stringa a byte per poterlo inviare nella socket.
#   sendto() attacca l'indirizzo di destinazione (serveName, serverPort) al messaggio e invia
#   il pacchetto risultante nella socket clientSocket
clientSocket.sendto(message.encode(), (serverName, serverPort))

# quando un pacchetto arriva da Internet alla socket client, i dati contenuti vengono assegnati alla variabile
#
modifiedMessage, serverAddress = clientSocket.recvfrom(2048)

print(modifiedMessage.decode())

clientSocket.close()