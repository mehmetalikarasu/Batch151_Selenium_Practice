package day05_practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C01_Iframe extends TestBase {
    // https://www.jqueryscript.net/demo/jQuery-Plugin-For-Responsive-Flexible-Iframes-Flexy/ sayfasına gidiniz
    // Videoyu görecek kadar asagiya ininiz
    // Videoyu izlemek icin Play tusuna basiniz
    // videoyu durdurunuz
    // videoyu tam ekran yapınız
    // videoyu calıstırınız
    // videoyu kucultunuz
    // videoyu durdurunuz
    // Videoyu calistirdiginizi test ediniz
    // 'jQuery Flexy Plugin Demos' yazısının gorunur oldugunu test ediniz


    @Test
    public void test01() {
        // https://www.jqueryscript.net/demo/jQuery-Plugin-For-Responsive-Flexible-Iframes-Flexy/ sayfasına gidiniz
        driver.get("https://www.jqueryscript.net/demo/jQuery-Plugin-For-Responsive-Flexible-Iframes-Flexy/");

        // Videoyu görecek kadar asagiya ininiz
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        bekle(2);

        // Videoyu izlemek icin Play tusuna basiniz
        driver.switchTo().frame(0); //Video frame'in icinde oldugu icin driver'i frame'in icine aliyoruz.
        WebElement playButton = driver.findElement(By.xpath("//*[@class='ytp-large-play-button ytp-button ytp-large-play-button-red-bg']"));
        playButton.click();
        bekle(2);

        // videoyu durdurunuz
        WebElement playOrStopButton = driver.findElement(By.xpath("//*[@class='ytp-play-button ytp-button']"));
        playOrStopButton.click();
        bekle(2);

        // videoyu tam ekran yapınız
        WebElement fullScreenButton = driver.findElement(By.xpath("//*[@class='ytp-fullscreen-button ytp-button']"));
        fullScreenButton.click();

        // videoyu calıstırınız
        playOrStopButton.click();
        bekle(2);

        // videoyu kucultunuz
        fullScreenButton.click();
        bekle(2);

        // videoyu durdurunuz
        playOrStopButton.click();
        bekle(2);

        // Videoyu calistirdiginizi test ediniz
        WebElement youtubeText = driver.findElement(By.xpath("//*[@class='ytp-youtube-button ytp-button yt-uix-sessionlink']"));
        Assert.assertTrue(youtubeText.isDisplayed());
        //Videoyu baslatmadan once sag alttaki youtube yazisi gozukmuyor, baslattiktan sonra gozukuyor bu nedenle isDisplayed() ile test ettik.

        // 'jQuery Flexy Plugin Demos' yazısının gorunur oldugunu test ediniz
        driver.switchTo().defaultContent();  //Bu yazi frame'in disinda oldugu icin anasayfaya donduruyourz driver'imizi.
        WebElement text = driver.findElement(By.xpath("//h1"));
        Assert.assertTrue(text.isDisplayed());

    }
}
