package TestScripts;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;

import BaseClasses.Login_BaseClass;
import Locators.EmployeeConcent_Locators;
import Locators.Login_Locator;
import Locators.Profile_menu;
import Locators.SequrityQue_Locators;
import Utility.Read_XLS;
import Utility.SuiteUtility;

public class CMLTesting extends Login_BaseClass{
	WebDriver driver;
		@BeforeTest
		@Parameters({"browser","UserId","Password","NewPassword","companyid","URL","Ans1","Ans2","Path","DepositoryName","DematAcctype","DepositoryParticipantName","DepositoryParticipantID","ClientDematACNo","NameRecord"})

		public void checkCaseToRun(String browser,String UserId, String Password, String NewPassword, String companyid, String URL,
				 String Ans1, String Ans2, String Path,String	DepositoryName,String DematAcctype,
				 String DepositoryParticipantName,String DepositoryParticipantID,String ClientDematACNo,String NameRecord) throws Exception {
			init();

			report = new ExtentReports(System.getProperty("user.dir") + "/src/Reports/ExtentReportResults.html", true);

			
			System.out.println("URL " + URL);
			String URLwithoutspace = URL.replaceAll("\\s", "");
			String CompanyId1 = companyid.toUpperCase();
			//Check if parameter passed from TestNG is 'firefox'
			if(browser.equalsIgnoreCase("firefox")){
			//create firefox instance
				//D:\SeleniumDriver
			System.setProperty("webdriver.gecko.driver", "D:\\Testing Team Automation\\SeleniumDriver\\geckodriver.exe");
			driver = new FirefoxDriver();
				//	test = report.startTest("URLs");
			driver.get(URLwithoutspace);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			String URL1=driver.getCurrentUrl();
			
			if(URL1.equals(URLwithoutspace))
			{
			System.out.println("Navigated to the specified URL");
			}
			else
			{
			System.out.println("Not Navigated to the UATGlobalUI URL"+ test.addScreenCapture(Screenshot.captureImage(driver)));

			}
			//======Covid 19===============
            if(Login_Locator.COVID(driver).isDisplayed())
            {
                System.out.println("COVID dialogue is displayed");
                Login_Locator.COVID(driver).click();
            }
            else
            {
                System.out.println("COVID dialogue is not displayed");
                System.out.println("alert not present");
            }
			
			// =================Login=================
	//		test = report.startTest("Login");
            Boolean MYESOPUserId = driver.findElements(By.id("txtUserId")).size() != 0;
    		
    		System.out.println("MYESOPUserId" + MYESOPUserId);
    	if(MYESOPUserId==true)
    	{
    		Login_Locator.MYESOPUserId(driver).clear();
    		Thread.sleep(2000);
    		Login_Locator.MYESOPUserId(driver).sendKeys(UserId);
    		Thread.sleep(2000);
    		System.out.println(UserId);
    		System.out.println("UserId "+UserId+" Clicked");
    	}
    	else
    	{
    		System.out.println("UserId "+UserId+" Not Clicked"+ test.addScreenCapture(Screenshot.captureImage(driver)));

    	}
    	Boolean MYESOPPassword = driver.findElements(By.xpath(".//*[@id='txtPassword1'] |.//*[@id='txtPassword']")).size() != 0;
    	System.out.println("MYESOPPassword" + MYESOPPassword);
    if(MYESOPPassword==true)
    {
    			Actions actions = new Actions(driver);
    		actions.moveToElement(Login_Locator.MYESOPPassword(driver));
    		actions.click();
    		actions.sendKeys(Password);
    		actions.build().perform();

    		System.out.println(Password);
    		System.out.println("Password "+Password+" Clicked");
    }
    else
    {
    	System.out.println("Password "+Password+" Not Clicked"+ test.addScreenCapture(Screenshot.captureImage(driver)));

    }
    Boolean MYESOPCompanyID = driver.findElements(By.id("txtCompanyId")).size() != 0;
    System.out.println("MYESOPCompanyID" + MYESOPCompanyID);
    if(MYESOPCompanyID==true)
    {
    		Login_Locator.MYESOPCompanyID(driver).clear();
    		Thread.sleep(4000);
    		Login_Locator.MYESOPCompanyID(driver).sendKeys(CompanyId1);
    		Thread.sleep(2000);
    		System.out.println(CompanyId1);
    		System.out.println("CompanyId1 "+CompanyId1+" Clicked");
    }
    else
    {
    	System.out.println("CompanyId1 "+CompanyId1+" Not Clicked"+ test.addScreenCapture(Screenshot.captureImage(driver)));

    }
    Boolean MYESOPLogin = driver.findElements(By.xpath(".//*[@id='btnOk'] |.//*[@id='login_btn']")).size() != 0;
    System.out.println("MYESOPLogin" + MYESOPLogin);
    if(MYESOPLogin==true)
    {

    		Login_Locator.MYESOPLogin(driver).click();
    		Thread.sleep(2000);
    		System.out.println("Login button Clicked");
    }
    else
    {
    	System.out.println("Login button Not Clicked"+ test.addScreenCapture(Screenshot.captureImage(driver)));

    }
      Boolean iselementpresent1 = driver.findElements(By.id("txtSecurityQuestion_answer1")).size() != 0;
	System.out.println("iselementpresent1" + iselementpresent1);
	Boolean iselementpresent2= driver.findElements(By.id("txtSecurity_answer3")).size() != 0;
	System.out.println("iselementpresent2" +iselementpresent2);
	Thread.sleep(2000);
	if (iselementpresent1 == true) 
	{
		Boolean SeqAns1 = driver.findElements(By.id("txtSecurityQuestion_answer1")).size() != 0;
		System.out.println("SeqAns1" + SeqAns1);
		if (SeqAns1 == true) {
		Login_Locator.SeqAns1(driver).sendKeys(Ans1);
		Thread.sleep(2000);
		System.out.println("SeqAns1 "+Ans1+" Entered");
		} else {
			System.out.println("SeqAns1 not Entered" + test.addScreenCapture(Screenshot.captureImage(driver)));
		}
		System.out.println(Ans2);	
		
		Boolean SeqAns2 = driver.findElements(By.id("txtSecurityQuestion_answer2")).size() != 0;
		System.out.println("SeqAns2" + SeqAns2);
		if (SeqAns2 == true) {
		Login_Locator.SeqAns2(driver).sendKeys(Ans2);
		Thread.sleep(2000);
		System.out.println("SeqAns2 "+Ans2+"Entered");
		} else {
			System.out.println("SeqAns2 not Entered" + test.addScreenCapture(Screenshot.captureImage(driver)));
		}
		System.out.println(Ans2);
		
		Boolean SubmitAns = driver.findElements(By.id("btnSubmitAnswer")).size() != 0;
		System.out.println("SubmitAns" + SubmitAns);
		if (SubmitAns == true) {
		Login_Locator.SubmitAns(driver).click();
		Thread.sleep(2000);	
		System.out.println("SubmitAns Clicked");
		} else {
			System.out.println("SubmitAns not Clicked" + test.addScreenCapture(Screenshot.captureImage(driver)));
		}
		
		System.out.println("SecurityQuestionAns Submited successfuly");
		System.out.println("SecurityQuestionAns Submited successfuly");
	} 
	else if(iselementpresent2==true)
	{
		Boolean Que1 = driver.findElements(By.id("txtSecurity_answer1")).size() != 0;
		System.out.println("Que1" + Que1);
		if (Que1 == true) {
		SequrityQue_Locators.Que1(driver).sendKeys("01");
		Thread.sleep(2000);
		System.out.println("Que1 01 Entered");
		System.out.println("01");
		} else {
			System.out.println("Que1 not Entered" + test.addScreenCapture(Screenshot.captureImage(driver)));
		}
			
		
		Boolean Que2 = driver.findElements(By.id("txtSecurity_answer2")).size() != 0;
		System.out.println("Que2" + Que2);
		if (Que2 == true) {
		SequrityQue_Locators.Que2(driver).sendKeys("01");
		Thread.sleep(2000);
		System.out.println("Que2 01 Entered");
		System.out.println("01");
		} else {
			System.out.println("Que2 not Entered" + test.addScreenCapture(Screenshot.captureImage(driver)));
		}
		Thread.sleep(2000);
		
		Boolean Que3 = driver.findElements(By.id("txtSecurity_answer3")).size() != 0;
		System.out.println("Que3" + Que3);
		if (Que3 == true) {
		SequrityQue_Locators.Que3(driver).sendKeys("01");
		Thread.sleep(2000);
		System.out.println("Que3 01 Entered");
		System.out.println("01");
		} else {
			System.out.println("Que3 not Entered" + test.addScreenCapture(Screenshot.captureImage(driver)));
		}
		
		Boolean Que4 = driver.findElements(By.id("txtSecurity_answer4")).size() != 0;
		System.out.println("Que4" + Que4);
		if (Que4 == true) {
		SequrityQue_Locators.Que4(driver).sendKeys("01");
		Thread.sleep(2000);
		System.out.println("Que4 01 Entered");
		System.out.println("01");
		} else {
			System.out.println("Que4 not Entered" + test.addScreenCapture(Screenshot.captureImage(driver)));
		}
		
		Thread.sleep(2000);
		
		Boolean Que5 = driver.findElements(By.id("txtSecurity_answer5")).size() != 0;
		System.out.println("Que5" + Que5);
		if (Que5 == true) {
		SequrityQue_Locators.Que5(driver).sendKeys("01");
		Thread.sleep(2000);
		System.out.println("Que5 01 Entered");
		System.out.println("01");
		} else {
			System.out.println("Que5 not Entered" + test.addScreenCapture(Screenshot.captureImage(driver)));
		}
		Thread.sleep(2000);
		
		Boolean BtnSubmit = driver.findElements(By.id("btnSubmit")).size() != 0;
		System.out.println("BtnSubmit" + BtnSubmit);
		if (BtnSubmit == true) {
		SequrityQue_Locators.BtnSubmit(driver).click();
		Thread.sleep(2000);				
		System.out.println("BtnSubmit Clicked");
		driver.switchTo().activeElement();
		} else {
			System.out.println("BtnSubmit not Clicked" + test.addScreenCapture(Screenshot.captureImage(driver)));
		}
		
		Boolean PopupBtn = driver.findElements(By.id("btn1")).size() != 0;
		System.out.println("PopupBtn" + PopupBtn);
		if (PopupBtn == true) {
		SequrityQue_Locators.PopupBtn(driver).click();
		driver.close();
		Thread.sleep(6000);
		System.out.println("PopupBtn Clicked");
		} else {
			System.out.println("PopupBtn not Clicked" + test.addScreenCapture(Screenshot.captureImage(driver)));
		}
		
		System.out.println("SecurityQuestionAns Updated successfuly");
		System.out.println("SecurityQuestionAns Updated successfuly");
		
	Boolean MYESOPUserId1 = driver.findElements(By.id("txtUserId")).size() != 0;
		
		System.out.println("MYESOPUserId" + MYESOPUserId1);
	if(MYESOPUserId1==true)
	{
		Login_Locator.MYESOPUserId(driver).clear();
		Thread.sleep(2000);
		Login_Locator.MYESOPUserId(driver).sendKeys(UserId);
		Thread.sleep(2000);
		System.out.println(UserId);
		System.out.println("UserId "+UserId+" Clicked");
	}
	else
	{
		System.out.println("UserId "+UserId+" Not Clicked"+ test.addScreenCapture(Screenshot.captureImage(driver)));

	}
	Boolean MYESOPPassword1 = driver.findElements(By.xpath(".//*[@id='txtPassword1'] |.//*[@id='txtPassword']")).size() != 0;
	System.out.println("MYESOPPassword" + MYESOPPassword1);
if(MYESOPPassword1==true)
{
			Actions actions = new Actions(driver);
		actions.moveToElement(Login_Locator.MYESOPPassword(driver));
		actions.click();
		actions.sendKeys(Password);
		actions.build().perform();

		System.out.println(Password);
		System.out.println("Password "+Password+" Clicked");
}
else
{
	System.out.println("Password "+Password+" Not Clicked"+ test.addScreenCapture(Screenshot.captureImage(driver)));

}
Boolean MYESOPCompanyID1 = driver.findElements(By.id("txtCompanyId")).size() != 0;
System.out.println("MYESOPCompanyID" + MYESOPCompanyID1);
if(MYESOPCompanyID1==true)
{
		Login_Locator.MYESOPCompanyID(driver).clear();
		Thread.sleep(4000);
		Login_Locator.MYESOPCompanyID(driver).sendKeys(CompanyId1);
		Thread.sleep(2000);
		System.out.println(CompanyId1);
		System.out.println("CompanyId1 "+CompanyId1+" Clicked");
}
else
{
	System.out.println("CompanyId1 "+CompanyId1+" Not Clicked"+ test.addScreenCapture(Screenshot.captureImage(driver)));

}
Boolean MYESOPLogin1 = driver.findElements(By.xpath(".//*[@id='btnOk'] |.//*[@id='login_btn']")).size() != 0;
System.out.println("MYESOPLogin" + MYESOPLogin1);
if(MYESOPLogin1==true)
{

		Login_Locator.MYESOPLogin(driver).click();
		Thread.sleep(2000);
		System.out.println("Login button Clicked");
}
else
{
	System.out.println("Login button Not Clicked"+ test.addScreenCapture(Screenshot.captureImage(driver)));

}
Boolean iselementpresent11 = driver.findElements(By.id("txtSecurityQuestion_answer1")).size() != 0;
System.out.println("iselementpresent1" + iselementpresent11);

if (iselementpresent11 == true) 
{
	Boolean SeqAns1 = driver.findElements(By.id("txtSecurityQuestion_answer1")).size() != 0;
	System.out.println("SeqAns1" + SeqAns1);
	if (SeqAns1 == true) {
	Login_Locator.SeqAns1(driver).sendKeys(Ans1);
	Thread.sleep(2000);
	System.out.println("SeqAns1 "+Ans1+" Entered");
	} else {
		System.out.println("SeqAns1 not Entered" + test.addScreenCapture(Screenshot.captureImage(driver)));
	}
	System.out.println(Ans2);	
	
	Boolean SeqAns2 = driver.findElements(By.id("txtSecurityQuestion_answer2")).size() != 0;
	System.out.println("SeqAns2" + SeqAns2);
	if (SeqAns2 == true) {
	Login_Locator.SeqAns2(driver).sendKeys(Ans2);
	Thread.sleep(2000);
	System.out.println("SeqAns2 "+Ans2+"Entered");
	} else {
		System.out.println("SeqAns2 not Entered" + test.addScreenCapture(Screenshot.captureImage(driver)));
	}
	System.out.println(Ans2);
	
	Boolean SubmitAns = driver.findElements(By.id("btnSubmitAnswer")).size() != 0;
	System.out.println("SubmitAns" + SubmitAns);
	if (SubmitAns == true) {
	Login_Locator.SubmitAns(driver).click();
	Thread.sleep(2000);	
	System.out.println("SubmitAns Clicked");
	} else {
		System.out.println("SubmitAns not Clicked" + test.addScreenCapture(Screenshot.captureImage(driver)));
	}
	
	System.out.println("SecurityQuestionAns Submited successfuly");
	System.out.println("SecurityQuestionAns Submited successfuly");
} 
	
else 
{
	test.log(LogStatus.FAIL,
			"SecurityQuestionAns Submition failed" + test.addScreenCapture(Screenshot.captureImage(driver)));
	System.out.println("SecurityQuestionAns Submition failed Or Security Questions not present");
}
if (isAlertPresents()) 
{
	Alert alert = driver.switchTo().alert();
	alert.accept();
}
else
{
	System.out.println("Alert not present"); 
}

	}	
	else 
	{
		test.log(LogStatus.FAIL,
				"SecurityQuestionAns Submition failed" + test.addScreenCapture(Screenshot.captureImage(driver)));
		System.out.println("SecurityQuestionAns Submition failed Or Security Questions not present");
	}
	if (isAlertPresents()) 
	{
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}
	else
	{
		System.out.println("Alert not present"); 
	}
	Boolean EmployeeConcent = driver.findElements(By.id("ctl00_ContentPlaceHolder1_btnMdlNo1")).size() != 0;
	System.out.println("iselementpresent" + EmployeeConcent);

	Thread.sleep(2000);
	if (EmployeeConcent == true) 

	{
		Boolean UserConsent_Checkbox = driver.findElements(By.id("chkConcent")).size() != 0;
		System.out.println("UserConsent_Checkbox" + UserConsent_Checkbox);

		Thread.sleep(2000);
		if (UserConsent_Checkbox == true) 
		{
		EmployeeConcent_Locators.UserConsent_Checkbox(driver).click();
		Thread.sleep(2000);
		System.out.println("Checkbox  present & Clicked");
		System.out.println("Checkbox present & Clicked" + test.addScreenCapture(Screenshot.captureImage(driver)));

	}
		else
		{
		
			System.out.println("Checkbox not present");
			System.out.println("Checkbox not present" + test.addScreenCapture(Screenshot.captureImage(driver)));
		
		}
		Boolean UserConsent_AgreeBtn = driver.findElements(By.xpath("//button[@id='btn1']")).size() != 0;
		System.out.println("UserConsent_AgreeBtn" + UserConsent_AgreeBtn);

		Thread.sleep(2000);
		if (UserConsent_AgreeBtn == true) 
		{
		EmployeeConcent_Locators.UserConsent_AgreeBtn(driver).click();
		Thread.sleep(2000);
		System.out.println("EmployeeContent Accepted");
		}
		else
		{
			System.out.println("Employee concent Agree button not Clicked");
			System.out.println("Employee concent Agree button not Clicked" + test.addScreenCapture(Screenshot.captureImage(driver)));
		
		}
		
	}
	else
	{
		System.out.println("content place holder not found Or  Employee Concent not unable to this employee");
		System.out.println("content place holder not found Or  Employee Concent not unable to this employee");
	}
			// =======ProfileMenu===================
		//	test = report.startTest("ProfileMenu");
	Boolean UserLogo = driver.findElements(By.id("UserLogo")).size() != 0;
		System.out.println("UserLogo" + UserLogo);
		if (UserLogo == true) {
	Profile_menu.UserLogo(driver).click();
	System.out.println("UserLogo Clicked");
	} else {
		System.out.println("UserLogo not Clicked" + test.addScreenCapture(Screenshot.captureImage(driver)));
	}
		
		Boolean Profile = driver.findElements(By.linkText("Profile")).size() != 0;
		System.out.println("Profile" + Profile);
		if (Profile == true) {
	Profile_menu.Profile(driver).click();
	Thread.sleep(2000);
	System.out.println("Profile Clicked");
	} else {
		System.out.println("Profile not Clicked" + test.addScreenCapture(Screenshot.captureImage(driver)));
	}
		

	//DematDetails
 	Boolean DematDetailsDematDetails_tab = driver.findElements(By.id("DematDetails")).size() != 0;
	System.out.println("DematDetailsDematDetails_tab" + DematDetailsDematDetails_tab);
	if (DematDetailsDematDetails_tab == true) {
	Profile_menu.DematDetailsDematDetails_tab(driver).click();
	Thread.sleep(2000);
	System.out.println("DematDetailsDematDetails_tab Clicked");
	} else {
	System.out.println("DematDetailsDematDetails_tab not Clicked" + test.addScreenCapture(Screenshot.captureImage(driver)));
	}
	
	Boolean DematDetailsEdit_btn = driver.findElements(By.xpath("//div[@class='add-demat-acc']//i[@class='fa fa-plus']")).size() != 0;
	System.out.println("DematDetailsEdit_btn" + DematDetailsEdit_btn);
	if (DematDetailsEdit_btn == true) {
	Profile_menu.DematDetailsEdit_btn(driver).click();
	Thread.sleep(2000);
	System.out.println("DematDetailsEdit_btn Clicked");
	} else {
	System.out.println("DematDetailsEdit_btn not Clicked" + test.addScreenCapture(Screenshot.captureImage(driver)));
	}
	if(Profile_menu.Add_DematDetailsDepositoryName_ddl(driver).isEnabled())
	{
		Profile_menu.Add_DematDetailsDepositoryName_ddl(driver).sendKeys(DepositoryName);
	}
	
	if(Profile_menu.Add_DematDetailsDematAccountType_ddl(driver).isEnabled())
	{
		Profile_menu.Add_DematDetailsDematAccountType_ddl(driver).sendKeys(DematAcctype);
	}
	
	if(Profile_menu.Add_DematDetailsDepository_ParticipantName(driver).isEnabled())
	{
		Profile_menu.Add_DematDetailsDepository_ParticipantName(driver).clear();
		Profile_menu.Add_DematDetailsDepository_ParticipantName(driver).sendKeys(DepositoryParticipantName);
	}
	
	if(Profile_menu.Add_DematDetailsDepository_ParticipantId(driver).isEnabled())
	{
		Profile_menu.Add_DematDetailsDepository_ParticipantId(driver).clear();
		Profile_menu.Add_DematDetailsDepository_ParticipantId(driver).sendKeys(DepositoryParticipantID);
	}
	
	if(Profile_menu.Add_DematDetailsClient_DematAccNo(driver).isEnabled())
	{
		Profile_menu.Add_DematDetailsClient_DematAccNo(driver).clear();
		Profile_menu.Add_DematDetailsClient_DematAccNo(driver).sendKeys(ClientDematACNo);
	}
	
	if(Profile_menu.Add_DematDetailsName_DP_Record(driver).isEnabled())
	{
		Profile_menu.Add_DematDetailsName_DP_Record(driver).clear();
		Profile_menu.Add_DematDetailsName_DP_Record(driver).sendKeys(NameRecord);
	}
	Boolean UploadCML = driver.findElements(By.id("UploadfilesCML")).size() != 0;
	System.out.println("UploadCML" + UploadCML);
	if (UploadCML == true) {
	Profile_menu.UploadCMLFile(driver).click();
	 System.out.println("FormFile_Path Clicked");
		
		Thread.sleep(2000);
	StringSelection filePath = new StringSelection(Path);
	Thread.sleep(3000);
	Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filePath, null);

	Robot robot = new Robot();
	// Press Enter

	robot.keyPress(KeyEvent.VK_ENTER);
	Thread.sleep(3000);
	// Release Enter
	robot.keyRelease(KeyEvent.VK_ENTER);
	Thread.sleep(3000);
	// Press CTRL+V
	robot.keyPress(KeyEvent.VK_CONTROL);
	robot.keyPress(KeyEvent.VK_V);
	Thread.sleep(3000);
	// Release CTRL+V
	robot.keyRelease(KeyEvent.VK_CONTROL);
	robot.keyRelease(KeyEvent.VK_V);
	Thread.sleep(3000);
	// Press Enter
	robot.keyPress(KeyEvent.VK_ENTER);
	robot.keyRelease(KeyEvent.VK_ENTER);

	Thread.sleep(3000);
	Profile_menu.btn_Upload(driver).click();
	Thread.sleep(3000);
	 System.out.println("Upload Button Clicked");
	 Thread.sleep(3000);
	System.out.println("UploadCML Uploaded");
	} else {
	System.out.println("UploadCML not Clicked" + test.addScreenCapture(Screenshot.captureImage(driver)));
	}
	

	Boolean Accept_btn = driver.findElements(By.id("btn1")).size() != 0;
	System.out.println("Accept_btn" + Accept_btn);
	if (Accept_btn == true) {
	Profile_menu.UploadAccept_btn(driver).click();
	Thread.sleep(3000);
	System.out.println("Accept_btn Clicked");
	} else {
	System.out.println("Accept_btn not Clicked" + test.addScreenCapture(Screenshot.captureImage(driver)));
	}
	// Switching to Alert    
	Thread.sleep(3000);
   
	
    Boolean Save_btn = driver.findElements(By.xpath("//button[@id='btnAddNow']")).size() != 0;
	System.out.println("Save_btn" + Save_btn);
	if (Save_btn == true) {
		Profile_menu.BtnSaveDematDetails(driver).click();
	
		Thread.sleep(3000);
	System.out.println("Save_btn Clicked");
	} else {
	System.out.println("Save_btn not Clicked" + test.addScreenCapture(Screenshot.captureImage(driver)));
	}
   
	Boolean Accept_btn2 = driver.findElements(By.id("btn1")).size() != 0;
	System.out.println("Accept_btn" + Accept_btn2);
	if (Accept_btn2 == true) {
	Profile_menu.UploadAccept_btn(driver).click();
	Thread.sleep(3000);
	System.out.println("Accept_btn Clicked");
	} else {
	System.out.println("Accept_btn not Clicked" + test.addScreenCapture(Screenshot.captureImage(driver)));
	}
	// Switching to Alert    
	Thread.sleep(3000);
			// ========close browser=================
		//	test = report.startTest("close browser");
	try {
		
		Boolean Logo = driver.findElements(By.xpath(".//*[@id='UserLogo']")).size() != 0;
		System.out.println("Logo" + Logo);
		if (Logo == true) {
		Login_Locator.Logo(driver).click();
		Thread.sleep(3000);
		System.out.println("Logo Clicked");
		} else {
		System.out.println("Logo not Clicked" + test.addScreenCapture(Screenshot.captureImage(driver)));
		}
		
		Boolean Logout = driver.findElements(By.linkText("Logout")).size() != 0;
		System.out.println("Logout" + Logout);
		if (Logout == true) {
		Login_Locator.Logout(driver).click();
		Thread.sleep(3000);
		driver.close();
		Thread.sleep(6000);	
		System.out.println("Logout Clicked");
		} else {
		System.out.println("Logout not Clicked" + test.addScreenCapture(Screenshot.captureImage(driver)));
		}
	//	driver.quit();
	}

	catch (Exception e) {

		e.printStackTrace();
	}	
	
			
				
	}
			//Check if parameter passed as 'chrome'
			else if(browser.equalsIgnoreCase("chrome")){
			//set path to chromedriver.exe
			System.setProperty("webdriver.chrome.driver","D:\\Testing Team Automation\\SeleniumDriver\\chromedriver.exe");
			//create chrome instance
			driver = new ChromeDriver();

		//	test = report.startTest("URLs");
			driver.get(URLwithoutspace);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			String URL1=driver.getCurrentUrl();
			
			if(URL1.equals(URLwithoutspace))
			{
			System.out.println("Navigated to the specified URL");
			}
			else
			{
			System.out.println("Not Navigated to the UATGlobalUI URL"+ test.addScreenCapture(Screenshot.captureImage(driver)));

			}
			//======Covid 19===============
            if(Login_Locator.COVID(driver).isDisplayed())
            {
                System.out.println("COVID dialogue is displayed");
                Login_Locator.COVID(driver).click();
            }
            else
            {
                System.out.println("COVID dialogue is not displayed");
                System.out.println("alert not present");
            }
			
			// =================Login=================
	//		test = report.startTest("Login");
            Boolean MYESOPUserId = driver.findElements(By.id("txtUserId")).size() != 0;
    		
    		System.out.println("MYESOPUserId" + MYESOPUserId);
    	if(MYESOPUserId==true)
    	{
    		Login_Locator.MYESOPUserId(driver).clear();
    		Thread.sleep(2000);
    		Login_Locator.MYESOPUserId(driver).sendKeys(UserId);
    		Thread.sleep(2000);
    		System.out.println(UserId);
    		System.out.println("UserId "+UserId+" Clicked");
    	}
    	else
    	{
    		System.out.println("UserId "+UserId+" Not Clicked"+ test.addScreenCapture(Screenshot.captureImage(driver)));

    	}
    	Boolean MYESOPPassword = driver.findElements(By.xpath(".//*[@id='txtPassword1'] |.//*[@id='txtPassword']")).size() != 0;
    	System.out.println("MYESOPPassword" + MYESOPPassword);
    if(MYESOPPassword==true)
    {
    			Actions actions = new Actions(driver);
    		actions.moveToElement(Login_Locator.MYESOPPassword(driver));
    		actions.click();
    		actions.sendKeys(Password);
    		actions.build().perform();

    		System.out.println(Password);
    		System.out.println("Password "+Password+" Clicked");
    }
    else
    {
    	System.out.println("Password "+Password+" Not Clicked"+ test.addScreenCapture(Screenshot.captureImage(driver)));

    }
    Boolean MYESOPCompanyID = driver.findElements(By.id("txtCompanyId")).size() != 0;
    System.out.println("MYESOPCompanyID" + MYESOPCompanyID);
    if(MYESOPCompanyID==true)
    {
    		Login_Locator.MYESOPCompanyID(driver).clear();
    		Thread.sleep(4000);
    		Login_Locator.MYESOPCompanyID(driver).sendKeys(CompanyId1);
    		Thread.sleep(2000);
    		System.out.println(CompanyId1);
    		System.out.println("CompanyId1 "+CompanyId1+" Clicked");
    }
    else
    {
    	System.out.println("CompanyId1 "+CompanyId1+" Not Clicked"+ test.addScreenCapture(Screenshot.captureImage(driver)));

    }
    Boolean MYESOPLogin = driver.findElements(By.xpath(".//*[@id='btnOk'] |.//*[@id='login_btn']")).size() != 0;
    System.out.println("MYESOPLogin" + MYESOPLogin);
    if(MYESOPLogin==true)
    {

    		Login_Locator.MYESOPLogin(driver).click();
    		Thread.sleep(2000);
    		System.out.println("Login button Clicked");
    }
    else
    {
    	System.out.println("Login button Not Clicked"+ test.addScreenCapture(Screenshot.captureImage(driver)));

    }
      Boolean iselementpresent1 = driver.findElements(By.id("txtSecurityQuestion_answer1")).size() != 0;
	System.out.println("iselementpresent1" + iselementpresent1);
	Boolean iselementpresent2= driver.findElements(By.id("txtSecurity_answer3")).size() != 0;
	System.out.println("iselementpresent2" +iselementpresent2);
	Thread.sleep(2000);
	if (iselementpresent1 == true) 
	{
		Boolean SeqAns1 = driver.findElements(By.id("txtSecurityQuestion_answer1")).size() != 0;
		System.out.println("SeqAns1" + SeqAns1);
		if (SeqAns1 == true) {
		Login_Locator.SeqAns1(driver).sendKeys(Ans1);
		Thread.sleep(2000);
		System.out.println("SeqAns1 "+Ans1+" Entered");
		} else {
			System.out.println("SeqAns1 not Entered" + test.addScreenCapture(Screenshot.captureImage(driver)));
		}
		System.out.println(Ans2);	
		
		Boolean SeqAns2 = driver.findElements(By.id("txtSecurityQuestion_answer2")).size() != 0;
		System.out.println("SeqAns2" + SeqAns2);
		if (SeqAns2 == true) {
		Login_Locator.SeqAns2(driver).sendKeys(Ans2);
		Thread.sleep(2000);
		System.out.println("SeqAns2 "+Ans2+"Entered");
		} else {
			System.out.println("SeqAns2 not Entered" + test.addScreenCapture(Screenshot.captureImage(driver)));
		}
		System.out.println(Ans2);
		
		Boolean SubmitAns = driver.findElements(By.id("btnSubmitAnswer")).size() != 0;
		System.out.println("SubmitAns" + SubmitAns);
		if (SubmitAns == true) {
		Login_Locator.SubmitAns(driver).click();
		Thread.sleep(2000);	
		System.out.println("SubmitAns Clicked");
		} else {
			System.out.println("SubmitAns not Clicked" + test.addScreenCapture(Screenshot.captureImage(driver)));
		}
		
		System.out.println("SecurityQuestionAns Submited successfuly");
		System.out.println("SecurityQuestionAns Submited successfuly");
	} 
	else if(iselementpresent2==true)
	{
		Boolean Que1 = driver.findElements(By.id("txtSecurity_answer1")).size() != 0;
		System.out.println("Que1" + Que1);
		if (Que1 == true) {
		SequrityQue_Locators.Que1(driver).sendKeys("01");
		Thread.sleep(2000);
		System.out.println("Que1 01 Entered");
		System.out.println("01");
		} else {
			System.out.println("Que1 not Entered" + test.addScreenCapture(Screenshot.captureImage(driver)));
		}
			
		
		Boolean Que2 = driver.findElements(By.id("txtSecurity_answer2")).size() != 0;
		System.out.println("Que2" + Que2);
		if (Que2 == true) {
		SequrityQue_Locators.Que2(driver).sendKeys("01");
		Thread.sleep(2000);
		System.out.println("Que2 01 Entered");
		System.out.println("01");
		} else {
			System.out.println("Que2 not Entered" + test.addScreenCapture(Screenshot.captureImage(driver)));
		}
		Thread.sleep(2000);
		
		Boolean Que3 = driver.findElements(By.id("txtSecurity_answer3")).size() != 0;
		System.out.println("Que3" + Que3);
		if (Que3 == true) {
		SequrityQue_Locators.Que3(driver).sendKeys("01");
		Thread.sleep(2000);
		System.out.println("Que3 01 Entered");
		System.out.println("01");
		} else {
			System.out.println("Que3 not Entered" + test.addScreenCapture(Screenshot.captureImage(driver)));
		}
		
		Boolean Que4 = driver.findElements(By.id("txtSecurity_answer4")).size() != 0;
		System.out.println("Que4" + Que4);
		if (Que4 == true) {
		SequrityQue_Locators.Que4(driver).sendKeys("01");
		Thread.sleep(2000);
		System.out.println("Que4 01 Entered");
		System.out.println("01");
		} else {
			System.out.println("Que4 not Entered" + test.addScreenCapture(Screenshot.captureImage(driver)));
		}
		
		Thread.sleep(2000);
		
		Boolean Que5 = driver.findElements(By.id("txtSecurity_answer5")).size() != 0;
		System.out.println("Que5" + Que5);
		if (Que5 == true) {
		SequrityQue_Locators.Que5(driver).sendKeys("01");
		Thread.sleep(2000);
		System.out.println("Que5 01 Entered");
		System.out.println("01");
		} else {
			System.out.println("Que5 not Entered" + test.addScreenCapture(Screenshot.captureImage(driver)));
		}
		Thread.sleep(2000);
		
		Boolean BtnSubmit = driver.findElements(By.id("btnSubmit")).size() != 0;
		System.out.println("BtnSubmit" + BtnSubmit);
		if (BtnSubmit == true) {
		SequrityQue_Locators.BtnSubmit(driver).click();
		Thread.sleep(2000);				
		System.out.println("BtnSubmit Clicked");
		driver.switchTo().activeElement();
		} else {
			System.out.println("BtnSubmit not Clicked" + test.addScreenCapture(Screenshot.captureImage(driver)));
		}
		
		Boolean PopupBtn = driver.findElements(By.id("btn1")).size() != 0;
		System.out.println("PopupBtn" + PopupBtn);
		if (PopupBtn == true) {
		SequrityQue_Locators.PopupBtn(driver).click();
		driver.close();
		Thread.sleep(6000);
		System.out.println("PopupBtn Clicked");
		} else {
			System.out.println("PopupBtn not Clicked" + test.addScreenCapture(Screenshot.captureImage(driver)));
		}
		
		System.out.println("SecurityQuestionAns Updated successfuly");
		System.out.println("SecurityQuestionAns Updated successfuly");
		
	Boolean MYESOPUserId1 = driver.findElements(By.id("txtUserId")).size() != 0;
		
		System.out.println("MYESOPUserId" + MYESOPUserId1);
	if(MYESOPUserId1==true)
	{
		Login_Locator.MYESOPUserId(driver).clear();
		Thread.sleep(2000);
		Login_Locator.MYESOPUserId(driver).sendKeys(UserId);
		Thread.sleep(2000);
		System.out.println(UserId);
		System.out.println("UserId "+UserId+" Clicked");
	}
	else
	{
		System.out.println("UserId "+UserId+" Not Clicked"+ test.addScreenCapture(Screenshot.captureImage(driver)));

	}
	Boolean MYESOPPassword1 = driver.findElements(By.xpath(".//*[@id='txtPassword1'] |.//*[@id='txtPassword']")).size() != 0;
	System.out.println("MYESOPPassword" + MYESOPPassword1);
if(MYESOPPassword1==true)
{
			Actions actions = new Actions(driver);
		actions.moveToElement(Login_Locator.MYESOPPassword(driver));
		actions.click();
		actions.sendKeys(Password);
		actions.build().perform();

		System.out.println(Password);
		System.out.println("Password "+Password+" Clicked");
}
else
{
	System.out.println("Password "+Password+" Not Clicked"+ test.addScreenCapture(Screenshot.captureImage(driver)));

}
Boolean MYESOPCompanyID1 = driver.findElements(By.id("txtCompanyId")).size() != 0;
System.out.println("MYESOPCompanyID" + MYESOPCompanyID1);
if(MYESOPCompanyID1==true)
{
		Login_Locator.MYESOPCompanyID(driver).clear();
		Thread.sleep(4000);
		Login_Locator.MYESOPCompanyID(driver).sendKeys(CompanyId1);
		Thread.sleep(2000);
		System.out.println(CompanyId1);
		System.out.println("CompanyId1 "+CompanyId1+" Clicked");
}
else
{
	System.out.println("CompanyId1 "+CompanyId1+" Not Clicked"+ test.addScreenCapture(Screenshot.captureImage(driver)));

}
Boolean MYESOPLogin1 = driver.findElements(By.xpath(".//*[@id='btnOk'] |.//*[@id='login_btn']")).size() != 0;
System.out.println("MYESOPLogin" + MYESOPLogin1);
if(MYESOPLogin1==true)
{

		Login_Locator.MYESOPLogin(driver).click();
		Thread.sleep(2000);
		System.out.println("Login button Clicked");
}
else
{
	System.out.println("Login button Not Clicked"+ test.addScreenCapture(Screenshot.captureImage(driver)));

}
Boolean iselementpresent11 = driver.findElements(By.id("txtSecurityQuestion_answer1")).size() != 0;
System.out.println("iselementpresent1" + iselementpresent11);

if (iselementpresent11 == true) 
{
	Boolean SeqAns1 = driver.findElements(By.id("txtSecurityQuestion_answer1")).size() != 0;
	System.out.println("SeqAns1" + SeqAns1);
	if (SeqAns1 == true) {
	Login_Locator.SeqAns1(driver).sendKeys(Ans1);
	Thread.sleep(2000);
	System.out.println("SeqAns1 "+Ans1+" Entered");
	} else {
		System.out.println("SeqAns1 not Entered" + test.addScreenCapture(Screenshot.captureImage(driver)));
	}
	System.out.println(Ans2);	
	
	Boolean SeqAns2 = driver.findElements(By.id("txtSecurityQuestion_answer2")).size() != 0;
	System.out.println("SeqAns2" + SeqAns2);
	if (SeqAns2 == true) {
	Login_Locator.SeqAns2(driver).sendKeys(Ans2);
	Thread.sleep(2000);
	System.out.println("SeqAns2 "+Ans2+"Entered");
	} else {
		System.out.println("SeqAns2 not Entered" + test.addScreenCapture(Screenshot.captureImage(driver)));
	}
	System.out.println(Ans2);
	
	Boolean SubmitAns = driver.findElements(By.id("btnSubmitAnswer")).size() != 0;
	System.out.println("SubmitAns" + SubmitAns);
	if (SubmitAns == true) {
	Login_Locator.SubmitAns(driver).click();
	Thread.sleep(2000);	
	System.out.println("SubmitAns Clicked");
	} else {
		System.out.println("SubmitAns not Clicked" + test.addScreenCapture(Screenshot.captureImage(driver)));
	}
	
	System.out.println("SecurityQuestionAns Submited successfuly");
	System.out.println("SecurityQuestionAns Submited successfuly");
} 
	
else 
{
	test.log(LogStatus.FAIL,
			"SecurityQuestionAns Submition failed" + test.addScreenCapture(Screenshot.captureImage(driver)));
	System.out.println("SecurityQuestionAns Submition failed Or Security Questions not present");
}
if (isAlertPresents()) 
{
	Alert alert = driver.switchTo().alert();
	alert.accept();
}
else
{
	System.out.println("Alert not present"); 
}

	}	
	else 
	{
		test.log(LogStatus.FAIL,
				"SecurityQuestionAns Submition failed" + test.addScreenCapture(Screenshot.captureImage(driver)));
		System.out.println("SecurityQuestionAns Submition failed Or Security Questions not present");
	}
	if (isAlertPresents()) 
	{
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}
	else
	{
		System.out.println("Alert not present"); 
	}
	Boolean EmployeeConcent = driver.findElements(By.id("ctl00_ContentPlaceHolder1_btnMdlNo1")).size() != 0;
	System.out.println("iselementpresent" + EmployeeConcent);

	Thread.sleep(2000);
	if (EmployeeConcent == true) 

	{
		Boolean UserConsent_Checkbox = driver.findElements(By.id("chkConcent")).size() != 0;
		System.out.println("UserConsent_Checkbox" + UserConsent_Checkbox);

		Thread.sleep(2000);
		if (UserConsent_Checkbox == true) 
		{
		EmployeeConcent_Locators.UserConsent_Checkbox(driver).click();
		Thread.sleep(2000);
		System.out.println("Checkbox  present & Clicked");
		System.out.println("Checkbox present & Clicked" + test.addScreenCapture(Screenshot.captureImage(driver)));

	}
		else
		{
		
			System.out.println("Checkbox not present");
			System.out.println("Checkbox not present" + test.addScreenCapture(Screenshot.captureImage(driver)));
		
		}
		Boolean UserConsent_AgreeBtn = driver.findElements(By.xpath("//button[@id='btn1']")).size() != 0;
		System.out.println("UserConsent_AgreeBtn" + UserConsent_AgreeBtn);

		Thread.sleep(2000);
		if (UserConsent_AgreeBtn == true) 
		{
		EmployeeConcent_Locators.UserConsent_AgreeBtn(driver).click();
		Thread.sleep(2000);
		System.out.println("EmployeeContent Accepted");
		}
		else
		{
			System.out.println("Employee concent Agree button not Clicked");
			System.out.println("Employee concent Agree button not Clicked" + test.addScreenCapture(Screenshot.captureImage(driver)));
		
		}
		
	}
	else
	{
		System.out.println("content place holder not found Or  Employee Concent not unable to this employee");
		System.out.println("content place holder not found Or  Employee Concent not unable to this employee");
	}
			// =======ProfileMenu===================
		//	test = report.startTest("ProfileMenu");
	Boolean UserLogo = driver.findElements(By.id("UserLogo")).size() != 0;
		System.out.println("UserLogo" + UserLogo);
		if (UserLogo == true) {
	Profile_menu.UserLogo(driver).click();
	System.out.println("UserLogo Clicked");
	} else {
		System.out.println("UserLogo not Clicked" + test.addScreenCapture(Screenshot.captureImage(driver)));
	}
		
		Boolean Profile = driver.findElements(By.linkText("Profile")).size() != 0;
		System.out.println("Profile" + Profile);
		if (Profile == true) {
	Profile_menu.Profile(driver).click();
	Thread.sleep(2000);
	System.out.println("Profile Clicked");
	} else {
		System.out.println("Profile not Clicked" + test.addScreenCapture(Screenshot.captureImage(driver)));
	}
		

	//DematDetails
 	Boolean DematDetailsDematDetails_tab = driver.findElements(By.id("DematDetails")).size() != 0;
	System.out.println("DematDetailsDematDetails_tab" + DematDetailsDematDetails_tab);
	if (DematDetailsDematDetails_tab == true) {
	Profile_menu.DematDetailsDematDetails_tab(driver).click();
	Thread.sleep(2000);
	System.out.println("DematDetailsDematDetails_tab Clicked");
	} else {
	System.out.println("DematDetailsDematDetails_tab not Clicked" + test.addScreenCapture(Screenshot.captureImage(driver)));
	}
	
	Boolean DematDetailsEdit_btn = driver.findElements(By.xpath("//div[@class='add-demat-acc']//i[@class='fa fa-plus']")).size() != 0;
	System.out.println("DematDetailsEdit_btn" + DematDetailsEdit_btn);
	if (DematDetailsEdit_btn == true) {
	Profile_menu.DematDetailsEdit_btn(driver).click();
	Thread.sleep(2000);
	System.out.println("DematDetailsEdit_btn Clicked");
	} else {
	System.out.println("DematDetailsEdit_btn not Clicked" + test.addScreenCapture(Screenshot.captureImage(driver)));
	}
	if(Profile_menu.Add_DematDetailsDepositoryName_ddl(driver).isEnabled())
	{
		Profile_menu.Add_DematDetailsDepositoryName_ddl(driver).sendKeys(DepositoryName);
	}
	
	if(Profile_menu.Add_DematDetailsDematAccountType_ddl(driver).isEnabled())
	{
		Profile_menu.Add_DematDetailsDematAccountType_ddl(driver).sendKeys(DematAcctype);
	}
	
	if(Profile_menu.Add_DematDetailsDepository_ParticipantName(driver).isEnabled())
	{
		Profile_menu.Add_DematDetailsDepository_ParticipantName(driver).clear();
		Profile_menu.Add_DematDetailsDepository_ParticipantName(driver).sendKeys(DepositoryParticipantName);
	}
	
	if(Profile_menu.Add_DematDetailsDepository_ParticipantId(driver).isEnabled())
	{
		Profile_menu.Add_DematDetailsDepository_ParticipantId(driver).clear();
		Profile_menu.Add_DematDetailsDepository_ParticipantId(driver).sendKeys(DepositoryParticipantID);
	}
	
	if(Profile_menu.Add_DematDetailsClient_DematAccNo(driver).isEnabled())
	{
		Profile_menu.Add_DematDetailsClient_DematAccNo(driver).clear();
		Profile_menu.Add_DematDetailsClient_DematAccNo(driver).sendKeys(ClientDematACNo);
	}
	
	if(Profile_menu.Add_DematDetailsName_DP_Record(driver).isEnabled())
	{
		Profile_menu.Add_DematDetailsName_DP_Record(driver).clear();
		Profile_menu.Add_DematDetailsName_DP_Record(driver).sendKeys(NameRecord);
	}
	Boolean UploadCML = driver.findElements(By.id("UploadfilesCML")).size() != 0;
	System.out.println("UploadCML" + UploadCML);
	if (UploadCML == true) {
	Profile_menu.UploadCMLFile(driver).click();
	 System.out.println("FormFile_Path Clicked");
		
		Thread.sleep(2000);
	StringSelection filePath = new StringSelection(Path);
	Thread.sleep(2000);
	Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filePath, null);

	Robot robot = new Robot();
	// Press Enter

	robot.keyPress(KeyEvent.VK_ENTER);

	// Release Enter
	robot.keyRelease(KeyEvent.VK_ENTER);

	// Press CTRL+V
	robot.keyPress(KeyEvent.VK_CONTROL);
	robot.keyPress(KeyEvent.VK_V);
	Thread.sleep(2000);
	// Release CTRL+V
	robot.keyRelease(KeyEvent.VK_CONTROL);
	robot.keyRelease(KeyEvent.VK_V);
	Thread.sleep(2000);
	// Press Enter
	robot.keyPress(KeyEvent.VK_ENTER);
	robot.keyRelease(KeyEvent.VK_ENTER);

	Thread.sleep(2000);
	Profile_menu.btn_Upload(driver).click();
	Thread.sleep(2000);
	 System.out.println("Upload Button Clicked");
	Thread.sleep(2000);
	System.out.println("UploadCML Uploaded");
	} else {
	System.out.println("UploadCML not Clicked" + test.addScreenCapture(Screenshot.captureImage(driver)));
	}
	

	Boolean Accept_btn = driver.findElements(By.id("btn1")).size() != 0;
	System.out.println("Accept_btn" + Accept_btn);
	if (Accept_btn == true) {
	Profile_menu.UploadAccept_btn(driver).click();
	Thread.sleep(2000);
	System.out.println("Accept_btn Clicked");
	} else {
	System.out.println("Accept_btn not Clicked" + test.addScreenCapture(Screenshot.captureImage(driver)));
	}
	// Switching to Alert    
	Thread.sleep(2000);
   
	
    Boolean Save_btn = driver.findElements(By.xpath("//button[@id='btnAddNow']")).size() != 0;
	System.out.println("Save_btn" + Save_btn);
	if (Save_btn == true) {
		Profile_menu.BtnSaveDematDetails(driver).click();
	
	Thread.sleep(2000);
	System.out.println("Save_btn Clicked");
	} else {
	System.out.println("Save_btn not Clicked" + test.addScreenCapture(Screenshot.captureImage(driver)));
	}
   
	Boolean Accept_btn2 = driver.findElements(By.id("btn1")).size() != 0;
	System.out.println("Accept_btn" + Accept_btn2);
	if (Accept_btn2 == true) {
	Profile_menu.UploadAccept_btn(driver).click();
	Thread.sleep(2000);
	System.out.println("Accept_btn Clicked");
	} else {
	System.out.println("Accept_btn not Clicked" + test.addScreenCapture(Screenshot.captureImage(driver)));
	}
	// Switching to Alert    
	Thread.sleep(2000);
			// ========close browser=================
		//	test = report.startTest("close browser");
	try {
		
		Boolean Logo = driver.findElements(By.xpath(".//*[@id='UserLogo']")).size() != 0;
		System.out.println("Logo" + Logo);
		if (Logo == true) {
		Login_Locator.Logo(driver).click();
		Thread.sleep(2000);
		System.out.println("Logo Clicked");
		} else {
		System.out.println("Logo not Clicked" + test.addScreenCapture(Screenshot.captureImage(driver)));
		}
		
		Boolean Logout = driver.findElements(By.linkText("Logout")).size() != 0;
		System.out.println("Logout" + Logout);
		if (Logout == true) {
		Login_Locator.Logout(driver).click();
		Thread.sleep(2000);
		driver.close();
		Thread.sleep(6000);	
		System.out.println("Logout Clicked");
		} else {
		System.out.println("Logout not Clicked" + test.addScreenCapture(Screenshot.captureImage(driver)));
		}
	//	driver.quit();
	}

	catch (Exception e) {

		e.printStackTrace();
	}	
	
			}
			else if(browser.equalsIgnoreCase("Chrome1"))
			{


				//set path to chromedriver.exe
				System.setProperty("webdriver.chrome.driver","D:\\Testing Team Automation\\SeleniumDriver\\chromedriver.exe");
				//create chrome instance
				driver = new ChromeDriver();

			//	test = report.startTest("URLs");
				driver.get(URLwithoutspace);
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				String URL1=driver.getCurrentUrl();
				
				if(URL1.equals(URLwithoutspace))
				{
				System.out.println("Navigated to the specified URL");
				}
				else
				{
				System.out.println("Not Navigated to the UATGlobalUI URL"+ test.addScreenCapture(Screenshot.captureImage(driver)));

				}
				//======Covid 19===============
	            if(Login_Locator.COVID(driver).isDisplayed())
	            {
	                System.out.println("COVID dialogue is displayed");
	                Login_Locator.COVID(driver).click();
	            }
	            else
	            {
	                System.out.println("COVID dialogue is not displayed");
	                System.out.println("alert not present");
	            }
				
				// =================Login=================
		//		test = report.startTest("Login");
	            Boolean MYESOPUserId = driver.findElements(By.id("txtUserId")).size() != 0;
	    		
	    		System.out.println("MYESOPUserId" + MYESOPUserId);
	    	if(MYESOPUserId==true)
	    	{
	    		Login_Locator.MYESOPUserId(driver).clear();
	    		Thread.sleep(4000);
	    		Login_Locator.MYESOPUserId(driver).sendKeys(UserId);
	    		Thread.sleep(1000);
	    		System.out.println(UserId);
	    		System.out.println("UserId "+UserId+" Clicked");
	    	}
	    	else
	    	{
	    		System.out.println("UserId "+UserId+" Not Clicked"+ test.addScreenCapture(Screenshot.captureImage(driver)));

	    	}
	    	Boolean MYESOPPassword = driver.findElements(By.xpath(".//*[@id='txtPassword1'] |.//*[@id='txtPassword']")).size() != 0;
	    	System.out.println("MYESOPPassword" + MYESOPPassword);
	    if(MYESOPPassword==true)
	    {
	    			Actions actions = new Actions(driver);
	    		actions.moveToElement(Login_Locator.MYESOPPassword(driver));
	    		actions.click();
	    		actions.sendKeys(Password);
	    		actions.build().perform();

	    		System.out.println(Password);
	    		System.out.println("Password "+Password+" Clicked");
	    }
	    else
	    {
	    	System.out.println("Password "+Password+" Not Clicked"+ test.addScreenCapture(Screenshot.captureImage(driver)));

	    }
	    Boolean MYESOPCompanyID = driver.findElements(By.id("txtCompanyId")).size() != 0;
	    System.out.println("MYESOPCompanyID" + MYESOPCompanyID);
	    if(MYESOPCompanyID==true)
	    {
	    		Login_Locator.MYESOPCompanyID(driver).clear();
	    		Thread.sleep(4000);
	    		Login_Locator.MYESOPCompanyID(driver).sendKeys(CompanyId1);
	    		Thread.sleep(2000);
	    		System.out.println(CompanyId1);
	    		System.out.println("CompanyId1 "+CompanyId1+" Clicked");
	    }
	    else
	    {
	    	System.out.println("CompanyId1 "+CompanyId1+" Not Clicked"+ test.addScreenCapture(Screenshot.captureImage(driver)));

	    }
	    Boolean MYESOPLogin = driver.findElements(By.xpath(".//*[@id='btnOk'] |.//*[@id='login_btn']")).size() != 0;
	    System.out.println("MYESOPLogin" + MYESOPLogin);
	    if(MYESOPLogin==true)
	    {

	    		Login_Locator.MYESOPLogin(driver).click();
	    		Thread.sleep(2000);
	    		System.out.println("Login button Clicked");
	    }
	    else
	    {
	    	System.out.println("Login button Not Clicked"+ test.addScreenCapture(Screenshot.captureImage(driver)));

	    }
	      Boolean iselementpresent1 = driver.findElements(By.id("txtSecurityQuestion_answer1")).size() != 0;
		System.out.println("iselementpresent1" + iselementpresent1);
		Boolean iselementpresent2= driver.findElements(By.id("txtSecurity_answer3")).size() != 0;
		System.out.println("iselementpresent2" +iselementpresent2);
		Thread.sleep(2000);
		if (iselementpresent1 == true) 
		{
			Boolean SeqAns1 = driver.findElements(By.id("txtSecurityQuestion_answer1")).size() != 0;
			System.out.println("SeqAns1" + SeqAns1);
			if (SeqAns1 == true) {
			Login_Locator.SeqAns1(driver).sendKeys(Ans1);
			Thread.sleep(2000);
			System.out.println("SeqAns1 "+Ans1+" Entered");
			} else {
				System.out.println("SeqAns1 not Entered" + test.addScreenCapture(Screenshot.captureImage(driver)));
			}
			System.out.println(Ans2);	
			
			Boolean SeqAns2 = driver.findElements(By.id("txtSecurityQuestion_answer2")).size() != 0;
			System.out.println("SeqAns2" + SeqAns2);
			if (SeqAns2 == true) {
			Login_Locator.SeqAns2(driver).sendKeys(Ans2);
			Thread.sleep(2000);
			System.out.println("SeqAns2 "+Ans2+"Entered");
			} else {
				System.out.println("SeqAns2 not Entered" + test.addScreenCapture(Screenshot.captureImage(driver)));
			}
			System.out.println(Ans2);
			
			Boolean SubmitAns = driver.findElements(By.id("btnSubmitAnswer")).size() != 0;
			System.out.println("SubmitAns" + SubmitAns);
			if (SubmitAns == true) {
			Login_Locator.SubmitAns(driver).click();
			Thread.sleep(2000);	
			System.out.println("SubmitAns Clicked");
			} else {
				System.out.println("SubmitAns not Clicked" + test.addScreenCapture(Screenshot.captureImage(driver)));
			}
			
			System.out.println("SecurityQuestionAns Submited successfuly");
			System.out.println("SecurityQuestionAns Submited successfuly");
		} 
		else if(iselementpresent2==true)
		{
			Boolean Que1 = driver.findElements(By.id("txtSecurity_answer1")).size() != 0;
			System.out.println("Que1" + Que1);
			if (Que1 == true) {
			SequrityQue_Locators.Que1(driver).sendKeys("01");
			Thread.sleep(2000);
			System.out.println("Que1 01 Entered");
			System.out.println("01");
			} else {
				System.out.println("Que1 not Entered" + test.addScreenCapture(Screenshot.captureImage(driver)));
			}
				
			
			Boolean Que2 = driver.findElements(By.id("txtSecurity_answer2")).size() != 0;
			System.out.println("Que2" + Que2);
			if (Que2 == true) {
			SequrityQue_Locators.Que2(driver).sendKeys("01");
			Thread.sleep(2000);
			System.out.println("Que2 01 Entered");
			System.out.println("01");
			} else {
				System.out.println("Que2 not Entered" + test.addScreenCapture(Screenshot.captureImage(driver)));
			}
			Thread.sleep(2000);
			
			Boolean Que3 = driver.findElements(By.id("txtSecurity_answer3")).size() != 0;
			System.out.println("Que3" + Que3);
			if (Que3 == true) {
			SequrityQue_Locators.Que3(driver).sendKeys("01");
			Thread.sleep(2000);
			System.out.println("Que3 01 Entered");
			System.out.println("01");
			} else {
				System.out.println("Que3 not Entered" + test.addScreenCapture(Screenshot.captureImage(driver)));
			}
			
			Boolean Que4 = driver.findElements(By.id("txtSecurity_answer4")).size() != 0;
			System.out.println("Que4" + Que4);
			if (Que4 == true) {
			SequrityQue_Locators.Que4(driver).sendKeys("01");
			Thread.sleep(2000);
			System.out.println("Que4 01 Entered");
			System.out.println("01");
			} else {
				System.out.println("Que4 not Entered" + test.addScreenCapture(Screenshot.captureImage(driver)));
			}
			
			Thread.sleep(2000);
			
			Boolean Que5 = driver.findElements(By.id("txtSecurity_answer5")).size() != 0;
			System.out.println("Que5" + Que5);
			if (Que5 == true) {
			SequrityQue_Locators.Que5(driver).sendKeys("01");
			Thread.sleep(2000);
			System.out.println("Que5 01 Entered");
			System.out.println("01");
			} else {
				System.out.println("Que5 not Entered" + test.addScreenCapture(Screenshot.captureImage(driver)));
			}
			Thread.sleep(2000);
			
			Boolean BtnSubmit = driver.findElements(By.id("btnSubmit")).size() != 0;
			System.out.println("BtnSubmit" + BtnSubmit);
			if (BtnSubmit == true) {
			SequrityQue_Locators.BtnSubmit(driver).click();
			Thread.sleep(2000);				
			System.out.println("BtnSubmit Clicked");
			driver.switchTo().activeElement();
			} else {
				System.out.println("BtnSubmit not Clicked" + test.addScreenCapture(Screenshot.captureImage(driver)));
			}
			
			Boolean PopupBtn = driver.findElements(By.id("btn1")).size() != 0;
			System.out.println("PopupBtn" + PopupBtn);
			if (PopupBtn == true) {
			SequrityQue_Locators.PopupBtn(driver).click();
			driver.close();
			Thread.sleep(6000);
			System.out.println("PopupBtn Clicked");
			} else {
				System.out.println("PopupBtn not Clicked" + test.addScreenCapture(Screenshot.captureImage(driver)));
			}
			
			System.out.println("SecurityQuestionAns Updated successfuly");
			System.out.println("SecurityQuestionAns Updated successfuly");
			
		Boolean MYESOPUserId1 = driver.findElements(By.id("txtUserId")).size() != 0;
			
			System.out.println("MYESOPUserId" + MYESOPUserId1);
		if(MYESOPUserId1==true)
		{
			Login_Locator.MYESOPUserId(driver).clear();
			Thread.sleep(2000);
			Login_Locator.MYESOPUserId(driver).sendKeys(UserId);
			Thread.sleep(2000);
			System.out.println(UserId);
			System.out.println("UserId "+UserId+" Clicked");
		}
		else
		{
			System.out.println("UserId "+UserId+" Not Clicked"+ test.addScreenCapture(Screenshot.captureImage(driver)));

		}
		Boolean MYESOPPassword1 = driver.findElements(By.xpath(".//*[@id='txtPassword1'] |.//*[@id='txtPassword']")).size() != 0;
		System.out.println("MYESOPPassword" + MYESOPPassword1);
	if(MYESOPPassword1==true)
	{
				Actions actions = new Actions(driver);
			actions.moveToElement(Login_Locator.MYESOPPassword(driver));
			actions.click();
			actions.sendKeys(Password);
			actions.build().perform();

			System.out.println(Password);
			System.out.println("Password "+Password+" Clicked");
	}
	else
	{
		System.out.println("Password "+Password+" Not Clicked"+ test.addScreenCapture(Screenshot.captureImage(driver)));

	}
	Boolean MYESOPCompanyID1 = driver.findElements(By.id("txtCompanyId")).size() != 0;
	System.out.println("MYESOPCompanyID" + MYESOPCompanyID1);
	if(MYESOPCompanyID1==true)
	{
			Login_Locator.MYESOPCompanyID(driver).clear();
			Thread.sleep(4000);
			Login_Locator.MYESOPCompanyID(driver).sendKeys(CompanyId1);
			Thread.sleep(2000);
			System.out.println(CompanyId1);
			System.out.println("CompanyId1 "+CompanyId1+" Clicked");
	}
	else
	{
		System.out.println("CompanyId1 "+CompanyId1+" Not Clicked"+ test.addScreenCapture(Screenshot.captureImage(driver)));

	}
	Boolean MYESOPLogin1 = driver.findElements(By.xpath(".//*[@id='btnOk'] |.//*[@id='login_btn']")).size() != 0;
	System.out.println("MYESOPLogin" + MYESOPLogin1);
	if(MYESOPLogin1==true)
	{

			Login_Locator.MYESOPLogin(driver).click();
			Thread.sleep(2000);
			System.out.println("Login button Clicked");
	}
	else
	{
		System.out.println("Login button Not Clicked"+ test.addScreenCapture(Screenshot.captureImage(driver)));

	}
	Boolean iselementpresent11 = driver.findElements(By.id("txtSecurityQuestion_answer1")).size() != 0;
	System.out.println("iselementpresent1" + iselementpresent11);

	if (iselementpresent11 == true) 
	{
		Boolean SeqAns1 = driver.findElements(By.id("txtSecurityQuestion_answer1")).size() != 0;
		System.out.println("SeqAns1" + SeqAns1);
		if (SeqAns1 == true) {
		Login_Locator.SeqAns1(driver).sendKeys(Ans1);
		Thread.sleep(2000);
		System.out.println("SeqAns1 "+Ans1+" Entered");
		} else {
			System.out.println("SeqAns1 not Entered" + test.addScreenCapture(Screenshot.captureImage(driver)));
		}
		System.out.println(Ans2);	
		
		Boolean SeqAns2 = driver.findElements(By.id("txtSecurityQuestion_answer2")).size() != 0;
		System.out.println("SeqAns2" + SeqAns2);
		if (SeqAns2 == true) {
		Login_Locator.SeqAns2(driver).sendKeys(Ans2);
		Thread.sleep(2000);
		System.out.println("SeqAns2 "+Ans2+"Entered");
		} else {
			System.out.println("SeqAns2 not Entered" + test.addScreenCapture(Screenshot.captureImage(driver)));
		}
		System.out.println(Ans2);
		
		Boolean SubmitAns = driver.findElements(By.id("btnSubmitAnswer")).size() != 0;
		System.out.println("SubmitAns" + SubmitAns);
		if (SubmitAns == true) {
		Login_Locator.SubmitAns(driver).click();
		Thread.sleep(2000);	
		System.out.println("SubmitAns Clicked");
		} else {
			System.out.println("SubmitAns not Clicked" + test.addScreenCapture(Screenshot.captureImage(driver)));
		}
		
		System.out.println("SecurityQuestionAns Submited successfuly");
		System.out.println("SecurityQuestionAns Submited successfuly");
	} 
		
	else 
	{
		test.log(LogStatus.FAIL,
				"SecurityQuestionAns Submition failed" + test.addScreenCapture(Screenshot.captureImage(driver)));
		System.out.println("SecurityQuestionAns Submition failed Or Security Questions not present");
	}
	if (isAlertPresents()) 
	{
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}
	else
	{
		System.out.println("Alert not present"); 
	}

		}	
		else 
		{
			test.log(LogStatus.FAIL,
					"SecurityQuestionAns Submition failed" + test.addScreenCapture(Screenshot.captureImage(driver)));
			System.out.println("SecurityQuestionAns Submition failed Or Security Questions not present");
		}
		if (isAlertPresents()) 
		{
			Alert alert = driver.switchTo().alert();
			alert.accept();
		}
		else
		{
			System.out.println("Alert not present"); 
		}
		Boolean EmployeeConcent = driver.findElements(By.id("ctl00_ContentPlaceHolder1_btnMdlNo1")).size() != 0;
		System.out.println("iselementpresent" + EmployeeConcent);

		Thread.sleep(2000);
		if (EmployeeConcent == true) 

		{
			Boolean UserConsent_Checkbox = driver.findElements(By.id("chkConcent")).size() != 0;
			System.out.println("UserConsent_Checkbox" + UserConsent_Checkbox);

			Thread.sleep(2000);
			if (UserConsent_Checkbox == true) 
			{
			EmployeeConcent_Locators.UserConsent_Checkbox(driver).click();
			Thread.sleep(2000);
			System.out.println("Checkbox  present & Clicked");
			System.out.println("Checkbox present & Clicked" + test.addScreenCapture(Screenshot.captureImage(driver)));

		}
			else
			{
			
				System.out.println("Checkbox not present");
				System.out.println("Checkbox not present" + test.addScreenCapture(Screenshot.captureImage(driver)));
			
			}
			Boolean UserConsent_AgreeBtn = driver.findElements(By.xpath("//button[@id='btn1']")).size() != 0;
			System.out.println("UserConsent_AgreeBtn" + UserConsent_AgreeBtn);

			Thread.sleep(2000);
			if (UserConsent_AgreeBtn == true) 
			{
			EmployeeConcent_Locators.UserConsent_AgreeBtn(driver).click();
			Thread.sleep(2000);
			System.out.println("EmployeeContent Accepted");
			}
			else
			{
				System.out.println("Employee concent Agree button not Clicked");
				System.out.println("Employee concent Agree button not Clicked" + test.addScreenCapture(Screenshot.captureImage(driver)));
			
			}
			
		}
		else
		{
			System.out.println("content place holder not found Or  Employee Concent not unable to this employee");
			System.out.println("content place holder not found Or  Employee Concent not unable to this employee");
		}
				// =======ProfileMenu===================
			//	test = report.startTest("ProfileMenu");
		Boolean UserLogo = driver.findElements(By.id("UserLogo")).size() != 0;
			System.out.println("UserLogo" + UserLogo);
			if (UserLogo == true) {
		Profile_menu.UserLogo(driver).click();
		System.out.println("UserLogo Clicked");
		} else {
			System.out.println("UserLogo not Clicked" + test.addScreenCapture(Screenshot.captureImage(driver)));
		}
			
			Boolean Profile = driver.findElements(By.linkText("Profile")).size() != 0;
			System.out.println("Profile" + Profile);
			if (Profile == true) {
		Profile_menu.Profile(driver).click();
		Thread.sleep(2000);
		System.out.println("Profile Clicked");
		} else {
			System.out.println("Profile not Clicked" + test.addScreenCapture(Screenshot.captureImage(driver)));
		}
			

		//DematDetails
	 	Boolean DematDetailsDematDetails_tab = driver.findElements(By.id("DematDetails")).size() != 0;
		System.out.println("DematDetailsDematDetails_tab" + DematDetailsDematDetails_tab);
		if (DematDetailsDematDetails_tab == true) {
		Profile_menu.DematDetailsDematDetails_tab(driver).click();
		Thread.sleep(2000);
		System.out.println("DematDetailsDematDetails_tab Clicked");
		} else {
		System.out.println("DematDetailsDematDetails_tab not Clicked" + test.addScreenCapture(Screenshot.captureImage(driver)));
		}
		
		Boolean DematDetailsEdit_btn = driver.findElements(By.xpath("//div[@class='add-demat-acc']//i[@class='fa fa-plus']")).size() != 0;
		System.out.println("DematDetailsEdit_btn" + DematDetailsEdit_btn);
		if (DematDetailsEdit_btn == true) {
		Profile_menu.DematDetailsEdit_btn(driver).click();
		Thread.sleep(2000);
		System.out.println("DematDetailsEdit_btn Clicked");
		} else {
		System.out.println("DematDetailsEdit_btn not Clicked" + test.addScreenCapture(Screenshot.captureImage(driver)));
		}
		if(Profile_menu.Add_DematDetailsDepositoryName_ddl(driver).isEnabled())
		{
			Profile_menu.Add_DematDetailsDepositoryName_ddl(driver).sendKeys(DepositoryName);
		}
		
		if(Profile_menu.Add_DematDetailsDematAccountType_ddl(driver).isEnabled())
		{
			Profile_menu.Add_DematDetailsDematAccountType_ddl(driver).sendKeys(DematAcctype);
		}
		
		if(Profile_menu.Add_DematDetailsDepository_ParticipantName(driver).isEnabled())
		{
			Profile_menu.Add_DematDetailsDepository_ParticipantName(driver).clear();
			Profile_menu.Add_DematDetailsDepository_ParticipantName(driver).sendKeys(DepositoryParticipantName);
		}
		
		if(Profile_menu.Add_DematDetailsDepository_ParticipantId(driver).isEnabled())
		{
			Profile_menu.Add_DematDetailsDepository_ParticipantId(driver).clear();
			Profile_menu.Add_DematDetailsDepository_ParticipantId(driver).sendKeys(DepositoryParticipantID);
		}
		
		if(Profile_menu.Add_DematDetailsClient_DematAccNo(driver).isEnabled())
		{
			Profile_menu.Add_DematDetailsClient_DematAccNo(driver).clear();
			Profile_menu.Add_DematDetailsClient_DematAccNo(driver).sendKeys(ClientDematACNo);
		}
		
		if(Profile_menu.Add_DematDetailsName_DP_Record(driver).isEnabled())
		{
			Profile_menu.Add_DematDetailsName_DP_Record(driver).clear();
			Profile_menu.Add_DematDetailsName_DP_Record(driver).sendKeys(NameRecord);
		}
		Boolean UploadCML = driver.findElements(By.id("UploadfilesCML")).size() != 0;
		System.out.println("UploadCML" + UploadCML);
		if (UploadCML == true) {
		Profile_menu.UploadCMLFile(driver).click();
		 System.out.println("FormFile_Path Clicked");
			
			Thread.sleep(2000);
		StringSelection filePath = new StringSelection(Path);
		Thread.sleep(2000);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filePath, null);

		Robot robot = new Robot();
		// Press Enter

		robot.keyPress(KeyEvent.VK_ENTER);

		// Release Enter
		robot.keyRelease(KeyEvent.VK_ENTER);

		// Press CTRL+V
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);

		// Release CTRL+V
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);

		// Press Enter
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);

		Thread.sleep(2000);
		Profile_menu.btn_Upload(driver).click();
		Thread.sleep(2000);
		 System.out.println("Upload Button Clicked");
		Thread.sleep(2000);
		System.out.println("UploadCML Uploaded");
		} else {
		System.out.println("UploadCML not Clicked" + test.addScreenCapture(Screenshot.captureImage(driver)));
		}
		

		Boolean Accept_btn = driver.findElements(By.id("btn1")).size() != 0;
		System.out.println("Accept_btn" + Accept_btn);
		if (Accept_btn == true) {
		Profile_menu.UploadAccept_btn(driver).click();
		Thread.sleep(2000);
		System.out.println("Accept_btn Clicked");
		} else {
		System.out.println("Accept_btn not Clicked" + test.addScreenCapture(Screenshot.captureImage(driver)));
		}
		// Switching to Alert    
		Thread.sleep(2000);
	   
		
	    Boolean Save_btn = driver.findElements(By.xpath("//button[@id='btnAddNow']")).size() != 0;
		System.out.println("Save_btn" + Save_btn);
		if (Save_btn == true) {
			Profile_menu.BtnSaveDematDetails(driver).click();
		
		Thread.sleep(2000);
		System.out.println("Save_btn Clicked");
		} else {
		System.out.println("Save_btn not Clicked" + test.addScreenCapture(Screenshot.captureImage(driver)));
		}
	   
		Boolean Accept_btn2 = driver.findElements(By.id("btn1")).size() != 0;
		System.out.println("Accept_btn" + Accept_btn2);
		if (Accept_btn2 == true) {
		Profile_menu.UploadAccept_btn(driver).click();
		Thread.sleep(2000);
		System.out.println("Accept_btn Clicked");
		} else {
		System.out.println("Accept_btn not Clicked" + test.addScreenCapture(Screenshot.captureImage(driver)));
		}
		// Switching to Alert    
		Thread.sleep(2000);
				// ========close browser=================
			//	test = report.startTest("close browser");
		try {
			
			Boolean Logo = driver.findElements(By.xpath(".//*[@id='UserLogo']")).size() != 0;
			System.out.println("Logo" + Logo);
			if (Logo == true) {
			Login_Locator.Logo(driver).click();
			Thread.sleep(2000);
			System.out.println("Logo Clicked");
			} else {
			System.out.println("Logo not Clicked" + test.addScreenCapture(Screenshot.captureImage(driver)));
			}
			
			Boolean Logout = driver.findElements(By.linkText("Logout")).size() != 0;
			System.out.println("Logout" + Logout);
			if (Logout == true) {
			Login_Locator.Logout(driver).click();
			Thread.sleep(2000);
			driver.close();
			Thread.sleep(6000);	
			System.out.println("Logout Clicked");
			} else {
			System.out.println("Logout not Clicked" + test.addScreenCapture(Screenshot.captureImage(driver)));
			}
		//	driver.quit();
		}

		catch (Exception e) {

			e.printStackTrace();
		}	
		
				
			
			}
			else if(browser.equalsIgnoreCase("Chrome3"))
			{

				//set path to chromedriver.exe
				System.setProperty("webdriver.chrome.driver","D:\\Testing Team Automation\\SeleniumDriver\\chromedriver.exe");
				//create chrome instance
				driver = new ChromeDriver();

			//	test = report.startTest("URLs");
				driver.get(URLwithoutspace);
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				String URL1=driver.getCurrentUrl();
				
				if(URL1.equals(URLwithoutspace))
				{
				System.out.println("Navigated to the specified URL");
				}
				else
				{
				System.out.println("Not Navigated to the UATGlobalUI URL"+ test.addScreenCapture(Screenshot.captureImage(driver)));

				}
				//======Covid 19===============
	            if(Login_Locator.COVID(driver).isDisplayed())
	            {
	                System.out.println("COVID dialogue is displayed");
	                Login_Locator.COVID(driver).click();
	            }
	            else
	            {
	                System.out.println("COVID dialogue is not displayed");
	                System.out.println("alert not present");
	            }
				
				// =================Login=================
		//		test = report.startTest("Login");
	            Boolean MYESOPUserId = driver.findElements(By.id("txtUserId")).size() != 0;
	    		
	    		System.out.println("MYESOPUserId" + MYESOPUserId);
	    	if(MYESOPUserId==true)
	    	{
	    		Login_Locator.MYESOPUserId(driver).clear();
	    		Thread.sleep(2000);
	    		Login_Locator.MYESOPUserId(driver).sendKeys(UserId);
	    		Thread.sleep(2000);
	    		System.out.println(UserId);
	    		System.out.println("UserId "+UserId+" Clicked");
	    	}
	    	else
	    	{
	    		System.out.println("UserId "+UserId+" Not Clicked"+ test.addScreenCapture(Screenshot.captureImage(driver)));

	    	}
	    	Boolean MYESOPPassword = driver.findElements(By.xpath(".//*[@id='txtPassword1'] |.//*[@id='txtPassword']")).size() != 0;
	    	System.out.println("MYESOPPassword" + MYESOPPassword);
	    if(MYESOPPassword==true)
	    {
	    			Actions actions = new Actions(driver);
	    		actions.moveToElement(Login_Locator.MYESOPPassword(driver));
	    		actions.click();
	    		actions.sendKeys(Password);
	    		actions.build().perform();

	    		System.out.println(Password);
	    		System.out.println("Password "+Password+" Clicked");
	    }
	    else
	    {
	    	System.out.println("Password "+Password+" Not Clicked"+ test.addScreenCapture(Screenshot.captureImage(driver)));

	    }
	    Boolean MYESOPCompanyID = driver.findElements(By.id("txtCompanyId")).size() != 0;
	    System.out.println("MYESOPCompanyID" + MYESOPCompanyID);
	    if(MYESOPCompanyID==true)
	    {
	    		Login_Locator.MYESOPCompanyID(driver).clear();
	    		Thread.sleep(4000);
	    		Login_Locator.MYESOPCompanyID(driver).sendKeys(CompanyId1);
	    		Thread.sleep(2000);
	    		System.out.println(CompanyId1);
	    		System.out.println("CompanyId1 "+CompanyId1+" Clicked");
	    }
	    else
	    {
	    	System.out.println("CompanyId1 "+CompanyId1+" Not Clicked"+ test.addScreenCapture(Screenshot.captureImage(driver)));

	    }
	    Boolean MYESOPLogin = driver.findElements(By.xpath(".//*[@id='btnOk'] |.//*[@id='login_btn']")).size() != 0;
	    System.out.println("MYESOPLogin" + MYESOPLogin);
	    if(MYESOPLogin==true)
	    {

	    		Login_Locator.MYESOPLogin(driver).click();
	    		Thread.sleep(2000);
	    		System.out.println("Login button Clicked");
	    }
	    else
	    {
	    	System.out.println("Login button Not Clicked"+ test.addScreenCapture(Screenshot.captureImage(driver)));

	    }
	      Boolean iselementpresent1 = driver.findElements(By.id("txtSecurityQuestion_answer1")).size() != 0;
		System.out.println("iselementpresent1" + iselementpresent1);
		Boolean iselementpresent2= driver.findElements(By.id("txtSecurity_answer3")).size() != 0;
		System.out.println("iselementpresent2" +iselementpresent2);
		Thread.sleep(2000);
		if (iselementpresent1 == true) 
		{
			Boolean SeqAns1 = driver.findElements(By.id("txtSecurityQuestion_answer1")).size() != 0;
			System.out.println("SeqAns1" + SeqAns1);
			if (SeqAns1 == true) {
			Login_Locator.SeqAns1(driver).sendKeys(Ans1);
			Thread.sleep(2000);
			System.out.println("SeqAns1 "+Ans1+" Entered");
			} else {
				System.out.println("SeqAns1 not Entered" + test.addScreenCapture(Screenshot.captureImage(driver)));
			}
			System.out.println(Ans2);	
			
			Boolean SeqAns2 = driver.findElements(By.id("txtSecurityQuestion_answer2")).size() != 0;
			System.out.println("SeqAns2" + SeqAns2);
			if (SeqAns2 == true) {
			Login_Locator.SeqAns2(driver).sendKeys(Ans2);
			Thread.sleep(2000);
			System.out.println("SeqAns2 "+Ans2+"Entered");
			} else {
				System.out.println("SeqAns2 not Entered" + test.addScreenCapture(Screenshot.captureImage(driver)));
			}
			System.out.println(Ans2);
			
			Boolean SubmitAns = driver.findElements(By.id("btnSubmitAnswer")).size() != 0;
			System.out.println("SubmitAns" + SubmitAns);
			if (SubmitAns == true) {
			Login_Locator.SubmitAns(driver).click();
			Thread.sleep(2000);	
			System.out.println("SubmitAns Clicked");
			} else {
				System.out.println("SubmitAns not Clicked" + test.addScreenCapture(Screenshot.captureImage(driver)));
			}
			
			System.out.println("SecurityQuestionAns Submited successfuly");
			System.out.println("SecurityQuestionAns Submited successfuly");
		} 
		else if(iselementpresent2==true)
		{
			Boolean Que1 = driver.findElements(By.id("txtSecurity_answer1")).size() != 0;
			System.out.println("Que1" + Que1);
			if (Que1 == true) {
			SequrityQue_Locators.Que1(driver).sendKeys("01");
			Thread.sleep(2000);
			System.out.println("Que1 01 Entered");
			System.out.println("01");
			} else {
				System.out.println("Que1 not Entered" + test.addScreenCapture(Screenshot.captureImage(driver)));
			}
				
			
			Boolean Que2 = driver.findElements(By.id("txtSecurity_answer2")).size() != 0;
			System.out.println("Que2" + Que2);
			if (Que2 == true) {
			SequrityQue_Locators.Que2(driver).sendKeys("01");
			Thread.sleep(2000);
			System.out.println("Que2 01 Entered");
			System.out.println("01");
			} else {
				System.out.println("Que2 not Entered" + test.addScreenCapture(Screenshot.captureImage(driver)));
			}
			Thread.sleep(2000);
			
			Boolean Que3 = driver.findElements(By.id("txtSecurity_answer3")).size() != 0;
			System.out.println("Que3" + Que3);
			if (Que3 == true) {
			SequrityQue_Locators.Que3(driver).sendKeys("01");
			Thread.sleep(2000);
			System.out.println("Que3 01 Entered");
			System.out.println("01");
			} else {
				System.out.println("Que3 not Entered" + test.addScreenCapture(Screenshot.captureImage(driver)));
			}
			
			Boolean Que4 = driver.findElements(By.id("txtSecurity_answer4")).size() != 0;
			System.out.println("Que4" + Que4);
			if (Que4 == true) {
			SequrityQue_Locators.Que4(driver).sendKeys("01");
			Thread.sleep(2000);
			System.out.println("Que4 01 Entered");
			System.out.println("01");
			} else {
				System.out.println("Que4 not Entered" + test.addScreenCapture(Screenshot.captureImage(driver)));
			}
			
			Thread.sleep(2000);
			
			Boolean Que5 = driver.findElements(By.id("txtSecurity_answer5")).size() != 0;
			System.out.println("Que5" + Que5);
			if (Que5 == true) {
			SequrityQue_Locators.Que5(driver).sendKeys("01");
			Thread.sleep(2000);
			System.out.println("Que5 01 Entered");
			System.out.println("01");
			} else {
				System.out.println("Que5 not Entered" + test.addScreenCapture(Screenshot.captureImage(driver)));
			}
			Thread.sleep(2000);
			
			Boolean BtnSubmit = driver.findElements(By.id("btnSubmit")).size() != 0;
			System.out.println("BtnSubmit" + BtnSubmit);
			if (BtnSubmit == true) {
			SequrityQue_Locators.BtnSubmit(driver).click();
			Thread.sleep(2000);				
			System.out.println("BtnSubmit Clicked");
			driver.switchTo().activeElement();
			} else {
				System.out.println("BtnSubmit not Clicked" + test.addScreenCapture(Screenshot.captureImage(driver)));
			}
			
			Boolean PopupBtn = driver.findElements(By.id("btn1")).size() != 0;
			System.out.println("PopupBtn" + PopupBtn);
			if (PopupBtn == true) {
			SequrityQue_Locators.PopupBtn(driver).click();
			driver.close();
			Thread.sleep(6000);
			System.out.println("PopupBtn Clicked");
			} else {
				System.out.println("PopupBtn not Clicked" + test.addScreenCapture(Screenshot.captureImage(driver)));
			}
			
			System.out.println("SecurityQuestionAns Updated successfuly");
			System.out.println("SecurityQuestionAns Updated successfuly");
			
		Boolean MYESOPUserId1 = driver.findElements(By.id("txtUserId")).size() != 0;
			
			System.out.println("MYESOPUserId" + MYESOPUserId1);
		if(MYESOPUserId1==true)
		{
			Login_Locator.MYESOPUserId(driver).clear();
			Thread.sleep(2000);
			Login_Locator.MYESOPUserId(driver).sendKeys(UserId);
			Thread.sleep(2000);
			System.out.println(UserId);
			System.out.println("UserId "+UserId+" Clicked");
		}
		else
		{
			System.out.println("UserId "+UserId+" Not Clicked"+ test.addScreenCapture(Screenshot.captureImage(driver)));

		}
		Boolean MYESOPPassword1 = driver.findElements(By.xpath(".//*[@id='txtPassword1'] |.//*[@id='txtPassword']")).size() != 0;
		System.out.println("MYESOPPassword" + MYESOPPassword1);
	if(MYESOPPassword1==true)
	{
				Actions actions = new Actions(driver);
			actions.moveToElement(Login_Locator.MYESOPPassword(driver));
			actions.click();
			actions.sendKeys(Password);
			actions.build().perform();

			System.out.println(Password);
			System.out.println("Password "+Password+" Clicked");
	}
	else
	{
		System.out.println("Password "+Password+" Not Clicked"+ test.addScreenCapture(Screenshot.captureImage(driver)));

	}
	Boolean MYESOPCompanyID1 = driver.findElements(By.id("txtCompanyId")).size() != 0;
	System.out.println("MYESOPCompanyID" + MYESOPCompanyID1);
	if(MYESOPCompanyID1==true)
	{
			Login_Locator.MYESOPCompanyID(driver).clear();
			Thread.sleep(4000);
			Login_Locator.MYESOPCompanyID(driver).sendKeys(CompanyId1);
			Thread.sleep(2000);
			System.out.println(CompanyId1);
			System.out.println("CompanyId1 "+CompanyId1+" Clicked");
	}
	else
	{
		System.out.println("CompanyId1 "+CompanyId1+" Not Clicked"+ test.addScreenCapture(Screenshot.captureImage(driver)));

	}
	Boolean MYESOPLogin1 = driver.findElements(By.xpath(".//*[@id='btnOk'] |.//*[@id='login_btn']")).size() != 0;
	System.out.println("MYESOPLogin" + MYESOPLogin1);
	if(MYESOPLogin1==true)
	{

			Login_Locator.MYESOPLogin(driver).click();
			Thread.sleep(2000);
			System.out.println("Login button Clicked");
	}
	else
	{
		System.out.println("Login button Not Clicked"+ test.addScreenCapture(Screenshot.captureImage(driver)));

	}
	Boolean iselementpresent11 = driver.findElements(By.id("txtSecurityQuestion_answer1")).size() != 0;
	System.out.println("iselementpresent1" + iselementpresent11);

	if (iselementpresent11 == true) 
	{
		Boolean SeqAns1 = driver.findElements(By.id("txtSecurityQuestion_answer1")).size() != 0;
		System.out.println("SeqAns1" + SeqAns1);
		if (SeqAns1 == true) {
		Login_Locator.SeqAns1(driver).sendKeys(Ans1);
		Thread.sleep(2000);
		System.out.println("SeqAns1 "+Ans1+" Entered");
		} else {
			System.out.println("SeqAns1 not Entered" + test.addScreenCapture(Screenshot.captureImage(driver)));
		}
		System.out.println(Ans2);	
		
		Boolean SeqAns2 = driver.findElements(By.id("txtSecurityQuestion_answer2")).size() != 0;
		System.out.println("SeqAns2" + SeqAns2);
		if (SeqAns2 == true) {
		Login_Locator.SeqAns2(driver).sendKeys(Ans2);
		Thread.sleep(2000);
		System.out.println("SeqAns2 "+Ans2+"Entered");
		} else {
			System.out.println("SeqAns2 not Entered" + test.addScreenCapture(Screenshot.captureImage(driver)));
		}
		System.out.println(Ans2);
		
		Boolean SubmitAns = driver.findElements(By.id("btnSubmitAnswer")).size() != 0;
		System.out.println("SubmitAns" + SubmitAns);
		if (SubmitAns == true) {
		Login_Locator.SubmitAns(driver).click();
		Thread.sleep(2000);	
		System.out.println("SubmitAns Clicked");
		} else {
			System.out.println("SubmitAns not Clicked" + test.addScreenCapture(Screenshot.captureImage(driver)));
		}
		
		System.out.println("SecurityQuestionAns Submited successfuly");
		System.out.println("SecurityQuestionAns Submited successfuly");
	} 
		
	else 
	{
		test.log(LogStatus.FAIL,
				"SecurityQuestionAns Submition failed" + test.addScreenCapture(Screenshot.captureImage(driver)));
		System.out.println("SecurityQuestionAns Submition failed Or Security Questions not present");
	}
	if (isAlertPresents()) 
	{
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}
	else
	{
		System.out.println("Alert not present"); 
	}

		}	
		else 
		{
			test.log(LogStatus.FAIL,
					"SecurityQuestionAns Submition failed" + test.addScreenCapture(Screenshot.captureImage(driver)));
			System.out.println("SecurityQuestionAns Submition failed Or Security Questions not present");
		}
		if (isAlertPresents()) 
		{
			Alert alert = driver.switchTo().alert();
			alert.accept();
		}
		else
		{
			System.out.println("Alert not present"); 
		}
		Boolean EmployeeConcent = driver.findElements(By.id("ctl00_ContentPlaceHolder1_btnMdlNo1")).size() != 0;
		System.out.println("iselementpresent" + EmployeeConcent);

		Thread.sleep(2000);
		if (EmployeeConcent == true) 

		{
			Boolean UserConsent_Checkbox = driver.findElements(By.id("chkConcent")).size() != 0;
			System.out.println("UserConsent_Checkbox" + UserConsent_Checkbox);

			Thread.sleep(2000);
			if (UserConsent_Checkbox == true) 
			{
			EmployeeConcent_Locators.UserConsent_Checkbox(driver).click();
			Thread.sleep(2000);
			System.out.println("Checkbox  present & Clicked");
			System.out.println("Checkbox present & Clicked" + test.addScreenCapture(Screenshot.captureImage(driver)));

		}
			else
			{
			
				System.out.println("Checkbox not present");
				System.out.println("Checkbox not present" + test.addScreenCapture(Screenshot.captureImage(driver)));
			
			}
			Boolean UserConsent_AgreeBtn = driver.findElements(By.xpath("//button[@id='btn1']")).size() != 0;
			System.out.println("UserConsent_AgreeBtn" + UserConsent_AgreeBtn);

			Thread.sleep(2000);
			if (UserConsent_AgreeBtn == true) 
			{
			EmployeeConcent_Locators.UserConsent_AgreeBtn(driver).click();
			Thread.sleep(2000);
			System.out.println("EmployeeContent Accepted");
			}
			else
			{
				System.out.println("Employee concent Agree button not Clicked");
				System.out.println("Employee concent Agree button not Clicked" + test.addScreenCapture(Screenshot.captureImage(driver)));
			
			}
			
		}
		else
		{
			System.out.println("content place holder not found Or  Employee Concent not unable to this employee");
			System.out.println("content place holder not found Or  Employee Concent not unable to this employee");
		}
				// =======ProfileMenu===================
			//	test = report.startTest("ProfileMenu");
		Boolean UserLogo = driver.findElements(By.id("UserLogo")).size() != 0;
			System.out.println("UserLogo" + UserLogo);
			if (UserLogo == true) {
		Profile_menu.UserLogo(driver).click();
		System.out.println("UserLogo Clicked");
		} else {
			System.out.println("UserLogo not Clicked" + test.addScreenCapture(Screenshot.captureImage(driver)));
		}
			
			Boolean Profile = driver.findElements(By.linkText("Profile")).size() != 0;
			System.out.println("Profile" + Profile);
			if (Profile == true) {
		Profile_menu.Profile(driver).click();
		Thread.sleep(2000);
		System.out.println("Profile Clicked");
		} else {
			System.out.println("Profile not Clicked" + test.addScreenCapture(Screenshot.captureImage(driver)));
		}
			

		//DematDetails
	 	Boolean DematDetailsDematDetails_tab = driver.findElements(By.id("DematDetails")).size() != 0;
		System.out.println("DematDetailsDematDetails_tab" + DematDetailsDematDetails_tab);
		if (DematDetailsDematDetails_tab == true) {
		Profile_menu.DematDetailsDematDetails_tab(driver).click();
		Thread.sleep(2000);
		System.out.println("DematDetailsDematDetails_tab Clicked");
		} else {
		System.out.println("DematDetailsDematDetails_tab not Clicked" + test.addScreenCapture(Screenshot.captureImage(driver)));
		}
		
		Boolean DematDetailsEdit_btn = driver.findElements(By.xpath("//div[@class='add-demat-acc']//i[@class='fa fa-plus']")).size() != 0;
		System.out.println("DematDetailsEdit_btn" + DematDetailsEdit_btn);
		if (DematDetailsEdit_btn == true) {
		Profile_menu.DematDetailsEdit_btn(driver).click();
		Thread.sleep(2000);
		System.out.println("DematDetailsEdit_btn Clicked");
		} else {
		System.out.println("DematDetailsEdit_btn not Clicked" + test.addScreenCapture(Screenshot.captureImage(driver)));
		}
		if(Profile_menu.Add_DematDetailsDepositoryName_ddl(driver).isEnabled())
		{
			Profile_menu.Add_DematDetailsDepositoryName_ddl(driver).sendKeys(DepositoryName);
		}
		
		if(Profile_menu.Add_DematDetailsDematAccountType_ddl(driver).isEnabled())
		{
			Profile_menu.Add_DematDetailsDematAccountType_ddl(driver).sendKeys(DematAcctype);
		}
		
		if(Profile_menu.Add_DematDetailsDepository_ParticipantName(driver).isEnabled())
		{
			Profile_menu.Add_DematDetailsDepository_ParticipantName(driver).clear();
			Profile_menu.Add_DematDetailsDepository_ParticipantName(driver).sendKeys(DepositoryParticipantName);
		}
		
		if(Profile_menu.Add_DematDetailsDepository_ParticipantId(driver).isEnabled())
		{
			Profile_menu.Add_DematDetailsDepository_ParticipantId(driver).clear();
			Profile_menu.Add_DematDetailsDepository_ParticipantId(driver).sendKeys(DepositoryParticipantID);
		}
		
		if(Profile_menu.Add_DematDetailsClient_DematAccNo(driver).isEnabled())
		{
			Profile_menu.Add_DematDetailsClient_DematAccNo(driver).clear();
			Profile_menu.Add_DematDetailsClient_DematAccNo(driver).sendKeys(ClientDematACNo);
		}
		
		if(Profile_menu.Add_DematDetailsName_DP_Record(driver).isEnabled())
		{
			Profile_menu.Add_DematDetailsName_DP_Record(driver).clear();
			Profile_menu.Add_DematDetailsName_DP_Record(driver).sendKeys(NameRecord);
		}
		Boolean UploadCML = driver.findElements(By.id("UploadfilesCML")).size() != 0;
		System.out.println("UploadCML" + UploadCML);
		if (UploadCML == true) {
		Profile_menu.UploadCMLFile(driver).click();
		 System.out.println("FormFile_Path Clicked");
			
			Thread.sleep(3000);
		StringSelection filePath = new StringSelection(Path);
		Thread.sleep(3000);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filePath, null);

		Robot robot = new Robot();
		// Press Enter

		robot.keyPress(KeyEvent.VK_ENTER);

		// Release Enter
		robot.keyRelease(KeyEvent.VK_ENTER);

		// Press CTRL+V
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);

		// Release CTRL+V
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);

		// Press Enter
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);

		Thread.sleep(2000);
		Profile_menu.btn_Upload(driver).click();
		Thread.sleep(2000);
		 System.out.println("Upload Button Clicked");
		Thread.sleep(2000);
		System.out.println("UploadCML Uploaded");
		} else {
		System.out.println("UploadCML not Clicked" + test.addScreenCapture(Screenshot.captureImage(driver)));
		}
		

		Boolean Accept_btn = driver.findElements(By.id("btn1")).size() != 0;
		System.out.println("Accept_btn" + Accept_btn);
		if (Accept_btn == true) {
		Profile_menu.UploadAccept_btn(driver).click();
		Thread.sleep(2000);
		System.out.println("Accept_btn Clicked");
		} else {
		System.out.println("Accept_btn not Clicked" + test.addScreenCapture(Screenshot.captureImage(driver)));
		}
		// Switching to Alert    
		Thread.sleep(2000);
	   
		
	    Boolean Save_btn = driver.findElements(By.xpath("//button[@id='btnAddNow']")).size() != 0;
		System.out.println("Save_btn" + Save_btn);
		if (Save_btn == true) {
			Profile_menu.BtnSaveDematDetails(driver).click();
		
		Thread.sleep(2000);
		System.out.println("Save_btn Clicked");
		} else {
		System.out.println("Save_btn not Clicked" + test.addScreenCapture(Screenshot.captureImage(driver)));
		}
	   
		Boolean Accept_btn2 = driver.findElements(By.id("btn1")).size() != 0;
		System.out.println("Accept_btn" + Accept_btn2);
		if (Accept_btn2 == true) {
		Profile_menu.UploadAccept_btn(driver).click();
		Thread.sleep(2000);
		System.out.println("Accept_btn Clicked");
		} else {
		System.out.println("Accept_btn not Clicked" + test.addScreenCapture(Screenshot.captureImage(driver)));
		}
		// Switching to Alert    
		Thread.sleep(2000);
				// ========close browser=================
			//	test = report.startTest("close browser");
		try {
			
			Boolean Logo = driver.findElements(By.xpath(".//*[@id='UserLogo']")).size() != 0;
			System.out.println("Logo" + Logo);
			if (Logo == true) {
			Login_Locator.Logo(driver).click();
			Thread.sleep(2000);
			System.out.println("Logo Clicked");
			} else {
			System.out.println("Logo not Clicked" + test.addScreenCapture(Screenshot.captureImage(driver)));
			}
			
			Boolean Logout = driver.findElements(By.linkText("Logout")).size() != 0;
			System.out.println("Logout" + Logout);
			if (Logout == true) {
			Login_Locator.Logout(driver).click();
			Thread.sleep(2000);
			driver.close();
			Thread.sleep(6000);	
			System.out.println("Logout Clicked");
			} else {
			System.out.println("Logout not Clicked" + test.addScreenCapture(Screenshot.captureImage(driver)));
			}
		//	driver.quit();
		}

		catch (Exception e) {

			e.printStackTrace();
		}	
		
				
			}
			
			//Check if parameter passed as 'Edge'
			else if(browser.equalsIgnoreCase("Edge")){
				System.setProperty("webdriver.edge.driver", "D:\\Testing Team Automation\\SeleniumDriver\\msedgedriver.exe");
				WebDriver driver = new EdgeDriver();


		

		//	test = report.startTest("URLs");
			driver.get(URLwithoutspace);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			String URL1=driver.getCurrentUrl();
			
			if(URL1.equals(URLwithoutspace))
			{
			System.out.println("Navigated to the specified URL");
			}
			else
			{
			System.out.println("Not Navigated to the UATGlobalUI URL"+ test.addScreenCapture(Screenshot.captureImage(driver)));

			}
			//======Covid 19===============
            if(Login_Locator.COVID(driver).isDisplayed())
            {
                System.out.println("COVID dialogue is displayed");
                Login_Locator.COVID(driver).click();
            }
            else
            {
                System.out.println("COVID dialogue is not displayed");
                System.out.println("alert not present");
            }
			
			// =================Login=================
	//		test = report.startTest("Login");
            Boolean MYESOPUserId = driver.findElements(By.id("txtUserId")).size() != 0;
    		
    		System.out.println("MYESOPUserId" + MYESOPUserId);
    	if(MYESOPUserId==true)
    	{
    		Login_Locator.MYESOPUserId(driver).clear();
    		Thread.sleep(2000);
    		Login_Locator.MYESOPUserId(driver).sendKeys(UserId);
    		Thread.sleep(2000);
    		System.out.println(UserId);
    		System.out.println("UserId "+UserId+" Clicked");
    	}
    	else
    	{
    		System.out.println("UserId "+UserId+" Not Clicked"+ test.addScreenCapture(Screenshot.captureImage(driver)));

    	}
    	Boolean MYESOPPassword = driver.findElements(By.xpath(".//*[@id='txtPassword1'] |.//*[@id='txtPassword']")).size() != 0;
    	System.out.println("MYESOPPassword" + MYESOPPassword);
    if(MYESOPPassword==true)
    {
    			Actions actions = new Actions(driver);
    		actions.moveToElement(Login_Locator.MYESOPPassword(driver));
    		actions.click();
    		actions.sendKeys(Password);
    		actions.build().perform();

    		System.out.println(Password);
    		System.out.println("Password "+Password+" Clicked");
    }
    else
    {
    	System.out.println("Password "+Password+" Not Clicked"+ test.addScreenCapture(Screenshot.captureImage(driver)));

    }
    Boolean MYESOPCompanyID = driver.findElements(By.id("txtCompanyId")).size() != 0;
    System.out.println("MYESOPCompanyID" + MYESOPCompanyID);
    if(MYESOPCompanyID==true)
    {
    		Login_Locator.MYESOPCompanyID(driver).clear();
    		Thread.sleep(4000);
    		Login_Locator.MYESOPCompanyID(driver).sendKeys(CompanyId1);
    		Thread.sleep(2000);
    		System.out.println(CompanyId1);
    		System.out.println("CompanyId1 "+CompanyId1+" Clicked");
    }
    else
    {
    	System.out.println("CompanyId1 "+CompanyId1+" Not Clicked"+ test.addScreenCapture(Screenshot.captureImage(driver)));

    }
    Boolean MYESOPLogin = driver.findElements(By.xpath(".//*[@id='btnOk'] |.//*[@id='login_btn']")).size() != 0;
    System.out.println("MYESOPLogin" + MYESOPLogin);
    if(MYESOPLogin==true)
    {

    		Login_Locator.MYESOPLogin(driver).click();
    		Thread.sleep(2000);
    		System.out.println("Login button Clicked");
    }
    else
    {
    	System.out.println("Login button Not Clicked"+ test.addScreenCapture(Screenshot.captureImage(driver)));

    }
      Boolean iselementpresent1 = driver.findElements(By.id("txtSecurityQuestion_answer1")).size() != 0;
	System.out.println("iselementpresent1" + iselementpresent1);
	Boolean iselementpresent2= driver.findElements(By.id("txtSecurity_answer3")).size() != 0;
	System.out.println("iselementpresent2" +iselementpresent2);
	Thread.sleep(2000);
	if (iselementpresent1 == true) 
	{
		Boolean SeqAns1 = driver.findElements(By.id("txtSecurityQuestion_answer1")).size() != 0;
		System.out.println("SeqAns1" + SeqAns1);
		if (SeqAns1 == true) {
		Login_Locator.SeqAns1(driver).sendKeys(Ans1);
		Thread.sleep(2000);
		System.out.println("SeqAns1 "+Ans1+" Entered");
		} else {
			System.out.println("SeqAns1 not Entered" + test.addScreenCapture(Screenshot.captureImage(driver)));
		}
		System.out.println(Ans2);	
		
		Boolean SeqAns2 = driver.findElements(By.id("txtSecurityQuestion_answer2")).size() != 0;
		System.out.println("SeqAns2" + SeqAns2);
		if (SeqAns2 == true) {
		Login_Locator.SeqAns2(driver).sendKeys(Ans2);
		Thread.sleep(2000);
		System.out.println("SeqAns2 "+Ans2+"Entered");
		} else {
			System.out.println("SeqAns2 not Entered" + test.addScreenCapture(Screenshot.captureImage(driver)));
		}
		System.out.println(Ans2);
		
		Boolean SubmitAns = driver.findElements(By.id("btnSubmitAnswer")).size() != 0;
		System.out.println("SubmitAns" + SubmitAns);
		if (SubmitAns == true) {
		Login_Locator.SubmitAns(driver).click();
		Thread.sleep(2000);	
		System.out.println("SubmitAns Clicked");
		} else {
			System.out.println("SubmitAns not Clicked" + test.addScreenCapture(Screenshot.captureImage(driver)));
		}
		
		System.out.println("SecurityQuestionAns Submited successfuly");
		System.out.println("SecurityQuestionAns Submited successfuly");
	} 
	else if(iselementpresent2==true)
	{
		Boolean Que1 = driver.findElements(By.id("txtSecurity_answer1")).size() != 0;
		System.out.println("Que1" + Que1);
		if (Que1 == true) {
		SequrityQue_Locators.Que1(driver).sendKeys("01");
		Thread.sleep(2000);
		System.out.println("Que1 01 Entered");
		System.out.println("01");
		} else {
			System.out.println("Que1 not Entered" + test.addScreenCapture(Screenshot.captureImage(driver)));
		}
			
		
		Boolean Que2 = driver.findElements(By.id("txtSecurity_answer2")).size() != 0;
		System.out.println("Que2" + Que2);
		if (Que2 == true) {
		SequrityQue_Locators.Que2(driver).sendKeys("01");
		Thread.sleep(2000);
		System.out.println("Que2 01 Entered");
		System.out.println("01");
		} else {
			System.out.println("Que2 not Entered" + test.addScreenCapture(Screenshot.captureImage(driver)));
		}
		Thread.sleep(2000);
		
		Boolean Que3 = driver.findElements(By.id("txtSecurity_answer3")).size() != 0;
		System.out.println("Que3" + Que3);
		if (Que3 == true) {
		SequrityQue_Locators.Que3(driver).sendKeys("01");
		Thread.sleep(2000);
		System.out.println("Que3 01 Entered");
		System.out.println("01");
		} else {
			System.out.println("Que3 not Entered" + test.addScreenCapture(Screenshot.captureImage(driver)));
		}
		
		Boolean Que4 = driver.findElements(By.id("txtSecurity_answer4")).size() != 0;
		System.out.println("Que4" + Que4);
		if (Que4 == true) {
		SequrityQue_Locators.Que4(driver).sendKeys("01");
		Thread.sleep(2000);
		System.out.println("Que4 01 Entered");
		System.out.println("01");
		} else {
			System.out.println("Que4 not Entered" + test.addScreenCapture(Screenshot.captureImage(driver)));
		}
		
		Thread.sleep(2000);
		
		Boolean Que5 = driver.findElements(By.id("txtSecurity_answer5")).size() != 0;
		System.out.println("Que5" + Que5);
		if (Que5 == true) {
		SequrityQue_Locators.Que5(driver).sendKeys("01");
		Thread.sleep(2000);
		System.out.println("Que5 01 Entered");
		System.out.println("01");
		} else {
			System.out.println("Que5 not Entered" + test.addScreenCapture(Screenshot.captureImage(driver)));
		}
		Thread.sleep(2000);
		
		Boolean BtnSubmit = driver.findElements(By.id("btnSubmit")).size() != 0;
		System.out.println("BtnSubmit" + BtnSubmit);
		if (BtnSubmit == true) {
		SequrityQue_Locators.BtnSubmit(driver).click();
		Thread.sleep(2000);				
		System.out.println("BtnSubmit Clicked");
		driver.switchTo().activeElement();
		} else {
			System.out.println("BtnSubmit not Clicked" + test.addScreenCapture(Screenshot.captureImage(driver)));
		}
		
		Boolean PopupBtn = driver.findElements(By.id("btn1")).size() != 0;
		System.out.println("PopupBtn" + PopupBtn);
		if (PopupBtn == true) {
		SequrityQue_Locators.PopupBtn(driver).click();
		driver.close();
		Thread.sleep(6000);
		System.out.println("PopupBtn Clicked");
		} else {
			System.out.println("PopupBtn not Clicked" + test.addScreenCapture(Screenshot.captureImage(driver)));
		}
		
		System.out.println("SecurityQuestionAns Updated successfuly");
		System.out.println("SecurityQuestionAns Updated successfuly");
		
	Boolean MYESOPUserId1 = driver.findElements(By.id("txtUserId")).size() != 0;
		
		System.out.println("MYESOPUserId" + MYESOPUserId1);
	if(MYESOPUserId1==true)
	{
		Login_Locator.MYESOPUserId(driver).clear();
		Thread.sleep(2000);
		Login_Locator.MYESOPUserId(driver).sendKeys(UserId);
		Thread.sleep(2000);
		System.out.println(UserId);
		System.out.println("UserId "+UserId+" Clicked");
	}
	else
	{
		System.out.println("UserId "+UserId+" Not Clicked"+ test.addScreenCapture(Screenshot.captureImage(driver)));

	}
	Boolean MYESOPPassword1 = driver.findElements(By.xpath(".//*[@id='txtPassword1'] |.//*[@id='txtPassword']")).size() != 0;
	System.out.println("MYESOPPassword" + MYESOPPassword1);
if(MYESOPPassword1==true)
{
			Actions actions = new Actions(driver);
		actions.moveToElement(Login_Locator.MYESOPPassword(driver));
		actions.click();
		actions.sendKeys(Password);
		actions.build().perform();

		System.out.println(Password);
		System.out.println("Password "+Password+" Clicked");
}
else
{
	System.out.println("Password "+Password+" Not Clicked"+ test.addScreenCapture(Screenshot.captureImage(driver)));

}
Boolean MYESOPCompanyID1 = driver.findElements(By.id("txtCompanyId")).size() != 0;
System.out.println("MYESOPCompanyID" + MYESOPCompanyID1);
if(MYESOPCompanyID1==true)
{
		Login_Locator.MYESOPCompanyID(driver).clear();
		Thread.sleep(4000);
		Login_Locator.MYESOPCompanyID(driver).sendKeys(CompanyId1);
		Thread.sleep(2000);
		System.out.println(CompanyId1);
		System.out.println("CompanyId1 "+CompanyId1+" Clicked");
}
else
{
	System.out.println("CompanyId1 "+CompanyId1+" Not Clicked"+ test.addScreenCapture(Screenshot.captureImage(driver)));

}
Boolean MYESOPLogin1 = driver.findElements(By.xpath(".//*[@id='btnOk'] |.//*[@id='login_btn']")).size() != 0;
System.out.println("MYESOPLogin" + MYESOPLogin1);
if(MYESOPLogin1==true)
{

		Login_Locator.MYESOPLogin(driver).click();
		Thread.sleep(2000);
		System.out.println("Login button Clicked");
}
else
{
	System.out.println("Login button Not Clicked"+ test.addScreenCapture(Screenshot.captureImage(driver)));

}
Boolean iselementpresent11 = driver.findElements(By.id("txtSecurityQuestion_answer1")).size() != 0;
System.out.println("iselementpresent1" + iselementpresent11);

if (iselementpresent11 == true) 
{
	Boolean SeqAns1 = driver.findElements(By.id("txtSecurityQuestion_answer1")).size() != 0;
	System.out.println("SeqAns1" + SeqAns1);
	if (SeqAns1 == true) {
	Login_Locator.SeqAns1(driver).sendKeys(Ans1);
	Thread.sleep(2000);
	System.out.println("SeqAns1 "+Ans1+" Entered");
	} else {
		System.out.println("SeqAns1 not Entered" + test.addScreenCapture(Screenshot.captureImage(driver)));
	}
	System.out.println(Ans2);	
	
	Boolean SeqAns2 = driver.findElements(By.id("txtSecurityQuestion_answer2")).size() != 0;
	System.out.println("SeqAns2" + SeqAns2);
	if (SeqAns2 == true) {
	Login_Locator.SeqAns2(driver).sendKeys(Ans2);
	Thread.sleep(2000);
	System.out.println("SeqAns2 "+Ans2+"Entered");
	} else {
		System.out.println("SeqAns2 not Entered" + test.addScreenCapture(Screenshot.captureImage(driver)));
	}
	System.out.println(Ans2);
	
	Boolean SubmitAns = driver.findElements(By.id("btnSubmitAnswer")).size() != 0;
	System.out.println("SubmitAns" + SubmitAns);
	if (SubmitAns == true) {
	Login_Locator.SubmitAns(driver).click();
	Thread.sleep(2000);	
	System.out.println("SubmitAns Clicked");
	} else {
		System.out.println("SubmitAns not Clicked" + test.addScreenCapture(Screenshot.captureImage(driver)));
	}
	
	System.out.println("SecurityQuestionAns Submited successfuly");
	System.out.println("SecurityQuestionAns Submited successfuly");
} 
	
else 
{
	test.log(LogStatus.FAIL,
			"SecurityQuestionAns Submition failed" + test.addScreenCapture(Screenshot.captureImage(driver)));
	System.out.println("SecurityQuestionAns Submition failed Or Security Questions not present");
}
if (isAlertPresents()) 
{
	Alert alert = driver.switchTo().alert();
	alert.accept();
}
else
{
	System.out.println("Alert not present"); 
}

	}	
	else 
	{
		test.log(LogStatus.FAIL,
				"SecurityQuestionAns Submition failed" + test.addScreenCapture(Screenshot.captureImage(driver)));
		System.out.println("SecurityQuestionAns Submition failed Or Security Questions not present");
	}
	if (isAlertPresents()) 
	{
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}
	else
	{
		System.out.println("Alert not present"); 
	}
	Boolean EmployeeConcent = driver.findElements(By.id("ctl00_ContentPlaceHolder1_btnMdlNo1")).size() != 0;
	System.out.println("iselementpresent" + EmployeeConcent);

	Thread.sleep(2000);
	if (EmployeeConcent == true) 

	{
		Boolean UserConsent_Checkbox = driver.findElements(By.id("chkConcent")).size() != 0;
		System.out.println("UserConsent_Checkbox" + UserConsent_Checkbox);

		Thread.sleep(2000);
		if (UserConsent_Checkbox == true) 
		{
		EmployeeConcent_Locators.UserConsent_Checkbox(driver).click();
		Thread.sleep(2000);
		System.out.println("Checkbox  present & Clicked");
		System.out.println("Checkbox present & Clicked" + test.addScreenCapture(Screenshot.captureImage(driver)));

	}
		else
		{
		
			System.out.println("Checkbox not present");
			System.out.println("Checkbox not present" + test.addScreenCapture(Screenshot.captureImage(driver)));
		
		}
		Boolean UserConsent_AgreeBtn = driver.findElements(By.xpath("//button[@id='btn1']")).size() != 0;
		System.out.println("UserConsent_AgreeBtn" + UserConsent_AgreeBtn);

		Thread.sleep(2000);
		if (UserConsent_AgreeBtn == true) 
		{
		EmployeeConcent_Locators.UserConsent_AgreeBtn(driver).click();
		Thread.sleep(2000);
		System.out.println("EmployeeContent Accepted");
		}
		else
		{
			System.out.println("Employee concent Agree button not Clicked");
			System.out.println("Employee concent Agree button not Clicked" + test.addScreenCapture(Screenshot.captureImage(driver)));
		
		}
		
	}
	else
	{
		System.out.println("content place holder not found Or  Employee Concent not unable to this employee");
		System.out.println("content place holder not found Or  Employee Concent not unable to this employee");
	}
			// =======ProfileMenu===================
		//	test = report.startTest("ProfileMenu");
	Boolean UserLogo = driver.findElements(By.id("UserLogo")).size() != 0;
		System.out.println("UserLogo" + UserLogo);
		if (UserLogo == true) {
	Profile_menu.UserLogo(driver).click();
	System.out.println("UserLogo Clicked");
	} else {
		System.out.println("UserLogo not Clicked" + test.addScreenCapture(Screenshot.captureImage(driver)));
	}
		
		Boolean Profile = driver.findElements(By.linkText("Profile")).size() != 0;
		System.out.println("Profile" + Profile);
		if (Profile == true) {
	Profile_menu.Profile(driver).click();
	Thread.sleep(2000);
	System.out.println("Profile Clicked");
	} else {
		System.out.println("Profile not Clicked" + test.addScreenCapture(Screenshot.captureImage(driver)));
	}
		

	//DematDetails
 	Boolean DematDetailsDematDetails_tab = driver.findElements(By.id("DematDetails")).size() != 0;
	System.out.println("DematDetailsDematDetails_tab" + DematDetailsDematDetails_tab);
	if (DematDetailsDematDetails_tab == true) {
	Profile_menu.DematDetailsDematDetails_tab(driver).click();
	Thread.sleep(2000);
	System.out.println("DematDetailsDematDetails_tab Clicked");
	} else {
	System.out.println("DematDetailsDematDetails_tab not Clicked" + test.addScreenCapture(Screenshot.captureImage(driver)));
	}
	
	Boolean DematDetailsEdit_btn = driver.findElements(By.xpath("//div[@class='add-demat-acc']//i[@class='fa fa-plus']")).size() != 0;
	System.out.println("DematDetailsEdit_btn" + DematDetailsEdit_btn);
	if (DematDetailsEdit_btn == true) {
	Profile_menu.DematDetailsEdit_btn(driver).click();
	Thread.sleep(2000);
	System.out.println("DematDetailsEdit_btn Clicked");
	} else {
	System.out.println("DematDetailsEdit_btn not Clicked" + test.addScreenCapture(Screenshot.captureImage(driver)));
	}
	if(Profile_menu.Add_DematDetailsDepositoryName_ddl(driver).isEnabled())
	{
		Profile_menu.Add_DematDetailsDepositoryName_ddl(driver).sendKeys(DepositoryName);
	}
	
	if(Profile_menu.Add_DematDetailsDematAccountType_ddl(driver).isEnabled())
	{
		Profile_menu.Add_DematDetailsDematAccountType_ddl(driver).sendKeys(DematAcctype);
	}
	
	if(Profile_menu.Add_DematDetailsDepository_ParticipantName(driver).isEnabled())
	{
		Profile_menu.Add_DematDetailsDepository_ParticipantName(driver).clear();
		Profile_menu.Add_DematDetailsDepository_ParticipantName(driver).sendKeys(DepositoryParticipantName);
	}
	
	if(Profile_menu.Add_DematDetailsDepository_ParticipantId(driver).isEnabled())
	{
		Profile_menu.Add_DematDetailsDepository_ParticipantId(driver).clear();
		Profile_menu.Add_DematDetailsDepository_ParticipantId(driver).sendKeys(DepositoryParticipantID);
	}
	
	if(Profile_menu.Add_DematDetailsClient_DematAccNo(driver).isEnabled())
	{
		Profile_menu.Add_DematDetailsClient_DematAccNo(driver).clear();
		Profile_menu.Add_DematDetailsClient_DematAccNo(driver).sendKeys(ClientDematACNo);
	}
	
	if(Profile_menu.Add_DematDetailsName_DP_Record(driver).isEnabled())
	{
		Profile_menu.Add_DematDetailsName_DP_Record(driver).clear();
		Profile_menu.Add_DematDetailsName_DP_Record(driver).sendKeys(NameRecord);
	}
	Boolean UploadCML = driver.findElements(By.id("UploadfilesCML")).size() != 0;
	System.out.println("UploadCML" + UploadCML);
	if (UploadCML == true) {
	Profile_menu.UploadCMLFile(driver).click();
	 System.out.println("FormFile_Path Clicked");
		
		Thread.sleep(2000);
	StringSelection filePath = new StringSelection(Path);
	Thread.sleep(2000);
	Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filePath, null);

	Robot robot = new Robot();
	// Press Enter

	robot.keyPress(KeyEvent.VK_ENTER);

	// Release Enter
	robot.keyRelease(KeyEvent.VK_ENTER);

	// Press CTRL+V
	robot.keyPress(KeyEvent.VK_CONTROL);
	robot.keyPress(KeyEvent.VK_V);
	Thread.sleep(2000);
	// Release CTRL+V
	robot.keyRelease(KeyEvent.VK_CONTROL);
	robot.keyRelease(KeyEvent.VK_V);
	Thread.sleep(2000);
	// Press Enter
	robot.keyPress(KeyEvent.VK_ENTER);
	robot.keyRelease(KeyEvent.VK_ENTER);

	Thread.sleep(2000);
	Profile_menu.btn_Upload(driver).click();
	 Thread.sleep(500);
	 System.out.println("Upload Button Clicked");
	Thread.sleep(2000);
	System.out.println("UploadCML Uploaded");
	} else {
	System.out.println("UploadCML not Clicked" + test.addScreenCapture(Screenshot.captureImage(driver)));
	}
	

	Boolean Accept_btn = driver.findElements(By.id("btn1")).size() != 0;
	System.out.println("Accept_btn" + Accept_btn);
	if (Accept_btn == true) {
	Profile_menu.UploadAccept_btn(driver).click();
	Thread.sleep(2000);
	System.out.println("Accept_btn Clicked");
	} else {
	System.out.println("Accept_btn not Clicked" + test.addScreenCapture(Screenshot.captureImage(driver)));
	}
	// Switching to Alert    
	Thread.sleep(2000);
   
	
    Boolean Save_btn = driver.findElements(By.xpath("//button[@id='btnAddNow']")).size() != 0;
	System.out.println("Save_btn" + Save_btn);
	if (Save_btn == true) {
		Profile_menu.BtnSaveDematDetails(driver).click();
	
	Thread.sleep(2000);
	System.out.println("Save_btn Clicked");
	} else {
	System.out.println("Save_btn not Clicked" + test.addScreenCapture(Screenshot.captureImage(driver)));
	}
   
	Boolean Accept_btn2 = driver.findElements(By.id("btn1")).size() != 0;
	System.out.println("Accept_btn" + Accept_btn2);
	if (Accept_btn2 == true) {
	Profile_menu.UploadAccept_btn(driver).click();
	Thread.sleep(2000);
	System.out.println("Accept_btn Clicked");
	} else {
	System.out.println("Accept_btn not Clicked" + test.addScreenCapture(Screenshot.captureImage(driver)));
	}
	// Switching to Alert    
	Thread.sleep(2000);
			// ========close browser=================
		//	test = report.startTest("close browser");
	try {
		
		Boolean Logo = driver.findElements(By.xpath(".//*[@id='UserLogo']")).size() != 0;
		System.out.println("Logo" + Logo);
		if (Logo == true) {
		Login_Locator.Logo(driver).click();
		Thread.sleep(2000);
		System.out.println("Logo Clicked");
		} else {
		System.out.println("Logo not Clicked" + test.addScreenCapture(Screenshot.captureImage(driver)));
		}
		
		Boolean Logout = driver.findElements(By.linkText("Logout")).size() != 0;
		System.out.println("Logout" + Logout);
		if (Logout == true) {
		Login_Locator.Logout(driver).click();
		Thread.sleep(2000);
		driver.close();
		Thread.sleep(6000);	
		System.out.println("Logout Clicked");
		} else {
		System.out.println("Logout not Clicked" + test.addScreenCapture(Screenshot.captureImage(driver)));
		}
	//	driver.quit();
	}

	catch (Exception e) {

		e.printStackTrace();
	}					
			}
			else if(browser.equalsIgnoreCase("ie")){
			//set path to ie.exe
			System.setProperty("webdriver.ie.driver","D:\\Testing Team Automation\\SeleniumDriver\\IEDriverServer.exe");
			//create ie instance
			driver = new InternetExplorerDriver();


			

		//	test = report.startTest("URLs");
			driver.get(URLwithoutspace);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			String URL1=driver.getCurrentUrl();
			
			if(URL1.equals(URLwithoutspace))
			{
			System.out.println("Navigated to the specified URL");
			}
			else
			{
			System.out.println("Not Navigated to the UATGlobalUI URL"+ test.addScreenCapture(Screenshot.captureImage(driver)));

			}
			//======Covid 19===============
            if(Login_Locator.COVID(driver).isDisplayed())
            {
                System.out.println("COVID dialogue is displayed");
                Login_Locator.COVID(driver).click();
            }
            else
            {
                System.out.println("COVID dialogue is not displayed");
                System.out.println("alert not present");
            }
			
			// =================Login=================
	//		test = report.startTest("Login");
            Boolean MYESOPUserId = driver.findElements(By.id("txtUserId")).size() != 0;
    		
    		System.out.println("MYESOPUserId" + MYESOPUserId);
    	if(MYESOPUserId==true)
    	{
    		Login_Locator.MYESOPUserId(driver).clear();
    		Thread.sleep(2000);
    		Login_Locator.MYESOPUserId(driver).sendKeys(UserId);
    		Thread.sleep(2000);
    		System.out.println(UserId);
    		System.out.println("UserId "+UserId+" Clicked");
    	}
    	else
    	{
    		System.out.println("UserId "+UserId+" Not Clicked"+ test.addScreenCapture(Screenshot.captureImage(driver)));

    	}
    	Boolean MYESOPPassword = driver.findElements(By.xpath(".//*[@id='txtPassword1'] |.//*[@id='txtPassword']")).size() != 0;
    	System.out.println("MYESOPPassword" + MYESOPPassword);
    if(MYESOPPassword==true)
    {
    			Actions actions = new Actions(driver);
    		actions.moveToElement(Login_Locator.MYESOPPassword(driver));
    		actions.click();
    		actions.sendKeys(Password);
    		actions.build().perform();

    		System.out.println(Password);
    		System.out.println("Password "+Password+" Clicked");
    }
    else
    {
    	System.out.println("Password "+Password+" Not Clicked"+ test.addScreenCapture(Screenshot.captureImage(driver)));

    }
    Boolean MYESOPCompanyID = driver.findElements(By.id("txtCompanyId")).size() != 0;
    System.out.println("MYESOPCompanyID" + MYESOPCompanyID);
    if(MYESOPCompanyID==true)
    {
    		Login_Locator.MYESOPCompanyID(driver).clear();
    		Thread.sleep(4000);
    		Login_Locator.MYESOPCompanyID(driver).sendKeys(CompanyId1);
    		Thread.sleep(2000);
    		System.out.println(CompanyId1);
    		System.out.println("CompanyId1 "+CompanyId1+" Clicked");
    }
    else
    {
    	System.out.println("CompanyId1 "+CompanyId1+" Not Clicked"+ test.addScreenCapture(Screenshot.captureImage(driver)));

    }
    Boolean MYESOPLogin = driver.findElements(By.xpath(".//*[@id='btnOk'] |.//*[@id='login_btn']")).size() != 0;
    System.out.println("MYESOPLogin" + MYESOPLogin);
    if(MYESOPLogin==true)
    {

    		Login_Locator.MYESOPLogin(driver).click();
    		Thread.sleep(2000);
    		System.out.println("Login button Clicked");
    }
    else
    {
    	System.out.println("Login button Not Clicked"+ test.addScreenCapture(Screenshot.captureImage(driver)));

    }
      Boolean iselementpresent1 = driver.findElements(By.id("txtSecurityQuestion_answer1")).size() != 0;
	System.out.println("iselementpresent1" + iselementpresent1);
	Boolean iselementpresent2= driver.findElements(By.id("txtSecurity_answer3")).size() != 0;
	System.out.println("iselementpresent2" +iselementpresent2);
	Thread.sleep(2000);
	if (iselementpresent1 == true) 
	{
		Boolean SeqAns1 = driver.findElements(By.id("txtSecurityQuestion_answer1")).size() != 0;
		System.out.println("SeqAns1" + SeqAns1);
		if (SeqAns1 == true) {
		Login_Locator.SeqAns1(driver).sendKeys(Ans1);
		Thread.sleep(2000);
		System.out.println("SeqAns1 "+Ans1+" Entered");
		} else {
			System.out.println("SeqAns1 not Entered" + test.addScreenCapture(Screenshot.captureImage(driver)));
		}
		System.out.println(Ans2);	
		
		Boolean SeqAns2 = driver.findElements(By.id("txtSecurityQuestion_answer2")).size() != 0;
		System.out.println("SeqAns2" + SeqAns2);
		if (SeqAns2 == true) {
		Login_Locator.SeqAns2(driver).sendKeys(Ans2);
		Thread.sleep(2000);
		System.out.println("SeqAns2 "+Ans2+"Entered");
		} else {
			System.out.println("SeqAns2 not Entered" + test.addScreenCapture(Screenshot.captureImage(driver)));
		}
		System.out.println(Ans2);
		
		Boolean SubmitAns = driver.findElements(By.id("btnSubmitAnswer")).size() != 0;
		System.out.println("SubmitAns" + SubmitAns);
		if (SubmitAns == true) {
		Login_Locator.SubmitAns(driver).click();
		Thread.sleep(2000);	
		System.out.println("SubmitAns Clicked");
		} else {
			System.out.println("SubmitAns not Clicked" + test.addScreenCapture(Screenshot.captureImage(driver)));
		}
		
		System.out.println("SecurityQuestionAns Submited successfuly");
		System.out.println("SecurityQuestionAns Submited successfuly");
	} 
	else if(iselementpresent2==true)
	{
		Boolean Que1 = driver.findElements(By.id("txtSecurity_answer1")).size() != 0;
		System.out.println("Que1" + Que1);
		if (Que1 == true) {
		SequrityQue_Locators.Que1(driver).sendKeys("01");
		Thread.sleep(2000);
		System.out.println("Que1 01 Entered");
		System.out.println("01");
		} else {
			System.out.println("Que1 not Entered" + test.addScreenCapture(Screenshot.captureImage(driver)));
		}
			
		
		Boolean Que2 = driver.findElements(By.id("txtSecurity_answer2")).size() != 0;
		System.out.println("Que2" + Que2);
		if (Que2 == true) {
		SequrityQue_Locators.Que2(driver).sendKeys("01");
		Thread.sleep(2000);
		System.out.println("Que2 01 Entered");
		System.out.println("01");
		} else {
			System.out.println("Que2 not Entered" + test.addScreenCapture(Screenshot.captureImage(driver)));
		}
		Thread.sleep(2000);
		
		Boolean Que3 = driver.findElements(By.id("txtSecurity_answer3")).size() != 0;
		System.out.println("Que3" + Que3);
		if (Que3 == true) {
		SequrityQue_Locators.Que3(driver).sendKeys("01");
		Thread.sleep(2000);
		System.out.println("Que3 01 Entered");
		System.out.println("01");
		} else {
			System.out.println("Que3 not Entered" + test.addScreenCapture(Screenshot.captureImage(driver)));
		}
		
		Boolean Que4 = driver.findElements(By.id("txtSecurity_answer4")).size() != 0;
		System.out.println("Que4" + Que4);
		if (Que4 == true) {
		SequrityQue_Locators.Que4(driver).sendKeys("01");
		Thread.sleep(2000);
		System.out.println("Que4 01 Entered");
		System.out.println("01");
		} else {
			System.out.println("Que4 not Entered" + test.addScreenCapture(Screenshot.captureImage(driver)));
		}
		
		Thread.sleep(2000);
		
		Boolean Que5 = driver.findElements(By.id("txtSecurity_answer5")).size() != 0;
		System.out.println("Que5" + Que5);
		if (Que5 == true) {
		SequrityQue_Locators.Que5(driver).sendKeys("01");
		Thread.sleep(2000);
		System.out.println("Que5 01 Entered");
		System.out.println("01");
		} else {
			System.out.println("Que5 not Entered" + test.addScreenCapture(Screenshot.captureImage(driver)));
		}
		Thread.sleep(2000);
		
		Boolean BtnSubmit = driver.findElements(By.id("btnSubmit")).size() != 0;
		System.out.println("BtnSubmit" + BtnSubmit);
		if (BtnSubmit == true) {
		SequrityQue_Locators.BtnSubmit(driver).click();
		Thread.sleep(2000);				
		System.out.println("BtnSubmit Clicked");
		driver.switchTo().activeElement();
		} else {
			System.out.println("BtnSubmit not Clicked" + test.addScreenCapture(Screenshot.captureImage(driver)));
		}
		
		Boolean PopupBtn = driver.findElements(By.id("btn1")).size() != 0;
		System.out.println("PopupBtn" + PopupBtn);
		if (PopupBtn == true) {
		SequrityQue_Locators.PopupBtn(driver).click();
		driver.close();
		Thread.sleep(6000);
		System.out.println("PopupBtn Clicked");
		} else {
			System.out.println("PopupBtn not Clicked" + test.addScreenCapture(Screenshot.captureImage(driver)));
		}
		
		System.out.println("SecurityQuestionAns Updated successfuly");
		System.out.println("SecurityQuestionAns Updated successfuly");
		
	Boolean MYESOPUserId1 = driver.findElements(By.id("txtUserId")).size() != 0;
		
		System.out.println("MYESOPUserId" + MYESOPUserId1);
	if(MYESOPUserId1==true)
	{
		Login_Locator.MYESOPUserId(driver).clear();
		Thread.sleep(2000);
		Login_Locator.MYESOPUserId(driver).sendKeys(UserId);
		Thread.sleep(2000);
		System.out.println(UserId);
		System.out.println("UserId "+UserId+" Clicked");
	}
	else
	{
		System.out.println("UserId "+UserId+" Not Clicked"+ test.addScreenCapture(Screenshot.captureImage(driver)));

	}
	Boolean MYESOPPassword1 = driver.findElements(By.xpath(".//*[@id='txtPassword1'] |.//*[@id='txtPassword']")).size() != 0;
	System.out.println("MYESOPPassword" + MYESOPPassword1);
if(MYESOPPassword1==true)
{
			Actions actions = new Actions(driver);
		actions.moveToElement(Login_Locator.MYESOPPassword(driver));
		actions.click();
		actions.sendKeys(Password);
		actions.build().perform();

		System.out.println(Password);
		System.out.println("Password "+Password+" Clicked");
}
else
{
	System.out.println("Password "+Password+" Not Clicked"+ test.addScreenCapture(Screenshot.captureImage(driver)));

}
Boolean MYESOPCompanyID1 = driver.findElements(By.id("txtCompanyId")).size() != 0;
System.out.println("MYESOPCompanyID" + MYESOPCompanyID1);
if(MYESOPCompanyID1==true)
{
		Login_Locator.MYESOPCompanyID(driver).clear();
		Thread.sleep(4000);
		Login_Locator.MYESOPCompanyID(driver).sendKeys(CompanyId1);
		Thread.sleep(2000);
		System.out.println(CompanyId1);
		System.out.println("CompanyId1 "+CompanyId1+" Clicked");
}
else
{
	System.out.println("CompanyId1 "+CompanyId1+" Not Clicked"+ test.addScreenCapture(Screenshot.captureImage(driver)));

}
Boolean MYESOPLogin1 = driver.findElements(By.xpath(".//*[@id='btnOk'] |.//*[@id='login_btn']")).size() != 0;
System.out.println("MYESOPLogin" + MYESOPLogin1);
if(MYESOPLogin1==true)
{

		Login_Locator.MYESOPLogin(driver).click();
		Thread.sleep(2000);
		System.out.println("Login button Clicked");
}
else
{
	System.out.println("Login button Not Clicked"+ test.addScreenCapture(Screenshot.captureImage(driver)));

}
Boolean iselementpresent11 = driver.findElements(By.id("txtSecurityQuestion_answer1")).size() != 0;
System.out.println("iselementpresent1" + iselementpresent11);

if (iselementpresent11 == true) 
{
	Boolean SeqAns1 = driver.findElements(By.id("txtSecurityQuestion_answer1")).size() != 0;
	System.out.println("SeqAns1" + SeqAns1);
	if (SeqAns1 == true) {
	Login_Locator.SeqAns1(driver).sendKeys(Ans1);
	Thread.sleep(2000);
	System.out.println("SeqAns1 "+Ans1+" Entered");
	} else {
		System.out.println("SeqAns1 not Entered" + test.addScreenCapture(Screenshot.captureImage(driver)));
	}
	System.out.println(Ans2);	
	
	Boolean SeqAns2 = driver.findElements(By.id("txtSecurityQuestion_answer2")).size() != 0;
	System.out.println("SeqAns2" + SeqAns2);
	if (SeqAns2 == true) {
	Login_Locator.SeqAns2(driver).sendKeys(Ans2);
	Thread.sleep(2000);
	System.out.println("SeqAns2 "+Ans2+"Entered");
	} else {
		System.out.println("SeqAns2 not Entered" + test.addScreenCapture(Screenshot.captureImage(driver)));
	}
	System.out.println(Ans2);
	
	Boolean SubmitAns = driver.findElements(By.id("btnSubmitAnswer")).size() != 0;
	System.out.println("SubmitAns" + SubmitAns);
	if (SubmitAns == true) {
	Login_Locator.SubmitAns(driver).click();
	Thread.sleep(2000);	
	System.out.println("SubmitAns Clicked");
	} else {
		System.out.println("SubmitAns not Clicked" + test.addScreenCapture(Screenshot.captureImage(driver)));
	}
	
	System.out.println("SecurityQuestionAns Submited successfuly");
	System.out.println("SecurityQuestionAns Submited successfuly");
} 
	
else 
{
	test.log(LogStatus.FAIL,
			"SecurityQuestionAns Submition failed" + test.addScreenCapture(Screenshot.captureImage(driver)));
	System.out.println("SecurityQuestionAns Submition failed Or Security Questions not present");
}
if (isAlertPresents()) 
{
	Alert alert = driver.switchTo().alert();
	alert.accept();
}
else
{
	System.out.println("Alert not present"); 
}

	}	
	else 
	{
		test.log(LogStatus.FAIL,
				"SecurityQuestionAns Submition failed" + test.addScreenCapture(Screenshot.captureImage(driver)));
		System.out.println("SecurityQuestionAns Submition failed Or Security Questions not present");
	}
	if (isAlertPresents()) 
	{
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}
	else
	{
		System.out.println("Alert not present"); 
	}
	Boolean EmployeeConcent = driver.findElements(By.id("ctl00_ContentPlaceHolder1_btnMdlNo1")).size() != 0;
	System.out.println("iselementpresent" + EmployeeConcent);

	Thread.sleep(2000);
	if (EmployeeConcent == true) 

	{
		Boolean UserConsent_Checkbox = driver.findElements(By.id("chkConcent")).size() != 0;
		System.out.println("UserConsent_Checkbox" + UserConsent_Checkbox);

		Thread.sleep(2000);
		if (UserConsent_Checkbox == true) 
		{
		EmployeeConcent_Locators.UserConsent_Checkbox(driver).click();
		Thread.sleep(2000);
		System.out.println("Checkbox  present & Clicked");
		System.out.println("Checkbox present & Clicked" + test.addScreenCapture(Screenshot.captureImage(driver)));

	}
		else
		{
		
			System.out.println("Checkbox not present");
			System.out.println("Checkbox not present" + test.addScreenCapture(Screenshot.captureImage(driver)));
		
		}
		Boolean UserConsent_AgreeBtn = driver.findElements(By.xpath("//button[@id='btn1']")).size() != 0;
		System.out.println("UserConsent_AgreeBtn" + UserConsent_AgreeBtn);

		Thread.sleep(2000);
		if (UserConsent_AgreeBtn == true) 
		{
		EmployeeConcent_Locators.UserConsent_AgreeBtn(driver).click();
		Thread.sleep(2000);
		System.out.println("EmployeeContent Accepted");
		}
		else
		{
			System.out.println("Employee concent Agree button not Clicked");
			System.out.println("Employee concent Agree button not Clicked" + test.addScreenCapture(Screenshot.captureImage(driver)));
		
		}
		
	}
	else
	{
		System.out.println("content place holder not found Or  Employee Concent not unable to this employee");
		System.out.println("content place holder not found Or  Employee Concent not unable to this employee");
	}
			// =======ProfileMenu===================
		//	test = report.startTest("ProfileMenu");
	Boolean UserLogo = driver.findElements(By.id("UserLogo")).size() != 0;
		System.out.println("UserLogo" + UserLogo);
		if (UserLogo == true) {
	Profile_menu.UserLogo(driver).click();
	System.out.println("UserLogo Clicked");
	} else {
		System.out.println("UserLogo not Clicked" + test.addScreenCapture(Screenshot.captureImage(driver)));
	}
		
		Boolean Profile = driver.findElements(By.linkText("Profile")).size() != 0;
		System.out.println("Profile" + Profile);
		if (Profile == true) {
	Profile_menu.Profile(driver).click();
	Thread.sleep(2000);
	System.out.println("Profile Clicked");
	} else {
		System.out.println("Profile not Clicked" + test.addScreenCapture(Screenshot.captureImage(driver)));
	}
		

	//DematDetails
 	Boolean DematDetailsDematDetails_tab = driver.findElements(By.id("DematDetails")).size() != 0;
	System.out.println("DematDetailsDematDetails_tab" + DematDetailsDematDetails_tab);
	if (DematDetailsDematDetails_tab == true) {
	Profile_menu.DematDetailsDematDetails_tab(driver).click();
	Thread.sleep(2000);
	System.out.println("DematDetailsDematDetails_tab Clicked");
	} else {
	System.out.println("DematDetailsDematDetails_tab not Clicked" + test.addScreenCapture(Screenshot.captureImage(driver)));
	}
	
	Boolean DematDetailsEdit_btn = driver.findElements(By.xpath("//div[@class='add-demat-acc']//i[@class='fa fa-plus']")).size() != 0;
	System.out.println("DematDetailsEdit_btn" + DematDetailsEdit_btn);
	if (DematDetailsEdit_btn == true) {
	Profile_menu.DematDetailsEdit_btn(driver).click();
	Thread.sleep(2000);
	System.out.println("DematDetailsEdit_btn Clicked");
	} else {
	System.out.println("DematDetailsEdit_btn not Clicked" + test.addScreenCapture(Screenshot.captureImage(driver)));
	}
	if(Profile_menu.Add_DematDetailsDepositoryName_ddl(driver).isEnabled())
	{
		Profile_menu.Add_DematDetailsDepositoryName_ddl(driver).sendKeys(DepositoryName);
	}
	
	if(Profile_menu.Add_DematDetailsDematAccountType_ddl(driver).isEnabled())
	{
		Profile_menu.Add_DematDetailsDematAccountType_ddl(driver).sendKeys(DematAcctype);
	}
	
	if(Profile_menu.Add_DematDetailsDepository_ParticipantName(driver).isEnabled())
	{
		Profile_menu.Add_DematDetailsDepository_ParticipantName(driver).clear();
		Profile_menu.Add_DematDetailsDepository_ParticipantName(driver).sendKeys(DepositoryParticipantName);
	}
	
	if(Profile_menu.Add_DematDetailsDepository_ParticipantId(driver).isEnabled())
	{
		Profile_menu.Add_DematDetailsDepository_ParticipantId(driver).clear();
		Profile_menu.Add_DematDetailsDepository_ParticipantId(driver).sendKeys(DepositoryParticipantID);
	}
	
	if(Profile_menu.Add_DematDetailsClient_DematAccNo(driver).isEnabled())
	{
		Profile_menu.Add_DematDetailsClient_DematAccNo(driver).clear();
		Profile_menu.Add_DematDetailsClient_DematAccNo(driver).sendKeys(ClientDematACNo);
	}
	
	if(Profile_menu.Add_DematDetailsName_DP_Record(driver).isEnabled())
	{
		Profile_menu.Add_DematDetailsName_DP_Record(driver).clear();
		Profile_menu.Add_DematDetailsName_DP_Record(driver).sendKeys(NameRecord);
	}
	Boolean UploadCML = driver.findElements(By.id("UploadfilesCML")).size() != 0;
	System.out.println("UploadCML" + UploadCML);
	if (UploadCML == true) {
	Profile_menu.UploadCMLFile(driver).click();
	 System.out.println("FormFile_Path Clicked");
		
		Thread.sleep(2000);
	StringSelection filePath = new StringSelection(Path);
	Thread.sleep(2000);
	Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filePath, null);

	Robot robot = new Robot();
	// Press Enter

	robot.keyPress(KeyEvent.VK_ENTER);

	// Release Enter
	robot.keyRelease(KeyEvent.VK_ENTER);

	// Press CTRL+V
	robot.keyPress(KeyEvent.VK_CONTROL);
	robot.keyPress(KeyEvent.VK_V);
	Thread.sleep(2000);
	// Release CTRL+V
	robot.keyRelease(KeyEvent.VK_CONTROL);
	robot.keyRelease(KeyEvent.VK_V);
	Thread.sleep(2000);
	// Press Enter
	robot.keyPress(KeyEvent.VK_ENTER);
	robot.keyRelease(KeyEvent.VK_ENTER);

	Thread.sleep(2000);
	Profile_menu.btn_Upload(driver).click();
	 Thread.sleep(500);
	 System.out.println("Upload Button Clicked");
	Thread.sleep(2000);
	System.out.println("UploadCML Uploaded");
	} else {
	System.out.println("UploadCML not Clicked" + test.addScreenCapture(Screenshot.captureImage(driver)));
	}
	

	Boolean Accept_btn = driver.findElements(By.id("btn1")).size() != 0;
	System.out.println("Accept_btn" + Accept_btn);
	if (Accept_btn == true) {
	Profile_menu.UploadAccept_btn(driver).click();
	Thread.sleep(2000);
	System.out.println("Accept_btn Clicked");
	} else {
	System.out.println("Accept_btn not Clicked" + test.addScreenCapture(Screenshot.captureImage(driver)));
	}
	// Switching to Alert    
	Thread.sleep(2000);
   
	
    Boolean Save_btn = driver.findElements(By.xpath("//button[@id='btnAddNow']")).size() != 0;
	System.out.println("Save_btn" + Save_btn);
	if (Save_btn == true) {
		Profile_menu.BtnSaveDematDetails(driver).click();
	
	Thread.sleep(2000);
	System.out.println("Save_btn Clicked");
	} else {
	System.out.println("Save_btn not Clicked" + test.addScreenCapture(Screenshot.captureImage(driver)));
	}
   
	Boolean Accept_btn2 = driver.findElements(By.id("btn1")).size() != 0;
	System.out.println("Accept_btn" + Accept_btn2);
	if (Accept_btn2 == true) {
	Profile_menu.UploadAccept_btn(driver).click();
	Thread.sleep(2000);
	System.out.println("Accept_btn Clicked");
	} else {
	System.out.println("Accept_btn not Clicked" + test.addScreenCapture(Screenshot.captureImage(driver)));
	}
	// Switching to Alert    
	Thread.sleep(2000);
			// ========close browser=================
		//	test = report.startTest("close browser");
	try {
		
		Boolean Logo = driver.findElements(By.xpath(".//*[@id='UserLogo']")).size() != 0;
		System.out.println("Logo" + Logo);
		if (Logo == true) {
		Login_Locator.Logo(driver).click();
		Thread.sleep(2000);
		System.out.println("Logo Clicked");
		} else {
		System.out.println("Logo not Clicked" + test.addScreenCapture(Screenshot.captureImage(driver)));
		}
		
		Boolean Logout = driver.findElements(By.linkText("Logout")).size() != 0;
		System.out.println("Logout" + Logout);
		if (Logout == true) {
		Login_Locator.Logout(driver).click();
		Thread.sleep(2000);
		driver.close();
		Thread.sleep(6000);	
		System.out.println("Logout Clicked");
		} else {
		System.out.println("Logout not Clicked" + test.addScreenCapture(Screenshot.captureImage(driver)));
		}
	//	driver.quit();
	}

	catch (Exception e) {

		e.printStackTrace();
	}	
	
			}
			else{
			//If no browser passed throw exception
			throw new Exception("Browser is not correct");
			}
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			}
		private boolean isAlertPresents() {
			// TODO Auto-generated method stub
			return false;
		}
		

		
		

		/*****************************************
		 * Function to checkCaseToRun
		 * ************************************************** Annotation
		 * : @AfterMethod
		 * 
		 * DESCRIPTION :
		 * 
		 * 1.@AfterMethod method will be executed after execution of @Test method
		 * every time.
		 * 
		 * 
		 * FUNCTION NAME : reporterDataResults()
		 * 
		 * 
		 * DESCRIPTION : This function is used to
		 * 
		 * 1.It writes Pass/Fail/Skip in excel sheet
		 * 
		 * 
		 * HISTORY : AUTHOR DATE VERSION
		 * 
		 * CREATED BY : Vasanti 6-JUNE-2016 1.0
		 *
		 ***************************************** Function to checkCaseToRun
		 **************************************************/
}
