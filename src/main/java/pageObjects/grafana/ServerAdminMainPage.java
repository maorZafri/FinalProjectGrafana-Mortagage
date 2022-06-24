package pageObjects.grafana;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class ServerAdminMainPage {
    @FindBy(how = How.XPATH, using ="//td[@class='width-4 text-center link-td']")
    public List<WebElement> rows;

    @FindBy(how = How.CSS, using ="a[class='css-1sara2j-button']")
    public WebElement btn_newUser ;

    @FindBy(how = How.CSS, using ="input[placeholder='Search user by login, email, or name.']")
    public WebElement txt_search ;


}
