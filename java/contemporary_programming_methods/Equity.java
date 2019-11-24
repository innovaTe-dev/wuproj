/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab07;

/**
 *
 * @author Tbeur
 */
public class Equity {

    private static double PV = 0;
    private static double R = 0;
    private static double N = 0;
    private static double FV = 0;

    public static double CalculateFV() {
        FV = PV * Math.pow(1 + R, N);
        return FV;
    }

    public static double getFV() {
        return FV;
    }

    public static double getR() {
        return R;
    }

    public static double getN() {
        return N;
    }

    public static double getPV() {
        return PV;
    }

    public static void setR(double r) {
        if (r < 0) {
        throw new IllegalArgumentException("This number is negative, unacceptable.");
        }
        R = r;
    }

    public static void setN(double n) {
        if (n < 0) {
        throw new IllegalArgumentException("This number is negative, unacceptable.");
        }
        N = n;
    }

    public static void setPV(double pv) {
        if (pv < 0) {
        throw new IllegalArgumentException("This number is negative, unacceptable.");
        }
        PV = pv;
    }
}
