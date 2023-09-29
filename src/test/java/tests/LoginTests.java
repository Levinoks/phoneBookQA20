package tests;

import dto.UserDTO;
import dto.UserDTOWith;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {

    @Test
    public void positiveLoginUserDTO(){
        UserDTO user =  new UserDTO("qwer1@hh.e", "User#12345");
        app.getUserHelper().login(user);
        Assert.assertTrue(app.getUserHelper().validationSuccessfulLogin());

    }

    @Test
    public void positiveLoginUserDTOWith(){
        UserDTOWith user =  new UserDTOWith().withEmail("qwer1@hh.e").withPassword("User#12345");
        app.getUserHelper().login(user);
        Assert.assertTrue(app.getUserHelper().validationSuccessfulLogin());

    }
}
