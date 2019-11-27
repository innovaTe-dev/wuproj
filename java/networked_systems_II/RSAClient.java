package PL5;

import static PL5.MyRSA.plain;
import java.io.*;
import java.net.*;
import java.util.*;

public class RSAClient {

    private static InetAddress host;
    private static final int PORT = 1234;
    private static Socket link;
    private static Scanner in;
    private static PrintWriter out;
    private static Scanner keyboard;

    public static void main(String[] args) throws IOException {
        try {
            host = InetAddress.getLocalHost();
            link = new Socket(host, PORT);
            in = new Scanner(
                    new InputStreamReader(
                            link.getInputStream()));
            out = new PrintWriter(
                    link.getOutputStream(), true);

            keyboard = new Scanner(
                    new InputStreamReader(System.in));

            String message;
            String response;
                System.out.print(
                        "Enter message: ");
                message = keyboard.nextLine();
                //Send message to server on
                //the socket's output stream...
                char[] letters = message.toCharArray();
                for (int k = 0; k < letters.length; k++) {
                    String temp = letters[k] + "";
                    long d = encrypt(temp);
                    out.println(d);

                //Accept response from server on
                //the socket's input stream...
                response = in.nextLine();

                //Display server's response to user...
                System.out.println(response);
            }
        } catch (UnknownHostException uhEx) {
            System.out.println(
                    "\nHost ID not found!\n");
        } catch (IOException ioEx) {
            ioEx.printStackTrace();
        } finally {
            try {
                if (link != null) {
                    System.out.println(
                            "Closing down connection...");
                    link.close();
    }
            } catch (IOException ioEx) {
                ioEx.printStackTrace();
            }
        }
    }
    
    public static long encrypt(String letter) {
        int n = 35;
        int e = 5;
        int m = plain.indexOf(letter) + 1;
        long m_e = (long)Math.pow(m,e);
        long c = (long)(Math.pow(m,e) % n);
        return c;
    }
}
