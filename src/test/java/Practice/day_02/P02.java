package Practice.day_02;

import net.bytebuddy.jar.asm.Handle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

public class P02 {
    public static void main(String[] args) throws InterruptedException {

        // test icin gerekli ayarlamalari yapiyoruz

        System.setProperty("webdriver.chrome.driver","src/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // 1- www.google.com adresine gidin
        String ht = "https://www.";
        driver.get(ht+"google.com");

        // 2- sayfanın title, Url ve handle değerlerini yazdırın
        System.out.println("1.sekme URL = "+driver.getCurrentUrl());
        System.out.println("1.sekme Title = "+driver.getTitle());
        System.out.println("1.sekme Handle = "+driver.getWindowHandle());
        String handle1 =driver.getWindowHandle() ;
        driver.navigate().refresh();
        System.out.println("1.sekme refresh sonrasi Handle = "+driver.getWindowHandle());

        // pencerenin handle numarasi her pencere acista degisir
        // 3-yeni bir sekme açılarak www.wisequarter.com adresine gidin
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get(ht+"wisequarter.com");

        // 4- gidilen sayfanın title ve url, handle değerleri yazdırın
        System.out.println("2.sekme URL = "+driver.getCurrentUrl());
        System.out.println("2.sekme Title = "+driver.getTitle());
        System.out.println("2.sekme Handle = "+driver.getWindowHandle());
        String handle2=driver.getWindowHandle() ;
        System.out.println("Tum sekmeler = "+driver.getWindowHandles()); // acilan iki sekmenin handle degerlerini yazdirir

        // 5- ilk sekmeye geçip, burada www.testotomasyonu.com adresine gidin
        // ilk sekmeye donmek icin o sekmenin handle variable'i kullanilir


        driver.switchTo().window(handle1); // burda tekrar eski sekmeye yani ilk sekmeye, handle1 numarali sekmeye switch ile geciyoruz
        driver.get(ht+"testotomasyonu.com"); // ve o geri dondugumuz sekmede testotomasyonu sayfasina gidiyoruz

        // 6- gidilen sayfanın title ve url handle değerleri yazdırın
        System.out.println("1.sekme URL= "+driver.getCurrentUrl());
        System.out.println("1.sekme Title= "+driver.getTitle());
        System.out.println("1.sekme Handle = "+driver.getWindowHandle());

        //2. sekmeye dönmek için 2. sekmenin handle degeri olarak atadigimiz handle2 kullanılır

        driver.switchTo().window(handle2);
        driver.get("http://www.babayigit.net");


        // simdi sekme degil, yeni bir pencere aciyoruz
        driver.switchTo().newWindow(WindowType.WINDOW);
        System.out.println("Yeni pencere ilk Sekme Handle = " + driver.getWindowHandle());
        driver.get(ht+"wisequarter.com");

        driver.switchTo().window(handle1);
        driver.navigate().to(ht+"amazon.com");
        System.out.println("Sekme Handle = " + driver.getWindowHandle());



        // navigate ile web adreslerine gidiyoruz, switch ile sekmeler ve pencereler arasında dolaşıyoruz(Nevfel)

        // 7- açılan pencereleri kapatın.
        Thread.sleep(1000);
        driver.quit();

    }
}



