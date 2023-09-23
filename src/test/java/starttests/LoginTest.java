package starttests;

import org.testng.annotations.*;


public class LoginTest extends BaseTest {
    @Test
    public void positiveLogin() {


        clickButtonLogin();
        inputEmail("qwer1@hh.e");
        inputPassword("User#12345");
        clickButtonLoginSubmit();
        validation();

    }
}
