package bs.testcase;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import bs.base.BaseClass;
import bs.pages.HomePage;
import bs.pages.LoginPage;
import bs.pages.Request_Book;

public class Request_Book_Test extends BaseClass {
	LoginPage loginPage;
	Request_Book requestBook;
	HomePage homePage;
	Logger log = Logger.getLogger(Request_Book_Test.class);

	public Request_Book_Test() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		log.info("******** Starting test cases execution  *********");
		initialization();
		loginPage = new LoginPage();
		loginPage.login(prop.getProperty("email"), prop.getProperty("password"));
		requestBook = new Request_Book();
	}

	@Test(priority = 1)
	public void Request_a_BookTest() throws InterruptedException {
		log.info("user request the book Method Runing...");
		requestBook.request(prop.getProperty("isbnElement"), prop.getProperty("bookTitle"));
		Thread.sleep(5000);

	}
	@Test(priority=2)
	public void it_shows_a_successful_message() throws InterruptedException {
		requestBook.request(prop.getProperty("isbnElement"), prop.getProperty("bookTitle"));
		String actualSuccMessg = requestBook.getSuccessMessg();
		Assert.assertEquals(actualSuccMessg, "We have saved your requested books successfully into our system. We will intimate you as soon as book available.");
		Thread.sleep(2000);
		System.out.println(actualSuccMessg);

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
		log.info("browser is closed");

	}

}
