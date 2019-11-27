/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PL2;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Random;

public class UDPServer {

    private static final int PORT = 1235;
    private static DatagramSocket dgramSocket;
    private static DatagramPacket inPacket, outPacket;
    private static byte[] buffer;

    public static void main(String[] args) {
        System.out.println("Waiting to serve at port " + PORT + "...\n");
        try {
            //1. Create the DatagramSocket object.
            dgramSocket = new DatagramSocket(PORT);
        } catch (SocketException e) {
            System.out.println("Unable to attach to port!");
            System.exit(1);
        }
        serveRequest();
    }

    private static void
            serveRequest() {
        try {
            String messageIn, messageOut;
            do {
                //2. Create a buffer for incomming datagrams
                buffer = new byte[256];
                //3. Create a DatagramPacket for the incomming datagrams
                inPacket = new DatagramPacket(buffer, buffer.length);
                //4. Accept an incomming datagram.
                dgramSocket.receive(inPacket); //inPacket is updated
                //5. Accept the sender's address and port from the packet
                InetAddress clientAddress = inPacket.getAddress();
                int clientPort = inPacket.getPort();
                System.out.printf("Client IP:Port ==> %s:%d%n",
                        clientAddress.getHostAddress(), clientPort);
                //6. Retrieve the data from the buffer 
                messageIn = new String(inPacket.getData() //bytearray
                        ,
                         0, //start position within the array
                        inPacket.getLength()); //full size of array
                //Echo the message that was received
                System.out.println("Message received==>" + messageIn);
                //create the messageOut by converting messageIn to uppercase.
                messageOut = messageIn.toUpperCase();
                //create the new packet with the message set to uppercase
                outPacket = new DatagramPacket(
                        messageOut.getBytes(),
                        messageOut.length(),
                        clientAddress,
                        clientPort);
                //8. Send the response datagram randomly to mimic the
                //the dropping of a packet
                int rand = (int) (Math.random() * 10);
                if (rand >= 4) {
                    dgramSocket.send(outPacket);
                }
            } while (true);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.out.println("\n* Closing connection ... *\n");
            //9. Close the datagram socket
            dgramSocket.close();
        }
    }
}
