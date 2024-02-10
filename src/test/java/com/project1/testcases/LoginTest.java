package com.project1.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.project1.pageobject.ForgotPasswordPage;
import com.project1.pageobject.HomePage;
import com.project1.pageobject.LoginPage;
import com.project1.testbase.BaseClass;

public class LoginTest extends BaseClass {

	LoginPage lp;

	ForgotPasswordPage fpp;

	HomePage hp;

	@Test
	public void login() throws InterruptedException {

		lp = openUrl();

		fpp = new ForgotPasswordPage(driver);

		hp = new HomePage(driver);

		try {

			lp.clickSignIn();

			Assert.assertEquals(lp.verifyErrorMsg(), true);

			lp.clickForgotPassword();

//		 waitTillElementToBeClickable(fpp.btn_ResetLogin);

			sleep();

			fpp.clickResetLogin();

			String password = fpp.getTemporaryPassword();

			fpp.clickGoToLogin();
			
			refreshPage();

			lp.enterUsername(getUsername());

			lp.enterPassword(password);

			lp.clickCheckBox();

			Assert.assertEquals(lp.verifyAgreeCheckBox(), true);

//		 waitTillElementToBeClickable(lp.btn_SignIn);

//			sleep();

			lp.clickSignIn();
			
//			sleep();
			
			waitTillElementIsVisible(hp.btn_logout);

			Assert.assertEquals(hp.verifyUser(username), true);

			Assert.assertTrue(hp.verifyMsg());

			hp.clickLogout();

		} catch (Exception e) {

			e.printStackTrace();
		}

	}

}
