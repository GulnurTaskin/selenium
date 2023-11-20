package day01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class selenium_ilktest {

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","src/resources/chromedriver.exe");


        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


        //2- https://www.trendyol.com adresine gidin
        driver.get("https://www.trendyol.com");

Thread.sleep(5000);

driver.manage().window().maximize();

Thread.sleep(5000);
driver.manage().window().fullscreen();

Thread.sleep(5000);



driver.close();
driver.quit();


    }


}
