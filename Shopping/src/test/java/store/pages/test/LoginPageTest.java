package store.pages.test;

import java.util.ArrayList;
import java.util.Iterator;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import store.pages.LoginPage;
import store.utilities.Base;
import store.utilities.ExcelUtils;

public class LoginPageTest extends Base {
	
String user,pass;



@BeforeTest
public void init()
{
	setUp();
	user=Prop.getProperty("username");
	pass=Prop.getProperty("password");
}

/*@DataProvider(name="login")
public Iterator<Object[]> login()
{
	
	ArrayList<Object[]> data= ExcelUtils.getLoginDatafromExcel();
	return data.iterator();
}
*/

@Test
public void userlogin()
{
	
LoginPage lp= PageFactory.initElements(driver, LoginPage.class);
log.info("login");

lp.userLogin(user, pass);
}

@AfterTest
public void shut()
{
	close();
}
	

}
