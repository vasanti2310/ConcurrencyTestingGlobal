package Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EditPersonalDetails_Locator 

{
	
	private static WebElement element = null;
	
	public static WebElement PersonalDetailsleftpanel(WebDriver driver)
	   {
	      element = driver.findElement(By.linkText("Personal Details"));
	      return element;
	   }
	
	public static WebElement EditPersonalDetails(WebDriver driver)
	   {
	      element = driver.findElement(By.linkText("Edit Personal Details"));
	      return element;
	   }
	
	public static WebElement txtDateofJoining(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_TabContainer1_TabPanel1_txtDOJ']"));
	      return element;
	   }
	
	
	
	public static WebElement txtGrade(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_TabContainer1_TabPanel1_txtGrade']"));
	      return element;
	   }
	
	public static WebElement txtFathersName(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_TabContainer1_TabPanel1_txtFathersName']"));
	      return element;
	   }
	
	public static WebElement txtDesignation(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_TabContainer1_TabPanel1_txtDesignation']"));
	      return element;
	   }
	
	public static WebElement CountryName(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_TabContainer1_TabPanel1_dllCountryName']"));
	      return element;
	   }
	
	public static WebElement txtPhoneNo(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_TabContainer1_TabPanel1_txtPhone']"));
	      return element;
	   }
	
	public static WebElement txtAddress(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_TabContainer1_TabPanel1_txtAddress']"));
	      return element;
	   }
	
	public static WebElement txtEmailId(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_TabContainer1_TabPanel1_txtEmail']"));
	      return element;
	   }
	
	public static WebElement txtPAN(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_TabContainer1_TabPanel1_txtPan']"));
	      return element;
	   }
	
	public static WebElement txtDepartment(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_TabContainer1_TabPanel1_txtDepartment']"));
	      return element;
	   }
	
	public static WebElement ResidentialStatus(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_TabContainer1_TabPanel1_ddlResdStatus']"));
	      return element;
	   }
	
	public static WebElement txtLocation(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_TabContainer1_TabPanel1_txtLocation']"));
	      return element;
	   }
	
	public static WebElement InsiderEmployee(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_TabContainer1_TabPanel1_ddlInsider']"));
	      return element;
	   }
	
	public static WebElement txtSBU(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_TabContainer1_TabPanel1_txtSBU']"));
	      return element;
	   }
	
	public static WebElement txtITWardNO(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_TabContainer1_TabPanel1_txtWardno']"));
	      return element;
	   }	
	
	public static WebElement txtEntity(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_TabContainer1_TabPanel1_txtEntity']"));
	      return element;
	   }
	
	public static WebElement txtCostCenter(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_TabContainer1_TabPanel1_txtCostCenter']"));
	      return element;
	   }
	
	public static WebElement TaxIdCountry(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_TabContainer1_TabPanel1_ddlTaxIDCountry']"));
	      return element;
	   }
	
	public static WebElement TaxIdState(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_TabContainer1_TabPanel1_ddlTaxIDState']"));
	      return element;
	   }
	
	public static WebElement btnSavePersonalDetails(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_TabContainer1_TabPanel1_BtnSaveAll']"));
	      return element;
	   }
	
	public static WebElement savePersonalDetailsMsg(WebDriver driver,String TestCaseName)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_lblMessage']"));
	      return element;
	   }
	
	
	
	public static WebElement DepositoryName(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_TabContainer1_TabPanel1_ddlDpoName']"));
	      return element;
	   }
	
	public static WebElement DematAccType(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_TabContainer1_TabPanel1_ddlDmatAcType']"));
	      return element;
	   }
	
	public static WebElement txtDepositoryparticipantName(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_TabContainer1_TabPanel1_txtDpName']"));
	      return element;
	   }
	
	public static WebElement txtDepositoryparticipantID(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_TabContainer1_TabPanel1_txtDpId']"));
	      return element;
	   }
	
	public static WebElement txtClientDematAccNo(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_TabContainer1_TabPanel1_txtClientId']"));
	      return element;
	   }
	
	public static WebElement txtNameAsDpRecord(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_TabContainer1_TabPanel1_txtDPRecordName']"));
	      return element;
	   } 
	
	public static WebElement BtnSaveDematDetails(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_TabContainer1_TabPanel1_BtnSaveDematDetails']"));
	      return element;
	   } 
	
	public static WebElement txtBrokerCompName(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_TabContainer1_TabPanel1_txtBrokerCompName']"));
	      return element;
	   } 
	
	public static WebElement txtBrokerCompID(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_TabContainer1_TabPanel1_txtBrokerCompID']"));
	      return element;
	   } 
	
	public static WebElement txtBrokerAccNo(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_TabContainer1_TabPanel1_txtBrokerAccNo']"));
	      return element;
	   } 
	
	public static WebElement BtnSaveBrokerDetails(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_TabContainer1_TabPanel1_BtnSaveBrokerDetails']"));
	      return element;
	   } 

}
