package Proje_05;

import Utlity.BaseDriver;
import Utlity.BaseDriverParameter;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;



public class Proje_5_POM extends BaseDriverParameter {
    @Test()
    void loginTest(){
        CaseWebElements cwe = new CaseWebElements();
        //Actions act = new Actions(BaseDriver.driver);
     // act.moveToElement(cwe.loginButton).click().build().perform();
        cwe.email.clear();
        cwe.email.sendKeys("admin@yourstore.com");
        cwe.password.clear();
        cwe.password.sendKeys("admin");
        cwe.loginButton.click();
        Assert.assertTrue(cwe.Validation.getText().contains("Dashboard"));

    }
}
