package sanity;

import extensions.Verifications;
import io.qameta.allure.Description;
import org.testng.annotations.Test;
import utilities.CommonOps;
import workflows.ApiFlows;

public class GrafanaAPI extends CommonOps {
    @Test(description = "Test01 - Get Team from Grafana")
    @Description("This Test Verify Team Property")
    public void test01_verifyTeam(){
        Verifications.verifyText(ApiFlows.getTeamProperty("teams[0].name"), "MaorTeam");
    }

    @Test(description = "Test02 - Add Team And Verify")
    @Description("This Test Add Team to Grafana And Verify it")
    public void test02_addTeamAndVerify(){
        ApiFlows.postTeam("MaorTeam2", "maor@team.com");
        Verifications.verifyText(ApiFlows.getTeamProperty("teams[1].name"), "MaorTeam2");
    }

    @Test(description = "Test03 - Update Team And Verify")
    @Description("This Test Update Team in Grafana And Verify it")
    public void test03_updateTeamAndVerify(){
        String id = ApiFlows.getTeamProperty("teams[1].id");
        ApiFlows.updateTeam("MaorTeam2", "maor@maor.com", id);
        Verifications.verifyText(ApiFlows.getTeamProperty("teams[1].email"), "maor@maor.com");
    }

    @Test(description = "Test04 - Delete Team And Verify")
    @Description("This Test Delete Team in Grafana And Verify it")
    public void test04_deleteTeamAndVerify(){
        String id = ApiFlows.getTeamProperty("teams[1].id");
        ApiFlows.deleteTeam(id);
        Verifications.verifyText(ApiFlows.getTeamProperty("totalCount"), "1");
    }
}
