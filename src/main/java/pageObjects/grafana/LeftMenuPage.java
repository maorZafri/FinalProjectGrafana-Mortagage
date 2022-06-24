package pageObjects.grafana;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LeftMenuPage {
    @FindBy(how = How.XPATH, using ="//li[@class='css-16buu1m'][1]")
    public WebElement btn_create;

    @FindBy(how = How.XPATH, using ="//li[@class='css-1s4ar18']")
    public WebElement btn_dashBoards;

    @FindBy(how = How.XPATH, using ="//li[@class='css-16buu1m'][2]")
    public WebElement btn_explore;

    @FindBy(how = How.XPATH, using ="//li[@class='css-16buu1m'][3]")
    public WebElement btn_alerting;

    @FindBy(how = How.XPATH, using ="//li[@class='css-16buu1m'][4]")
    public WebElement btn_configuration;

    @FindBy(how = How.CLASS_NAME, using ="css-1s4ar18")
    public WebElement btn_server;

}
