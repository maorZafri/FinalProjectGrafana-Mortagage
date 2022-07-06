package sanity;

import com.google.common.util.concurrent.Uninterruptibles;
import extensions.Verifications;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.CommonOps;
import workflows.ElectronFlows;

import java.util.concurrent.TimeUnit;

@Listeners(utilities.Listeners.class)
public class ToDoListElectron extends CommonOps {

    @Test(description = "Test01 - Add And Verify New Task")
    @Description("This Test adds a new task and Verifies it in the list of tasks")
    public void test01_addAndVerifyNewTask(){
        ElectronFlows.addNewTask("Learn Java");
        Verifications.verifyNumber(ElectronFlows.getNumberOfTasks(), 1);
        Uninterruptibles.sleepUninterruptibly(1, TimeUnit.SECONDS);

    }
    @Test(description = "Test02 - Add And Verify New Tasks")
    @Description("This Test adds a new task and Verifies it in the list of tasks")
    public void test02_addAndVerifyNewTasks(){
        ElectronFlows.addNewTask("Learn Java");
        ElectronFlows.addNewTask("Learn C#");
        ElectronFlows.addNewTask("Learn Python");
        Verifications.verifyNumber(ElectronFlows.getNumberOfTasks(), 4);
    }
}
