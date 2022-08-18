package bs.testcase;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import bs.base.BaseClass;
import bs.pages.LoginPage;
import bs.pages.WishList;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

public class WishList_Test extends BaseClass {
	
	LoginPage loginPage;
	WishList wishlist;
	Logger log = Logger.getLogger(WishList_Test.class);

	public WishList_Test() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		log.info("******** Starting test cases execution  *********");
		initialization();
		loginPage = new LoginPage();
		loginPage.login(prop.getProperty("email"), prop.getProperty("password"));
		wishlist = new WishList();
	}

	@Test(priority = 1)
	public void feature_authTest() throws InterruptedException {
		log.info("Feature Author Method Runing...");
		wishlist.feature_auth();
		String title = wishlist.validateWishListPageTitle();
		Assert.assertEquals(title, "Buy Best Selling William Wordsworth Books Online at Bookswagon");
		System.out.println("title:"+title);
	}

	@Test(priority = 2)
	public void search_BookNameTest() throws InterruptedException {
		log.info("Search by book name Method Runing...");
		wishlist.search_BookName(prop.getProperty("addwishlistByBookname"));
		String title = wishlist.validateWishListPageTitle();
		Assert.assertEquals(title,"wings of fire - Books - 24x7 online bookstore Bookswagon.com");
		System.out.println("title:"+title);
	}

	@Test(priority = 3)
	public void addWishlist_AuthorNameTest() throws InterruptedException {
		log.info("Search by Author name Method Runing...");
		wishlist.addWishlist_AuthorName(prop.getProperty("addwishlistByAuthor"));
		String title = wishlist.validateWishListPageTitle();
		Assert.assertEquals(title,"a.p.j. abdul kalam - Books - 24x7 online bookstore Bookswagon.com");
		System.out.println("title:"+title);
	}

	@Test(priority = 4)
	public void addWishlist_PublisherTest() throws InterruptedException {
		log.info("Search by Publisher Method Runing...");
		wishlist.addWishlist_Publisher(prop.getProperty("addwishlistByPublisher"));
		String title = wishlist.validateWishListPageTitle();
		Assert.assertEquals(title,"rupa publications india - Books - 24x7 online bookstore Bookswagon.com");
		System.out.println("title:"+title);
	}

	@Test(priority = 5)
	public void wishlist_Test() throws InterruptedException {
		log.info("Wishlist Method Runing...");
		wishlist.wish_list();
	}

	@AfterMethod
	public void tearDown() throws InterruptedException {
		Thread.sleep(5000);
		driver.quit();
		log.info("browser is closed");

	}

}
