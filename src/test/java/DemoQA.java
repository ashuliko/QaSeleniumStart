import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class DemoQA {
    WebDriver wd;

    @BeforeMethod
    public void init() {
        wd = new ChromeDriver();
        wd.navigate().to("https://demoqa.com/automation-practice-form");
        wd.manage().window().maximize();
        //неявное ожидание элемента какого то, с момента запуска ждет до 10сек или раньше, если элемент появился
        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        JavascriptExecutor js=(JavascriptExecutor)wd;
        js.executeScript("document.querySelector('footer').style.display='none';");

    }

    @Test
     public void fillStudentForm(){
        type(By.id("firstName"), "Ivan");
        type(By.cssSelector("#lastName"), "Ivanov");
        type(By.xpath("//*[@id='userEmail']"), "dugma@gmail.com");
        wd.findElement(By.cssSelector("#gender-radio-1")).click();
        type(By.id("userNumber"), "123456789");
        type(By.xpath("//*id='dateOfBirthInput']"), "31 Aug 2021");

        wd.findElement(By.id("submit")).click();

        }

        public void type(By locator, String text){
            WebElement element = wd.findElement(locator);
            element.click();
            element.clear();
            element.sendKeys(text);
        }




}
