package day01_practice;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C01 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // "https://testpages.herokuapp.com/styled/calculator" adresine gidin
        driver.get("https://testpages.herokuapp.com/styled/calculator");

        // ilk kutucuga 20 giriniz
        List<WebElement> kutucuklar = driver.findElements(By.xpath("//*[@type='text']"));
        WebElement ilkKutucuk = kutucuklar.get(0);
        ilkKutucuk.sendKeys("20");

        // ikinci kutucuga 30 giriniz
        WebElement ikinciKutucuk = kutucuklar.get(1);
        ikinciKutucuk.sendKeys("30");

        // calculate'e tıklayınız
        WebElement calculateButonu = driver.findElement(By.xpath("//*[@type='submit']"));
        calculateButonu.click();
        Thread.sleep(3000);

        // sonucu yazdırınız
        WebElement sonuc = driver.findElement(By.xpath("//*[@id='answer']"));
        System.out.println("Sonuc: "+sonuc.getText());

        // sayfayi kapatiniz
        driver.close();

    }
}
