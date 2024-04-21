package org.maya.TestParam;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractComponent.AbstractComponent;

public class SignUpPage extends AbstractComponent{
	WebDriver driver;
	
	public SignUpPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//input[@id='customer.firstName']")
	private WebElement firstName;
	
	@FindBy(xpath = "//input[@id='customer.lastName']")
	private WebElement lastName;
	
	@FindBy(xpath = "//input[@id='customer.address.street']")
	private WebElement address;
	
	@FindBy(xpath = "//input[@id='customer.address.city']")
	private WebElement city;
	
	@FindBy(xpath = "//input[@id='customer.address.state']")
	private WebElement state;
	
	@FindBy(xpath = "//input[@id='customer.address.zipCode']")
	private WebElement zipCode;
	
	@FindBy(xpath = "//input[@id='customer.phoneNumber']")
	private WebElement phoneNumber;
	
	@FindBy(xpath = "//input[@id='customer.ssn']")
	private WebElement ssn;
	
	@FindBy(xpath = "//input[@id='customer.username']")
	private WebElement username;
	
	@FindBy(xpath = "//input[@id='customer.password']")
	private WebElement password;
	
	@FindBy(xpath = "//input[@id='repeatedPassword']")
	private WebElement repeatedPassword;
	
	@FindBy(css = "input[value='Register']")
	private WebElement RegisterButton;
	
	@FindBy(css = "#rightPanel p")
	private WebElement creText;
	
	public AccountOverview registerUser(String user, String pass) {
		firstName.sendKeys("TestFirstMaya");
		lastName.sendKeys("TestLastMaya");
		address.sendKeys("TestAddress");
		city.sendKeys("TestCity");
		state.sendKeys("TestState");
		zipCode.sendKeys("51740");
		phoneNumber.sendKeys("995-456-9876");
		ssn.sendKeys("965-696-968");
		username.sendKeys(user);
		password.sendKeys(pass);
		repeatedPassword.sendKeys(pass);
		RegisterButton.click();
		AccountOverview obj = new AccountOverview(driver);
		return obj;
	}
	
	public String getAccCreText() {
		String txt = creText.getText();
		logOut();
		return txt;
	}
}
