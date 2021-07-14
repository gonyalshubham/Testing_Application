package com.pom.classes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	@FindBy (xpath="(//div[@class=\"xtXmba\"])[2]")
	private WebElement grocery;
	
	@FindBy (xpath="(//div[@class=\"xtXmba\"])[3]")
	private WebElement mobile;
	
	@FindBy (xpath="(//div[@class=\"xtXmba\"])[5]")
	private WebElement electronic;

	@FindBy (xpath="(//div[@class=\"_3vhnxf\"])[10]")
    private WebElement logout;
	
	public HomePage(WebDriver driver)
	{
		
		PageFactory.initElements(driver, this);
	}
	
	public void grocery()
	{
		grocery.click();
		
	}
	
	public void mobile()
	{
		mobile.click();
	}
	
	public void electronic()
	{
		electronic.click();
	}
	
	public void logout()
    {
    	logout.click();
    }
}
