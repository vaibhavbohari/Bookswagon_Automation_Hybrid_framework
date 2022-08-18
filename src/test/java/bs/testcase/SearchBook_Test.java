package bs.testcase;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import bs.base.BaseClass;
import bs.pages.HomePage;
import bs.pages.LoginPage;
import bs.pages.SearchBook;

public class SearchBook_Test extends  BaseClass{
	
	SearchBook searchBook;
	HomePage homePage;
	LoginPage loginPage;
	Logger log = Logger.getLogger(SearchBook_Test.class);
	
	public SearchBook_Test () {
		super();
	}

	@BeforeMethod
	public void setUp() throws IOException, InterruptedException {
		log.info("******** Starting test cases execution  *********");
		initialization();
		loginPage = new LoginPage();
		loginPage.login(prop.getProperty("email"), prop.getProperty("password"));
		searchBook = new SearchBook();
		homePage = new HomePage();
	}
	
	@Test(priority=1)
	public void verifySearchPageTest() throws Exception{
		searchBook.clickSearchButton("Perspective Made Easy");
		searchBook.clickOnBookNow();
		log.info("Verify Successfully Search Feature");
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
		log.info("browser is closed");

		
	}


}
