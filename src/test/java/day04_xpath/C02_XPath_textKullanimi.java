package day04_xpath;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_XPath_textKullanimi {

    /*
    Xpath link olmasa bile yazisi olan webelementleri
    yazi ile locate etmemize imkan tanir
         //button[text() ='Add']
     */

    public static void main(String[] args) throws InterruptedException {


        // test icin gerekli ayarlamalari yapiyoruz en basta

        System.setProperty("Webdriver.chrome.driver", "src/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // 1- https://testotomasyonu.com/addremove/ adresine gidin

        driver.get("https://testotomasyonu.com/addremove/");

        // 2- Add Element butonuna basin
        driver.findElement(By.xpath("//button[text() ='Add']")).click();

        // 3- Remove butonu’nun gorunur oldugunu test edin

        WebElement removeButonu = driver.findElement(By.xpath("//button[text() ='Remove']"));

        if (removeButonu.isDisplayed()) {
            System.out.println("Remove butonu gorunme testi PASSED");
        } else {
            System.out.println("Remove butonu gorunme testi FAILED");
        }

        // 4- Remove tusuna basin

        removeButonu.click();


        // 5- “Add/Remove Elements” yazisinin gorunur oldugunu test edin

        WebElement addRemoveYaziElementi = driver.findElement(By.xpath("//*[text() ='Add/Remove Elements']"));

        if (addRemoveYaziElementi.isDisplayed()) {
            System.out.println("Add/Remove Elements yazisi gorunme testi PASSED");
        } else {
            System.out.println("Add/Remove Elements yazisi gorunme testi FAILED");
        }


        // remove butonunun gorunur olmadigini test edin

        // remove butonunu aratinca gorunmeyecek ve exception firlatacak.
        // bu demek oluyorki buton gorunmuyor, test PASSED
        // eger buton gorunuyorsa exception firlatmaz,
        // bu da istedigimiz bi durum olmadigi icin test FAILED
        // o yuzden try cath yapiyoruz
        try {
            removeButonu = driver.findElement(By.xpath("//*[@class='remove-btn']"));
            System.out.println("Remove butonu gorunmeme testi FAILED");
        } catch (NoSuchElementException e) {
            System.out.println("Remove butonu gorunmeme testi PASSED");
        }


        driver.quit();

    }
}