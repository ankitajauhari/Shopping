package store.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage {
	
@FindBy(className="login") private WebElement loginLink;	
@FindBy(xpath="//input[@id=\"email_create\"]")	private WebElement emailReg;
@FindBy(xpath="//button[@id=\"SubmitCreate\"]") private WebElement accountCreate;


}
