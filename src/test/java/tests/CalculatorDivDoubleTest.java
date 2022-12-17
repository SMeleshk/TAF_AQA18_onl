package tests;

import org.testng.Assert;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import utils.Retry;

public class CalculatorDivDoubleTest extends PreAndPostConditions {

    protected Calculator calculator = new Calculator();

    @Test (testName = "division with provider", dataProvider = "dataForDiv", dataProviderClass = StaticProvider.class)
    public void testDivision1(double a, double b, double expected) {
        Assert.assertEquals(calculator.division(a, b), expected, "неверное частное");
    }

    @Test (testName = "division by |min|")
    public void testDivision2() {
        Assert.assertEquals(calculator.division(1, 10E-309), 1.0E308, "неверное частное");
    }

    @Test (testName = "division by |min|-1")
    public void testDivision3() {
        Assert.assertTrue(Double.isInfinite(calculator.division(1, 10E-310)), "неверное частное");
    }

    @Test (testName = "division by -|min|")
    public void testDivision21() {
        Assert.assertEquals(calculator.division(1, -10E-309), -1.0E308, "неверное частное");
    }

    @Test (testName = "division by -|min|-1")
    public void testDivision31() {
        Assert.assertTrue(Double.isInfinite(calculator.division(1, -10E-310)), "неверное частное");
    }

    @Test (testName = "division of |max|") //min-1 и max+1 idea не позволяет сделать
    public void testDivision4() {
        Assert.assertEquals(calculator.division(1.7e308, 1), 1.7E308, "неверное частное");
    }

    @Test (testName = "division of |max|+1")
    public void testDivision5() {
        Assert.assertTrue(Double.isInfinite(calculator.division(1.7e308, 0.1)), "неверное частное");
    }

    @Test (testName = "division of -|max|") //min-1 и max+1 idea не позволяет сделать
    public void testDivision6() {
        Assert.assertEquals(calculator.division(-1.7e308, 1), -1.7E308, "неверное частное");
    }

    @Test (testName = "division of -|max|-1", dependsOnMethods = "testDivision6", alwaysRun = true)
    public void testDivision7() {
        Assert.assertTrue(Double.isInfinite(calculator.division(-1.7e308, 0.1)), "неверное частное");
    }

    @Test (testName = "division by 0", groups = "division by zero")
    public void testDivisionByZero() {
        Assert.assertTrue(Double.isInfinite(calculator.division(1.0, 0)), "неверное частное");
    }

    @Test (retryAnalyzer = Retry.class)
    public void retryTest() {
        double x = calculator.division(1.0, 0);
        if (Double.isInfinite(x)) {
            System.out.println("Success");
            Assert.assertTrue(true);
        } else {
            Assert.assertTrue(false);
        }
    }

    @Test (testName = "NaN")
    public void testNaN() {
        Assert.assertTrue(Double.isNaN(calculator.division(0.0, 0)), "неверное частное");
    }

    @Parameters({"value1", "value2"})
    @Test
    public void paramTest(@Optional("1.0") Double value1, @Optional("1.0") Double value2) {
        Assert.assertEquals(calculator.division(value1, value2), 1.0, "неверное частное");
    }
}
