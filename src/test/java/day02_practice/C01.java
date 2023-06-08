package day02_practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C01 {
    // https://ebay.com sayfasına gidiniz
    // electronics bolumune tıklayınız
    // genisligi 225 ve uzunlugu 225 olan resimlerin hepsine sırasıyla tıklayınız ve sayfa baslıgını yazdırınız

    WebDriver driver;

    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void tearDown() throws Exception {
        driver.close();
    }

    @Test
    public void test01() throws InterruptedException {
        driver.get("https://www.ebay.com/");
        Thread.sleep(1000);

        driver.findElement(By.xpath("(//*[text()='Electronics'])[2]")).click();
/*
        List<WebElement> images = driver.findElements(By.xpath("//*[@width='225' and @height='225'] "));
        for (int i = 0; i < images.size(); i++) {
            images = driver.findElements(By.xpath("//*[@width='225' and @height='225'] "));
            images.get(i).click();
            Thread.sleep(1000);
            System.out.println("Sayfa basligi : "+driver.getTitle());
            driver.navigate().back();
        }

 */

        for (int i = 0; i < 4; i++) {
            List<WebElement> images = driver.findElements(By.xpath("//img[@width='225' and @height='225']"));
            images.get(i).click();
            System.out.println((i+1)+". sayfa basligi= "+driver.getTitle());
            driver.navigate().back();
        }


    }
}
