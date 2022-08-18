package bs.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import bs.base.BaseClass;

public class SearchBook extends BaseClass{
	
	@FindBy(xpath = "//input[@id='ctl00_TopSearch1_txtSearch']")
	private WebElement searchBook;

	@FindBy(xpath = "//input[@id='ctl00_TopSearch1_Button1']")
	private WebElement searchBtn;
	
	@FindBy(xpath = "//input[@value ='Buy Now']")
	private WebElement clickOnBookNow;

	@FindBy(xpath = "//input[@id='BookCart_lvCart_imgPayment']")
	private WebElement clickOnPlaceOrder;

	// initialize Object
	public SearchBook() {
		PageFactory.initElements(driver, this);
	}
	
	// Check search box with book item
		public void SearchBookItem(String strBookName) {
			searchBook.sendKeys(strBookName);
		}
		
		//This method to check search button
		public void SearchBtn() {
			searchBtn.click();
		}

		// This method is to set search value
		public HomePage clickSearchButton(String strSearchBookName) throws InterruptedException {
			this.SearchBookItem(strSearchBookName);
			Thread.sleep(3000);
			this.SearchBtn();
			Thread.sleep(3000);
			return new HomePage();
		}

		//This method is to click on navigation book
		public void clickOnBookNow() throws InterruptedException {
			clickOnBookNow.click();
			Thread.sleep(3000);
		}


}
