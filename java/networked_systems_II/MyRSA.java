/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PL5;
import java.io.*;
import java.util.*;
import java.math.BigInteger;

/**
 *
 * @author Tbeur
 */
public class MyRSA {
    final static String plain = "abcdefghijklmnopqrstuvwxyz";
    public static void main(String[] args) {
        long c = 0;
        Date date = new Date();
        System.out.println("CM361 PL5 Simple RSA - Trevor Beurman " + date);
        System.out.printf("PL   ");
        System.out.printf("m\t  ");
        System.out.printf("  m**e  ");
        System.out.printf("c\t\t\t\t\tc**d");
        System.out.printf("           m");
        System.out.printf(" PL\n");
        for (int k = 0; k < plain.length(); k++) {
            char pll = plain.charAt(k);
            String pl = Character.toString(pll);
            System.out.printf("%s", pl);
            c = encrypt(pl);
            String plll = decrypt(c);
            System.out.printf("%2s\n", plll);
        }
    }
    
    public static long encrypt(String letter) {
        int n = 35;
        int e = 5;
        int m = plain.indexOf(letter) + 1;
        System.out.printf("%5d", m);
        long m_e = (long)Math.pow(m,e);
        System.out.printf("%10d",m_e);
        long c = (long)(Math.pow(m,e) % n);
        System.out.printf("%3d", c);
        return c;
    }
    
    public static String decrypt(long c) {
        int d = 29;
        int n = 35;
        BigInteger temp = new BigInteger(c + "");
        BigInteger c_d = temp.pow(d);
        System.out.printf("%50s", c_d);
        BigInteger nbig = new BigInteger(n+"");
        temp = c_d.mod(nbig);
        int m = temp.intValue();
        System.out.printf("%3s", m);
        return "" + plain.charAt(m-1);
    }
}
