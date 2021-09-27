package com.cursor;

import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
    private final static Scanner scanner = new Scanner(new InputStreamReader(System.in));

    public static void main(String[] args) {

//      Task №1

        Circle Circle1 = new Circle(1);
        System.out.println("The area is: " + Circle1.calcCircleArea());

//      Task №2
        Car car1 = new Car("Skoda", "White", 220);
        Car.printMenu();
        String userCommand = scanner.nextLine();
        do {
            switch (userCommand) {
                case "1":
                    car1.turnOnEngine();
                    break;
                case "2":
                    car1.turnOffEngine();
                    break;
                case "3":
                    car1.drive();
                    break;
                case "4":
                    car1.setCurrentSpeed();
                    break;
                case "5":
                    continue;
                default:
                    System.out.println("Error");
                    Car.printMenu();
                    break;
            }
            userCommand = scanner.nextLine();
        }
        while (!userCommand.equals("5"));

//      Task №3

        long hryvnya;
        byte coins;
        char symbol;
        System.out.println("Enter hryvnya for money1");
        hryvnya = scanner.nextLong();
        System.out.println("Enter coins for money1");
        coins = scanner.nextByte();
        while (coins < 0 || coins > 99) {
            System.out.println("Error, write please coins from 0 to 99");
            coins = scanner.nextByte();
        }
        Money money1 = new Money(hryvnya, coins);

        System.out.println("Enter hryvnya for money2");
        hryvnya = scanner.nextLong();
        System.out.println("Enter coins for money2");
        coins = scanner.nextByte();

        while (coins < 0 || coins > 99) {
            System.out.println("Error, write please coins from 0 to 99");
            coins = scanner.nextByte();
        }
        Money money2 = new Money(hryvnya, coins);
        System.out.println("Please enter your mathematical operation (for example + , - , * , / , < , > ");
        symbol = scanner.next().charAt(0);
        Money.doAction(money1, money2, symbol);
    }

}



