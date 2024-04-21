package org.maya.TestParam;

import java.util.Random;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import testComponent.BaseTest;

public class Test1 extends BaseTest {
	String url = "https://parabank.parasoft.com/parabank/index.htm";
	Random random = new Random();
	int x = random.nextInt(1000);
	String userName = "Maya"+x;
	String passwrd = "Pass0";

	LandingPage lndPage;
	SignUpPage sngPage;
	AccountOverview accOvr;
	
	@Test(groups = "Regis")
	public void Register() {
		lndPage =  launchApp(url);
		System.out.println("userName -> "+userName);
		sngPage = lndPage.goToRegisterLink();
		accOvr =  sngPage.registerUser(userName,passwrd);
		/*
		 * String t1 = sngPage.getAccCreText(); SoftAssert asrt = new SoftAssert();
		 * asrt.assertEquals(t1,
		 * "Your account was created successfully. You are now logged in.");
		 * asrt.assertAll();
		 */
	}
	@Test(groups = "GetAccNType", dependsOnMethods = "Register")
	public void GetAccAndType() throws InterruptedException {
		accOvr.accOvrView();
		accOvr.getAccAndType();
	}
	
	
}
