/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab01;

/**
 * Rectangle
 * This class represents the geometry of a Rectangle
 * @author Tbeur
 * @version 1
 */
public class Rectangle {
    private double area = 0;
    private double perimeter = 0;
    private double width = 1;
    private double height = 1;
    public Rectangle(double w, double h){
        width = w;
        height = h;
    }

public void getArea()
{
area = (width * height);
System.out.printf("Rectangle: area:%7.3f%n", area);
}
public void getPerimeter()
{
perimeter = (width + height + width + height);
System.out.printf("Rectangle: perimeter:%7.3f%n",perimeter);
}
}
