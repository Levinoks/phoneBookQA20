package tests;

import dto.UserDTO;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegistrationTests extends BaseTest{

    @Test
    public void positiveRegistrationUserDto(){
        UserDTO user = new UserDTO();
        app.getUserHelper().registration();
        Assert.assertTrue(app.getUserHelper().validationSuccessfulLogin());


    }

    @Test
    public void negativeRegistrationUserDto(){
        UserDTO user = new UserDTO("qqqq", "123");
        app.getUserHelper().registration();
        Assert.assertTrue(app.getUserHelper().loginFailedErrorMessage());
    }




}
