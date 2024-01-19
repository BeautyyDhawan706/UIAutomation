package Testcase;

import Base.TestBase;

import Pages.LoginPage;
import Util.Generic;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {

    LoginPage page ;


    public LoginTest(){
        super();
    }
    @BeforeSuite
    public void setup() throws InterruptedException {
        initialization();
        page = new LoginPage();

    }

    @Test(priority = 1)
    public void verifyText() throws InterruptedException {
        String text =  page.validateTextMsgOnLoginPage();
        Assert.assertEquals(text, prop.getProperty("LoginImage"));
    }

    @Test(priority = 2)
    public void UserLoginWithValidNumber() throws InterruptedException {
        page.login(prop.getProperty("validNumber"));

    }



//    @AfterSuite
//    public void Teardown(){
//        driver.quit();
//
//
//    }
}
