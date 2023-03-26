package Proje_05;

import Utlity.BaseDriverParameter;
import Utlity.Tools;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.Random;

public class POM extends BaseDriverParameter {


    @Test()
    void loginTest() {
        WebElements cwe = new WebElements(driver);
        cwe.email.clear();
        cwe.email.sendKeys("admin@yourstore.com");
        cwe.password.clear();
        cwe.password.sendKeys("admin");
        cwe.loginButton.click();
        Assert.assertTrue(cwe.Validation.getText().contains("Dashboard"));
    }


   @Test(priority = 1)

   void navMenuCheck() {
       WebElements cwe = new WebElements(driver);

       for (int i = 0; i < cwe.leftNawMenu.size(); i++) {

           wait.until(ExpectedConditions.elementToBeClickable(cwe.leftNawMenu.get(i)));

           cwe.leftNawMenu.get(i).click();


           if (cwe.leftNawMenu.get(i).getAttribute("style").contains("display: block;")){
           System.out.println("open");}


       }
       boolean degisken = false;
       for (int i = 0; i < cwe.leftNawMenu.size(); i++) {


           if (cwe.leftNawMenu.size() > 0)
               degisken = true;
       }
       if(degisken){
       System.out.println(" all elements are visible");}

       }
    String email = generateEmail();

       @Test(priority = 2)

   void addCustomer(){
           WebElements cwe = new WebElements(driver);
           cwe.customersOne.click();
           cwe.customersTwo.click();
           cwe.addNew.click();
           cwe.email.sendKeys(email);
           cwe.password.sendKeys("123123");
           cwe.firstName.sendKeys("yunus");
           cwe.lastNamecustmr.sendKeys("demir");
           cwe.dateOBirth.sendKeys("03/07/1993");
           cwe.save.click();
           Assert.assertTrue(cwe.validationCustomer.isDisplayed());
       }



       @Test(priority = 3)
    void editCustomer(){

           WebElements cwe = new WebElements(driver);
            cwe.searchButtonFirst.click();
            cwe.lastNameSrc.sendKeys("demir");
            cwe.emailsearch.sendKeys(email);
            cwe.searchButton.click();
            cwe.editButton.click();
            cwe.firstName.clear();
            cwe.firstName.sendKeys("enes");
            cwe.save.click();
            Assert.assertTrue(cwe.validationsearch.isDisplayed(),"TEST FAILED");

       }

       @Test(priority = 4)
    void deleteCustomer(){
           WebElements cwe = new WebElements(driver);
           cwe.firstNamesearch.sendKeys("enes");
           cwe.lastNameSrc.sendKeys("demir");
           cwe.emailsearch.sendKeys(email);
           cwe.searchButton.click();
           cwe.editButton.click();
           cwe.delete.click();
           cwe.deleteAlert.click();
           Assert.assertTrue(cwe.validationsearch.isDisplayed(),"TEST FAILED");

       }

       @Test(priority = 5)
    void searchFunction(){
           WebElements cwe = new WebElements(driver);
           new Actions(driver).moveToElement(cwe.searchBox).click().sendKeys("Shipments").
                   sendKeys(Keys.DOWN).sendKeys(Keys.ENTER).build().perform();
           Tools.Bekle(3);
           Assert.assertEquals(driver.getCurrentUrl(),"https://admin-demo.nopcommerce.com/Admin/Order/ShipmentList");

       }


    public String generateEmail(){
        String mail = "study3@gmail.com";
        Random random = new Random();
        char randomLetter = (char) (random.nextInt(26) + 'A');
        return randomLetter + mail;
    }

   }

