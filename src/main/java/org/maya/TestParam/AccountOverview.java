package org.maya.TestParam;

import java.time.Duration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import abstractComponent.AbstractComponent;

public class AccountOverview extends AbstractComponent {
	WebDriver driver;
	
	public AccountOverview(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = "#accountTable")
	private WebElement accountTable;
	
	@FindBy(css = "tr td:nth-child(1) a")
	private List<WebElement> accList;
	
	@FindBy(css = "#accountTable .ng-binding:nth-child(2)")
	private List<WebElement> balList;
	
	@FindBy(css = "#accountId")
	private WebElement accNum;
	
	@FindBy(css = "#accountType")
	private WebElement accType;
	
	@FindBy(css = "tr td:nth-child(1) a")
	private WebElement accListTemp;
	
	
	public List<String> getAccountNums() {
		List<String> accNumLst =  accList.stream().map(s->s.getText()).collect(Collectors.toList());
		return accNumLst;
	}
	
	public Map<String, String> getAccAndType() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.elementToBeClickable(accListTemp));
		Map<String, String> mp = new HashMap<String, String>();
		for(WebElement a : accList) {
			Actions act = new Actions(driver);
			act.keyDown(Keys.CONTROL).click(a).build().perform();
		}
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> itr = windows.iterator();
		String parentId = itr.next();
		while(itr.hasNext()) {
			String childWin = itr.next();
			driver.switchTo().window(childWin);
			Thread.sleep(3000);
			System.out.println("~~~~~~~~~~~");
			System.out.println(accNum.getText());
			System.out.println(accType.getText());
			System.out.println("~~~~~~~~~~~");
			mp.put(accNum.getText(), accType.getText());
		}
		Thread.sleep(5000);
		driver.switchTo().window(parentId);
		System.out.println("~~~~~~~~~~~");
		System.out.println(mp);
		System.out.println("~~~~~~~~~~~");
		return mp;
	}
}
