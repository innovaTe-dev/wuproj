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
public class Purse {

    private int size = 0;
    private final int MAX = 10;
    private Coin[] coins = new Coin[MAX];


    public void add(Coin c) {
        if (size < MAX) {
            coins[size] = c;
            size++;
        }
    }

    public double sum() {
        double sum = 0;
        for (int j = 0; j < size; j++) {
            sum += coins[j].getValue();;
        }
        return sum;
    }

    public double maxValue() {
        double max = 0;
        double maxCheck = 0;
        for (int y = 0; y < size; y++) {
            if (y == 0) {
                maxCheck = coins[y].getValue();
            }
            if (maxCheck < coins[y].getValue()) {
                max = coins[y].getValue();
            }
        }
        return max;
    }

    public Coin maxCoin() {
        Coin max = coins[0];
        double maxCheck = 0;
        for (int f = 0; f < size; f++) {
            if (f == 0) {
                maxCheck = coins[f].getValue();
            }
            if (maxCheck < coins[f].getValue()) {
                max = coins[f];
            }
        }
        return max;
    }

    public void removeCoin(String n) {
        for (int r = 0; r < size; r++) {
            if (coins[r].getName().equals(n)) {
                coins[r] = null;
                coins[r] = coins[size - 1];
                size = size - 1;
                r = size;
            }
        }
    }

    public Coin[] getCoins() {
        return coins;
    }

    public int getSize() {
        return size;
    }
}
