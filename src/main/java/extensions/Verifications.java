package extensions;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.sikuli.script.FindFailed;
import utilities.CommonOps;

import java.util.List;

import static org.testng.Assert.*;

public class Verifications extends CommonOps {

    @Step("Verify Text In Element")
    public static void verifyTextInElemnt(WebElement elem, String expected){
        wait.until(ExpectedConditions.visibilityOf(elem));
        assertEquals(elem.getText(), expected);
    }
    @Step("Verify Number of Element")
    public static void numberOfElements(List<WebElement> elems, int expected){
        wait.until(ExpectedConditions.visibilityOf(elems.get(elems.size()-1)));
        assertEquals(elems.size(), expected);
    }
    @Step("Verify Visibility of Element (Soft-Assertion)")
    public static void visibilityOfElements(List<WebElement> elems) {
        for(WebElement elem : elems ){
            softAssert.assertTrue(elem.isDisplayed(),"Sorry" + elem.getText() + "not displayed");
        }
        softAssert.assertAll("Some elements were not displayed");
    }
    @Step("Verify Element Visually")
    public static void visualElement(String expectedImageName){
        try {
            screen.find(getData("ImageRepo"));
        } catch (FindFailed findFailed) {
            System.out.println("Error Comparing Image File: " + findFailed);
            fail("Error Comparing Image File: " + findFailed);
        }
    }
    @Step("Verify Element Displayed")
    public static void existenceOfElement(List<WebElement> elements){
        assertTrue(elements.size() > 0);
    }
    @Step("Verify Element Not Displayed")
    public static void nonExistenceOfElement(List<WebElement> elements){
        assertTrue(elements.size() == 0);
    }
    @Step("Verify Text with Text")
    public static void verifyText(String actual, String expected){
        assertEquals(actual, expected);
    }
}
