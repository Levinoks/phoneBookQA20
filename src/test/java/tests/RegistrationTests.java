package tests;

import dto.UserDTO;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegistrationTests extends BaseTest {


    @Test
    public void positiveRegistrationUserDto() {

        app.getUserHelper().registration();
        Assert.assertTrue(app.getUserHelper().validationSuccessfulLogin());


    }

    @Test
    public void negativeRegistrationPasswordWithoutLetters() {
        UserDTO user = new UserDTO("qwe@fg.com", "1234567!");   //1234567! (without letters)
        app.getUserHelper().negativeRegistration(user);
        Assert.assertTrue(app.getUserHelper().registrationFailedErrorMessage());


    }

    @Test
    public void negativeRegistrationPassword() {
        UserDTO user = new UserDTO("qwe@fg.com", "рапваыв!!!");   //рапваыв!!! (cyrillic letter or any other language)
        app.getUserHelper().negativeRegistration(user);
        Assert.assertTrue(app.getUserHelper().registrationFailedErrorMessage());


    }

    @Test
    public void negativeRegistrationUserDto() {
        UserDTO user = new UserDTO("qqqq", "123");
        app.getUserHelper().negativeRegistration(user);

        Assert.assertTrue(app.getUserHelper().registrationFailedErrorMessage());
    }

    @Test
    public void allSpecialCharsPassword() {
        app.getUserHelper().registrationPasswordDiffChars();


    }


}



