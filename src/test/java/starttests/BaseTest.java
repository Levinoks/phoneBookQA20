package starttests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import utils.RandomUtils;

import java.util.concurrent.TimeUnit;

public class BaseTest {


    public WebDriver driver;
    public int emailNameLenght = 7;
    public int passLenght = 8;
    RandomUtils randomUtils = new RandomUtils();
    public String email = randomUtils.generateEmail(emailNameLenght);
    public String password = randomUtils.generatePassword(passLenght);
    public WebElement btnLogin;
    public WebElement inputEmail;
    public WebElement inputPass;
    public WebElement btnLoginSubmit;
    public WebElement btnRegSubmit;
    public WebElement btnSignOut;


    @BeforeSuite
    public void setUp() {
        driver = new ChromeDriver();
        driver.navigate().to("https://telranedu.web.app/home");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

        String emailForLogin = email;
        String passwordForLogin = password;


    }

    public void validation() {
        WebElement btnSignOut = driver.findElement(By.xpath("//button"));
        String btnSignOutText = btnSignOut.getText().trim().toUpperCase();
        System.out.println(btnSignOutText);
        String expectedResult = "SIGN OUT";
        Assert.assertEquals(btnSignOutText, expectedResult);

    }

    public void clickButtonLogin() {
        WebElement btnLogin = driver.findElement(By.xpath("//a[@href='/login']"));
        btnLogin.click();
    }

    public void clickButtonLoginSubmit() {
        WebElement btnLoginSubmit = driver.findElement(By.xpath("//button[@name='login']"));
        btnLoginSubmit.click();
    }

    public void clickButtonRegSubmit() {
        WebElement btnRegSubmit = driver.findElement(By.xpath("//button[@name='registration']"));
        btnRegSubmit.click();
    }

    public void inputEmail(String email) {
        WebElement inputEmail = driver.findElement(By.xpath("//input[@name='email']"));
        inputEmail.click();
        inputEmail.clear();
        inputEmail.sendKeys(email);

    }

    public void inputPassword(String password) {
        WebElement inputPass = driver.findElement(By.xpath("//input[@name='password']"));
        inputPass.click();
        inputPass.clear();
        inputPass.sendKeys(password);

    }

    @AfterSuite
    public void tearDown() {
        driver.quit();
    }
}
