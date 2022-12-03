package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class CalculatorTest extends BaseTest{

    @Test
    public void testSum(){
        Assert.assertEquals(calculator.sum(2, 3), 5, "неверная сумма");
    }

    @Test
    public void testSum10(){

        Assert.assertEquals(calculator.sum(2, 3), 10, "неверная сумма");
    }


    @Test(enabled = false) //тест не  будет выполняться (true всегда по дефолту)
    public void testSum1(){
        Assert.assertEquals(calculator.sum(2, 3), 5, "неверная сумма");
    }

    @Test(description = "Тест с описанием") //отображается в репортинге
    public void testSum2(){
        Assert.assertEquals(calculator.sum(2, 3), 5, "неверная сумма");
    }

    @Test(testName = "Тест с названием") //отображается после исполнения в консоли
    public void testSum3(){
        Assert.assertEquals(calculator.sum(2, 3), 5, "неверная сумма");
    }


    @Test(timeOut = 1000) //таймаут в миллисекундах
    public void testSum4() throws InterruptedException {
        Thread.sleep(1001);
    }

    @Test(invocationCount = 3) //выполнение теста опред.кол-во раз последоватеьно
    public void testSum5(){
        Assert.assertEquals(calculator.sum(2, 3), 5, "неверная сумма");
    }

    @Test(invocationCount = 3, invocationTimeOut = 1000, threadPoolSize = 3) //считает все выполнения как одно. pool - количество потоков
    public void testSum6() throws InterruptedException {
        Thread.sleep(500);
        Assert.assertEquals(calculator.sum(2, 3), 5, "неверная сумма");
    }

    @Test (expectedExceptions =  NullPointerException.class)
    public void exceptionTet() {
        List list = null;
        int size = list.size();
    }

}
