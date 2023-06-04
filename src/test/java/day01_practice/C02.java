package day01_practice;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // https://www.amazon.com/ adresine gidin
        driver.get("https://www.amazon.com/");

        // arama motorunda nutella yazip aratınız
        WebElement aramaKutusu = driver.findElement(By.xpath("//*[@type='text']"));
        aramaKutusu.sendKeys("nutella", Keys.ENTER);

        // Customer Service ve Registry butonlarına sırasıyla tıklayın ve title'larının "Amazon" icerdigini test edin
        WebElement customerService = driver.findElement(By.xpath("(//*[@class='nav-a  '])[2]"));
        customerService.click();
        String customerServiceTitle = driver.getTitle(); //Customer Service title'ini String variable'a assign ettik
        driver.navigate().back(); //geri gelmesi icin...

        WebElement registry = driver.findElement(By.xpath("(//*[@class='nav-a  '])[3]"));
        registry.click();
        String registryTitle = driver.getTitle(); //Registry title'ini String variable'a assign ettik

        String expectedContent ="Amazon"; //Beklenen icerik adinda variable olusturduk
        if (customerServiceTitle.contains(expectedContent)){
            System.out.println("Customer service title contains Amazon, Test PASSED");
        }else System.out.println("Customer service title doesn't contain Amazon, Test FAILED");

        if (registryTitle.contains(expectedContent)){
            System.out.println("Registry title contains Amazon, Test PASSED");
        }else System.out.println("Registry title doesn't contain Amazon, Test FAILED");

        // pencereyi kapatiniz
        driver.close();
    }
}
