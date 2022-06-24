package workflows;

import com.google.common.util.concurrent.Uninterruptibles;
import extensions.UIActions;
import extensions.Verifications;
import io.qameta.allure.Step;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utilities.CommonOps;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class WebFlows extends CommonOps {

    @Step("Business Flow: Login")
    public static void login(String user, String pass){
        UIActions.updateText(grafanalogin.username, user);
        UIActions.updateText(grafanalogin.password, pass);
//        wait.until(ExpectedConditions.elementToBeClickable(grafanalogin.loginButton));
        UIActions.click(grafanalogin.btn_login);
        UIActions.click(grafanalogin.btn_skip);
    }
    @Step("Business Flow: Create New User")
    public static void createNewUser(String name, String email, String userName, String pass){
        UIActions.click(grafanaServerAdminMain.btn_newUser);
        UIActions.updateText(grafanaAddNewUser.txt_name, name);
        UIActions.updateText(grafanaAddNewUser.txt_email, email);
        UIActions.updateText(grafanaAddNewUser.txt_userName, userName);
        UIActions.updateText(grafanaAddNewUser.txt_password, pass);
        UIActions.click(grafanaAddNewUser.btn_create);
    }
    @Step("Business Flow: Delete Last User")
    public static void deleteLastUser(){
        UIActions.click(grafanaServerAdminMain.rows.get(grafanaServerAdminMain.rows.size()-1));
        UIActions.click(grafanaEditUser.btn_deleteUser);
        UIActions.click(grafanaEditUser.btn_confirmDeleteUser);
    }
    @Step("Business Flow: Search And Verify User")
    public static void searchAndVerifyUser(String user, String shouldExist){
        UIActions.updateTextHuman(grafanaServerAdminMain.txt_search, user);
        if (shouldExist.equalsIgnoreCase("exists"))
            Verifications.existenceOfElement(grafanaServerAdminMain.rows);
        else if (shouldExist.equalsIgnoreCase("not-exist"))
            Verifications.nonExistenceOfElement(grafanaServerAdminMain.rows);
        else
            throw new RuntimeException(("Invalid Expected Output Option in Data Driving testing, Should be Exists or not-exist"));
    }
}
