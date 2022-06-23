package com.EOD.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.EOD.pageObjects.LoginPage;
import com.EOD.testBase.BaseClass;

public class TC_LoginTest_001 extends BaseClass {
	
	
	
	
	
	@Test
	public void loginTest() throws InterruptedException
	{
		
		
		logger.info("**************TC_LoginTest_001 Starting***************");
		
		
		driver.get(configPropObj.getProperty("baseURL"));
		
		LoginPage lp=new LoginPage(driver);
		
		logger.info("**************Providing login details*************");
		
		lp.setUserName(configPropObj.getProperty("userName"));
		lp.setPassword(configPropObj.getProperty("password"));
		lp.ClickLogin();   
		//Thread.sleep(5000);
		//lp.Display_link();
		//lp.ReValidate();
		
		
		
		
		/*String exp_title="PDA";
		String act_title=driver.getTitle();
		
		if(exp_title.equals(act_title))
		{
			logger.info("**********TC_LoginTest_001 Passed*************");
			Assert.assertTrue(true);
		}
		else
		{
			logger.info("**********TC_LoginTest_001 failed*************");
			Assert.assertTrue(false);
		}
		
		logger.info("**********TC_LoginTest_001 Completed*************");*/
			
		
		//driver.get("https://www.google.com/");
		
		
		/*public void ReValidate()
		{
			
			for(int i=0;i<=SecureWeblinks.size();i++)
			{
				driver.navigate().to(SecureWeblinks.get(i));
				//driver.findElement(By.name("q")).sendKeys(SecureWeblinks[i]);
				String act_title=driver.getTitle();
				String exp_title="Login";
				
				if(act_title.equals(exp_title))
				{
					
					Assert.assertTrue(true);
				}
				
				else
				{
					Assert.assertTrue(false);
				}
				
			}*/
			
	}
	
	

	
	
	
}
