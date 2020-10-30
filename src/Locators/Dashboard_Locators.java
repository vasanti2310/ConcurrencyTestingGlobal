package Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Dashboard_Locators {
	private static WebElement element = null;
	
	public static WebElement Dashboard(WebDriver driver)
	{
		element = driver.findElement(By.linkText("Dashboard"));
		return element;
	}
	public static WebElement ToggleBtn(WebDriver driver)
	{
		element = driver.findElement(By.xpath(".//*[@id='btnToggle']"));	    
	    return element;
	}
	public static WebElement MySummaryReport(WebDriver driver)
	{
		element = driver.findElement(By.xpath(".//*[@id='grid1']/div[2]/div[2]/div[1]/div/div[1]/div/div[2]/div/a"));	    
	    return element;
	}    
	public static WebElement ExportBtn(WebDriver driver)
	{
		element = driver.findElement(By.xpath(".//*[@id='btnExport']"));	    
	    return element;
	} 
	
	public static WebElement MyExerciseTransactions(WebDriver driver)
	{
		element = driver.findElement(By.xpath(".//*[@id='lnkExcersiceViewDetails']"));	    
	    return element;
	}  
	public static WebElement MoreBtn(WebDriver driver)
	{
		element = driver.findElement(By.xpath(".//*[@id='LnkMoreExcercise']"));	    
	    return element;
	}    
	public static WebElement ProfileLnk(WebDriver driver)
	{
		element = driver.findElement(By.xpath(".//*[@id='lnkProfile']"));	    
	    return element;
	}    
}