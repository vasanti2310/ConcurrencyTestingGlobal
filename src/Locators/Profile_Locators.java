package Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Profile_Locators {
	private static WebElement element = null;
	
/*******************************************************************************************
* 
*                       
* HISTORY          :   AUTHOR                  	DATE            	VERSION
* 
* CREATED BY       :   Vasanti			6-JUNE-2016     	1.0
*
*******************************************************************************************/	

	
	public static WebElement Profile(WebDriver driver)
	{
	element = driver.findElement(By.linkText("Profile"));
	return element;
	}
	public static WebElement OtherDetails(WebDriver driver)
	{
	element = driver.findElement(By.xpath("//a[@id='OtherDetails']"));
	return element;
	}
	public static WebElement CancelBtn(WebDriver driver)
	{
	element = driver.findElement(By.xpath("//button[@id='BtnCancelUserDetails']"));
	return element;
	}
	public static WebElement SaveBtn(WebDriver driver)
	{
	element = driver.findElement(By.xpath("//button[@id='btnSave']"));
	return element;
	}
	public static WebElement DematDetails(WebDriver driver)
	{
	element = driver.findElement(By.xpath("//a[@id='DematDetails']"));
	return element;
	}
}
