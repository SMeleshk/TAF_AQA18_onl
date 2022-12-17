package tests;

import baseEntities.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FileUploadTest extends BaseTest {

    //File Upload
    //Загрузить файл
    //Проверить, что имя файла на странице совпадает с именем загруженного файла

    @Test
    public void uploadTest() {
        driver.get("http://the-internet.herokuapp.com/upload");

        String pathToFile = FileUploadTest.class.getClassLoader().getResource("123456.txt").getPath().substring(1);
        waitsService.waitForExists(By.id("file-upload")).sendKeys(pathToFile);
        waitsService.waitForVisibilityBy(By.id("file-submit")).submit();
        Assert.assertEquals(waitsService.waitForVisibilityBy(By.id("uploaded-files")).getText().trim(),
                "123456.txt");
    }
}
