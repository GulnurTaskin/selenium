package day02_driverMethodlari;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C01_getMethodlari {


    public static void main(String[] args) {

        // main methodu cagirdiktan sonra selenium,da calisrken
        // asagidaki 3 satiri mutlaka yaziyoruz
        // bugunun sonunda 4. satiri da ekleyecegiz
        // kopyala yapistir yerine manuel olarak yazmaya alismamiz lazim OBLIGATOIRE

        System.setProperty("Webdriver.chromee.driver","src/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.testotomasyonu.com"); // driver'a gidecegi sitenin adresini https://'li olarak yaziyoruz

        // daha sonra baska bir adres'e yonlendiriyoruz
        driver.get("https://www.wisequarter.com");


        // driver.get("www.youtube.com")
        // driver.get() https:// yazilmadan calismaz
        driver.get("https://youtube.com");


        // actigimiz sayfalari kapatmak icin;
        driver.close(); // close methodu, kodu run ettigimiz zaman tam olarak kapatmiyor
        // kod calismaya devam ediyor
        // o yuzden driver.quit() kullanmak daha iyi




    }
}
