package com.project1.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.project1.pageobject.ForgotPasswordPage;
import com.project1.pageobject.HomePage;
import com.project1.pageobject.LoginPage;
import com.project1.testbase.BaseClass;

public class EndToEndTest extends BaseClass {

	LoginPage lp;

	ForgotPasswordPage fpp;

	HomePage hp;

	String username;

	@Test()
	public void e2e() {

		lp = openUrl();

		try {

			username = getUsername();
			
			logger.info("Getting UserName");

			lp.enterUsername(username);
			
			logger.info("UserName entered");

			lp.enterPassword(getPassword());
			
			logger.info("Password entered");

			lp.clickCheckBox();
			
			logger.info("CheckBox Clicked");

			lp.clickSignIn();
			
			logger.info("SignIn Button Clicked");

			hp = new HomePage(driver);

			waitTillElementIsVisible(hp.btn_logout);

			Assert.assertTrue(hp.verifyUser(username));
			
			logger.info("UserName Verified in HomePage");

			Assert.assertTrue(hp.verifyMsg());
			
			logger.info("Success Message Verified");

			hp.clickLogout();
			
			logger.info("Logout Button Clicked");

		} catch (Exception e) {

			e.printStackTrace();
		}

	}

}
