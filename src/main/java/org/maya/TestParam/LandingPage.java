package org.maya.TestParam;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractComponent.AbstractComponent;

public class LandingPage extends AbstractComponent{
	WebDriver driver;
	
	public LandingPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "username")
	private WebElement usrName;
	
	@FindBy(name = "password")
	private WebElement pwd;
	
	@FindBy(css = "input[type='submit']")
	private WebElement logInButton;
	
	@FindBy(linkText = "Register")
	private WebElement registerLink;
	
	public void goTo(String url) {
		driver.get(url);
	}
	
	public void Login(String usr, String pswd) {
		usrName.sendKeys(usr);
		pwd.sendKeys(pswd);
		logInButton.click();
	}
	
	public SignUpPage goToRegisterLink() {
		registerLink.click();
		SignUpPage obj = new SignUpPage(driver);
		return obj;
	}
}
