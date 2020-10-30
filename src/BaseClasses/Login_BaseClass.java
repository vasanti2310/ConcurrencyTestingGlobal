
package BaseClasses;
import org.testng.SkipException;
import org.testng.annotations.BeforeSuite;
import TestSuiteBase.SuiteBase;
import Utility.Read_XLS;
import Utility.SuiteUtility;

public class Login_BaseClass extends SuiteBase
{
	Read_XLS ExcelPath = null;
	String SheetName = null;
	String SuiteName = null;
	String ToRunColumnName = null;	

/***************************************** Function to checkSuiteToRun  **************************************************
* Annotation	   :   @BeforeSuite
* 
* DESCRIPTION		: 
*                     
* 					  1.@BeforeSuite before any tests declared inside a TestNG suite are run.
* 					
* 
* FUNCTION NAME    :   checkSuiteToRun()
* 
* 
* DESCRIPTION      :   This function is used to  
*                    
*                      1.This function will be executed before SuiteOne's test cases to check SuiteToRun flag.
*					   2.To set TestSuiteList.xls file's path In FilePath Variable.
*                       3.Insert log In applog.log file.
*                       4.To report Pass/Fail/Skip
* HISTORY          :   AUTHOR                  	DATE            	VERSION
* 
* CREATED BY       :   Vasanti			6-JUNE-2016     	1.0
*
*****************************************  Function to checkSuiteToRun  
 * @throws Exception **************************************************/	

	@BeforeSuite
	public void checkSuiteToRun() throws Exception{
		
	init();	

		System.out.println("Init in MyEsopsLogin base");
		//To set TestSuiteList.xls file's path In FilePath Variable.
		ExcelPath = TestSuiteListExcel;
		SheetName = "SuitesList";
		SuiteName = "MyEsopsLogin";
		ToRunColumnName = "SuiteToRun";
		//Bellow given syntax will Insert log In applog.log file.
				Add_Log.info("Execution started for MyEsopsLogin.");
				
				//If SuiteToRun !== "y" then SuiteOne will be skipped from execution.
				if(!SuiteUtility.checkToRunUtility(ExcelPath, SheetName,ToRunColumnName,SuiteName)){			
					Add_Log.info("SuiteToRun = N for "+SuiteName+" So Skipping Execution.");
					//To report SuiteOne as 'Skipped' In SuitesList sheet of TestSuiteList.xls If SuiteToRun = N.
					SuiteUtility.WriteResultUtility(ExcelPath, SheetName, "Skipped/Executed", SuiteName, "Skipped");
					//It will throw SkipException to skip test suite's execution and suite will be marked as skipped In testng report.
					throw new SkipException(SuiteName+"'s SuiteToRun Flag Is 'N' Or Blank. So Skipping Execution Of "+SuiteName);
				}
				//To report SuiteOne as 'Executed' In SuitesList sheet of TestSuiteList.xls If SuiteToRun = Y.
				SuiteUtility.WriteResultUtility(ExcelPath, SheetName, "Skipped/Executed", SuiteName, "Executed");		
			
}
	

}
