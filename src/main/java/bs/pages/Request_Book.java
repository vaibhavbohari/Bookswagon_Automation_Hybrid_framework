package bs.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import bs.base.BaseClass;

public class Request_Book extends BaseClass{
	@FindBy(xpath = "//a[text()='Request a Book']")
	WebElement requestBook;
	
	@FindBy(xpath = "//input[@id='ctl00_phBody_RequestBook_txtISBN']")
	WebElement isbnId;
	
	@FindBy(xpath = "//input[@id='ctl00_phBody_RequestBook_txtTitle']")
	WebElement book_title;
	
	@FindBy(xpath = "//input[@id='ctl00_phBody_RequestBook_imgbtnSave']")
	WebElement submit;
	
	//@FindBy(xpath = "/html[1]/body[1]/form[1]/div[10]/div[1]/div[5]/div[1]/label[1]")
	//WebElement  successMessg;
	
	
	public Request_Book() {
		PageFactory.initElements(driver, this);	
	}
	
	public String validateRequestBookTitle() {
		return driver.getTitle();
	}
	
	public void request(String isbn, String bt) throws InterruptedException {
		requestBook.click();
		isbnId.sendKeys(isbn);
		Thread.sleep(2000);
		book_title.sendKeys(bt);
		Thread.sleep(2000);
		submit.click();
		Thread.sleep(2000);

	}
	
	public String getSuccessMessg() {
		return driver.findElement(By.id("ctl00_phBody_RequestBook_lblsuccessmsg")).getText();
		
	}
	
	
}
