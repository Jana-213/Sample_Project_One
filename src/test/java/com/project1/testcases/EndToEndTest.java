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

			lp.enterUsername(username);

			lp.enterPassword(getPassword());

			lp.clickCheckBox();

			lp.clickSignIn();

			hp = new HomePage(driver);

			waitTillElementIsVisible(hp.btn_logout);

			Assert.assertTrue(hp.verifyUser(username));

			Assert.assertTrue(hp.verifyMsg());

			hp.clickLogout();

		} catch (Exception e) {

			e.printStackTrace();
		}

	}

}
