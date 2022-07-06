package pageObjects.Discord;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HomePage {
    @FindBy(how = How.XPATH, using ="//a[@href='//discord.com/register']")
    public WebElement btn_register;
}
