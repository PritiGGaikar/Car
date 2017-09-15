package common_Function;

import java.io.File;  
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * @author Amit
 *
 */
public class loginpage extends RW 
{ 	
	
	 
	public String Login(WebDriver driver1) throws Exception
	{
		 WebDriver driver=driver1;  
				
		 
	
		 
		 
	     driver.findElement(By.id(jibe_config.getData(2, 1, 2))).sendKeys(jibe_config.getData(1,1,0));  // Read username from excelsheet
	     Thread.sleep(1000);	   
		 driver.findElement(By.id(jibe_config.getData(2, 2, 2))).sendKeys(jibe_config.getData(1,1,1)); //   Read Password from excelsheet
		 Thread.sleep(1000);	   
	     driver.findElement(By.id(jibe_config.getData(2, 3, 2))).click(); 				    //  Read login button  from excelsheet
	     Thread.sleep(1000);
	     String title = driver.getTitle().trim();         // Get trim title from web.
	     
	
	     
	     
	       //System.out.println("Successfully logged in " + title);
	   // WebElement<list>  =driver.findElement(By.xpath("//*[contains(text(),'Log Out')]"));
	  
	    // Assert.assertEquals("Text not found!",List);
	    //Get the page load Time
	     
	  //------------------------------------------------Start------------------------------------------------------------------//  
	     
	     long LoagingStart = System.currentTimeMillis();   //take system(PC) current time in millisecond
		  
		  List<WebElement> allLinks = driver.findElements(By.xpath("//*"));  //Find xpath of all element for opened page. 

		  long Loadingstop = System.currentTimeMillis();  //take system(PC) current time in millisecond
		  
		  double TotalTime = (Loadingstop-LoagingStart);
		  
		  String Result  =  Double.toString(TotalTime);
		  
		  System.out.println(driver.getTitle().trim()+"Pageloading time is "+ TotalTime + " Milisec");	
		//  write_data.writedata(4,1,2,Result);

		  
	//--------------------------------------------------End-----------------------------------------------------------------//  
		  
		  
		//  write_data.writedata(0,1,2,Result);  // Writing page load time to excel sheet with respect to page. 
		  
		  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		  
		  Thread.sleep(100);
		  	         
	    //  return(title);
		  return(null);
	      	        
	}
	//-----------------Function for Take screenshot if wrong page is open or expected page is crashed--------------------------//
	
		public String SShot (String actual1, String title1, WebDriver driver1) throws IOException
		{
			
			String actual = actual1;
			String title = title1;
			WebDriver driver = driver1;
			
			
			if(title.contentEquals(actual))
			{
				System.out.println(title+ " page is open" );
			}	
			else
			{
			
					File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
					
					FileUtils.copyFile(scrFile, new File(path.concat("\\ScreenShot\\"+ driver.getTitle().trim()+"_"+System.currentTimeMillis()+".jpg")));
				
					driver.close();
			}
			
			return(null);
			
			
		}}
	//--