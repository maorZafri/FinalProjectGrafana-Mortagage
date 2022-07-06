package pageObjects.Discord;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class RegisterPage {
    @FindBy(how = How.XPATH, using ="//input[@name='email']")
    public WebElement txt_email;

    @FindBy(how = How.XPATH, using ="//input[@name='username']")
    public WebElement txt_username;

    @FindBy(how = How.XPATH, using ="//input[@name='password']")
    public WebElement txt_password;

}
