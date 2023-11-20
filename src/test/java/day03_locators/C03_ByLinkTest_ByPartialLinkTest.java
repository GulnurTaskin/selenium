package day03_locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_ByLinkTest_ByPartialLinkTest {
    public static void main(String[] args) throws InterruptedException {

        // 1. test icin gerekli ayarlamalari yapin

        System.setProperty("Webdriver.chrome.driver", "src/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver(); // webriver elementimizi olusturuyoruz
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


        // 2. testotomasyonu.com anasayfaya gidin

        driver.get("https://www.testotomasyonu.com");

        // 3. shoes linkine tiklayin

           // driver.findElement(By.linkText("Shoes")).click();
           // driver.findElement(By.linkText("hoes")).click();
           // eger By.LinkText() kullanirsaniz, link uzerindeki texti birebir ayni yazmamiz gerekir
           // bosluk, ? gibi karakterler varsa onlar da mutlaka yazilmalidir
           // yazinin sace bir kismiyla aramak istiyorsak By.partialLinkText kullanmaliyiz

        // driver.findElement(By.partialLinkText("hoes")).click();
        // driver.findElement(By.partialLinkText("oes")).click();
        // driver.findElement(By.partialLinkText("ho")).click();
        // driver.findElement(By.partialLinkText("oe")).click();
        // bunlarin hepsiyle de shoes linkine tiklaniyor

        // Ama biz bu adreste baska bir seye de bakacagimiz icin (bknz: 6. gorev)
        // shoes linkine tiklamayi su sekilde yapacagiz
        WebElement shoesLinki =driver.findElement(By.partialLinkText("oe"));
        shoesLinki.click();



        /*
        By.partialLinkText() kullanildiginda,
        link uzerindeki yazinin tamamina ihtiyac yoktur
        yazinin , istedigimiz webelementi unique olarak bulabilecegimiz
        herhangi bir parcasini kullanmamiz yeterli olur
        */


        // 4. acilan sayfada url'in Shoes icerdigini test edin

        String expectedUrlIcerik = "Shoes";
        String actualUrl = driver.getCurrentUrl();

        if (actualUrl.contains(expectedUrlIcerik)) {
            System.out.println("Shoes URL testi PASSED");
        } else {
            System.out.println("Shoes URL testi FAILED");
        }

        // 5. acilan sayfada url'in Shoes icerdigini test edin

        String expectedTitleIcerik = "Shoes";
        String actualTitle = driver.getTitle();

        if (actualTitle.contains(expectedTitleIcerik)) {
            System.out.println("Shoes TITLE testi PASSED");
        } else {
            System.out.println("Shoes TITLE testi FAILED");
        }


        // 6. Shoes linkinin bu sayfada da erisilebilir oldugunu test edin
        shoesLinki =driver.findElement(By.partialLinkText("oe")); // bu kismi eklemezsek stale element exception gelir
        if (shoesLinki.isEnabled()){ // StaleElementReferenceException
            System.out.println("Shoes linki erisim testi PASSED");
        }else {
            System.out.println("Shoes linki erisim testi FAILED");
        }

        /*
        bir webelementi locate ettikten sonra
        sayfayi yenileme veya yeni bir sayfaya gitme gibi islemler yaparsak
        driver daha onceden yaptigimiz locate'leri KULLANMAYABILIR
        ve bize "Stale ElementReferenceException" verir

        bu durumda lacate ve elemente kayit islemini Yeniden yapmaliyiz

         */




        // sayfayi kapatin

        driver.quit();
    }
}
