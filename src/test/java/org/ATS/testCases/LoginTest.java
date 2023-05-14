package org.ATS.testCases;



import java.io.IOException;

import org.ATS.PageObjects.LoginPage;
import org.ATS.baseClass.baseClass;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;



public class LoginTest extends baseClass{
	
	WebDriver driver;
	LoginPage login;
	
	@BeforeMethod
	public void setup() throws IOException
	{
		configPropertiesFile();
		driver = openBrowserAndURL(configprop.getProperty("browser"));
	}
	
	@Test(priority=1)
	public void loginWithValidCredentials()
	{
		login = new LoginPage(driver);
		login.clickOnLoginTab();
		login.enterUserName("abhishek");
		login.enterPassword("abhishek&9420");
		login.clickOnLoginButton();
		
		String actualmssg = login.verifyLoginMssg();
		String expectedmssg = "Welcome back abhi";
		Assert.assertEquals(actualmssg, expectedmssg);
	}
	
	@Test(priority=2)
	public void invalidUsernameorPasswordMssg()
	{
		login = new LoginPage(driver);
		login.clickOnLoginTab();
		login.enterUserName("abc");
		login.enterPassword("abcdefg");
		login.clickOnLoginButton();
		
		String actualmssg = login.invalidUsernameorPasswordMssg();
		String expectedmssg = "Error: Incorrect login or password provided.";
		Assert.assertEquals(actualmssg, expectedmssg);
	}
	
	@AfterMethod
	public void teardown()
	{
		driver.close();
	}

}
