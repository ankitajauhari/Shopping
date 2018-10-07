package store.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;

import store.utilities.Base;

public class DressesPage extends Base{
	
@FindBy(className="shopping_cart") private WebElement cart;
@FindBy(className="icon-chevron-right.right") private WebElement checkOut;
@FindBy(id="cgv") private WebElement checkbox;
	
private List<WebElement> dresses;
private List<String> links;




public List<String> getAllImages()
{
	
	dresses= driver.findElements(By.className("product_img_link"));
	links= new ArrayList<String>();
	for(WebElement i: dresses)
	{
		links.add(i.getAttribute("href"));
	}
	
	System.out.println("We have total "+links.size()+" dresses");
	return links;
	
		
}

public double order()
{
	cart.click();
	checkOut.click();	
	checkOut.click();
	checkbox.click();
	checkOut.click();

	return 9.1;
}
	 
}
