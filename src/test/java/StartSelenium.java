import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class StartSelenium {
    //before ( open www) ---> test (steps)+Assert ---> after (logout)
    //before (open browser) ---> test(open www) ---> after (close www + close browser)

    WebDriver wd;

@BeforeMethod
public void preCondition(){
    //open browser
    wd = new ChromeDriver();
}

@Test
    public void startContact(){
    //open www
        //without history
    //wd.get("https://contacts-app.tobbymarshall815.vercel.app/home");
        //with history
    wd.navigate().to("https://contacts-app.tobbymarshall815.vercel.app/home");

    WebElement element1 = wd.findElement(By.tagName("div"));
    wd.findElement(By.xpath("//div"));
    List<WebElement> list = wd.findElements(By.tagName("div"));


    System.out.println(list.size());
    WebElement elDiv2 = list.get(1);


    WebElement element2 = wd.findElement(By.id("root"));
    wd.findElement(By.xpath("//*[@id='root']"));
    wd.findElement(By.cssSelector("#root"));

    //WebElement element3 = wd.findElement(By.className("login_login__3EHKB"));
    WebElement element3 = wd.findElement(By.className("container"));
    WebElement element4 = wd.findElement(By.cssSelector("login_login__3EHKB"));
    wd.findElement(By.xpath("//*[@class='container']"));
    wd.findElement(By.xpath("//[@class='login_login__3EHKB']"));
}
@Test
    public void loginTest(){

    //step1 open www
    wd.navigate().to("https://contacts-app.tobbymarshall815.vercel.app/home");

    //step2 click login button
    //WebElement loginA = wd.findElement(By.className("active"));
    WebElement loginA = wd.findElement(By.linkText("LOGIN"));
    loginA.click();

    //step3 type email
            //index 0 = email, index1 = password
    List<WebElement> listInputs = wd.findElements(By.tagName("input"));
    WebElement email = listInputs.get(0); //dostali iz lista: listInputs
    wd.findElements(By.cssSelector("[placeholder = \"Email\"]"));
    email.click();
    email.clear();
    email.sendKeys("qwerty@ru.ru");

    //step4 type password
    WebElement password = listInputs.get(1); //dostali iz lista: listInputs
    wd.findElement(By.cssSelector("[placeholder = 'Password']"));
    password.click();
    password.clear();
    password.sendKeys("AaSsDd123*$!");

    //step5 click login button
    WebElement loginB = wd.findElement(By.tagName("button"));
    wd.findElement(By.cssSelector("button"));
    loginB.click();


}

    @Test
    public void loginXPathTest(){

    }

@AfterMethod
    public void postCondition(){
    //close browser+www

        //close 1 window, browser work
    //wd.close();
        //close all windows and browser
    //wd.quit();
}

}
