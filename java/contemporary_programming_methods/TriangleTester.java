/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab03;
import java.util.Scanner;

/**
 *
 * @author Tbeur
 */
public class TriangleTester {
    public static void main(String[] args)
    {
        System.out.println("CM245 Contemporary Programming Methods - Lab03 - TriangleTester");
        for (int k = 0; k < 4; k++)
        {
            double side1 = 0;
            double side2 = 0;
            double side3 = 0;
            boolean filled = true;
            String color = "white";
            Scanner readerDb = new Scanner(System.in);
            Scanner readerTorF = new Scanner(System.in);
            Scanner readerColor = new Scanner(System.in);
            System.out.println("Enter in three sides for the traingle:");
            side1 = readerDb.nextDouble();
            if (side1 <= 0)
            {
                break;
            }
            side2 = readerDb.nextDouble();
            if (side2 <= 0)
            {
                break;
            }
            side3 = readerDb.nextDouble();
            if (side3 <= 0)
            {
                break;
            }
            System.out.println("Is the triangle filled?(true or false)");
            filled = readerTorF.nextBoolean();
            System.out.println("What color is the triangle?");
            color = readerColor.nextLine();
            Triangle t = new Triangle(side1, side2, side3);
            t.setFilled(filled);
            t.setColor(color);
            System.out.println(t);
            System.out.println("area = " + t.getArea());
            System.out.println("perimeter = " + t.getPerimeter());
            System.out.println("color = " + t.getColor());
            System.out.println("fill = " + t.isFilled());
        }
    }
    
}
