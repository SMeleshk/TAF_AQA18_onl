package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CalculatorDivIntTest {

    protected Calculator calculator = new Calculator();

    @Test (enabled = false)
    public void testDivision(){
        Assert.assertEquals(calculator.divInt(6, 3), 2, "неверное частное");
    }

    @Test (testName = "both positive", description = "priority 1", priority = 1)
    public void testDivision2(){
        Assert.assertEquals(calculator.divInt(6, 3), 2, "неверное частное");
    }

    @Test (testName = "|a|<|b|")
    public void testDivision3(){
        Assert.assertEquals(calculator.divInt(3, 6), 0, "неверное частное");
    }

    @Test (testName = "a negative, b positive")
    public void testDivision4(){
        Assert.assertEquals(calculator.divInt(-6, 3), -2, "неверное частное");
    }

    @Test (testName = "a positive, b negative")
    public void testDivision5(){
        Assert.assertEquals(calculator.divInt(6, -3), -2, "неверное частное");
    }

    @Test (testName = "both negative")
    public void testDivision6(){
        Assert.assertEquals(calculator.divInt(-6, -3), 2, "неверное частное");
    }

    @Test (testName = "invocation x3", invocationCount = 3)
    public void testDivision7(){
        Assert.assertEquals(calculator.divInt(-6, -1), 6, "неверное частное");
    }

    @Test (testName = "min and max", invocationCount = 3, invocationTimeOut = 30, threadPoolSize = 3) //min-1 и max+1 idea не позволяет сделать
    public void testDivision8(){
        Assert.assertEquals(calculator.divInt(-2147483648, 2147483647), -1, "неверное частное");
    }

    @Test (testName = "max and min", timeOut = 100)
    public void testDivision9(){
        Assert.assertEquals(calculator.divInt(2147483647, -2147483648), 0, "неверное частное");
    }

    @Test (testName = "division by 0", expectedExceptions = ArithmeticException.class, groups = "division by zero")
    public void testDivisionByZero() {
        calculator.divInt(1, 0);
    }




}
