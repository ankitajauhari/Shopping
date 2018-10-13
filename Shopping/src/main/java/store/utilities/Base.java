package store.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.log4testng.Logger;



public class Base {

	protected  static WebDriver driver;
	protected  static Properties Prop;
	protected static File f;
	protected static WebDriverWait wait;
	protected static Logger log ;

	
	public  void setUp()
		{
			try {
				
			log=Logger.getLogger(Base.class);
			System.setProperty("webdriver.chrome.driver","C:\\Users\\admin\\Desktop\\aashi\\chromedriver_win32\\chromedriver.exe");
			driver=new ChromeDriver();
			f=new File("C:\\Users\\admin\\eclipse-workspace\\Selenium\\resources\\data.properties");
			 Prop = new Properties();
			 wait = new WebDriverWait(driver,50);
			 FileInputStream fileInput = null;
			 fileInput = new FileInputStream(f);
				Prop.load(fileInput);
				driver.get(Prop.getProperty("url"));
				log.info("Url opened");
				driver.manage().window().maximize();
				
				
			}
			catch( Exception e)
			{
				e.printStackTrace();
			}
		
		}
		
		
		public static void screenshot(WebDriver driver, long ms)
		{

		try {
			 File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			 FileUtils.copyFile(scrFile, new File("screen_"+ms+".png"));
		  
		    System.out.println("ScreenShot Taken");
		} 
		catch (Exception e) 
		{
		    System.out.println("Exception while taking ScreenShot "+e.getMessage());
		}


		}

	
		public void close()
		{
			driver.close();
		
		}
			
}
