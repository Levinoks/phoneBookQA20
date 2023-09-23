package starttests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;

public class RegistrationTest extends BaseTest {
    @Test
    public void registratitonPositive() {
        clickButtonLogin();
        inputEmail(email);
        System.out.println(email);

        inputPassword(password);
        System.out.println(password);
        clickButtonRegSubmit();
        validation();


    }


}