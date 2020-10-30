package Utility;

public class SuiteUtility {
	

/******************************************************************************************
* HISTORY          :   AUTHOR                  	DATE            	VERSION
* 
* CREATED BY       :   Vasanti			6-JUNE-2016     	1.0
*
*******************************************************************************************/	
		
public static boolean checkToRunUtility(Read_XLS xls, String sheetName, String ToRun, String testSuite){
		
		
	boolean Flag = false;	
		String fl = xls.retrieveToRunFlag(sheetName,ToRun,testSuite);
		System.out.println("run flag - "+ fl+ sheetName +ToRun+testSuite);
		if(xls.retrieveToRunFlag(sheetName,ToRun,testSuite).equalsIgnoreCase("y")){
			Flag = true;
		}
		else{
			Flag = false;
		}
		return Flag;		
	}
	
	public static String[] checkToRunUtilityOfData(Read_XLS xls, String sheetName, String ColName){
		
		return xls.retrieveToRunFlagTestData(sheetName,ColName);		 	
	}
 
	public static Object[][] GetTestDataUtility(Read_XLS xls, String sheetName){
	 	return xls.retrieveTestData(sheetName);	
	}
 
	public static boolean WriteResultUtility(Read_XLS xls, String sheetName, String ColName, int rowNum, String Result){			
		return xls.writeResult(sheetName, ColName, rowNum, Result);		 	
	}
 
	public static boolean WriteResultUtility(Read_XLS xls, String sheetName, String ColName, String rowName, String Result){			
		return xls.writeResult(sheetName, ColName, rowName, Result);	 	
	}

/******************************************************************************************
* HISTORY          :   AUTHOR                  	DATE            	VERSION
* 
* CREATED BY       :   Vasanti			6-JUNE-2016     	1.0
*
*******************************************************************************************/	

}


