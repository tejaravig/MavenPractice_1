package com.testBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	public static WebDriver driver;
	public Logger logger;
	public Properties p;
	
	
	@BeforeClass(groups= {"Sanity","Regression","Master"})
	@Parameters({"os","browser"})
	public void setup(String os , String br) throws Exception
	{
		
		
		// LOADING CONFIG.PROPERTIES FILE
		
		FileReader file = new FileReader("./src//test//resources//config.properties"); // (.//)is representing the current project location.
		p=new Properties();
		p.load(file);
		
		
		logger = LogManager.getLogger(this.getClass());  //log4j2
		
		/*if (p.getProperty("execution_env").equalsIgnoreCase("remote")) {  //grid using remote

		    DesiredCapabilities capabilities = new DesiredCapabilities();

		    // OS
		    if (os.equalsIgnoreCase("windows")) {
		        capabilities.setPlatform(Platform.WIN11);
		    } 
		    else if (os.equalsIgnoreCase("mac")) {
		        capabilities.setPlatform(Platform.MAC);
		    } 
		    else {
		        System.out.println("no matching os");
		        return;
		    }

		    // Browser
		    switch (br.toLowerCase()) {
		        case "chrome":
		            capabilities.setBrowserName("chrome");
		            break;

		        case "edge":
		            capabilities.setBrowserName("MicrosoftEdge");
		            break;

		        case "firefox":
		            capabilities.setBrowserName("firefox");
		            break;

		        default:
		            System.out.println("no matching browser");
		            return;
		    }

		    // ✅ FIXED URL (hub -> HUB is wrong in latest grid)
		    driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);
		}
		
		*/


		// Local execution
		
		//if (p.getProperty("execution_env").equalsIgnoreCase("local")) {

		    switch (br.toLowerCase()) {
		        case "chrome":
		            driver = new ChromeDriver();
		            break;

		        case "edge":
		            driver = new EdgeDriver();
		            break;

		        case "firefox":
		            driver = new FirefoxDriver();
		            break;

		        default:
		            System.out.println("Invalid browser name..");
		            return;
		    }
		    
		    
	//}
		
		
		WebDriverManager.chromedriver().setup();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.manage().window().maximize();
		//driver.get("https://tutorialsninja.com/demo/index.php?route=common/home");
		
		driver.get(p.getProperty("appURL"));  // reading url from properties file.
	}
	
	@AfterClass(groups= {"Sanity","Regression","Master"})
	public void tearDown()
	{
		driver.quit();
	}

	
	//To run randomly generated the details
	
	public String randomString() 
	{
		String generatedstring = RandomStringUtils.randomAlphabetic(3);
		return generatedstring;
	}
	
	public String randomNumber()
	{
		String generatednumber = RandomStringUtils.randomNumeric(5);
		return generatednumber;
	}
	
	public String randomAlphaNumaric()
	{
		String genetaredstring = RandomStringUtils.randomAlphabetic(3);
		String genaratedstring = RandomStringUtils.randomNumeric(3);
		return(genetaredstring+genaratedstring);
	}
	
	
	//screenshot method
	
			public String captureScreen(String testName) throws IOException {

			    String timeStamp = new java.text.SimpleDateFormat("yyyyMMddHHmmss")
			            .format(new java.util.Date());

			    TakesScreenshot ts = (TakesScreenshot) driver;
			    File source = ts.getScreenshotAs(OutputType.FILE);

			    String targetPath = System.getProperty("user.dir")
			            + "/screenshots/" + testName + "_" + timeStamp + ".png";

			    File targetFile = new File(targetPath);
			    org.apache.commons.io.FileUtils.copyFile(source, targetFile);

			    return targetPath;
			}
			
	
}
	

 
 
