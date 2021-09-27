package com.cursor;

import java.util.Scanner;

public class Car {


    private final Scanner scan = new Scanner(System.in);

    private String model;
    private String color;
    private int maxSpeed;
    public int currentSpeed;
    private boolean isEngineTurnOn = false;

    public Car() {
    }

    public Car(String model, String color, int maxSpeed) {
        this.model = model;
        this.color = color;
        this.maxSpeed = maxSpeed;
    }

    public void turnOnEngine() {
        if (isEngineTurnOn) {
            System.out.println("Engine is already running");
        } else {
            isEngineTurnOn = true;
            System.out.println("Engine started");
        }
    }

    public void turnOffEngine() {
        if (isEngineTurnOn) {
            isEngineTurnOn = false;
            System.out.println("Engine stopped");
        } else {
            System.out.println("Engine is not running yet");
        }
    }

    public void setCurrentSpeed() {
        if (isEngineTurnOn) {
            System.out.println("Write from 0 to " + maxSpeed);
            currentSpeed = scan.nextInt();

            while (currentSpeed > maxSpeed || currentSpeed < 0) {
                System.out.println("Error while setting current speed. Please write from 0 to " + maxSpeed);
                currentSpeed = scan.nextInt();
            }
            System.out.println("Successfully setting current speed to " + currentSpeed);
        } else {
            System.out.println("Firstly turn on engine.");
        }
    }

    public static void printMenu() {
        System.out.println("Enter please one of the following:");
        System.out.println("1 - start engine");
        System.out.println("2 - stop engine");
        System.out.println("3 - drive");
        System.out.println("4 - set current speed");
        System.out.println("5 - exit");
    }

    public void drive() {
        if (isEngineTurnOn && currentSpeed != -1) {
            if (currentSpeed == 0) {
                System.out.println("Car is stopped");
            } else {
                System.out.println("Car is driving with speed " + currentSpeed);
            }
        } else {
            String errorMessage = isEngineTurnOn ? "Please set current speed" : "Please start engine";
            System.out.println(errorMessage);
        }
    }
}

