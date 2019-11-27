from socket import *
import time
import sys
argv = sys.argv
serverName = argv[1]
serverPort = argv[2]
timeout = 1
serverPort = int(serverPort)
clientSocket = socket(AF_INET, SOCK_DGRAM)
clientSocket.settimeout(timeout)
k = 0
while k < 10:
    k = k + 1
    data = 'Ping ' + str(k) + " " + time.asctime()
    try:
        rttb = time.time()
        clientSocket.sendto(data.encode(),(serverName, serverPort))
        message, address = clientSocket.recvfrom(2048)
        rtta = time.time()
        print("Reply from " + address[0] + ": " + message.decode())
        print("RTT: " + str(rtta - rttb))
    except:
        outtime = 'Request timed out.'
        print(outtime)
        continue
clientSocket.close()
