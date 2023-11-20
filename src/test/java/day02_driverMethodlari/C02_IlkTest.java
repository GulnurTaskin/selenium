package day02_driverMethodlari;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C02_IlkTest {
    public static void main(String[] args) {

        // testotomasyonu anasayfaya gidin
        // URL'in https://www.testotomasyonu.com oldugunu
        // ve Title'in test kelimesi icerdigini test edin

        // her test icin mutlaka bir webdriver olusturmali
        // ve gerekli ayarlamari yapmaliyiz

        // yine en basta su 3 satiri yaziyoruz, burasi zorunlu,
        // elle yazmaya alis
        System.setProperty("Webdriver.chrome.driver","src/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // simdi adim adim yukarda istenen asamalari yapalim:

        // 1. testotomasyonu anasayfaya gidin

        driver.get("https://www.testotomasyonu.com");

        // URL'in https://www.testotomasyonu.com oldugunu

        String expectedUrl = "https://wwww.testotomasyonu.com"; // bu bizim olmasini bekledigimiz url adresi
        String actualUrl = driver.getCurrentUrl(); // bu da actuel olarak sitenin url'si
        // bu ikisinin birbirine esit olup olmadigini if kullanarak test edecegiz
        // hocaaam java ne isimize yarayacak? iste bu ise yarayacak, anladin? :)

        if (expectedUrl.equals(actualUrl)) {
            System.out.println("URL testi Passed");
        } else {
            System.out.println("URL testi Failed");
            System.out.println("Actual URL"+ actualUrl);
        } // iste if elegi ile testimizi yapiyoruz


        // 2. ve Title'in test kelimesi icerdigini test edin

        String expectedTitleIcerigi= "test";
        String actualTitle = driver.getTitle();

        if (actualTitle.contains(expectedTitleIcerigi)){
            System.out.println("title testi Passed");
        } else {
            System.out.println("Title testi Failed");
            System.out.println("Actual title :" + actualTitle);
        }





        driver.quit();


    }
}
