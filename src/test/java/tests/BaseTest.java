package tests;

import dto.UserDTOLombok;
import manager.AppManager;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import utils.RandomUtils;

public class BaseTest {
    static AppManager app = new AppManager();
    UserDTOLombok userLombok = UserDTOLombok.builder()
            .email("qwer1@hh.e")
            .password("User#12345")
            .build();
    RandomUtils random = new RandomUtils();

    @BeforeSuite
    public void setUp() {
        app.init();
    }

    @AfterSuite
    public void stop() {
        app.tearDown();
    }

    public void signoutIfAuthorized() {
        if (app.getUserHelper().isBtnSignOutPresent())
            app.getUserHelper().signout();


    }
}
