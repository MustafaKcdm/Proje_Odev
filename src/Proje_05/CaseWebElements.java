package Proje_05;

import Utlity.BaseDriver;
import Utlity.BaseDriverParameter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CaseWebElements {
    public CaseWebElements() {
        PageFactory.initElements(BaseDriverParameter.driver,this);
    }

    @FindBy(xpath ="//*[@id='Email']")
    public WebElement email;
    @FindBy(css = "input[id='Password']")
    public WebElement password;
    @FindBy(xpath = "//*[@type='submit']")

    public WebElement loginButton;
    @FindBy(xpath = "//h1[normalize-space()='Dashboard']")
    public WebElement Validation;



}
