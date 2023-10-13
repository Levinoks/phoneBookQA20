package tests;

import dto.UserDTO;
import dto.UserDTOLombok;
import dto.UserDTOWith;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {

    @Test
    public void positiveLoginUserDTOLombok(){
        UserDTOLombok userLombok = UserDTOLombok.builder()
                .email("qwer1@hh.e")
                .password("User#12345")
                .build();

        app.getUserHelper().login(userLombok );
        Assert.assertTrue(app.getUserHelper().validationSuccessfulLogin());

    }

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

    @Test
    public void negativeLoginUserDTO(){
        UserDTO user = new UserDTO("qw122@vv.ff", "123we4@1");
        app.getUserHelper().negativeLogin(user);
       
        Assert.assertTrue(app.getUserHelper().loginFailedErrorMessage());
    }



}
