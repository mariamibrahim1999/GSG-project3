import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static java.lang.Thread.sleep;

public class FirstTest {
    WebDriver driver;
    WebElement contactButton;
    JavascriptExecutor jse;
    @BeforeClass
    public void setUp(){
        //Initialize driver
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
       driver=  WebDriverManager.chromedriver().capabilities(options).create();
        jse = (JavascriptExecutor) driver;
       driver.get("https://wewill.tech");

    }

    @Test(priority = 1)
    public void contactButtonIsDisplayed()  {
        contactButton=driver.findElement(By.xpath("//*[@id=\"ast-desktop-header\"]/div[1]/div/div/div/div[2]/div[2]/div"));
        Assert.assertTrue(contactButton.isDisplayed());
    }

    @Test(priority = 2)
    public void contactButtonTextIsCorrect(){
        Assert.assertEquals(contactButton.getText(),"Contact");
    }

    @Test(priority = 4)
    public void scrollTopIsDisplayed() throws InterruptedException {
        jse.executeScript("window.scrollBy(0,500)");
        sleep(3000);
        WebElement scrollTop= driver.findElement(By.cssSelector("svg.ast-arrow-svg"));
        Assert.assertTrue(scrollTop.isDisplayed());
        
    }
}
