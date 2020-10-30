package TestScripts;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.google.common.io.Files;

public class Screenshot {

	public static String captureImage(WebDriver driver) throws IOException {
	
		TakesScreenshot srcShot = ((TakesScreenshot)driver);
		File srcFile = srcShot.getScreenshotAs(OutputType.FILE);
		File destFile = new File("D:\\Testing Team Automation\\SanityTesting\\src\\Screenshots\\"+System.currentTimeMillis()+".png");
		String errorFilePath = destFile.getAbsolutePath();
		Files.copy(srcFile, destFile);
		return errorFilePath;
	

		}
}