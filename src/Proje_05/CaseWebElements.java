package Proje_05;

import Utlity.BaseDriver;
import Utlity.BaseDriverParameter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

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

    @FindBy(xpath = "//*[@class='nav-item has-treeview']")
    public List<WebElement> leftNawMenu;

    @FindBy(xpath = "//[@class='nav-icon far fa-user']")
    public List<WebElement> customers;

    @FindBy(css = "i[class='nav-icon far fa-user']")
    public WebElement customersOne;

    @FindBy(xpath = "//*[text()=' Customers']")
    public WebElement customersTwo;
    @FindBy(css ="a[class='btn btn-primary']")
    public WebElement addNew;
    @FindBy(id="Email")
    public WebElement emailCustomer;
    @FindBy(id="Password")
    public WebElement passwordCustomer;
    @FindBy(id="FirstName")
    public WebElement firstName;
    @FindBy(id="LastName")
    public WebElement lastNamecustmr;
    @FindBy(id="DateOfBirth")
    public WebElement dateOBirth;
    @FindBy(name="save")
    public WebElement save;
    @FindBy(css ="[class='alert alert-success alert-dismissable']")
    public WebElement validationCustomer;

    @FindBy(id="SearchFirstName")
    public WebElement firstNamesearch;

    @FindBy(id="SearchLastName")
    public WebElement lastNameSrc;

    @FindBy(id="SearchEmail")
    public WebElement emailsearch;

    @FindBy(id="search-customers")
    public WebElement searchButton;

    @FindBy(xpath="//i[@class='fas fa-pencil-alt']")
    public WebElement editButton;

    @FindBy(xpath= "//td[text()='Registered']")
    public WebElement validationsearch;

    @FindBy(id="search-customers")
    public WebElement searchButtonFirst;

    @FindBy(id = "customer-delete")
    public WebElement delete;

    @FindBy(xpath="//button[@class='btn btn-danger float-right']")
    public WebElement deleteAlert;

    @FindBy(css =" input[placeholder='Search']")
    public WebElement searchBox;






}
