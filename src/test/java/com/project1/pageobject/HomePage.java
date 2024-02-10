package com.project1.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver) {
		super(driver);

	}

	// Locators

	@FindBy(css = "div.login-container h2")
	public WebElement txt_loggedUser;

	@FindBy(css = "button.logout-btn")
	public WebElement btn_logout;

	@FindBy(css = "div.login-container p")
	public WebElement txt_successMsg;
	

	// Methods

	public boolean verifyUser(String username) {

		String split[] = txt_loggedUser.getText().replace(",", "").split(" ");

		for (String s : split) {

			if (s.contains(username)) {
				if (s.equalsIgnoreCase(username)) {
					return true;
				}
			}
		}
		return false;
	}

	public boolean verifyMsg() {

		if (txt_successMsg.isDisplayed()) {

			String text = txt_successMsg.getText();

			if (text.contains("success")) {
				
				return true;
			}
		}

		return false;
	}

	public void clickLogout() {

		btn_logout.click();
	}

}
