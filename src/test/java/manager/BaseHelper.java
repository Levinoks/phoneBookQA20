package manager;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.util.List;

public class BaseHelper {
    WebDriver driver;



    public BaseHelper(WebDriver driver) {
        this.driver = driver;
    }

    private WebElement findElement(By locator) {
        System.out.println(locator);
        return driver.findElement(locator);

    }

    private List<WebElement> findElements(By locator) {
        System.out.println(locator);
        return driver.findElements(locator);

    }

    public void click(By locator) {
        WebElement elem = findElement(locator);
        elem.click();
    }

    public void inputData(By locator, String text) {
        WebElement elem = findElement(locator);
        elem.click();
        elem.clear();
        elem.sendKeys(text);

    }

    public String getText(By locator) {
        WebElement elem = findElement(locator);
        return elem.getText().trim().toUpperCase();
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

    public void pause(int second) {
        try {
            Thread.sleep(second * 1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    public boolean isElementPresent(By locator) {
        return !findElements(locator).isEmpty();
    }

    public void alert() {
        new WebDriverWait(driver, 10).until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();
    }

    public void clickByXY(By locator, int down, int right){
        Rectangle rect = findElement(locator).getRect();
        int x=rect.getX()+rect.getWidth()/right;
        int y=rect.getY()+rect.getHeight()/down;
        Actions act = new Actions(driver);
        act.moveByOffset(x,y).click().perform();
    }

    public void refresh(){
        Actions act = new Actions(driver);
        act.sendKeys(Keys.F5).click().perform();
    }

    public void clickByJS(String locator){
        JavascriptExecutor js=(JavascriptExecutor) driver;
        js.executeScript(locator);
        System.out.println(locator);
    }


}
