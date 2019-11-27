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
public class UDP_Client {
    private static InetAddress host;
    private static final int PORT = 1235;
    private static DatagramSocket dgramSocket;
    private static DatagramPacket inPacket, outPacket;
    private static byte[] buffer;

    public static void main(String[] args)
    {
        System.out.println("Opening port ... \n");
        try
        {
            host = InetAddress.getLocalHost();
        }
        catch (UnknownHostException e)
        {
            System.out.println("Host ID not found!");
            System.exit(1);
        }
        run();
    }
private static void run()
{
    try {
        dgramSocket = new DatagramSocket();
        BufferedReader userEntry = new BufferedReader(new InputStreamReader(System.in));
        String message = "", response = "";
        do
        {
            System.out.print("Enter message: ");
            message = userEntry.readLine();
            if (!message.equals("***CLOSE***"))
            {
                outPacket = new DatagramPacket (
                message.getBytes(),
                message.length(),
                host,
                PORT);
                dgramSocket.send(outPacket);
                buffer = new byte[256];
                inPacket = new DatagramPacket(
                buffer, buffer.length);
                dgramSocket.receive(inPacket);
                response = new String(inPacket.getData(), 0, inPacket.getLength());
                System.out.println("\nServer> " + response);
            }
        }
        while (!message.equals("***CLOSE***"));
    }
    catch (IOException e) {
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
