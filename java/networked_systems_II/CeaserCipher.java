/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PL4Handouts;


public class CeaserCipher {

    private static String plain = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ 1234567890,'.";
    //private static String plain = "abcde";
    public static String encrypt(String msg, int offset) {
        String eMsg = "";
        for (int k = 0; k < msg.length(); k++) {
            int ci = plain.indexOf(msg.charAt(k));
            ci = (offset + ci) % (plain.length());
            eMsg = eMsg + plain.charAt(ci);
        }
        return eMsg;
    }

    public static String decrypt(String msg, int offset) {
        String dMsg = "";

        for (int k = 0; k < msg.length(); k++) {
            int ci = 0;
            try {
                //System.out.print(msg.charAt(k) + " ");
                ci = plain.indexOf(msg.charAt(k));
                //System.out.println(" ci> " +ci + "new ci> " + (ci-offset));
                ci = ((ci - offset) + plain.length()) % plain.length();
                dMsg = dMsg + plain.charAt(ci);
            } catch (StringIndexOutOfBoundsException ex) {
                //I put this in for debugging. 
                System.out.println("Index out of bounds at k = " + k
                    + " ci = " + ci);
            }
        }

        return dMsg;
    }

    public static void main(String[] args) {
        int offset = 3;
        String msg = "Hello Washburn.  It's Spring.";
        System.out.println("Inital Msg =====> " + msg);
        String enMsg = encrypt(msg, offset);
        System.out.println("Encrypted Msg ==> " + enMsg);
        String deMsg = decrypt(enMsg, offset);
        System.out.println("Decrypted Msg ==> " + deMsg);
    }
}
