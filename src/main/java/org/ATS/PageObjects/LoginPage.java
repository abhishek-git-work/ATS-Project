package org.ATS.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[text()='Login or register']")
	private WebElement logintab;
	
	public void clickOnLoginTab()
	{
		logintab.click();
	}
	
	@FindBy(xpath="//input[@id='loginFrm_loginname']")
	private WebElement enterUserName;
	
	public void enterUserName(String username)
	{
		enterUserName.sendKeys(username);
	}
	
	@FindBy(xpath="//input[@id='loginFrm_password']")
	private WebElement enterPassword;
	
	public void enterPassword(String password)
	{
		enterPassword.sendKeys(password);
	}
	
	@FindBy(xpath="//button[normalize-space()='Login']")
	private WebElement clickOnLoginButton;
	
	public void clickOnLoginButton()
	{
		clickOnLoginButton.click();
	}
	
	@FindBy(xpath="//div[@class='menu_text']")
	private WebElement successfulLoginmssg;
	
	public String verifyLoginMssg()
	{
		String loginmssg = successfulLoginmssg.getText();
		return loginmssg;
	}

	@FindBy(xpath="//div[@class='alert alert-error alert-danger']")
	private WebElement invalidUsernameorPasswordMssg;
	
	public String invalidUsernameorPasswordMssg()
	{
		String invalidLoginMssg = invalidUsernameorPasswordMssg.getText();
		return invalidLoginMssg;
	}
}
