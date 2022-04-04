import com.thoughtworks.gauge.Logger;
import com.thoughtworks.gauge.Step;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import io.appium.java_client.TouchAction;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public class BasePage extends BaseTest{

    @Step("<int> saniye kadar bekle")
    public void waitForsecond(int s) throws InterruptedException {
        Thread.sleep(1000*s);
    }

    @Step("<id> elementin sayfada gorunur olduğunu kontrol et ve tıkla")
    public void findByelementEndclick(String id){
        MobileElement element = appiumDriver.findElement(By.id(id));
        if (element.isDisplayed()){
            element.click();
            Logger.info("Kontrol edilen element Gorunur oldu ve tiklandi");
        }else{
            Logger.info("Kontrol edilen" + " " + id + "element Gorunur olmadi");
        }
    }


    @Step("Sayfayı aşağı doğru kaydır")

    public void Scroll(){

        TouchAction action = new TouchAction(appiumDriver);
        action.press(PointOption.point(713,2605)).moveTo(PointOption.point(713,485)).release().perform();

    }

    @Step("Rastgele Ürün Seç")
    public void chooseRandomProduct(){

        List<MobileElement> elements = appiumDriver.findElements(By.xpath("//*[@resource-id='com.ozdilek.ozdilekteyim:id/imageView']"));
        Random rnd = new Random();
        int rndInt = rnd.nextInt(elements.size());
        elements.get(rndInt).click();
        Logger.info("Kontrol edilen" + " " + rndInt + ". index elementi Gorunur oldu ve tiklandi");

    }

    @Step("Id <id> li elementi bul ve <info> gir")
    public void sendKeys(String id, String info){

        System.out.println("Giris yapma sayfasi acildi");
        MobileElement element = appiumDriver.findElement(By.id(id));
        if (element.isDisplayed()){
            element.sendKeys(info);
            Logger.info("Kontrol edilen" + " " + id + "element Gorunur oldu ve tiklandi");
        }else{
            Logger.info("Kontrol edilen" + " " + id + "element Gorunur olmadi");
        }

    }

    @Step("Xpath <xpath> li elementi bul ve tıkla")
    public void clickByxpath(String xpath){

        MobileElement element = appiumDriver.findElement(By.xpath(xpath));
        if (element.isDisplayed()){
            element.click();
            Logger.info("Kontrol edilen" + " " + xpath + "element Gorunur oldu ve tiklandi");
        }else{
            Logger.info("Kontrol edilen" + " " + xpath + "element Gorunur olmadi");
        }

    }

}

