package Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EmployeeConcent_Locators {
	private static WebElement element = null;
	
	public static WebElement UserConsent_Checkbox(WebDriver driver)
	{
		element = driver.findElement(By.id("chkConcent"));	    
	    return element;
	}
	public static WebElement UserConsent_AgreeBtn(WebDriver driver)
	{
		element = driver.findElement(By.xpath("//button[@id='btn1']"));	    
	    return element;
	} 
	public static WebElement UserConsent_DisagreeBtn(WebDriver driver)
	{
		element = driver.findElement(By.xpath("//button[@id='btn2']"));	    
	    return element;
	}

}
