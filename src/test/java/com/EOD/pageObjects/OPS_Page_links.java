package com.EOD.pageObjects;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.EOD.testBase.BaseClass;



public class OPS_Page_links{
	
	public WebDriver driver;
	//public List<String> SecureWeblinks=new ArrayList<String>();
	
	public HashMap Sl_Map= new HashMap();
	

	public OPS_Page_links(WebDriver driver)
	{
		
		this.driver=driver;
		
		PageFactory.initElements(this.driver, this);
		
	}
	
		@FindBy(tagName="a")	
		List<WebElement> alllinks;
	
	
	@Test
	public void Display_link()
	{
		int i=0;
		try
		{
			for(WebElement e:alllinks)
			{
				String url=e.getText()+"-"+e.getAttribute("href");
				String S_links=e.getAttribute("href");
				System.out.println(url);
				
				//SecureWeblinks.set(i, S_links);
				
				Sl_Map.put(i, S_links);
				i++;				
				
								
			}
			
			System.out.println("Total number of Secure links available in EOD site:"+ Sl_Map.size());
			System.out.println("****Printing from Secure Links List****");
			
			//Creating Excel sheet to generate and store test data
			
			File excelFile=new File("C:\\Users\\radhe.shyam\\eclipse-workspace\\EOD_Site_Security_V001\\testData\\EOD_Security_Test_Data1.xlsx");
			FileOutputStream fileOut= new FileOutputStream(excelFile);
			
			XSSFWorkbook workbook=new XSSFWorkbook();
			XSSFSheet sheet=workbook.createSheet("EOD_Data");
			
					
			for(int j=0;j<=Sl_Map.size();j++)
			{
				String Sec_links= (String) Sl_Map.get(j);
				System.out.println(Sec_links);
				
				int c=0;
				XSSFRow row=sheet.createRow(j);
				String EOD_Link= (String) Sl_Map.get(j);
				row.createCell(c).setCellValue(EOD_Link);
			
				
			}
			
			workbook.write(fileOut);
			fileOut.close();
			System.out.println("After validation Total number of Secure links available in EOD site:"+ Sl_Map.size());
		}
		catch(Exception e) 
		{
			System.out.println(e);
		}
		
	
	
	}
	
	/*public void ReValidate() throws InterruptedException
	{
		
		System.out.println("Printing from Revalidation");
		
		for(int i=0;i<=SecureWeblinks.size();i++)
		{
			
			
			driver.get("https://www.google.com");
			driver.findElement(By.name("q")).sendKeys(SecureWeblinks.get(i));
			
			Thread.sleep(1000);
			
			//driver.navigate().to(SecureWeblinks.get(i));
			
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
