#udp_client.py
#python 3 
#I tested this as a client/server program on my windows machine using
#my localhost as the hostname.  Note: in textbook raw_input should be converted to input
#in order to support python 3.
#To execute on windows given python 3 is installed:
#    python <dir>\udp_client.py

from socket import *
serverName = 'localhost' #change this to an ip address when you are ready
#serverName = 'cisdeb.washburn.edu' #change this to an ip address when you are ready
serverPort = 12000
clientSocket = socket(AF_INET,SOCK_DGRAM)
message = input('Input lowercase sentence:')
clientSocket.sendto(message.encode(),(serverName,serverPort))
modifiedMessage, serverAddress = clientSocket.recvfrom(2048)
print(modifiedMessage.decode())
clientSocket.close()
