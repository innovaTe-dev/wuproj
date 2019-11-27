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
public class TCP_Echo_Client {
    private static InetAddress host;
    private static final int PORT = 1234;

public static void main(String[] args) {
try {
host = InetAddress.getLocalHost();
}
catch (UnknownHostException e) {
System.out.println("Host ID not found!");
System.exit(1);
}
run();
}
private static void run()
{
Socket link = null;
try {
link = new Socket(host, PORT);
BufferedReader in = new BufferedReader(new InputStreamReader(link.getInputStream()));
PrintWriter out = new PrintWriter(link.getOutputStream(),true);
BufferedReader userEntry = new BufferedReader(new InputStreamReader(System.in));
String message, response;
do
{
System.out.println("Enter message: ");
message = userEntry.readLine();
out.println(message);
response = in.readLine();
System.out.println("\nServer> " + response);
}
while (!message.equals("***CLOSE***"));
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
catch (IOException e) {
System.out.println("Unable to disconnect!");
System.exit(1);
}
}
System.out.println("\nClient Terminating...");
}
}