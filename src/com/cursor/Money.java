package com.cursor;

import java.text.DecimalFormat;

public class Money {

    private static final DecimalFormat decimalFormat = new DecimalFormat("##.00");

    private long hryvnia;
    private byte coins;


    public Money(long hryvnia, byte coins) {
        this.hryvnia = hryvnia;
        this.coins = coins;
    }

    public Money() {

    }

    public static void add(Money money1, Money money2) {
        long sumHryvnia = money1.getHryvnia() + money2.getHryvnia();
        int sumCoins = money1.getCoins() + money2.getCoins();

        if (sumCoins >= 100) {
            sumCoins %= 100;
            sumHryvnia++;
        }
        System.out.println("Sum: " + sumHryvnia + "," + sumCoins);
    }

    public static void minus(Money money1, Money money2) {
        int money1Coins = money1.getCoins();
        if (money1.getHryvnia() < money2.getHryvnia()) {
            System.out.println("Result will be < 0");
            return;
        } else if (money1.getHryvnia() == money2.getHryvnia() && money1.getCoins() < money2.getCoins()) {
            System.out.println("Result will be < 0");
            return;
        } else if (money1.getCoins() < money2.getCoins()) {
            money1.setHryvnia(money1.getHryvnia() - 1);
            money1Coins = money1.getCoins() + 100;
        }
        long sumHryvnia = money1.getHryvnia() - money2.getHryvnia();
        int sumCoins = money1Coins - money2.getCoins();
        System.out.println("Minus: " + sumHryvnia + "," + sumCoins);
    }

    public static void multiply(Money money1, Money money2) {
        double hryvniaAndCoins1 = Double.parseDouble(String.valueOf(money1.getHryvnia()).concat(".").concat(String.valueOf(money1.getCoins())));
        double hryvniaAndCoins2 = Double.parseDouble(String.valueOf(money2.getHryvnia()).concat(".").concat(String.valueOf(money2.getCoins())));
        String multiply = decimalFormat.format(hryvniaAndCoins1 * hryvniaAndCoins2);

        String result = multiply.replace(".", ",");

        System.out.println("Multiply: " + result);

    }

    public static void divide(Money money1, Money money2) {
        double hryvniaAndCoins1 = Double.parseDouble(String.valueOf(money1.getHryvnia()).concat(".").concat(String.valueOf(money1.getCoins())));
        double hryvniaAndCoins2 = Double.parseDouble(String.valueOf(money2.getHryvnia()).concat(".").concat(String.valueOf(money2.getCoins())));
        String divide = decimalFormat.format(hryvniaAndCoins1 / hryvniaAndCoins2);

        String result = divide.replace(".", ",");

        System.out.println("Divide: " + result);

    }

    public static void comparisonMore(Money money1, Money money2) {
        double hryvniaAndCoins1 = Double.parseDouble(String.valueOf(money1.getHryvnia()).concat(".").concat(String.valueOf(money1.getCoins())));
        double hryvniaAndCoins2 = Double.parseDouble(String.valueOf(money2.getHryvnia()).concat(".").concat(String.valueOf(money2.getCoins())));
        boolean divide = (hryvniaAndCoins1 > hryvniaAndCoins2);
        if (divide) {
            System.out.println("The first amount of money is greater than the second!");
        } else {
            System.out.println("The first amount of money is not more than the second!");
        }
    }

    public static void comparisonLess(Money money1, Money money2) {
        double hryvniaAndCoins1 = Double.parseDouble(String.valueOf(money1.getHryvnia()).concat(".").concat(String.valueOf(money1.getCoins())));
        double hryvniaAndCoins2 = Double.parseDouble(String.valueOf(money2.getHryvnia()).concat(".").concat(String.valueOf(money2.getCoins())));
        boolean divide = (hryvniaAndCoins1 < hryvniaAndCoins2);
        if (divide) {
            System.out.println("The first amount of money is not less than the second!");
        } else {
            System.out.println("The first amount of money is not less than the second!");
        }
    }


    public void setHryvnia(long hryvnia) {
        this.hryvnia = hryvnia;
    }

    public void setCoins(byte coins) {
        if (coins >= 100) {
            System.out.println("Error, write please coins from 0 to 99");
        } else if (coins <= 100) {
            this.coins = coins;
        }
    }

    public long getHryvnia() {
        return hryvnia;
    }

    public byte getCoins() {
        return coins;
    }


    public static void doAction(Money money1, Money money2, char symbol) {
        switch (symbol) {
            case '+':
                add(money1, money2);
                break;
            case '-':
                minus(money1, money2);
                break;
            case '*':
                multiply(money1, money2);
                break;
            case '/':
                divide(money1, money2);
                break;
            case '>':
                comparisonMore(money1, money2);
                break;
            case '<':
                comparisonLess(money1, money2);
                break;
            default:
                System.out.println("This mathematical operation does not exist!");
        }

    }
}
