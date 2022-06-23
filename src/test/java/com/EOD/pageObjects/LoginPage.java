package com.EOD.pageObjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginPage 
{
	
	public WebDriver driver;
	
	public List<String> SecureWeblinks=new ArrayList<String>();
	
	
		public LoginPage(WebDriver driver)
		{
			
			this.driver=driver;
			
			PageFactory.initElements(this.driver, this);
			
		}
		
	
		@FindBy(id="txtUserName")
		@CacheLookup
		WebElement txtusername;
		
		@FindBy(id="txtPassword")
		@CacheLookup
		WebElement txtpassword;
		
		@FindBy(id="btnLogin")
		WebElement btnlogin;
		
		@FindBy(id="HeaderControl_lnkLogout")
		WebElement lnklogout;
		
		@FindBy(tagName="a")		
		List<WebElement> alllinks;
			
		public void setUserName(String uname)
		{
			txtusername.clear();
			txtusername.sendKeys(uname);
		}
	
		public void setPassword(String pwd)
		{
			txtpassword.clear();
			txtpassword.sendKeys(pwd);
		}
		
	
		public void ClickLogin()
		{
			btnlogin.click();
		}
		
		public void ClickLogout()
		{
			lnklogout.click();
		}
		
		
		
		
		
		
		/*public void Display_link()
		{
			int i=1;
			try
			{
				for(WebElement e:alllinks)
				{
					String url=e.getText()+"-"+e.getAttribute("href");
					String S_links=e.getAttribute("href");
					System.out.println(url);
					
					SecureWeblinks.add(S_links);
					i++;				
					
									
				}
			}
			catch(Exception e) 
			{
				System.out.println(e);
			}
			
		
		
		}*/
		
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
				
			}
		}*/
	
	
	
}
