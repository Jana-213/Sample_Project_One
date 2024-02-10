package com.project1.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

	public LoginPage(WebDriver driver) {
		
		super(driver);
	}
	
	
	//Locators
	
	@FindBy(css = "form.form h1")
	private WebElement title;
	
	@FindBy(id = "inputUsername")
	private WebElement txt_username;
	
	@FindBy(name = "inputPassword")
	private WebElement txt_password;
	
	@FindBy(css = "input#chkboxTwo")
	public WebElement checkBox_Agree;
	
	@FindBy(linkText = "Forgot your password?")
	private WebElement txt_ForgotPassword;
	
	@FindBy(xpath = "//button[text()='Sign In']")
	public WebElement btn_SignIn;
	
	@FindBy(css = "p.error")
	private WebElement txt_errorMsg;
	
	//Actions
	
	public boolean verifyTitle() {
		
		return title.isDisplayed();
	}
	
	public String verifyTitleText() {
		
		return title.getText();
	}
	
	public void enterUsername(String username) {
		
		txt_username.sendKeys(username);
	}
	
	public void enterPassword(String password) {
		
		txt_password.sendKeys(password);
	}
	
	public void clickCheckBox() {
		
		checkBox_Agree.click();
	}
	
	public boolean verifyAgreeCheckBox() {
		
		return checkBox_Agree.isSelected();
	}
	
	public void clickForgotPassword() {
		
		txt_ForgotPassword.click();
	}
	
	public void clickSignIn() {
		
		btn_SignIn.click();
	}
	
	public String checkErrorMsg() {
		
		return txt_errorMsg.getText();
	}
	
	public boolean verifyErrorMsg() {
		
		return txt_errorMsg.isDisplayed();
	}

}
