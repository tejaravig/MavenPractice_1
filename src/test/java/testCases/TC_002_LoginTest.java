package testCases;

import org.testng.annotations.Test;

import com.pageObjects.HomePage;
import com.pageObjects.LoginPage;
import com.pageObjects.MyAccountPage;
import com.testBase.BaseClass;

import junit.framework.Assert;

public class TC_002_LoginTest extends BaseClass {
	
	@Test(groups={"Sanity","Master"})
	public void  Verify_Login_Test()
	{
		
		logger.info("*** Staring TC_002_LoginTest.. ****");
		
		try
		{
		//homepage
		
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLogin();
		
		//login page
		
		LoginPage lp = new LoginPage(driver);
		
		lp.setEmailaddress(p.getProperty("email"));
		lp.setPassword(p.getProperty("password"));
		lp.clickLogin();
		
		//myAccount page
		
		MyAccountPage map = new MyAccountPage(driver);
		boolean targetPage=map.isMyAccountPageExists();
		
		Assert.assertTrue(targetPage); //Assert.assertEquals(targetpage,true,"Login failed");
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		logger.info("*** Finished TC_002_LoginTest..*** ");
		
	}

}
