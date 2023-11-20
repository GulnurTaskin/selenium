package day02_driverMethodlari;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C03_getMethodlari {
    public static void main(String[] args) throws InterruptedException {

        /*
            Selenium 4.12 versiyonu ile
            kendi Webdriver'ini da olusturabiliyor

            Yani artik disardan bir webdriver tanimlama MECBURIYETI kalmadi

            ANCAK... sirketlerin pek cogu kendilerine ozel olarak
            satin aldiklari webdriver'lari kullanabiliyor.

            Biz bu duruma alismak icin
            Selenium webdriver yerine indirdigimiz driver.exe dosyasini kullanmaya devam edecegiz
         */



        System.setProperty("Webdriver.chrome.driver", "src/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();


        driver.get("https://www.testotomasyonu.com");


        // System.out.println(driver.getPageSource());

        System.out.println(driver.getWindowHandle()); // D2CC9BE9B383DC2AFF24D777A115C21E
        // Window handle degeri: selenium'un olusturdugu her webdriver objesine verdigi
        // unique bir kod'dur
        // biz bu degerleri birden fazla sayfa acilirsa,
        // sayfalar arasinda gecis yapmak icin kullanacagiz

        System.out.println(driver.getWindowHandles()); // [D2CC9BE9B383DC2AFF24D777A115C21E]
        // aktif webdriver objesinin actigi TUM SAYFALARIN window handle degerlerini getirir



   driver.quit();
    }
}
