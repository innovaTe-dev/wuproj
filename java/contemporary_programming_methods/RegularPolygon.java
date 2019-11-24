/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab01;

/**
 * ReguklarPolygon
 * This class represents the geometry of a Regular Polygon
 * @author Tbeur
 * @version 1
 */
public class RegularPolygon {
    private double y = 0;
    private double x = 0;
    private int n = 3;
    private double side = 1;
    private double area = 0;
    private double perimeter = 0;
    public RegularPolygon(double y, double x, int n, double side){
        this.y = y;
        this.x = x;
        this.n = n;
        this.side = side;
    }
    
            

public void getArea()
{
area = (n * Math.pow(side, 2))/(4 * Math.tan(Math.PI/n));
System.out.printf("Polygon: area:%8.3f%n", area);
}
public void getPerimeter()
{
perimeter = (n * side);
System.out.printf("Polygon: perimeter:%7.3f%n",perimeter);
}
public void getX()
{
System.out.printf("Polygon: x coordinate:%7.3f%n",x);
}
public void getY()
{
System.out.printf("Polygon: y coordinate:%7.3f%n",y);
}
public void getSideLength()
{
System.out.printf("Polygon: side length:%7.3f%n",side);
}
public void getSides()
{
System.out.printf("Polygon: number of sides:%4d%n",n); 
}
}
