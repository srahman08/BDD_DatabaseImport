package base;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestBase {
	
	public static WebDriver driver;
	 public TestBase() {
	 }
	 public static void initializeDriver() {
	  System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
	  driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.manage().deleteAllCookies();
	  driver.manage().timeouts().pageLoadTimeout(2, TimeUnit.SECONDS);
	  driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	  driver.get("https://techfios.com/billing/?ng=admin/");
	 }
	
	 public void takeScreenshotAtEndOfTest(WebDriver driver) throws IOException {
		  TakesScreenshot ts = ((TakesScreenshot) driver);
		  SimpleDateFormat formatter = new SimpleDateFormat("MMddyy_HHmmss");
		  Date date = new Date();
		  String label = formatter.format(date);
		  File sourceFile = ts.getScreenshotAs(OutputType.FILE);
		  String currentDir = System.getProperty("user.dir");
		  FileUtils.copyFile(sourceFile, new File(currentDir + "/screenshots/" + label + ".png"));
		 }
	 
}
