package sanity;

import extensions.Verifications;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.CommonOps;
import workflows.WebFlows;

@Listeners(utilities.Listeners.class)

public class GrafanaWebDB extends CommonOps {

    @Test(description = "Test01 - Login to Grafana with DB Credentials")
    @Description("This Test login with DB credentials and verifies the main header")
    public void Test01_loginDBAndVerifyHeader() {
        WebFlows.loginDB();
        Verifications.verifyTextInElemnt(grafanaMain.Welcome, "Welcome to Grafana");

    }
}
