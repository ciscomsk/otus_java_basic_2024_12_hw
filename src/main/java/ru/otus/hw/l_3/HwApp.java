package ru.otus.hw.l_3;

import java.util.Random;
import java.util.Scanner;

public class HwApp {
    public static void main(String[] args) {
        int userChoice = getMethodNumber();
        System.out.println("method number: " + userChoice);
        executeMethod(userChoice);
    }

    public static void greetings() {
        System.out.print("Hello\nWorld\nfrom\nJava\n");
    }

    public static void checkSign(int a, int b, int c) {
        System.out.println("a = " + a + ", b = " + b + ", c = " + c);
        long sum = a + b + c;
        System.out.println("sum = " + sum);

        // v1
//        if (sum >= 0) {
//            System.out.println("Сумма положительная");
//        } else {
//            System.out.println("Сумма отрицательная");
//        }

        // v2
        String message = (sum >= 0) ? "Сумма положительная" : "Сумма отрицательная";
        System.out.println(message);
    }

    public static void selectColor(int data) {
        System.out.println("data = " + data);

        // v1
//        if (data <= 10) {
//            System.out.println("Красный");
//        } else if (data <= 20) {
//            System.out.println("Желтый");
//        } else {
//            System.out.println("Зеленый");
//        }

        // v2
        String color;
        if (data <= 10) {
            color = "Красный";
        } else if (data <= 20) {
            color = "Желтый";
        } else {
            color = "Зеленый";
        }
        System.out.println(color);
    }

    public static void compareNumbers(int a, int b) {
        System.out.println("a = " + a + ", b = " + b);

        // v1
//        if (a >= b) {
//            System.out.println("a >= b");
//        } else {
//            System.out.println("a < b");
//        }

        // v2
        String message = (a >= b) ? "a >= b" : "a < b";
        System.out.println(message);
    }

    public static void addOrSubtractAndPrint(int initValue, int delta, boolean increment) {
        System.out.println("initValue = " + initValue + ", delta = " + delta + ", increment = " + increment);

        long res = (increment) ? initValue + delta : initValue - delta;
        System.out.println("res = " + res);
    }

    public static int getMethodNumber() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter method number - from 1 to 5 inclusive: ");
        return sc.nextInt();
    }

    public static void executeMethod(int methodNumber) {
        Random rnd = new Random();

        switch (methodNumber) {
            case 1 -> greetings();
            case 2 -> {
                int a = rnd.nextInt();
                int b = rnd.nextInt();
                int c = rnd.nextInt();
                checkSign(a, b, c);
            }
            case 3 -> {
                int data = rnd.nextInt(30);
                selectColor(data);
            }
            case 4 -> {
                int a = rnd.nextInt();
                int b = rnd.nextInt();
                compareNumbers(a, b);
            }
            case 5 -> {
                int initValue = rnd.nextInt();
                int delta = rnd.nextInt();
                boolean increment = rnd.nextBoolean();
                addOrSubtractAndPrint(initValue, delta, increment);
            }
            default -> System.out.println("Unknown method number");
        }
    }
}
