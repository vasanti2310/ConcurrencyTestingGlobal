package TestScripts;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.relevantcodes.extentreports.LogStatus;

import BaseClasses.Login_BaseClass;
import Locators.EmployeeConcent_Locators;
import Locators.Login_Locator;
import Locators.Profile_menu;
import Locators.SequrityQue_Locators;

public class EdgeBrwsr extends Login_BaseClass{
	@BeforeTest
	@Parameters({"browser","UserId","Password","NewPassword","companyid","URL","Ans1","Ans2","Path","DepositoryName","DematAcctype","DepositoryParticipantName","DepositoryParticipantID","ClientDematACNo","NameRecord"})

	public void EDGEBrowserRun(String browser,String UserId, String Password, String NewPassword, String companyid, String URL,
	 String Ans1, String Ans2, String Path,String	DepositoryName,String DematAcctype,
	 String DepositoryParticipantName,String DepositoryParticipantID,String ClientDematACNo,String NameRecord) throws Exception {
		System.out.println("Demo Start");
		
		 WebDriver driver;
			
				System.out.println("URL " + URL);
				String URLwithoutspace = URL.replaceAll("\\s", "");
				String CompanyId1 = companyid.toUpperCase();
				
				
				if(browser.equalsIgnoreCase("Edge"))
				{
					System.setProperty("webdriver.edge.driver", "D:\\Testing Team Automation\\SeleniumDriver\\msedgedriver.exe");
					 driver = new EdgeDriver();

					 driver.get("https://demoqa.com");
					 Thread.sleep(3000);
					 driver.quit();
					 System.out.println("Execution complete");
				}	
		}
			private boolean isAlertPresents() {
				// TODO Auto-generated method stub
				return false;
			}}
