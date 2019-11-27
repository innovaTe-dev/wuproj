/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PL2;

import java.io.*;
import java.net.*;
import java.util.*;

/**
 *
 * @author Tbeur
 */
public class UDPPinger_pt2 {
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
        ArrayList<Long> list = new ArrayList<Long>();
        int lostcount = 0;
        int goodcount = 0;
        int total = 0;
        InetAddress catchaddress = null;
        try {
            dgramSocket = new DatagramSocket();
            dgramSocket.setSoTimeout(1000);
        } catch (SocketException e) {
            System.out.println("Error setting timeout TIMEOUT: " + e);
        }
        for (int i = 1; i < 11; i++) {
            total++;
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
                InetAddress serverAddress = inPacket.getAddress();
                catchaddress = serverAddress;
                Date after = new Date();
                long receiveTime = after.getTime();
                long RTT = receiveTime - sendTime;
                list.add(RTT);
                goodcount++;
                System.out.println("Reply from " + serverAddress.getHostAddress() + ":" + " bytes=" + fullPing.length() + ",time=" + RTT + "ms");
                if (total == 10) {
                  double pcktloss = (((double)lostcount / (double)total) * 100);
                  int pcktlosspct = (int) pcktloss;
                  long avg = getAverage(list, goodcount);
                  System.out.println("Ping statistics for " + serverAddress.getHostAddress() + ":");
                  System.out.println("  Packets: Sent = " + i + "," + " Received " + goodcount + ", Lost = " + lostcount + "," + " " + "(" + pcktlosspct + "%" + " loss)");
                  System.out.println("Approximate round trip times in milli-seconds:");
                  System.out.println("  Minimum = " + Collections.max(list) + "ms" + " Maximum = " + Collections.min(list) + "ms" + ", " + "Average = " + avg + "ms"); 
                }
            } catch (IOException ex) {
                lostcount++;
                System.out.println("***TIMEOUT***");
               if (total == 10) {
                  double pcktloss = (((double)lostcount / (double)total) * 100);
                  int pcktlosspct = (int) pcktloss;
                  long avg = getAverage(list, goodcount);
                  System.out.println("Ping statistics for " + catchaddress.getHostAddress() + ":");
                  System.out.println("  Packets: Sent = " + i + "," + " Received " + goodcount + ", Lost = " + lostcount + "," + " " + "(" + pcktlosspct + "%" + " loss)");
                  System.out.println("Approximate round trip times in milli-seconds:");
                  System.out.println("  Minimum = " + Collections.min(list) + "ms" + " Maximum = " + Collections.max(list) + "ms" + ", " + "Average = " + avg + "ms"); 
                }
                }
            }
        System.out.println("\n* Closing connection ... *\n");
            //9. Close the datagram socket
            dgramSocket.close();
    }
    public static long getAverage(ArrayList<Long> Array, int total) {
        long sum = 0;
        int p = 0;
        for (int k = 0; k < total; k++) {
            sum = sum + Array.get(k);
            p++;
        }
        long avg = sum / p;
        return avg;
}
    
}
