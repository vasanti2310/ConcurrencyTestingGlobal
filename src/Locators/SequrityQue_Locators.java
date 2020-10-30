package Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SequrityQue_Locators {
private static WebElement element = null;
	
	//Exercise - Exercise Now
	public static WebElement Que1(WebDriver driver)
	{
		element = driver.findElement(By.id("txtSecurity_answer1"));
		return element;
	}
	public static WebElement Que2(WebDriver driver)
	{
		element = driver.findElement(By.id("txtSecurity_answer2"));
		return element;
	}
	public static WebElement Que3(WebDriver driver)
	{
		element = driver.findElement(By.id("txtSecurity_answer3"));
		return element;
	}
	public static WebElement Que4(WebDriver driver)
	{
		element = driver.findElement(By.id("txtSecurity_answer4"));
		return element;
	}
	public static WebElement Que5(WebDriver driver)
	{
		element = driver.findElement(By.id("txtSecurity_answer5"));
		return element;
	}
	public static WebElement BtnSubmit(WebDriver driver)
	{
		element = driver.findElement(By.id("btnSubmit"));
		return element;
	}
	public static WebElement PopupBtn(WebDriver driver)
	{
		element = driver.findElement(By.id("btn1"));
		return element;
	}
}
