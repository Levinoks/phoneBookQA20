package tests;

import manager.AppManager;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseTest {
    static AppManager app = new AppManager();

    @BeforeSuite
    public void setUp(){
        app.init();
    }

    @AfterSuite
    public void stop(){
        app.tearDown();
    }
}
