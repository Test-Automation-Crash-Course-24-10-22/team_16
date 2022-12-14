package com.softserve.rozetka.login_page_tests.login_button_tests;

import com.softserve.rozetka.locators.login_page_locators.LoginPageElements;
import com.softserve.rozetka.locators.login_page_locators.RemindPasswordPageElements;
import com.softserve.rozetka.pages.login_page.HomePage;
import com.softserve.rozetka.pages.login_page.LoginPage;
import com.softserve.rozetka.runners.BaseRunner;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginButtonTests extends BaseRunner{
    private static final String HIDE_ATTRIBUTE_HIDESHOW_PASSWORD  = "#icon-eye-blind";
    private static final String SHOW_ATTRIBUTE_HIDESHOW_PASSWORD  = "#icon-eye";

    @Test(priority = 1)
    public void checkOpenPasswordRecoveryFormAfterClickingOnRemindPasswordButton() {
        new HomePage(driver)
                .clickOnLoginButton();
        new LoginPage(driver)
                .clickOnRemindPasswordButton();
        Assert.assertEquals(driver.findElement(RemindPasswordPageElements.getTemporaryPasswordButton()).getText(), "Отримати тимчасовий пароль");
        Assert.assertEquals(driver.findElement(RemindPasswordPageElements.getRememberedYourPasswordButton()).getText(), "Я згадав свій пароль");
        new LoginPage(driver)
                .closeLoginForm();
    }

    @Test(priority = 2)
    public void checkHideShowPasswordButtonShowsPasswordOnEvenNumberClicks(){
        new HomePage(driver)
                .clickOnLoginButton();
        new LoginPage(driver)
                .enterInvalidPassword()
                .clickOnHideShowPasswordButton()
                .clickOnHideShowPasswordButton();
        Assert.assertEquals(driver.findElement(LoginPageElements.getHideShowPasswordButtonHref()).getAttribute("href"), HIDE_ATTRIBUTE_HIDESHOW_PASSWORD);
        Assert.assertEquals(driver.findElement(LoginPageElements.getPasswordField()).getAttribute("type"), "password");
    }

    @Test(priority = 3)
    public void checkHideShowPasswordButtonShowsPasswordOnOddNumberClicks(){
        new HomePage(driver)
                .clickOnLoginButton();
        new LoginPage(driver)
                .enterInvalidPassword()
                .clickOnHideShowPasswordButton();
        Assert.assertEquals(driver.findElement(LoginPageElements.getHideShowPasswordButtonHref()).getAttribute("href"), SHOW_ATTRIBUTE_HIDESHOW_PASSWORD);
        Assert.assertEquals(driver.findElement(LoginPageElements.getPasswordField()).getAttribute("type"), "text");
    }
}
