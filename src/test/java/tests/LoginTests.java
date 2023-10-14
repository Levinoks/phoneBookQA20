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


}
