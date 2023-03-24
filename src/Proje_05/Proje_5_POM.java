package Proje_05;

import Utlity.BaseDriverParameter;
import Utlity.Tools;
import javafx.scene.layout.Priority;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.swing.*;


public class Proje_5_POM extends BaseDriverParameter {


    @Test()
    void loginTest() {
        CaseWebElements cwe = new CaseWebElements();
        cwe.email.clear();
        cwe.email.sendKeys("admin@yourstore.com");
        cwe.password.clear();
        cwe.password.sendKeys("admin");
        cwe.loginButton.click();
        Assert.assertTrue(cwe.Validation.getText().contains("Dashboard"));
    }


   @Test(priority = 1)

   void navMenuCheck() {
       CaseWebElements cwe = new CaseWebElements();

       for (int i = 0; i < cwe.leftNawMenu.size(); i++) {

           wait.until(ExpectedConditions.elementToBeClickable(cwe.leftNawMenu.get(i)));

           cwe.leftNawMenu.get(i).click();

           if (cwe.leftNawMenu.get(i).getAttribute("style").contains("display: block;")) ;
           System.out.println("open");


       }
       for (int i = 0; i < cwe.leftNawMenu.size(); i++) {

           boolean degisken = false;
           if (cwe.leftNawMenu.size() > 0)
               degisken = true;
       }
       System.out.println(" all elements visible");

       }

       @Test(priority = 6)
    void addCustomer(){
           CaseWebElements cwe = new CaseWebElements();
           cwe.customersOne.click();
           cwe.customersTwo.click();
           cwe.addNew.click();
           cwe.email.sendKeys("2study3@gmail.com");
           cwe.password.sendKeys("123123");
           cwe.firstName.sendKeys("yunus");
           cwe.lastNamecustmr.sendKeys("demir");
           cwe.dateOBirth.sendKeys("03/07/1993");
           cwe.save.click();
           Assert.assertTrue(cwe.validationCustomer.isDisplayed());
       }


       @Test(priority = 3)
    void editCustomer(){
           CaseWebElements cwe = new CaseWebElements();
           cwe.customersOne.click();
           cwe.customersTwo.click();
            cwe.searchButtonFirst.click();
            Tools.Bekle(1);
            cwe.firstNamesearch.sendKeys("yunus");
            cwe.lastNameSrc.sendKeys("demir");
            cwe.emailsearch.sendKeys("2study3@gmail.com");
            cwe.searchButton.click();
            Assert.assertTrue(cwe.validationsearch.isDisplayed(),"TEST FAILED");
            cwe.editButton.click();
            cwe.firstName.clear();
            cwe.firstName.sendKeys("enes");
            cwe.save.click();
            Assert.assertTrue(cwe.validationsearch.isDisplayed(),"TEST FAILED");

       }

       @Test(priority = 4)
    void deleteCustomer(){
           CaseWebElements cwe = new CaseWebElements();
           cwe.customersOne.click();
           cwe.customersTwo.click();
           cwe.searchButtonFirst.click();
           cwe.firstNamesearch.sendKeys("enes");
           cwe.lastNameSrc.sendKeys("demir");
           cwe.emailsearch.sendKeys("study3@gmail.com");
           cwe.searchButton.click();
           cwe.editButton.click();
           cwe.delete.click();
           cwe.deleteAlert.click();
           Assert.assertTrue(cwe.validationsearch.isDisplayed(),"TEST FAILED");

       }

       @Test(priority = 5)
    void searchFunction(){
           CaseWebElements cwe = new CaseWebElements();
           new Actions(driver).moveToElement(cwe.searchBox).click().sendKeys("Shipments").
                   sendKeys(Keys.DOWN).sendKeys(Keys.ENTER).build().perform();
           Tools.Bekle(3);
           Assert.assertEquals(driver.getCurrentUrl(),"https://admin-demo.nopcommerce.com/Admin/Order/ShipmentList");

       }

   }

