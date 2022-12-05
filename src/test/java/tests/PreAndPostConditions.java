package tests;

import org.testng.annotations.AfterGroups;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeTest;

public class PreAndPostConditions {

    @BeforeTest
    public void beforeTest() { System.out.println("Тест начинается");}

    @AfterTest
    public void afterTest() { System.out.println("Тест завершён");}

    @BeforeGroups (groups = "division by zero")
    public void beforeGroup() { System.out.println("Тест группы начинается");}

    @AfterGroups (groups = "division by zero")
    public void afterGroup() { System.out.println("Тест группы завершён");}

}
