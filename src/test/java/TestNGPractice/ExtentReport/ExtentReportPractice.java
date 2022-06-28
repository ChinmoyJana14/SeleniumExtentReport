package TestNGPractice.ExtentReport;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportPractice {	
	ExtentReports extentReports;	
	@BeforeTest
	public void config() {
		String path = System.getProperty("user.dir") +"\\reports\\index.html";
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(path);
		sparkReporter.config().setDocumentTitle("Test Results");
		sparkReporter.config().setReportName("Chinmoy Selenium Practice Test Results");
		extentReports = new ExtentReports();
		extentReports.attachReporter(sparkReporter);
		extentReports.setSystemInfo("Chinmoy", "Automation Tester");		
	}	
	@Test
	public void Intitial() {
		extentReports.createTest("Intitial");
		System.setProperty("webdriver.chrome.driver", "E:\\Software\\Grid\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();	
		driver.get("https://www.amazon.com/");
		driver.manage().window().maximize();
		System.out.println(driver.getTitle());
		extentReports.flush();
	}

}
