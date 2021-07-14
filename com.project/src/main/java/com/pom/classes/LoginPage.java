package com.pom.classes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	
	
	@FindBy (xpath = "//input[@class=\"_2IX_2- VJZDxU\"]")
	private WebElement emailid;
	
	@FindBy (xpath = "//input[@type=\"password\"]")//div[@class=\"_1D1L_j\"]
	private WebElement password;
	
	@FindBy  (xpath = "//button[@class=\"_2KpZ6l _2HKlqd _3AWRsL\"]")
	private WebElement login;

	
	
	
	public LoginPage(WebDriver driver) 
	{
	
		PageFactory.initElements(driver, this);
		
	}
	
	
	public void emailid()
	{
		emailid.sendKeys("9834243552");
	}
	
	public void password()
	{
		password.sendKeys("sumeetshubham123");
	}
	public void login()
	{
		login.click();
	}
	
    
}
