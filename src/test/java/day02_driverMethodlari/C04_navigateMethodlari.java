package day02_driverMethodlari;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C04_navigateMethodlari {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("Webdriver.chrome.driver", "src/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();


        // 1. testotomasyonu anasayfaya gidin
        driver.get("https://www.testotomasyonu.com");

        // 2. tittle'in otomasyon icerdigini test edin
        String expectedTitleIcerik = "Otomasyon";
        String actualTitle = driver.getTitle();

        if (actualTitle.contains(expectedTitleIcerik)){
            System.out.println("Testotmasyonu title testi PASSED");
            } else {
            System.out.println("Testotomasyonu title testi FAILED");
        }

        // 3. sonra wisequarter anasayfasina gidin
         driver.navigate().to("https://www.wisequarter.com");

        // 4. url'in wisequarter icerdigini test edin

        String expectedUrlIcerik = "wisequarter";
        String actualUrl = driver.getCurrentUrl();

        if (actualUrl.contains(expectedUrlIcerik)){
            System.out.println("Wisequarter URL testi PASSED");
        }else {
            System.out.println("Wisequarter URL testi FAILED");
        }

        // 5. tekrar testotomasyonu sayfasina donun

        driver.navigate().back();

        // 6. url'in otomasyon icerdigini test edin

        expectedUrlIcerik = "otomasyon";
        actualUrl = driver.getCurrentUrl();

        if (actualUrl.contains(expectedUrlIcerik)){
            System.out.println("Testotomasyonu URL testi PASSED");
        } else {
            System.out.println("Testotomasyonu URL testi FAILED");
            System.out.println("actual URL :"+ actualUrl);
        }


        // sayfayi kapatin

        Thread.sleep(2000);
        driver.quit();



    }
}
