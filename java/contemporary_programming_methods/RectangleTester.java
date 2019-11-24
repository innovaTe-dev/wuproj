/*
 */
package Lab01;
import java.util.*;
import java.io.*;
/**
 * RectangleTester
 * This class represents the geometry of a Rectangle
 * @author Tbeur
 * @version 1
 * 
 */
public class RectangleTester {

    public static void main(String[] args)
    {
        double w = 0;
        double h = 0;
        Scanner dataReader = new Scanner(System.in);
        System.out.printf("\u000cBeginning program execution...%n");
        System.out.printf("Lab 01 CM245 Beurman%n");
        do
        {
        System.out.printf("Enter in the width of your rectangle:%n");
        w = dataReader.nextDouble();
        System.out.printf("Enter in the height of your rectangle:%n");
        h = dataReader.nextDouble();
        if (w <= 0 || h <= 0)
        {
            System.out.println("Terminating program execution...");
        }
        if (w > 0 || h > 0) {
        Rectangle r1 = new Rectangle(w, h);
        System.out.printf("Printing Rectangle----------------------%n");
        r1.getArea();
        r1.getPerimeter();
        }
                }
        while (w > 0 || h > 0);
        
    }
    
}
