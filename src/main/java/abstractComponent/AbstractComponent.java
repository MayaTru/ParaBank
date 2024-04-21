package abstractComponent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AbstractComponent {
	WebDriver driver;
	public AbstractComponent(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText = "Log Out")
	private WebElement logOutButton;
	
	@FindBy(linkText = "Accounts Overview")
	private WebElement AccountOverViewLink;
	
	public void logOut() {
		logOutButton.click();
	}
	
	public void accOvrView() {
		AccountOverViewLink.click();
	}
}
