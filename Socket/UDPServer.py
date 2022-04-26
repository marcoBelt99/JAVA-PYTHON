from socket import *
serverPort = 12000
serverSocket = socket(AF_INET, SOCK_DGRAM)
# Assegno alla socket lato server il numero di porta 12000
serverSocket.bind(('', serverPort))
print("Il server è pronto a ricevere")
while 1:
    # message contiene i dati, clientAddress contiene l'indirizzo IP ed il numero di porta del client
    # in questo caso UDPServer userà l'indirizzo come indirizzo di risposta, come avviene con la posta
    # ordinaria
    message, clientAddress = serverSocket.recvfrom(2048)
    modifiedMessage = message.decode().upper()
    serverSocket.sendto(modifiedMessage.encode(), clientAddress)
