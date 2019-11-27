package PL4Handouts;
import java.io.*;
import java.net.*;
import java.util.*;
/**
 *
 * @author cecil.schmidt
 * This program demonstrates the use of a block cipher which is used
 * in cryptography applications.  The length of the block three.
 * 
**/
public class BlockCipher {
    private static int[] block_cipher = {0b110,0b111,0b101,0b100,
                                         0b011,0b010,0b000,0b001};
    public static int k_s(int arg){
        return block_cipher[arg];
    }
    
    public static void main(String[] args) {
        
        /* here is another example with an r value included. */ 
        System.out.println("******************************");
        Date date = new Date();
        System.out.println("PL 4 - Beurman " + date);
        System.out.println("");
        int iv_0 = 0b001;
        int m_1 = 0b010; //the inital message
        System.out.println("Original number as binary ==> " + formatAsBin(m_1));
        int c_1 = k_s(m_1 ^ iv_0);
        int s_1 = k_s(c_1);
        int m_2 = s_1 ^ iv_0;
        System.out.println("c_minus1         ===========> " + formatAsBin(iv_0));
        System.out.println("c_current        ===========> " + formatAsBin(c_1));
        System.out.println("Encrypted binary ===========> " + formatAsBin(c_1));
        System.out.println("Decrypted s      ===========> " + formatAsBin(s_1));
        System.out.println("Decrypted binary ===========> " + formatAsBin(m_1));
        System.out.println("");
        System.out.println("Original number as binary ==> " + formatAsBin(m_1));
        int c_2 = k_s(m_2 ^ c_1);
        int s_2 = k_s(c_2);
        System.out.println("c_minus1         ===========> " + formatAsBin(c_1));
        System.out.println("c_current        ===========> " + formatAsBin(c_2));
        System.out.println("Encrypted binary ===========> " + formatAsBin(c_2));
        System.out.println("Decrypted s      ===========> " + formatAsBin(s_2));
        System.out.println("Decrypted binary ===========> " + formatAsBin(m_1));
        System.out.println("");
        System.out.println("Original number as binary ==> " + formatAsBin(m_1));
        int c_3 = k_s(m_2 ^ c_2);
        int s_3 = k_s(c_3);
        System.out.println("c_minus1         ===========> " + formatAsBin(c_2));
        System.out.println("c_current        ===========> " + formatAsBin(c_3));
        System.out.println("Encrypted binary ===========> " + formatAsBin(c_3));
        System.out.println("Decrypted s      ===========> " + formatAsBin(s_3));
        System.out.println("Decrypted binary ===========> " + formatAsBin(m_1));
        
    }
    public static String formatAsBin(int num) {
        return String.format("%3s", Integer.toBinaryString(num)).replace(' ', '0');
        //int k = Integer.valueOf(s, 2);
        //System.out.println(k);
    }
}
