package bs.testcase;

import java.awt.AWTException;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;



import bs.base.BaseClass;
import bs.pages.Add_Address_Page;
import bs.pages.LoginPage;
import bs.utility.Utility;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

public class Add_Address_Test extends BaseClass {

	LoginPage loginPage;
	Add_Address_Page add_address;
	Utility utility;
	Logger log = Logger.getLogger(Add_Address_Test.class);
	public String SheetName = "Sheet1";

	public Add_Address_Test() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		log.info("******** Starting test cases execution  *********");
		initialization();
		loginPage = new LoginPage();
		loginPage.login(prop.getProperty("email"), prop.getProperty("password"));
		add_address = new Add_Address_Page();

	}
	@DataProvider
	public Object[][] getLoginTestData() {
		Object data[][] = Utility.getTestData(SheetName);
		return data;
	}

	
	

	@Test(dataProvider = "getLoginTestData")
	public void add_Address_Test(String RecipientName, String StreetAddress, String Country, String State, String City)
			throws AWTException {
		//log.info("Add new address Method Runing...");
		add_address.add_Address(RecipientName, StreetAddress, Country, State, City);
	}

	@AfterMethod
	public void tearDown() throws InterruptedException {
		Thread.sleep(5000);
		driver.quit();
		log.info("browser is closed");

	}

}
