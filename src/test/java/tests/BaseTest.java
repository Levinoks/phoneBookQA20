package tests;

import dto.UserDTOLombok;
import manager.AppManager;
import manager.TestNGListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.*;
import utils.RandomUtils;

import java.lang.reflect.Method;
@Listeners(TestNGListener.class)
public class BaseTest {
    Logger logger = LoggerFactory.getLogger(BaseTest.class);
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

    @BeforeMethod
    public void loggerBeforeMethod(Method method){
        logger.info("start method: "+ method.getName());
    }

    @AfterMethod
    public void loggerAfterMethod(Method method){
        logger.info("stop method: "+ method.getName());
    }
}
