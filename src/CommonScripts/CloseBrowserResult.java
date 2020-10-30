package CommonScripts;

import java.io.IOException;

import com.relevantcodes.extentreports.LogStatus;

import TestSuiteBase.SuiteBase;
import Utility.Read_XLS;
import Utility.SuiteUtility;

public class CloseBrowserResult extends  SuiteBase{
		
		public static void browser(boolean testCasePass, String testCaseName, Read_XLS filePath, String sheetName) throws InterruptedException, IOException
		{
			if(testCasePass){
				Add_Log.info(testCaseName+" : Reporting test case as PASS In excel.");
				//test.log(LogStatus.PASS,testCaseName + test.addScreenCapture(Screenshot.captureImage(OpenBrowser.driver)));
				test.log(LogStatus.PASS,testCaseName);
				SuiteUtility.WriteResultUtility(filePath, sheetName, "Pass/Fail/Skip", testCaseName, "PASS");
				Thread.sleep(1000);
			
			}
			else{
				Add_Log.info(testCaseName+" : Reporting test case as FAIL In excel.");
				//test.log(LogStatus.FAIL,testCaseName + test.addScreenCapture(Screenshot.captureImage(OpenBrowser.driver)));
				test.log(LogStatus.FAIL,testCaseName);
				SuiteUtility.WriteResultUtility(filePath, sheetName, "Pass/Fail/Skip", testCaseName, "FAIL");
				Thread.sleep(1000);
			
			}
			
			report.endTest(test);
			report.flush();
		}

	
	}
