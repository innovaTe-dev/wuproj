/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab05;
import java.util.*;
import java.io.*;
import java.util.ArrayList;

/**
 *
 * @author Tbeur
 */
public class OctagonTester {
    public static void main(String[] args) throws FileNotFoundException
    {
        ArrayList<Octagon> list = new ArrayList<>();
        Scanner sideReader = new Scanner(new File("data.txt"));
        PrintWriter dataOut = new PrintWriter(new File("report.txt"));
        dataOut.println("Trevor Beurman, Lab05, 3/22/2018");
        while (sideReader.hasNextLine())
        {
            String rec = sideReader.nextLine();
            String[] fields = rec.split(",");
            for (int k = 0; k < fields.length; k++)
            {
                try {
                    double a = Double.parseDouble(fields[k]);
                    Octagon o = new Octagon(a);
                    list.add(o);
                    dataOut.println(fields[k]);
                }
                catch (NumberFormatException ex)
                {
                    dataOut.println("Invalid input detected. This input was skipped: " + fields[k]);
                }
                catch (IllegalArgumentException ex)
                {
                    dataOut.println("Input was less than zero. This input was skipped: " + fields[k]);
                }
            }
        }
        dataOut.print(list);
        java.util.Collections.sort(list);
        for (int j = 0; j < list.size(); j++)
        {
        dataOut.println(list.get(j));
        }
        dataOut.close();
        sideReader.close();
    }

}
