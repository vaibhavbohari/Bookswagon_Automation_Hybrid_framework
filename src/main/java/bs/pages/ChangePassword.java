package bs.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import bs.base.BaseClass;

public class ChangePassword extends BaseClass {
	
	@FindBy(linkText="Change Password")
	WebElement change_Pass;
	
	@FindBy(xpath="//input[@id='ctl00_phBody_ChangePassword_txtCurPwd']")
	WebElement curr_pass;
	
	@FindBy(xpath="//input[@id='ctl00_phBody_ChangePassword_txtNewPassword']")
	WebElement new_Pass;
	
	@FindBy(xpath="//input[@id='ctl00_phBody_ChangePassword_txtConfirmPwd']")
	WebElement curr_Pass;
	
	@FindBy(xpath="//input[@id='ctl00_phBody_ChangePassword_imgSubmit']")
	WebElement chan_Pass_btn;
	
	public ChangePassword() {
		PageFactory.initElements(driver,this);
	}
	
	public String getSuccessMessg() {
		return driver.findElement(By.id("ctl00_phBody_ChangePassword_lblmsg")).getText();
		
	}
	
	
	public void change_password(String currentPassword,String newPassword,String confirmPassword) {			
		change_Pass.click();
		curr_pass.sendKeys(currentPassword);
		new_Pass.sendKeys(newPassword);
		curr_Pass.sendKeys(confirmPassword);
		chan_Pass_btn.click();
		this.getSuccessMessg();
		
	}

}
