/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab04;

/**
 *
 * @author Tbeur
 */
public class Part {

    private String partNum = "";
    private double price = 0;

    public Part() {
    }

    public Part(String partNum, double price) {
        setPartNum(partNum);
        setPrice(price);
    }

    public String getPartNum() {
        return partNum;
    }

    public double getPrice() {
        return price;
    }

    public void setPartNum(String partNum) throws IllegalArgumentException {
        int x = partNum.length();
        int check = 0;
        char[] errorchar = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        for (int k = 0; k < partNum.length(); k++)
        {
            check = partNum.indexOf(errorchar[k]);
            if (check == -1)
            {
                this.partNum = partNum;
            }
            else
            {
                throw new IllegalArgumentException("Part number cannot have lowercase letters");
            }
        }
        if (x < 16 && x > 8) {
            this.partNum = partNum;
        } else {
            throw new IllegalArgumentException("Part number must be between length of 8 and 16");
        }
    }

    public void setPrice(double price) throws IllegalArgumentException {
        if (price > 0) {
            this.price = price;
        } else {
            throw new IllegalArgumentException("Price must be greater than zero");
        }
    }
}
