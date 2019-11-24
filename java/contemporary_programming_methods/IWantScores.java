/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab04;

import java.util.*;
import java.io.*;
import java.util.ArrayList;

/**
 *
 * @author Tbeur
 */
public class IWantScores {

    public static void main(String[] args) throws FileNotFoundException {
        int elements = 0;
        int j = 1;
        ArrayList<Double> scores = new ArrayList<>();
        Scanner scoresReader = new Scanner(new File("Scores.txt"));
        for (int k = 0; scoresReader.hasNext() != false; k++) {
            scores.add(scoresReader.nextDouble());
            elements++;
        }
        double sum = 0;
        double avg = 0;
        for (int h = 0; h < elements; h++) {
            sum += scores.get(h);
        }
        avg = sum / elements;
        System.out.println("sum: " + sum);
        System.out.println("avg: " + avg);
    }

}
