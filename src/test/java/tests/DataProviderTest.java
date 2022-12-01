package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DataProviderTest {

    Calculator calculator = new Calculator();

    @Test (dataProvider = "dataForSum", dataProviderClass = StaticProvider.class, threadPoolSize = 2)
    public void testSum(int a, int b, int expected) {
        Assert.assertEquals(calculator.sum(a, b), expected, "неверная сумма");
    }


}
