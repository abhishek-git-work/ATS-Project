package org.ATS.utilities;

import java.io.File;
import java.io.IOException;

import org.ATS.baseClass.baseClass;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;



public class ScreenshotMethod extends baseClass{
	
	
	public static String takeScreenshotMethod(String testname) throws IOException
	{
		File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String destination = ("Screenshots//Test-"+testname+" "+TimestampMethod.getLocalDateTime()+".jpeg");
		FileHandler.copy(source, new File(destination));
		
		return destination;
	}
	
	

}
