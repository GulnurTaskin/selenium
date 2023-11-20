package Practice.day_01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class P04_ilkSeleniumTesti {
    public static void main(String[] args) {
        /*
     . .Exercise2...
1-Driver oluşturalim
2-Java class'imiza chnomedriver.exet i tanitalim
3-Driver'in tum ekranı kaplamasini saglayalim
4-Driverla sayfanın yuklenmesini 10.000 milisaniye (10 saniye) boyunca beklesini söyleyelim. Egen oncesinde sayfa Yüklenirse, beklemeyi bıraksın.
5-"https://www.otto.de” adresine gidelim
6-BU web adresinin sayfa basligini (title) ve adres (url)ini alalim
7-Title ve url inin "0TT0” kelimesinin içerip icermedigini kontrol edelim
8-Ardindan "https://wisequarter.com/” adresine gidip
9-BU adresin basligini alalim ve "Quarter” kelimesini icenip icermedigini kontrol edelim
10-Bir onceki web sayfamiza geri donelim
11-Sayfayı yenileyelim
12-Daha sonra web sayfamiza tekrar donelim ve oldugumuuz sayfayi kapatalim
13- En son adim olarak butun sayfalarimizi kapatmis olalim
     */

        System.setProperty("Webdriver.chrome.driver","src/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10000));

        driver.get("https://www.otto.de");
        String ottoUrl = driver.getCurrentUrl();
        String ottoTitle = driver.getTitle();
        if (ottoTitle.contains("OTTO")&&ottoUrl.contains("OTTO")){
            System.out.println("TITLE and URL test PASSED");
        }else {
            System.out.println("TITLE and URL test FAILED");
        }

        driver.get("https://wisequarter/");
        String wqTitle = driver.getTitle();
        boolean kelime = wqTitle.contains("Quarter");
        if (kelime){
            System.out.println("WISE QUARTER TEST PASSED");
        }else {
            System.out.println("WISE QUARTER TEST FAILED");

            driver.navigate().back();
            driver.navigate().refresh();
            driver.navigate().forward();

        }

        //if else içinde else'de kaldığı için else olmazsa yazdırmaz
        System.out.println("-------------------------------------Test Tamamlandi-----------------------------------");


driver.quit();

    }
}
