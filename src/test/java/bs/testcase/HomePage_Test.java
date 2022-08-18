package bs.testcase;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import bs.base.BaseClass;
import bs.pages.HomePage;
import bs.pages.LoginPage;

public class HomePage_Test extends BaseClass {

	LoginPage loginPage;
	HomePage homePage;
	Logger  log = Logger.getLogger(HomePage_Test.class);
	
	
	public HomePage_Test() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		log.info("****** Starting test cases execution  *******");
		initialization();
		loginPage = new LoginPage();
		homePage=loginPage.login(prop.getProperty("email"), prop.getProperty("password"));
		log.info("************Login the Application**********************");
		log.info("Open Home Page");
	}
	
	@Test(priority = 1)
	public void HomePageTitleTest() throws InterruptedException {
		log.info("****** starting test case ******");
		log.info("Opening Home Page");
		String homePageTitle = homePage.verifyHomePageTitle();
		Assert.assertEquals(homePageTitle, "Online BookStore India, Buy Books Online, Buy Book Online India - Bookswagon.com");
		Thread.sleep(2000);
		log.info("Title Verified Successfully.....");
	
	}

	@Test(priority = 2)
	public void verifyUserNameTest() {
		log.info("****** starting test case ******");
		log.info("******* verifyUserNameTest ******");
		String username = homePage.verifyCorrectUserName();
		Assert.assertEquals(username,"Vaibhav Pramod Bohari");
		System.out.println(username);
		log.info("UserName Verified Successfully.....");
		
	}
	@Test(priority = 3)
	public void verifyClickOnLogout() throws InterruptedException {
		log.info("****** starting test case ******");
		log.info("******* verifyClickOnLogout ******");
		loginPage = homePage.logout_from_account();
		Thread.sleep(3000);
		
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
		 log.info("browser is closed");
	}

	
}
