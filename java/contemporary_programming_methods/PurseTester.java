/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab02;

import java.io.*;
import java.util.*;

/**
 *
 * @author Tbeur
 */
public class PurseTester {

    public static void main(String[] args) throws FileNotFoundException {
        Purse p = new Purse();
        Scanner coinReader = new Scanner(new File("coins.data"));
        while (coinReader.hasNext()) {
            String rec = coinReader.nextLine();
            String[] fields = rec.split(", ");
            double ref = Double.parseDouble(fields[1]);
            Coin c = new Coin(fields[0], ref);
            p.add(c);
        }
        prntPurse(p);
        double sum = p.sum();
        System.out.printf("sum:%4.2f%n", sum);
        double maxValue = p.maxValue();
        System.out.printf("maxValue:%4.2f%n", maxValue);
        Coin maxCoin = p.maxCoin();
        System.out.printf("maxCoin:");
        prntCoin(maxCoin);
        p.removeCoin("PENNY");
        prntPurse(p);
        sum = p.sum();
        System.out.printf("sum:%4.2f%n", sum);
        Coin c = new Coin("DIME", 0.10);
        p.add(c);
        p.add(c);
        prntPurse(p);
        sum = p.sum();
        System.out.printf("sum:%4.2f%n", sum);
    }

    public static void prntPurse(Purse p) {
        Coin[] list = p.getCoins();
        System.out.println("IN THE PURSE:");
        for (int k = 0; k < p.getSize(); k++) {
            System.out.printf("%s,", list[k].getName());
            System.out.printf("%4.2f%n", list[k].getValue());
        }
    }

    public static void prntCoin(Coin c) {
        System.out.printf("%s,", c.getName());
        System.out.printf("%4.2f%n", c.getValue());
    }
}
