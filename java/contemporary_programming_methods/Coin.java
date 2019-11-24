/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab02;

/**
 *
 * @author Tbeur
 */
public class Coin {

    private String name = "";
    private double value = 0;

    public Coin(String n, double v) {
        name = "PENNY";
        value = 0.01;
        name = n;
        value = v;
    }

    public void setName(String n) {
        n = name;
    }
    public void setValue(double v) {
        v = value;
    }
    

    public String getName() {
        return name;
    }

    public double getValue() {
        return value;
    }
}
