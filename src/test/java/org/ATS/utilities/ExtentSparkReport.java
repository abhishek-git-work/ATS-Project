package org.ATS.utilities;

import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentSparkReport {
	
	public static ExtentReports generateExtentReport()
	{
		ExtentReports extentreport = new ExtentReports();
		File reportfile = new File("extentReport.html");
		ExtentSparkReporter sparkreport = new ExtentSparkReporter(reportfile);
		extentreport.attachReporter(sparkreport);
		
//design report (optional)
		sparkreport.config().setTheme(Theme.DARK);
		sparkreport.config().setReportName("ATS Test Project Report");
		sparkreport.config().setDocumentTitle("ATS Report");
		sparkreport.config().setTimeStampFormat("dd/MM/yyyy hh:mm:ss");
				
		return extentreport;		
	}

}
