package manager;

import dto.UserDTO;
import dto.UserDTOLombok;
import dto.UserDTOWith;
import org.openqa.selenium.*;
import utils.RandomUtils;


public class UserHelper extends BaseHelper {

    public UserHelper(WebDriver driver) {
        super(driver);
    }


    By btnLoginNavBar = By.xpath("//a[@href='/login']");
    By inputEmail = By.xpath("//input[@name='email']");
    By inputPassword = By.xpath("//input[@name='password']");
    By btnLoginSubmit = By.xpath("//button[@name='login']");
    By btnSignOutNavBar = By.xpath("//button[contains(text(), 'Sign Out')]");
    By errorMessage1 = By.xpath("//div[contains(text(), 'Login Failed with code 401')]");
    By errorMessage2 = By.xpath("//div[contains(text(), 'Registration failed with code 400')]");
    By errorMessage3 = By.xpath("//div[contains(text(), 'Registration failed with code 409')]");
    RandomUtils random = new RandomUtils();
    By btnRegSubmit = By.xpath("//button[@name='registration']");
    By btnContactsNavBar = By.xpath("//a[@href='/contacts']");
    String btnSignOutJS = "document.querySelector('button').click();";


    public void login(UserDTO user) {
        click(btnLoginNavBar);
        inputData(inputEmail, user.getEmail());
        inputData(inputPassword, user.getPassword());
        clickByXY(btnLoginSubmit, 2, 2);
        pause(5);

    }

    public void login(UserDTOWith user) {
        click(btnLoginNavBar);
        inputData(inputEmail, user.getEmail());
        inputData(inputPassword, user.getPassword());
        click(btnLoginSubmit);
        pause(5);

    }

    public void login(UserDTOLombok user) {
        click(btnLoginNavBar);
        inputData(inputEmail, user.getEmail());
        inputData(inputPassword, user.getPassword());
        click(btnLoginSubmit);
        pause(5);


    }


    public void negativeLogin(UserDTO user) {
        click(btnLoginNavBar);
        inputData(inputEmail, user.getEmail());
        inputData(inputPassword, user.getPassword());
        click(btnLoginSubmit);
        pause(10);
        alert();

    }

    public void registration() {
        click(btnLoginNavBar);
        inputData(inputEmail, random.generateEmail(5));
        inputData(inputPassword, random.generatePassword(8));
        click(btnRegSubmit);


    }


    public void registrationLombok(UserDTOLombok user) {
        click(btnLoginNavBar);
        inputData(inputEmail, user.getEmail());
        inputData(inputPassword, user.getPassword());
        click(btnRegSubmit);
    }

    public void negativeRegistration(UserDTO user) {
        click(btnLoginNavBar);
        inputData(inputEmail, user.getEmail());
        inputData(inputPassword, user.getPassword());
        click(btnRegSubmit);
        pause(10);
        alert();

    }


    public void registrationPasswordDiffChars() {

        for (int i = 0; i < random.pass().length; i++) {
            click(btnLoginNavBar);
            inputData(inputEmail, random.generateEmail(5));
            inputData(inputPassword, random.pass()[i]);

            System.out.println(random.pass()[i]);
            click(btnRegSubmit);


            if (isElementPresent(btnSignOutNavBar)) {
                click(btnSignOutNavBar);
            } else {
                char ch = random.pass()[i].charAt(7);
                System.out.println("'" + ch + "'" +
                        " - special symbol is not valid!\nchar index = " + i);
                pause(10);
                alert();

            }
        }
    }


    public boolean validationSuccessfulLogin() {
        return isTextEqual(btnContactsNavBar, "Contacts");
    }

    public boolean loginFailedErrorMessage() {
        return isTextEqual(errorMessage1, "Login Failed with code 401");
    }

    public boolean registrationFailedErrorMessage() {
        return isTextEqual(errorMessage2, "Registration failed with code 400");
    }public boolean registrationFailedErrorMessage3() {
        return isTextEqual(errorMessage3, "Registration failed with code 409");
    }


    public boolean isBtnSignOutPresent() {
        return isElementPresent(btnSignOutNavBar);
    }

    public void signout() {
        clickByJS(btnSignOutJS);

    }

}
