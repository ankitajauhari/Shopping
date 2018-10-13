package store.pages.test;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import store.pages.ProductDetailPage;
import store.utilities.Base;

public class BuyProductTest extends Base {
	double bill;

@Test(priority=2)
public void addItemtoCart()
{
	try
	{
	ProductDetailPage product= PageFactory.initElements(driver, ProductDetailPage.class);
	product.buyTop();
	product.openNewTab();
   bill=product.order();
	System.out.println("Your bill is:"+bill);
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
}
	

}
