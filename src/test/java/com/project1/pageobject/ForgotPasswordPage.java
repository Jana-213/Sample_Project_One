package com.project1.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ForgotPasswordPage extends BasePage{

	public ForgotPasswordPage(WebDriver driver) {
		super(driver);
	}
	
	// Locators
	
	@FindBy(css = "button[class*='go-to-login-btn']")
	public WebElement btn_GoToLogin;
	
	@FindBy(css = "button[class*='reset-pwd-btn']")
	public WebElement btn_ResetLogin;
	
	
	@FindBy(css = "p.infoMsg")
	private WebElement txt_TempPassword;
	
	@FindBy(xpath = "//input[@placeholder=\"Name\"]")
	private WebElement input_Name;
	
	@FindBy(xpath = "//input[@placeholder=\"Email\"]")
	private WebElement input_Email;
	
	@FindBy(css = "//input[@placeholder=\"Phone Number\"]")
	private WebElement input_PhoneNumber;
	
	
	// Actions
	
	public void enterName(String name) {
		
		input_Name.sendKeys(name);
	}
	
	public void enterEmail(String email) {
		
		input_Email.sendKeys(email);
	}
	
	public void enterPhoneNumber(String phone) {
		
		input_PhoneNumber.sendKeys(phone);
	}
	
	public void clickGoToLogin() {
		
		btn_GoToLogin.click();
	}
	
	public void clickResetLogin() {
		
		btn_ResetLogin.click();
	}
	
	public String getTemporaryPassword() {
		
		String pass = "";
		
		String text = txt_TempPassword.getText();
		
		String[] split = text.split("'");
		
		for(String s :split) {
			if(s.contains("rahul")) {
				pass = s.trim();
			}
		}
		
		return pass;
	}

}
