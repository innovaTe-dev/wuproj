/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab04;
import java.util.*;
import java.io.*;

/**
 *
 * @author Tbeur
 */
public class HundredInt {
    public static void main(String[] args)
    {
        Scanner dataReader = new Scanner(System.in);
        int[] integers = new int[100];
        int x = 0;
        for (int k = 0; k < 100; k++)
        {
            integers[k] = (int) Math.floor(Math.random()*100)+ 1;
        }
        for (int j = 0; j >= 0; j++)
        {
        System.out.println("Which element would you like to access?(number):");
        x = dataReader.nextInt();
        try {System.out.println(integers[x]);}
        catch (ArrayIndexOutOfBoundsException ex)
        {
        if (x < 0)
        {
            j = -2;
        }
            System.out.println("Out of Bounds");
        }
        }
    }
    
}
