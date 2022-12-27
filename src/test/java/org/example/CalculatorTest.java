package org.example;

import org.example.ex1.Calculator;
import org.testng.Assert;
import org.testng.annotations.Test;


public class CalculatorTest {
    @Test(testName = "Сумма")
    public void calculateSum() {
        Assert.assertEquals(Calculator.calculate("18 + 29"), 47);
    }

    @Test(testName = "Разность")
    public void calculateSub() {
        Assert.assertEquals(Calculator.calculate("18 - 29"), -11);
    }

    @Test(testName = "Деление")
    public void calculateDiv() {
        Assert.assertEquals(Calculator.calculate("24 / 2"), 12);
    }

    @Test(testName = "Умножение")
    public void calculateMult() {
        Assert.assertEquals(Calculator.calculate("24 * 2"), 48);
    }

    @Test(testName = "Некорректная операция")
    public void calculateWhenIncorrectSign() {
        Assert.assertNull(Calculator.calculate("24 % 2"));
    }

    @Test(testName = "Некорректные входные данные")
    public void incorrectExpression() {
        Assert.assertNull(Calculator.calculate("a * b"));
    }

    @Test(testName = "Некорректные входные данные (double)")
    public void incorrectExpressionWhenDouble() {
        Assert.assertNull(Calculator.calculate("2.5 * 2"));
    }

    @Test(testName = "Операция с отрицательными числами")
    public void calculateWhenNegativeNum() {
        Assert.assertEquals(Calculator.calculate("-2 * -2"), 4);
    }

    @Test(testName = "Выражение не проходящее по маске 'a * b'")
    public void incorrectExpressionWithoutSpaces() {
        Assert.assertNull(Calculator.calculate("2*2"));
    }

    @Test(testName = "Выражение с пробелами вначале и в конце")
    public void incorrectExpressionWithSpaces() {
        Assert.assertEquals(Calculator.calculate("  -2 * 2  "), -4);
    }
}
