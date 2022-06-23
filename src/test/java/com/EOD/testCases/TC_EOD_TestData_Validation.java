
/*
 * Workbook-->XSSFWorkBook
 * Sheet-->XSSFSheet
 * Row-->XSSFRow
 * Cell-->XSSFCell
 */

package com.EOD.testCases;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.EOD.pageObjects.LoginPage;
import com.EOD.pageObjects.OPS_Page_links;
import com.EOD.testBase.BaseClass;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC_EOD_TestData_Validation{
	
	WebDriver driver;
	
	
	
	@Test
	public void EOD_TestData() throws IOException
	{
		
			FileInputStream file=new FileInputStream("C:\\Users\\radhe.shyam\\eclipse-workspace\\EOD_Site_Security_V001\\testData\\EOD_Security_Test_Data.xlsx");
			
			XSSFWorkbook workbook=new XSSFWorkbook(file);
			XSSFSheet sheet=workbook.getSheet("Sheet1");
			
			int row_count=sheet.getLastRowNum();
			int col_count=sheet.getRow(0).getLastCellNum();
			
			System.out.println("Number of Rows"+ row_count);
			System.out.println("Number of Column "+col_count);		
		
				System.out.println("Printing before row loop");
				for(int r=0;r<=row_count;r++)
				{
					//System.out.println("Printing from row loop");
					
					XSSFRow row=sheet.getRow(r);
					int c=0;
					//System.out.println("Printing from inner loop");
					DataFormatter format=new DataFormatter();
					XSSFCell cell=row.getCell(c);
					String cellData=String.valueOf(cell.getStringCellValue());
					//String cellData=format.formatCellValue(cell);
					System.out.println("Cell data  "+cellData);
					
					//Launching web browser
					
					WebDriverManager.chromedriver().setup();
					driver=new ChromeDriver();
					driver.get(cellData);
					
					String act_title=driver.getTitle();
					String exp_title="Login";
					
					if(act_title.equals(exp_title))
					{
						System.out.println("Secured Link::  "+cellData);
					}
					
					else
					{
						System.out.println("Not a Secured Link::  "+cellData);
					}
					
					driver.quit();
					
					/*for(int c=0;c<=col_count;c++)
					{
						System.out.println("Printing from inner loop");
						DataFormatter format=new DataFormatter();
						XSSFCell cell=row.getCell(c);
						
						String cellData=String.valueOf(cell.getStringCellValue());
						
						//String cellData=cell.getStringCellValue();
						//String cellData=format.formatCellValue(cell);				
						System.out.println("Cell data"+cellData);
						
					}*/
				}
		
	}

}
