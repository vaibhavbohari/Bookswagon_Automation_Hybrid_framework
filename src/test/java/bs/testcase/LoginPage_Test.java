package bs.testcase;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import bs.pages.HomePage;

import bs.base.BaseClass;
import bs.pages.LoginPage;
import bs.utility.Utility;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

public class LoginPage_Test extends BaseClass {
	
	LoginPage loginPage;
	HomePage homePage;
	Logger log = Logger.getLogger(LoginPage_Test.class);


	Utility utility;
	public String SheetName = "Sheet2";

	public LoginPage_Test() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		log.info("******** Starting test cases execution  *********");
		initialization();
		loginPage = new LoginPage();
	}
	@Test(priority = 1)
	public void loginPageTitleTest() {
		String title = loginPage.validateLoginPageTitle();
		Assert.assertEquals(title, "Online BookStore India, Buy Books Online, Buy Book Online India - Bookswagon.com");
		System.out.println("title:"+title);
	}
	@Test(priority = 2)
	public void ImageTest() {
		boolean flag = loginPage.validateImage();
		Assert.assertTrue(flag);
		System.out.println(flag);
	}
	
	
	@Test(priority = 3)
	public void loginTest() {
		log.info("LoginTest Method Runing...");
		homePage=loginPage.login(prop.getProperty("email"), prop.getProperty("password"));
		log.info("login successful with username and Password");
	}
	
	@DataProvider
	public Object[][] getLoginTestData() {
		Object data[][] = utility.getTestData(SheetName);
		return data;
	}
	
	@Test(dataProvider = "getLoginTestData", priority = 4)
	public void MultipleUserLoginTest(String username, String password) {
		log.info("Multiple user login Method Runing...");
		loginPage.multipleUserLogin(username, password);
		
	
	}
	
	@AfterMethod
	public void tearDown() throws InterruptedException {
		Thread.sleep(5000);
		driver.quit();
		log.info("browser is closed");
	}


}
