package day02_driverMethodlari;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C06_ByIdLocator {
    public static void main(String[] args) throws InterruptedException {

        // dortluyu yaziyoruz..
        System.setProperty("Webdriver.chrome.driver","src/resources/chromedriver.exe" );
        WebDriver driver =new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


        // testotomasyonu.com adresine gidin
        driver.get("https://www.testotomasyonu.com");

        // arama kutusuna phone yazip arattirin

        // bir webelementi kullanmak istiyorsak
        // oncelile driver'a elementi buldurup
        // kullanabilecegimiz bir obje olarak kaydetmeliyiz

        WebElement aramaKutusu = driver.findElement(By.id("global-search"));

        aramaKutusu.sendKeys("phone");
        aramaKutusu.submit();

        // bulunan sonuc sayisini yazdirin

        WebElement sonucYaziElementi= driver.findElement(By.className("product-count-text"));

        // System.out.println(sonucYaziElementi);
        // Webelementler direk yazdirilmaz
        // eger webelement uzerindeki yaziyi elde etmek istersek
        System.out.println(sonucYaziElementi.getText()); // 4 Products Found

        // Arama sonucunda urun bulunabildigini test edin

        String sonucSayisiStr = sonucYaziElementi.getText().replaceAll("\\D","");

        int sonucSayisiInt = Integer.parseInt(sonucSayisiStr);

        if (sonucSayisiInt>0) {
            System.out.println("Arama testi PASSED"); // Arama testi PASSED
        } else {
            System.out.println("Arama sonucu FAILED");
        }



        Thread.sleep(2000);
        driver.quit();

    }

}
