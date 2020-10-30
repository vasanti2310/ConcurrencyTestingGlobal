package Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage_Locators {
private static WebElement element = null;
	
	/*=================HomePage========================*/
	   
    public static WebElement HomePageLocator1(WebDriver driver)
   {
	element = driver.findElement(By.xpath(".//*[@id='myCarousel']/div[2]/div/ol/li[1]"));
	return element;
   }
    public static WebElement HomePageLocator2(WebDriver driver)
    {
 	element = driver.findElement(By.xpath(".//*[@id='myCarousel']/div[2]/div/ol/li[2]"));
 	return element;
    }
    public static WebElement HomePageLocator3(WebDriver driver)
    {
 	element = driver.findElement(By.xpath(".//*[@id='myCarousel']/div[2]/div/ol/li[3]"));
 	return element;
    }
    public static WebElement HomePageLocator4(WebDriver driver)
    {
 	element = driver.findElement(By.xpath(".//*[@id='myCarousel']/div[2]/div/ol/li[4]"));
 	return element;
    }
    public static WebElement HomePageLocator5(WebDriver driver)
    {
 	element = driver.findElement(By.xpath(".//*[@id='myCarousel']/div[2]/div/ol/li[5]"));
 	return element;
    }
   
    /*=================FooterPage========================*/
    
    public static WebElement FooterPageLocator1(WebDriver driver)
    {
 	element = driver.findElement(By.xpath(".//*[@id='footer']/div/div/div[2]/div/ul/li[1]/a"));
 	return element;
    }      
  
    public static WebElement FooterPageLocator2(WebDriver driver)
    {
 	element = driver.findElement(By.xpath(".//*[@id='footer']/div/div/div[2]/div/ul/li[2]/a"));
 	return element;
    } 
    
    public static WebElement FooterPageLocator3(WebDriver driver)
    {
 	element = driver.findElement(By.xpath(".//*[@id='footer']/div/div/div[2]/div/ul/li[4]/a"));
 	return element;
    }
    
    public static WebElement FooterPageLocator4(WebDriver driver)
    {
 	element = driver.findElement(By.xpath(".//*[@id='footer']/div/div/div[2]/div/ul/li[5]/a"));
 	return element;
    }
    
    public static WebElement FooterPageLocator5(WebDriver driver)
    {
 	element = driver.findElement(By.xpath(".//*[@id='footer']/div/div/div[2]/div/ul/li[6]/a"));
 	return element;
    }
    
    public static WebElement LoginPage(WebDriver driver)
    {
 	element = driver.findElement(By.xpath(".//*[@id='btnLogin']"));
 	return element;
    }
 }