package Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class Login_Locator {
	private static WebElement element = null;
	
/*******************************************************************************************
* 
*                       
* HISTORY          :   AUTHOR                  	DATE            	VERSION
* 
* CREATED BY       :   Vasanti			6-JUNE-2016     	1.0
*
*******************************************************************************************/	

	public static WebElement COVID(WebDriver driver)
    {
    element = driver.findElement(By.xpath("//button[@id='btn1']"));
    return element;
    }
	public static WebElement MYESOPUserId(WebDriver driver)
	{
	element = driver.findElement(By.id("txtUserId"));
	return element;
	}
	public static WebElement MYESOPPassword(WebDriver driver)
	{
//	element = driver.findElement(By.id("txtPassword1"));
	element =  driver.findElement(By.xpath(".//*[@id='txtPassword1'] |.//*[@id='txtPassword']"));
	return element;
	}
	public static WebElement MYESOPCompanyID(WebDriver driver)
	{
	element = driver.findElement(By.id("txtCompanyId"));
	return element;
	}

	public static WebElement MYESOPLogin(WebDriver driver)
	{
	//element = driver.findElement(By.id("btnOk"));
		element =  driver.findElement(By.xpath(".//*[@id='btnOk'] |.//*[@id='login_btn']"));
		
		return element;
	}
	public static WebElement SeqAns1(WebDriver driver)
	{
	element = driver.findElement(By.id("txtSecurityQuestion_answer1"));
	return element;
	}

	public static WebElement SeqAns2(WebDriver driver)
	{
	element = driver.findElement(By.id("txtSecurityQuestion_answer2"));
	return element;
	}
	public static WebElement SubmitAns(WebDriver driver)
	{
	element = driver.findElement(By.id("btnSubmitAnswer"));
	return element;
	}
	public static WebElement SelectFormat(WebDriver driver)
	{
	element = driver.findElement(By.xpath(".//*[@id='MyReportViewer_ctl01_ctl05_ctl00']"));

	return element;
	}
	public static WebElement Export(WebDriver driver)
	{
	element = driver.findElement(By.id("MyReportViewer_ctl01_ctl05_ctl01"));
	return element;
	}
	public static WebElement Logo(WebDriver driver)
	{
		 element =  driver.findElement(By.xpath(".//*[@id='UserLogo']"));
	        return element;
	}
	public static WebElement Logout(WebDriver driver)
	{
		 element =  driver.findElement(By.linkText("Logout"));
	        return element;
	}
	public static WebElement ForgetPWD(WebDriver driver)
	{
		element=  driver.findElement(By.xpath(".//*[@id='forgotpassword']"));
		return element;
	}
	public static WebElement ForgetPwdSubmit(WebDriver driver)
	{
		element= driver.findElement(By.id("btnForgotPassword"));
		return element;
	}
	public static WebElement ForgetPWDbackToLogin(WebDriver driver)
	{
		element=driver.findElement(By.xpath(".//*[@id='backtologin']"));
		return element;
	}
	public static WebElement UserLogo(WebDriver driver)
	{
	element = driver.findElement(By.xpath("//div[@id='UserLogo']"));
	return element;
	}
}
