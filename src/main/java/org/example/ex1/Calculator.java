package org.example.ex1;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Calculator {
    public static void main(String[] args) {
        System.out.println("Enter an expression:");
        Scanner scanner = new Scanner(System.in);

        String expression;
        while (!(expression = scanner.nextLine()).equals("q")) {
            if (!checkExpression(expression)) {
                System.out.println("Expression mask: a + b . Mathematical symbols: + - / * . Only integer");
            } else {
                String[] elements = expression.split(" ");
                int a = Integer.parseInt(elements[0]);
                String operator = elements[1];
                int b = Integer.parseInt(elements[2]);

                Integer result = calculate(a, b, operator);
                System.out.println(expression + " = " + result);
            }
            System.out.println("Enter an expression:");
        }
    }

    public static Integer calculate(int a, int b, String operator) {
        return switch (operator) {
            case "+" -> a + b;
            case "-" -> a - b;
            case "/" -> a / b;
            case "*" -> a * b;
            default -> null;
        };
    }

    public static boolean checkExpression (String expression) {
        return Pattern.matches("^\\s*-?\\d+\\s[+-/*]\\s-?\\d+\\s*$", expression);
    }
}