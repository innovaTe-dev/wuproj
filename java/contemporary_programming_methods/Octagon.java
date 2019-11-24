/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab05;
import java.util.*;
import java.io.*;
import java.math.*;

/**
 *
 * @author Tbeur
 */
public class Octagon extends GeometricObject implements Comparable<Octagon>
{
    private double side1 = 1.0;
    public Octagon()
    {
    }
    public Octagon(double side1) {
        setSide(side1);
    }
    public double getSide()
    {
        return side1;
    }
    public void setSide(double side1)
    {
        if (side1 < 0)
        {
            throw new IllegalArgumentException("Invalid side.");
        }
        this.side1 = side1;
    }
    @Override
    public double getArea()
    {
       double area = 0;
       area = 2*(1+Math.sqrt(2))*Math.pow(side1, 2);
       return area;
    }
    @Override
    public double getPerimeter()
    {
      double perimeter = 0;
      perimeter = (side1 * 8);
      return perimeter;
    }

    @Override
    public int compareTo(Octagon o)
    {
        if (getArea() > o.getArea())
        {
            return 1;
        }
        else if (getArea() > o.getArea())
        {
            return -1;
        }
        else
        {
            return 0;
        }
    }
    @Override
    public String toString()
    {
        return "Area: " + getArea() + " Side: " + getSide() + " Perimeter: " + getPerimeter();
    }
}
