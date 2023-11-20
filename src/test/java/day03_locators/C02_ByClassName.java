package day03_locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.ReusableMethods;

import java.time.Duration;
import java.util.List;

public class C02_ByClassName {
    public static void main(String[] args) {


        // 1- Bir test class’i olusturun ilgili ayarlari yapin

        System.setProperty("webdriver.chrome.driver","src/resources/chromedriver.exe");
        WebDriver driver =  new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // 2- https://www.automationexercise.com/ adresine gidin

        driver.get("https://www.automationexercise.com");


        // 3- Category bolumundeki elementleri locate edin

        /*
        bunun icin oncelikle istenen sayfaya manuel olarak gittik, HTML kodlarina baktik
        kategori elementleri class ismi panel-title olarak uc tane oldugunu gorduk.
        kategori elementlerine locate etmek icin bu class ismini kullanarak,
        asagidaki List methodu ile kategori elementlerini bir listeye koyduk.
         */
        List<WebElement> kategoriElementleriList = driver.findElements(By.className("panel-title"));

        // 4- Category bolumunde 3 element oldugunu test edin

        int expectedKategoriSayisi = 3; // test sonucunda kategori sayisinin uc olmasini bekliyoruz
        int actualKategoriSayisi = kategoriElementleriList.size(); // var olan kategori sayisini bu sekilde tesbit edecegiz

        if(expectedKategoriSayisi==actualKategoriSayisi){     // if ile beklenen ve actuel kategori sayisinin esit olup olmadigini kontrol ediyoruz
            System.out.println("Kategori sayisi testi PASSED");
        }else {
            System.out.println("Kategori sayisi testi FAILED");
        }

        // 5- Category isimlerini yazdirin

        System.out.println(ReusableMethods.stringListeDonustur(kategoriElementleriList));  // [WOMEN, MEN, KIDS]
                // burda daha once olusturdugumuz hazir methodu cagiriyoruz


        // 6- Sayfayi kapatin

        driver.quit();




    }

}
