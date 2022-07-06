package workflows;

import extensions.MobileAction;
import io.qameta.allure.Step;
import utilities.CommonOps;


public class MobileFlow extends CommonOps {
    @Step("Business Flow: Fill Form and Calculate Mortgage")
    public static void calculateMortgage(String amount, String term, String rate) {
        MobileAction.updateText(mortgageMain.txt_amount, amount);
        MobileAction.updateText(mortgageMain.txt_term, term);
        MobileAction.updateText(mortgageMain.txt_rate, rate);
        MobileAction.tap(mortgageMain.atn_calculate);

    }
}
