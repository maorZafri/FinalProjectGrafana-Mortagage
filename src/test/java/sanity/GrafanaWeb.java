package sanity;

import com.google.common.util.concurrent.Uninterruptibles;
import extensions.UIActions;
import extensions.Verifications;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.CommonOps;
import workflows.WebFlows;
import javax.swing.text.Utilities;
import java.util.concurrent.TimeUnit;


@Listeners(utilities.Listeners.class)
    public class GrafanaWeb extends CommonOps {

    @Test(description = "Test01 - Verify Header")
    @Description("This Test login and verifies the main header")
    public void Test01_VerifyHeader() {
        WebFlows.login(getData("UserName"), getData("Password"));
        Verifications.verifyTextInElemnt(grafanaMain.Welcome, "Welcome to Grafana");

    }

    @Test(description = "Test02 - Verify Default Users")
    @Description("This Test verifies the default users")
    public void Test02_VerifyDefaultUsers() {
        UIActions.mouseHover(grafanaLeftmenu.btn_server, grafanaServerAdmin.btn_users);
        Verifications.numberOfElements(grafanaServerAdminMain.rows, 1);
    }

    @Test(description = "Test03 - Verify New User")
    @Description("This Test verifies a new user has been added")
    public void Test03_VerifyNewUser() {
        UIActions.mouseHover(grafanaLeftmenu.btn_server, grafanaServerAdmin.btn_users);
        WebFlows.createNewUser("Maor", "maoremg1@gmail.com", "maorzafri", "maor17595");
        Verifications.numberOfElements(grafanaServerAdminMain.rows, 2);
    }

    @Test(description = "Test04 - Verify New User delete")
    @Description("This Test verifies the deletion of a user")
    public void Test04_VerifyNewUserDelete() {
        UIActions.mouseHover(grafanaLeftmenu.btn_server, grafanaServerAdmin.btn_users);
        WebFlows.deleteLastUser();
        Uninterruptibles.sleepUninterruptibly(1, TimeUnit.SECONDS);
        Verifications.numberOfElements(grafanaServerAdminMain.rows, 1);

    }

    @Test(description = "Test05 - Verify Progress Steps")
    @Description("This Test verifies the default progress steps are displayed (using soft assertion)")
    public void Test05_VerifyProgressSteps() {
        Verifications.visibilityOfElements(grafanaMain.list_progressSteps);
    }

    @Test(description = "Test06 - Verify Avatar Icon")
    @Description("This Test verifies the Avatar Image Using Sikuli tool)")
    public void Test06_VerifyAvatarIcon() {
        Verifications.visualElement("GrafanaAvatar");
    }

    @Test(description = "Test07 - Search Users", dataProvider = "data-provider-users", dataProviderClass = utilities.ManageDDT.class)
    @Description("This Test Searches users in a table using DDT)")
    public void Test07_SearchUsers(String user, String shouldExist) {
        UIActions.mouseHover(grafanaLeftmenu.btn_server, grafanaServerAdmin.btn_users);
        WebFlows.searchAndVerifyUser(user, shouldExist);
    }
}
