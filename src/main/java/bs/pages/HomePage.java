package bs.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



import bs.base.BaseClass;

public class HomePage extends BaseClass {
	
	@FindBy(xpath = "//span[@class='usernametext']")

	WebElement userNameLabel;

	@FindBy(xpath = "//input[@id = 'ctl00$TopSearch1$txtSearch']")
	WebElement search;
	
	@FindBy(xpath = "//li[@class='active']//a[normalize-space()='Personal Settings']")
	WebElement personalSettings;

	@FindBy( linkText = "My Account" )
	WebElement myAccount;

	@FindBy(linkText = "My Orders")
	WebElement myOrders;

	@FindBy(linkText = "My Wishlist")
	WebElement myWishlist;

	@FindBy(linkText = "My Gift Certificates")
	WebElement myGiftCertificates;
	
	@FindBy(linkText = "My Addresses")
	WebElement myAddresses;
	
	@FindBy(linkText = "Change Password")
	WebElement changePassword;
	
	@FindBy (id = "ctl00_lblUser")
    WebElement myProfile;
	
    @FindBy (id = "ctl00_lnkbtnLogout")
    WebElement logout;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	public String verifyHomePageTitle() {
		return driver.getTitle();

	}

	public String verifyCorrectUserName() {
		return userNameLabel.getText();
	}
	
	public LoginPage logout_from_account () throws InterruptedException {
        Thread.sleep (4000);
        Actions actions = new Actions (driver);
        //Hovering on my account menu
        actions.moveToElement (myProfile);
        Thread.sleep (300);
        //To mouseover on sub Logout button menu and click
        actions.moveToElement (logout).build ().perform ();
        Thread.sleep (400);
        
        return new LoginPage();
    }


}
