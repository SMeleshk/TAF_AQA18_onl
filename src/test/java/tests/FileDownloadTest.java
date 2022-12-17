package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.util.HashMap;

public class FileDownloadTest {

    //File Download (с зорачкай)
    //Изучить https://www.swtestacademy.com/download-file-in-selenium/
    //Скачать файл
    //Проверить наличие файла на файловой системе

    @Test
    public void downloadTest() throws InterruptedException {

        HashMap<String, Object> chromePrefs = new HashMap<>();
        chromePrefs.put("profile.default_content_settings.popups", 0);
        chromePrefs.put("download.default_directory", System.getProperty("user.dir"));
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", chromePrefs);
        WebDriver driver = new ChromeDriver(options);

        driver.get("http://the-internet.herokuapp.com/download");
        String downloadLink = driver.findElement(By.linkText("test.txt")).getAttribute("href");
        driver.get(downloadLink);

        Thread.sleep(500);

        File folder = new File(System.getProperty("user.dir"));
        File[] listOfFiles = folder.listFiles();
        boolean found = false;
        File f = null;

        for (File listOfFile : listOfFiles) {
            if (listOfFile.isFile()) {
                String fileName = listOfFile.getName();
                if (fileName.matches("test.txt")) {
                    f = new File(fileName);
                    found = true;
                }
            }
        }

        Assert.assertTrue(found, "Downloaded document is not found");
        f.deleteOnExit();
        driver.quit();
    }
}
