package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.pageObjects.AccountRegistrationPage;
import com.pageObjects.HomePage;
import com.testBase.BaseClass;

public class TC_001_AccountRegestrationTest extends BaseClass {
	   
	
	@Test(groups={"Regression","Master"})
	public void Verify_Account_Regestration()
	{
		logger.info("****** Starting TC001_AccountRegestrationTest ******");
		
		try
		{
		
		HomePage hp = new HomePage(driver);
		
		hp.clickMyAccount();
		hp.clickRegster();
		
		AccountRegistrationPage regpage = new AccountRegistrationPage(driver);
		String password = randomAlphaNumaric();
		
		logger.info("*** Providing the customer details ...***");
		
		regpage.setFirstName(randomString().toUpperCase());
		regpage.setLastName(randomString().toUpperCase());
		regpage.setEmail(randomString() +"@gmail.com");
		regpage.setPassword(password);
		regpage.setConfirmPassword(password);
		regpage.setTelephone(randomNumber());
		regpage.setPrivacyPolicy();
		regpage.clickContinue();
		
		logger.info("Validating Expected Message....");
		
		String confmsg= regpage.getConfirmationMsg();
		Assert.assertEquals(confmsg,"Your Account Has Been Created!");
		if(confmsg.equals("Your Account Has Been Created!"))
			
			//logger.info("Test Pased");
		{
			Assert.assertTrue(true);
		}
		else
		{
			logger.error("Test failed ..");
			logger.debug("Debug logs ..");
			Assert.assertFalse(false);
		}
		
		//Assert.assertEquals(confmsg, "Your Account Has Been Created!");
	}
		catch(Exception e) 
		{
			//logger.info("Test failed:" +e.getMessage());
			Assert.fail();
		}
		
		
		logger.info("**** Finished TC001_AccountRegestrationTest **");
	}

}







