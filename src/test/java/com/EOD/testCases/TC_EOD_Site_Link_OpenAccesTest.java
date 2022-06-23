package com.EOD.testCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.EOD.pageObjects.OPS_Page_links;
import com.EOD.testBase.BaseClass;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC_EOD_Site_Link_OpenAccesTest extends OPS_Page_links{
	
	
	public TC_EOD_Site_Link_OpenAccesTest(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@Test
	public void Test_EOD_Links()
	{
		WebDriver driver;
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		
		OPS_Page_links OPL=new OPS_Page_links(driver);
		
		
		String exp_titile="Login";
		String act_title;
		for(int i=0; i<this.Sl_Map.size();i++)
		{
			String PreTestUrl=(String) this.Sl_Map.get(i);
			driver.get(PreTestUrl);
			act_title=driver.getTitle();
			
			if(act_title.equals(exp_titile))
			{
				System.out.println(PreTestUrl);
				System.out.println("******Validation Passed*******");
				
			}
			
			else
				System.out.println(PreTestUrl);
				System.out.println("*******Validation Failed*******");
			
		}
		
	 
	}
	
	
	

}
