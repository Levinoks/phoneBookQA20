package tests;

import dto.UserDTO;
import dto.UserDTOLombok;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Random;

public class RegistrationTests extends BaseTest {
Random rand = new Random();
    @BeforeMethod
    public void preconditions() {
        signoutIfAuthorized();
    }


    @Test
    public void positiveRegistrationUserDtoLombok() {
        String email = random.generateEmail(6);
        String password = random.generatePassword(8);
        UserDTOLombok userLombok = UserDTOLombok.builder()
                .email(email)
                .password(password)
                .build();
        app.getUserHelper().registrationLombok(userLombok);
        Assert.assertTrue(app.getUserHelper().validationSuccessfulLogin());


    }

//    @Test
//    public void positiveRegistrationUserDto() {
//
//        app.getUserHelper().registration();
//        Assert.assertTrue(app.getUserHelper().validationSuccessfulLogin());
//
//
//    }

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

//    @Test
//    public void allSpecialCharsPassword() {
//        app.getUserHelper().registrationPasswordDiffChars();
//
//
//    }

    @Test
    public void negativeRegistrationPassword_lessSymbols() {//7 symbols
        UserDTO user = new UserDTO(random.generateEmail(7), "User#12");
        app.getUserHelper().negativeRegistration(user);

        Assert.assertTrue(app.getUserHelper().registrationFailedErrorMessage());
    }

//    @Test   //according to the documentation it is not possible to create a password more than 15 symbols.But the test failed with a password of 16 symbols. it is a bug!!!
//    public void negativeRegistrationPassword_moreSymbols() {//15 symbols
//        UserDTO user = new UserDTO("Educator22@mydomain.com", "UserUserU#123456");
//        app.getUserHelper().negativeRegistration(user);
//
//        Assert.assertTrue(app.getUserHelper().registrationFailedErrorMessage());
//    }
    @Test
    public void negativeRegistrationUserAlreadyExist() {//user already exist
        UserDTO user = new UserDTO("Educator10@mydomain", "User#123");
        app.getUserHelper().negativeRegistration(user);

        Assert.assertTrue(app.getUserHelper().registrationFailedErrorMessage3());
    }

    @Test
    public void negativeRegistrationEmail_WO_at() {//without @
        UserDTO user = new UserDTO(random.generateString(4)+"domaincom", "User#123");
        app.getUserHelper().negativeRegistration(user);

        Assert.assertTrue(app.getUserHelper().registrationFailedErrorMessage());
    }
//    @Test  //according to the documentation it is not possible to make registration with cyrillic email. it is a bug!!!
//    public void negativeRegistrationEmailCyrillic() {//all parts are in cyrillic
//        UserDTO user = new UserDTO("тестер"+ rand.nextInt()+"22@гмейл.ком", "User#123");
//        app.getUserHelper().negativeRegistration(user);
//
//        Assert.assertTrue(app.getUserHelper().registrationFailedErrorMessage());
//    }

    @Test
    public void negativeRegistrationEmail_moreThan65Chars() {//more than max 65 characters in the recipient name
        UserDTO user = new UserDTO(random.generateString(65)+"@domain.com", "User#123");
        app.getUserHelper().negativeRegistration(user);

        Assert.assertTrue(app.getUserHelper().registrationFailedErrorMessage());
    }



}



