package manager;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class BaseHelper {
    WebDriver driver;

    public BaseHelper(WebDriver driver) {
        this.driver = driver;
    }

    private WebElement findElement(By locator){
        System.out.println(locator);
        return driver.findElement(locator);

    }
    private List<WebElement> findElements(By locator){
        System.out.println(locator);
        return driver.findElements(locator);

    }

    public void click (By locator){
        WebElement elem = findElement(locator);
        elem.click();
    } public void inputData (By locator, String text){
        WebElement elem = findElement(locator);
        elem.click();
        elem.clear();
        elem.sendKeys(text);

    }

    public String getText (By locator){
        WebElement elem = findElement(locator);
        return  elem.getText().trim().toUpperCase();
    }

    public boolean isTextEqual(By locator, String expectedResult) {
        String actualResult = getText(locator);
        expectedResult = expectedResult.toUpperCase();
        if (expectedResult.equals(actualResult)) {
            return true;
        } else {
            System.out.println("expected result: " + expectedResult + "\nactual result: " + actualResult);
            return false;

        }

    }



}
