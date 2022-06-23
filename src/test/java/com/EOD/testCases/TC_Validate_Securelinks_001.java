package com.EOD.testCases;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import com.EOD.pageObjects.LoginPage;
import com.EOD.pageObjects.OPS_Page_links;
import com.EOD.testBase.BaseClass;





public class TC_Validate_Securelinks_001 extends BaseClass{
	
		@Test
		public void SecureLink_validation() throws InterruptedException
		{
			
			logger.info("****Starting Secure Link Validation Test****");
			
			driver.get(configPropObj.getProperty("baseURL"));
			
			
			LoginPage lp=new LoginPage(driver);
			OPS_Page_links Alllinks=new OPS_Page_links(driver);
			TC_EOD_Site_Link_OpenAccesTest OAT=new TC_EOD_Site_Link_OpenAccesTest(driver);
			
			
			logger.info("**************Providing login details*************");
			
			lp.setUserName(configPropObj.getProperty("userName"));
			lp.setPassword(configPropObj.getProperty("password"));
			lp.ClickLogin();
						//Thread.sleep(5000);
			//lp.ClickLogout();
			Alllinks.Display_link();
			//Thread.sleep(3000);
			// lp.ClickLogout();
			//driver.close();
			
			lp.ClickLogout();
			
			//logger.info("**************Displaying Secure link list*************");
			//Alllinks.Display_link();
			//OAT.Test_EOD_Links();
			//driver.quit();
			//logger.info("**************Validating Secure links*************");
			//Alllinks.ReValidate();
			
			
		}
		
		
	
}
