package manager;

import dto.UserDTO;
import dto.UserDTOWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.RandomUtils;

public class UserHelper extends BaseHelper{

    public UserHelper(WebDriver driver) {
        super(driver);
    }

    By btnLoginNavBar = By.xpath("//a[@href='/login']");
    By inputEmail = By.xpath("//input[@name='email']");
    By inputPassword = By.xpath("//input[@name='password']");
    By btnLoginSubmit = By.xpath("//button[@name='login']");
    By btnSignOutNavBar = By.xpath("//button");
    By errorMessage = By.xpath("//div[@class='login_login__3EHKB']");
    RandomUtils random = new RandomUtils();
    By btnRegSubmit = By.xpath("//button[@name='registration']");




    public void login(UserDTO user){
        click(btnLoginNavBar);
        inputData(inputEmail, user.getEmail());
        inputData(inputPassword, user.getPassword());
        click(btnLoginSubmit);

    }

    public void login (UserDTOWith user){
        click(btnLoginNavBar);
        inputData(inputEmail, user.getEmail());
        inputData(inputPassword, user.getPassword());
        click(btnLoginSubmit);

    }

    public void registration(){
        click(btnLoginNavBar);
        inputData(inputEmail, random.generateEmail(5));
        inputData(inputPassword, random.generatePassword(8));
        click(btnRegSubmit);

    }




    public boolean validationSuccessfulLogin(){
        return isTextEqual(btnSignOutNavBar, "Sign out");
    }

    public boolean loginFailedErrorMessage() {

        return isTextEqual(errorMessage, "Loading...");
    }
}
