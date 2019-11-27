# see https://docs.python.org/3/tutorial/inputoutput.html
# Import socket module

from socket import * 
import sys # In order to terminate the program

# Create a TCP server socket

serverSocket = socket(AF_INET, SOCK_STREAM)

# Assign a port number
serverPort = 80

# Bind the socket to server address and server port
serverSocket.bind(("", serverPort))

# Listen to at most 1 connection at a time
serverSocket.listen(1)

# Server should be up and running and listening to the incoming connections
print('The server is ready to receive')
while True:
	# Set up a new connection from the client
	connectionSocket, addr = serverSocket.accept()

	# If an exception occurs during the execution of try clause
	# the rest of the clause is skipped
	# If the exception type matches the word after except
	# the except clause is executed
	try:
		# Receives the request message from the client
		message = connectionSocket.recv(1024).decode()
		# Extract the path of the requested object from the message
		# Open and read the file and store it in a temporary buffer
		# Send the HTTP response header line to the connection #  #   socket
		# Send the content of the requested file to the connection socket  
        #   one char at a time
        # Terminate message  
		# Close the client connection socket
		connectionSocket.close()

	except IOError: # Here is an error handler for you
			# Send HTTP response message for file not found
			connectionSocket.send("HTTP/1.1 404 Not Found\r\n\r\n".encode())
			connectionSocket.send("<html><head></head><body><h1>404 Not Found</h1></body></html>\r\n".encode())
			# Close the client connection socket
			connectionSocket.close()

serverSocket.close()  
sys.exit()#Terminate the program after sending the corresponding data
