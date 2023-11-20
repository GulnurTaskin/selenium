package day03_locators;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.ReusableMethods;

import java.time.Duration;
import java.util.List;

public class C01_byClassNameLocator {
    public static void main(String[] args) throws InterruptedException {

System.setProperty("WebDriver.chrome.driver", "src/resources/chromedriver.exe");
WebDriver driver = new ChromeDriver();
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


        // testotomasyonu.com sayfasina gidin
        driver.get("https://www.testotomasyonu.com");

        // arama kutusuna phone yazip arattirin

        WebElement aramaKutusu = driver.findElement(By.id("global-search"));
        aramaKutusu.sendKeys("phone"+ Keys.ENTER);

        // arama yapildiktan sonra, sol tarafta cikan Categories menusundeki
        // kategori sayisinin 8 oldugunu test edin

       List<WebElement> kategoriElementleriList = driver.findElements(By.className("acc_head"));

       int expectedKategoriSayisi = 8;
       int actualKategoriSayisi = kategoriElementleriList.size();

       if (actualKategoriSayisi==expectedKategoriSayisi){
           System.out.println("Kategori sayisi testi PASSED");
       }else {
           System.out.println("Kategori sayisi testi FAILED");
           System.out.println("actual kategori sayisi: "+actualKategoriSayisi);
       }



        // kategorileri yazdirin

        // System.out.println(kategoriElementleriList); // boyle yapinca asagidaki gibi cikiyor sonuc. yanii asil istedigimiz listeyi getirmedi
        /*
        [[[ChromeDriver: chrome on windows (42065533b96506d4adf52e78ff79043b)] -> class name: acc_head],
        [[ChromeDriver: chrome on windows (42065533b96506d4adf52e78ff79043b)] -> class name: acc_head],
        [[ChromeDriver: chrome on windows (42065533b96506d4adf52e78ff79043b)] -> class name: acc_head],
        [[ChromeDriver: chrome on windows (42065533b96506d4adf52e78ff79043b)] -> class name: acc_head],
        [[ChromeDriver: chrome on windows (42065533b96506d4adf52e78ff79043b)] -> class name: acc_head],
        [[ChromeDriver: chrome on windows (42065533b96506d4adf52e78ff79043b)] -> class name: acc_head],
        [[ChromeDriver: chrome on windows (42065533b96506d4adf52e78ff79043b)] -> class name: acc_head],
        [[ChromeDriver: chrome on windows (42065533b96506d4adf52e78ff79043b)] -> class name: acc_head]]

        */

        // yukardaki list webelementlerden olusuyor
        // webelementler uzerindeki yaziyi direk yazdiramayiz
        // her bir webelementi ele alip, uzerindeki yaziyi yazdirmamiz gerekir

        /*

        // kategorileri su sekilde yazdirabiliriz
        // bir for each loop olusturuyoruz
        // kategoriElementleriList'in her bir elemanini tek tek ele aliyoruz
        // sonra da her bir elemani getText methodu ile yazi yazan kisimlarini alip sout ile yazdiriyoruz

        for (WebElement each:kategoriElementleriList
             ) {
            System.out.println(each.getText());
        }


        yazdirma islemini yukardaki gibi bir for each loop ile yapabiliriz
        ama biz bu islemi cok kullanacagimiz icin bir method olusturup,
        webElement'lerden olusan listeyi
        String'lerden olusan bir listeye cevirdik


         */


        // ReusableMethods class'inda olusturdugumuz stringListeDonustur methodumuzu cagiriyoruz
        // kategoriElementleriList'ini text olarak bize yazdirsin diye..
        // boylelikle tek satirda cozulmus oldu
        System.out.println(ReusableMethods.stringListeDonustur(kategoriElementleriList));

        //Grocery
        //Kids Wear
        //Travel
        //Shoes
        //Furniture
        //Men Fashion
        //Women Fashion
        //Electronics

        Thread.sleep(3000);
        driver.quit();
    }
}
