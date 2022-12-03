package tests;

import org.testng.annotations.DataProvider;

public class StaticProvider {

    @DataProvider (name = "dataForSum")
    public static Object[][] dataForSumTest() {
        return new Object[][] {
                {-2, -3, -5},
                {0, 0, 0},
                {2, 3, 5}
        };
    }

    @DataProvider (name = "dataForDiv")
    public static Object[][] dataForDivTest() {
        return new Object[][] {
                {6, 3, 2},
                {6, -3, -2},
                {-6, 3, -2},
                {-6, -3, 2},
                {0, -1, 0},
                {3, 3, 1},
                {3, 2, 1.5},
                {-3.0, -2.0, 1.5},
                {3.0, -2.0, -1.5},
                {-3.0, 2.0, -1.5},
                {1.110, 2.22, 0.5},
                {10E-324, 10, 0.0},
                {-10E-324, 10, -0.0}
        };
    }
}
