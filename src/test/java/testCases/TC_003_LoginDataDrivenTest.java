package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.pageObjects.HomePage;
import com.pageObjects.LoginPage;
import com.pageObjects.MyAccountPage;
import com.testBase.BaseClass;

import utilities.DataProviders;

public class TC_003_LoginDataDrivenTest extends BaseClass
{
	@Test(dataProvider="LoginData", dataProviderClass=DataProviders.class,groups="DataDriven")//getting dataprovider form diff class//getting dataprovider from same class "dataProviderClass=DataProviders.class"this is not require.
	public void Verify_LoginDDT_Test(String email,String pwd,String expec) throws Exception
	{
		
		logger.info("*** Started TC_003_LoginDataDrivenTest..****");
		
		try
		{
	
		//homepage
		
				HomePage hp = new HomePage(driver);
				hp.clickMyAccount();
				hp.clickLogin();
				
				//login page
				
				LoginPage lp = new LoginPage(driver);
				
				lp.setEmailaddress(email);
				lp.setPassword(pwd);
				lp.clickLogin();
				
				//myAccount page
				
				MyAccountPage map = new MyAccountPage(driver);
				boolean targetPage=map.isMyAccountPageExists();
		
				
				/* Data is valid -login success - test pass -logout
				                login failed -test fail
				                 
				               
				 * Data is invalid - login success - test fail - logout
				 *                   login failed - test pass
				 */
				
				if(expec.equalsIgnoreCase("valid"))
				{
					if(targetPage ==true)
					{
					map.clickLogout();
					Assert.assertTrue(true);
					
				}
					else
					{
						Assert.assertTrue(false);
					}
				}
				
				if(expec.equalsIgnoreCase("invalid"))
				{
					if(targetPage ==true)
					{
						map.clickLogout();
						Assert.assertTrue(false);
					}
					else
					{
						Assert.assertTrue(true);
					}
		
	
				   }
		         }
		          catch(Exception e)
		         {
			      Assert.fail();
		      }
		         Thread.sleep(2000);
	             logger.info("*** Finished TC_003_LoginDataDrivenTest..*****");
	
	       }
	
        }
	
		
	
	


