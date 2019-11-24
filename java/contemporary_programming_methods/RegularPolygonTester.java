/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab01;


/**
 * RegularPolygonTester
 * This class represents the geometry of a Regular Polygon
 * @author Tbeur
 * @version 1
 */
import java.io.*;
public class RegularPolygonTester {
    public static void main(String[] args)
    {
        System.out.printf("\u000cBeginning program execution...%n");
        System.out.printf("Lab 01 CM245 Beurman%n");
        System.out.printf("Printing Polygon----------------------%n");
        RegularPolygon p1 = new RegularPolygon(0,0,6,4);
                p1.getArea();
                p1.getPerimeter();
                p1.getSides();
                p1.getX();
                p1.getY();
        System.out.printf("Printing Polygon----------------------%n");
        RegularPolygon p2 = new RegularPolygon(5.6,7.8,10,4);
                p2.getArea();
                p2.getPerimeter();
                p2.getSides();
                p2.getX();
                p2.getY();
        System.out.printf("Printing Polygon----------------------%n");
        RegularPolygon p3 = new RegularPolygon(0,0,3,2);
                p3.getArea();
                p3.getPerimeter();
                p3.getSides();
                p3.getX();
                p3.getY();
        System.out.println("Terminating program execution...");
        }
    
}
