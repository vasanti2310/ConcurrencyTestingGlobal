package Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ChangePWD_Locators {
	private static WebElement element = null;
	
/*******************************************************************************************
* 
*                       
* HISTORY          :   AUTHOR                  	DATE            	VERSION
* 
* CREATED BY       :   Vasanti			6-JUNE-2016     	1.0
*
*******************************************************************************************/	

	
	public static WebElement ChangePWD(WebDriver driver)
	{
	element =  driver.findElement(By.xpath(".//*[@id='lichangepassword']/a"));
	return element;
	}
	
	public static WebElement ChangePWDCross(WebDriver driver)
	{
	element =  driver.findElement(By.xpath(".//*[@id='btnNoteClose']"));
	return element;
	}
	public static WebElement ChangePWDBtn(WebDriver driver)
	{
	element =  driver.findElement(By.xpath("//input[@id='btnChnagePassword']"));
	return element;
	}
	public static WebElement ChangePWDCancelBtn(WebDriver driver)
	{
	element =  driver.findElement(By.xpath("//button[@id='btnCancel']"));
	return element;
	}
	
	public static WebElement ChangePWDNote(WebDriver driver)
	{
	element =  driver.findElement(By.xpath("//button[@id='show_PwdConfig']"));
	return element;
	}
	
	public static WebElement OldPassword(WebDriver driver)
	{
		element = driver.findElement(By.id("oldpwd")); 
		return element;
	}
	
	public static WebElement NewPassword(WebDriver driver)
	{
		element = driver.findElement(By.id("NewPassword")); 
		return element;
	}
	
	public static WebElement ConfirmPassword(WebDriver driver)
	{
		element = driver.findElement(By.id("confirmpwd")); 
		return element;
	}
	
	public static WebElement ChangePassword_btn(WebDriver driver)
	{
		element = driver.findElement(By.xpath(".//*[@id='btnChnagePassword']")); 
		return element;
	}
	public static WebElement PopupBtn(WebDriver driver)
	{
		element = driver.findElement(By.id("btn1")); 
		return element;
	}
}
