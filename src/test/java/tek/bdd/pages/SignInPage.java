package tek.bdd.pages;

import org.openqa.selenium.By;

public class SignInPage {
    public static final By PAGE_SUBTITLE = By.className("login__subtitle");
    public static final By EMAIL_INPUT = By.id("email");
    public static final By PASSWORD_INPUT = By.id("password");
    public static final By LOGIN_BUTTON = By.id("loginBtn");
    public static final By ERROR_MESSAGE = By.className("error");
    public static final By Create_New_Account_Button = By.id("newAccountBtn");
}
