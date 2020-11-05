package Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Profile_menu 
{
private static WebElement element = null;

public static WebElement UserLogo(WebDriver driver)
{
	element = driver.findElement(By.id("UserLogo")); 
	return element;
}
    //Profile tab
	public static WebElement Profile(WebDriver driver)
	{
		element = driver.findElement(By.linkText("Profile")); 
		return element;
	}
	
	
	
	//DematDetails
	public static WebElement DematDetailsDematDetails_tab(WebDriver driver)
	{
		element = driver.findElement(By.id("DematDetails")); 
		return element;
	}
	public static WebElement DematDetailsDematDetails_Add(WebDriver driver)
	{
		element = driver.findElement(By.className("add-demat-acc"));
			return element;
	}
	public static WebElement DematDetailsEdit_btn(WebDriver driver)
	{	element = driver.findElement(By.xpath("//div[@class='add-demat-acc']//i[@class='fa fa-plus']")); 
		return element;
	}
	
	
	public static WebElement Add_DematDetailsDepositoryName_ddl(WebDriver driver)
	{
		element = driver.findElement(By.id("ddlDepositename")); 
		return element;
	}
	
	public static WebElement Add_DematDetailsDematAccountType_ddl(WebDriver driver)
	{
		element = driver.findElement(By.id("ddlDematAccountType")); 
		return element;
	}
	
	public static WebElement Add_DematDetailsDepository_ParticipantName(WebDriver driver)
	{
		element = driver.findElement(By.id("txtDepositoryParticipantName")); 
		return element;
	}
	
	public static WebElement Add_DematDetailsDepository_ParticipantId(WebDriver driver)
	{
		element = driver.findElement(By.id("txtDepositoryParticipantId")); 
		return element;
	}
	
	public static WebElement Add_DematDetailsClient_DematAccNo(WebDriver driver)
	{
		element = driver.findElement(By.id("txtClientIdNo")); 
		return element;
	}
	
	public static WebElement Add_DematDetailsName_DP_Record(WebDriver driver)
	{
		element = driver.findElement(By.id("txtNameDPRecord")); 
		return element;
	}
	
	public static WebElement Edit_DematDetailsDepositoryName_ddl(WebDriver driver)
	{
		element = driver.findElement(By.id("ddlDepositename")); 
		return element;
	}
	
	public static WebElement Edit_DematDetailsDematAccountType_ddl(WebDriver driver)
	{
		element = driver.findElement(By.id("ddlDematAccountType")); 
		return element;
	}
	
	public static WebElement Edit_DematDetailsDepository_ParticipantName(WebDriver driver)
	{
		element = driver.findElement(By.id("txtDepositoryParticipantName")); 
		return element;
	}
	
	public static WebElement Edit_DematDetailsDepository_ParticipantId(WebDriver driver)
	{
		element = driver.findElement(By.id("txtDepositoryPartiId")); 
		return element;
	}
	
	public static WebElement Edit_DematDetailsClient_DematAccNo(WebDriver driver)
	{
		element = driver.findElement(By.id("txtClientId")); 
		return element;
	}
	
	public static WebElement Edit_DematDetailsName_DP_Record(WebDriver driver)
	{
		element = driver.findElement(By.id("txtDpRecord")); 
		return element;
	}

	public static WebElement UploadCMLFile(WebDriver driver)
	{
		element = driver.findElement(By.id("UploadfilesCML")); 
		return element;
	}
	public static WebElement ActualFileName(WebDriver driver)
	{
		element = driver.findElement(By.id("UploadfilesCML")); 
		return element;
	}
	public static WebElement btn_Upload(WebDriver driver)
	{
		element = driver.findElement(By.id("btnUploadfileTax")); 
		return element;
	}
	
	public static WebElement DematDetailsUpdate_btn(WebDriver driver)
	{
		element = driver.findElement(By.id("BtnUpdateDematDetails")); 
		return element;
	}
	public static WebElement UploadAccept_btn(WebDriver driver)
	{
		element = driver.findElement(By.id("btn1")); 
		return element;
	}
	public static WebElement BtnSaveDematDetails(WebDriver driver)
	{
		element = driver.findElement(By.xpath("//button[@id='btnAddNow']")); 
		return element;
	}
	
	
	
	public static WebElement DematDetailsCancel_btn(WebDriver driver)
	{
		element = driver.findElement(By.id("btnCancelDematAcc")); 
		return element;
	}
	
	
	
}
