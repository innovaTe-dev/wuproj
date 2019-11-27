/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PL2;

import java.io.*;
import java.util.*;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Tbeur
 */
public class UDPPinger_pt1 {

    private static InetAddress host;
    private static final int PORT = 1235;
    private static DatagramSocket dgramSocket;
    private static DatagramPacket inPacket, outPacket;
    private static byte[] buffer;

    public static void main(String[] args) {
        System.out.println("Opening port ... \n");
        try {
            host = InetAddress.getLocalHost();
        } catch (UnknownHostException e) {
            System.out.println("Host ID not found!");
            System.exit(1);
        }
        sendRequest();
    }

    public static void sendRequest() {
        try {
            dgramSocket = new DatagramSocket();
            dgramSocket.setSoTimeout(1000);
        } catch (SocketException e) {
            System.out.println("Error setting timeout TIMEOUT: " + e);
        }
        for (int i = 1; i < 11; i++) {
            try {
                String ping = "PING " + i;
                Date before = new Date();
                long sendTime = before.getTime();
                String fullPing = ping + " " + before;
                outPacket = new DatagramPacket(fullPing.getBytes(), fullPing.length(), host, PORT);
                dgramSocket.send(outPacket);
                buffer = new byte[256];
                inPacket = new DatagramPacket(
                buffer, buffer.length);
                dgramSocket.receive(inPacket);
                Date after = new Date();
                long receiveTime = after.getTime();
                long RTT = receiveTime - sendTime;
                System.out.println(fullPing + " " + "RTT= " + RTT);
            } catch (IOException ex) {
                System.out.println("***TIMEOUT***");
            }
        }
            System.out.println("\n* Closing connection ... *\n");
            //9. Close the datagram socket
            dgramSocket.close();
        }
    }
