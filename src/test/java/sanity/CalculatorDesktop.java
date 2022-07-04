package sanity;

import extensions.Verifications;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.CommonOps;
import workflows.DesktopFlows;
import workflows.WebFlows;

@Listeners(utilities.Listeners.class)
public class CalculatorDesktop extends CommonOps {

    @Test(description = "Test01 - Verify Addition Command")
    @Description("This Test Verifies the Addition Command")
    public void Test01_VerifyAdditionCommand() {
        DesktopFlows.calculateAddition();
        Verifications.verifyTextInElemnt(calcMain.field_results, "Display is 8");

    }

}
