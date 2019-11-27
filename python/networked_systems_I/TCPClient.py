from socket import *
serverName = 'localhost'
serverPort = 12000
clientSocket = socket(AF_INET, SOCK_STREAM)
clientSocket.connect((serverName, serverPort))
command = input
clientSocket.send(command.encode())
print('From Server: ' , modifiedSentence.decode())
clientSocket.close()
