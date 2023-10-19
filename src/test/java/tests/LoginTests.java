package tests;

import dto.UserDTO;
import dto.UserDTOWith;
import org.testng.Assert;
import org.testng.annotations.*;

public class LoginTests extends BaseTest {
    @BeforeMethod
    public void preconditionsLogin() {
        signoutIfAuthorized();
    }



    @Test
    public void positiveLoginUserDTOLombok() {


        app.getUserHelper().login(userLombok);
        Assert.assertTrue(app.getUserHelper().validationSuccessfulLogin());

    }

    @Test
    public void positiveLoginUserDTO() {
        UserDTO user = new UserDTO("qwer1@hh.e", "User#12345");
        app.getUserHelper().login(user);
        Assert.assertTrue(app.getUserHelper().validationSuccessfulLogin());

    }

    @Test
    public void positiveLoginUserDTOWith() {
        UserDTOWith user = new UserDTOWith().withEmail("qwer1@hh.e").withPassword("User#12345");
        app.getUserHelper().login(user);
        Assert.assertTrue(app.getUserHelper().validationSuccessfulLogin());

    }

    @Test
    public void negativeLoginUserDTO() {
        UserDTO user = new UserDTO("qw122@vv.ff", "123we4@1");
        app.getUserHelper().negativeLogin(user);

        Assert.assertTrue(app.getUserHelper().loginFailedErrorMessage());
    }

    @Test
    public void negativeLoginWrongPassword() {//password without lowercase letters
        UserDTO user = new UserDTO("qw122@vv.ff", "QAQAQ12345");
        app.getUserHelper().negativeLogin(user);

        Assert.assertTrue(app.getUserHelper().loginFailedErrorMessage());
    }
    @Test
    public void negativeLoginBlankPassword() {//password is blank
        UserDTO user = new UserDTO("qw122@vv.ff", "");
        app.getUserHelper().negativeLogin(user);

        Assert.assertTrue(app.getUserHelper().loginFailedErrorMessage());
    }

    @Test
    public void negativeLoginWrongEmail() {//special characters appear consecutively two or more times
        UserDTO user = new UserDTO("Qwer%%ty1@mydomain.ua", "QAQAQ12345");
        app.getUserHelper().negativeLogin(user);

        Assert.assertTrue(app.getUserHelper().loginFailedErrorMessage());
    }

    @Test
    public void negativeLoginEmail_WO_at() {//without @
        UserDTO user = new UserDTO("testermydomain.com", "User#123");
        app.getUserHelper().negativeLogin(user);

        Assert.assertTrue(app.getUserHelper().loginFailedErrorMessage());
    }

    @Test
    public void negativeLoginEmail_with2at() {//email is not well-formed with 2 @
        UserDTO user = new UserDTO("educator94@@gmail.com", "User#123");
        app.getUserHelper().negativeLogin(user);

        Assert.assertTrue(app.getUserHelper().loginFailedErrorMessage());
    }

}
