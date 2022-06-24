package pageObjects.grafana;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class ServerAdminMenuPage {
    @FindBy(how = How.XPATH, using ="//a[@href='/admin/users']")
    public WebElement btn_users;


}
