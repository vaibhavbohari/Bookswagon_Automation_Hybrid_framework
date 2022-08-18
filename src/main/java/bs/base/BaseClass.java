package bs.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import bs.utility.Utility;
import bs.utility.WebEventListener;



public class BaseClass {
	
	
		
		public static WebDriver driver;
		public static Properties prop;
		public static EventFiringWebDriver e_driver;
		public static WebEventListener eventListener;
		

		
		
		public BaseClass() {
			
			try {
				prop = new Properties();
				FileInputStream ip;
				ip = new FileInputStream(
						"C:\\Users\\VAIBHAV\\eclipse-workspace\\Bookswagon_Hybrid_Framework\\src\\main\\java\\bs\\config\\config.properties");
				prop.load(ip);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		public void initialization() {		
			//log.info("Brower Name :" + prop.getProperty("brower"));
			String browserName = prop.getProperty("brower");
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\VAIBHAV\\QAAutomation\\chromedriver_win32 (2)\\chromedriver.exe");
			driver = new ChromeDriver();	
			
			e_driver = new EventFiringWebDriver(driver);
			// Now create object of EventListerHandler to register it with
			// EventFiringWebDriver
			eventListener = new WebEventListener();
			e_driver.register(eventListener);
			driver = e_driver;

			//log.info("Application URL :" + prop.getProperty("url"));
			driver.get(prop.getProperty("url"));
			driver.manage().window().maximize();
			driver.manage().timeouts().pageLoadTimeout(Utility.Page_Load_TImeOut, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);		
		}

}
