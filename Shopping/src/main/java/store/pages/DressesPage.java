package store.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import store.utilities.Base;

public class DressesPage extends Base{

@FindBy(xpath="//li//a[@title=\"Women\"]") private WebElement women;
@FindBy(xpath="//a[@title=\"Tops\" and @class=\"img\"]") private WebElement tops;	
@FindBy(xpath="//a[@title=\"T-shirts\" and @class=\"img\"]") private WebElement tShirts;	
@FindBy(xpath="//span[@id=\"total_price\"]") private WebElement totalCost;
@FindBy(xpath="//div[@class=\"button-container\"]//a[@title=\"Proceed to checkout\"]") private WebElement proceed;
@FindBy(xpath="//a[@title=\"Pay by check.\"]") private WebElement checkPay;
@FindBy(xpath="//span[contains(text(),'I confirm my order')]") private WebElement confirmOrder;

@FindBy(className="shopping_cart") private WebElement cart;
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
	proceed.click();	
	proceed.click();
	proceed.click();
	checkbox.click();
	proceed.click();
	double cost=Float.parseFloat(totalCost.getText());
	checkPay.click();
	confirmOrder.click();
	return cost;
	
}

public void buyTop()
{
	wait.until(ExpectedConditions.visibilityOf(women));
	women.click();
	wait.until(ExpectedConditions.visibilityOf(tops));
	tops.click();
	wait.until(ExpectedConditions.visibilityOf(tShirts));
	tShirts.click();
}

 
}
