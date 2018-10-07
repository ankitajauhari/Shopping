package store.pages;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import store.utilities.Base;

public class LoginPage extends Base{

@FindBy(className="login") private WebElement loginLink;	
@FindBy(id="email") private WebElement email;
@FindBy(id="passwd") private WebElement pass;
@FindBy(id="SubmitLogin") private WebElement submitButton;
@FindBy(css="#login_form > div > p.lost_password.form-group > a") private WebElement forgotPassword;
 


public void userLogin(String username, String password) {
	
	
	loginLink.click();

	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	email.sendKeys(username);
	pass.sendKeys(password);
	submitButton.click();
	log.info("User logged in successfully");
  }



public void forgotPassword()
{
	forgotPassword.click();
}
}
