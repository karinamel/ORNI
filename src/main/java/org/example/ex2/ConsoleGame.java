package org.example.ex2;

import java.util.Scanner;

public class ConsoleGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        do {
            startGame();
            System.out.println("Если хотите сыграть еще раз, напишите 0");
        } while (scanner.nextLine().equals("0"));
    }

    public static void startGame() {
        int N = (int) (1 + Math.random() * 100);
        System.out.println("Угадай число в диапазоне [1,100]");

        int count = 1;
        int value = getValue();
        int absTemp = Math.abs(value - N);
        int absPrevious = absTemp;
        while (true) {
            if (absTemp == 0) {
                System.out.println("Поздравляю! Загаданное число: " + N + " Вы угадали за " + count + " попыток");
                break;
            }
            System.out.println(getStatus(absTemp, absPrevious));
            count++;
            value = getValue();
            absPrevious = absTemp;
            absTemp = Math.abs(value - N);
        }
    }

    private static String getStatus (int absTemp, int absPrevious) {
        String result;
        if (absTemp > absPrevious) {
            result = ("Холоднее");
        } else if (absTemp < absPrevious) {
            result = ("Теплее");
        } else {
            result = ("Ничего не изменилось");
        }
        if (result.equals("Ничего не изменилось")) {
            if (absTemp <= 2) {
                result = ("Слишком горячо");
            } else if (absTemp <= 5) {
                result = ("Очень горячо");
            } else if (absTemp <= 10) {
                result = ("Горячо");
            } else if (absTemp <= 20) {
                result = ("Тепло");
            } else if (absTemp <= 50) {
                result = ("Прохладно");
            } else if (absTemp <= 80) {
                result = ("Холодно");
            } else if (absTemp <= 100) {
                result = ("Слишком холодно");
            }
        }
        return result;
    }

    private static int getValue() {
        Scanner scanner = new Scanner(System.in);
        try {
            int value = scanner.nextInt();
            if (value > 100 || value <= 0) throw new Exception();
            return value;
        } catch (Exception e) {
            System.out.println("Введите целое число в диапазоне [1, 100]");
            return getValue();
        }
    }
}
