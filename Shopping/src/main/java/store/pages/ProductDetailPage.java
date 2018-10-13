package store.pages;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class ProductDetailPage extends DressesPage{
	
@FindBy(css="#our_price_display") private WebElement price;
@FindBy(css="#add_to_cart > button > span") private WebElement addToCart;
@FindBy(id="wishlist_button") private WebElement addToWishList;
@FindBy(className="icon-plus") private WebElement quantity;
@FindBy(id="group_1") private WebElement size;
@FindBy(id="color_to_pick_list") private WebElement color;
@FindBy(xpath="//a[@title=\"Proceed to checkout\"]") private WebElement cont;
 
private List<String> productURL;



public void openNewTab() throws InterruptedException
{
	
	productURL=getAllImages();
 String baseURL=driver.getCurrentUrl();
 for( String s:productURL)
 {
	 Keys.chord(Keys.CONTROL,"t");
	driver.get(s);
	System.out.println(price.getText());
	quantity.click();
	size.click();
	 Select sel= new Select(size);
	 Thread.sleep(1000);
	 sel.selectByVisibleText("M");;
	addToCart.click();	
	Thread.sleep(10000);
	driver.switchTo().activeElement();
	cont.click();
	
	
 }
 
 driver.get(baseURL);

}

}
