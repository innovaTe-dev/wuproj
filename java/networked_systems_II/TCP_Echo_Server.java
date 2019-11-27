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
public class TCP_Echo_Server {
    private static ServerSocket listener;
    private static final int PORT = 1234;
 public static void main(String[] args) {
     System.out.println("Opening port ... \n");
     try
     {
         listener = new ServerSocket(PORT);
     }
     catch (IOException e) {
         System.out.println("Unable to attach to port!");
         System.exit(1);
     }
     do
     {
         run();
     }
     while(true);
 }
 private static void run() {
     Socket link = null;
     try {
     link = listener.accept();
     BufferedReader in = new BufferedReader(new InputStreamReader(link.getInputStream()));
     PrintWriter out = new PrintWriter(link.getOutputStream(),true);
     int numMessages = 0;
     String message = in.readLine();
     
     while(!message.equals("***CLOSE***"))
     {
         System.out.println("Message received");
         numMessages++;
         out.println("Message " + numMessages + ": " + message);
         message = in.readLine();
     }
     out.println(numMessages + " messages received.");
 }
 catch (IOException e)
 {
     e.printStackTrace();
 }
 finally
 {
     try
     {
         System.out.println("\n* Closing connection ...");
         link.close();
     }
     catch (IOException e) 
     {
         System.out.println("Unable to disconnect!");
         System.exit(1);
     }
         
     }
 }
}
 
