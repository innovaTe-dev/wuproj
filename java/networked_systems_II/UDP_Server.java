/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package networking;

import java.io.*;
import java.net.*;

/**
 *
 * @author Tbeur
 */
public class UDP_Server {
    private static InetAddress host;
    private static final int PORT = 1235;
    private static DatagramSocket dgramSocket;
    private static DatagramPacket inPacket, outPacket;
    private static byte[] buffer;

    public static void main(String[] args)
    {
        System.out.println("Opening port ... \n");
        try {
            dgramSocket = new DatagramSocket(PORT);
        }
        catch (SocketException e)
        {
            System.out.println("Unable to attach to port!");
            System.exit(1);
        }
        run();
    }
    private static void run()
    {
        try {
            String messageIn, messageOut;
            int numMessages = 0;
            do
            {
                buffer = new byte[256];
                inPacket = new DatagramPacket(buffer, buffer.length);
                dgramSocket.receive(inPacket);
                InetAddress clientAddress = inPacket.getAddress();
                int clientPort = inPacket.getPort();
                messageIn = new String(inPacket.getData(), 0, inPacket.getLength());
                System.out.println("message received");
                numMessages++;
                messageOut = ("Message " + numMessages + ": " + messageIn);
                outPacket = new DatagramPacket (
                messageOut.getBytes(),
                messageOut.length(),
                clientAddress,
                clientPort);
                dgramSocket.send(outPacket);
            }
            while (true);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally {
            System.out.println("\n* Closing connection ... *\n");
            dgramSocket.close();
        }
    }
}
            }
        }
    }
        }
