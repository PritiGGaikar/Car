package carsTesting;

import java.util.ArrayList;

import org.apache.poi.ss.usermodel.Row;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentReports;

import common_Function.RW;

public class CreateNewJob extends RW {

	private static ExtentReports report;

	public synchronized static ExtentReports getReporter(String filePath) {

		if (report == null) {
			report = new ExtentReports(path.concat("Report\\Cars.html"));

			report.addSystemInfo("Host Name", "Priti") // Environment Setup For
														// Report
					.addSystemInfo("Environment", "QA");
		}

		return report;
	}

	public void CreateNewJobs(WebDriver driver1) throws Exception {
		// Get URLPage		
		driver1.get("http://192.168.1.102/JIBE/Technical/JMS/JMS_Index.aspx");
		
		//AddIncident(driver1);
		CreateCar(driver1);
		//CorrectiveAction(driver1);
		PreventiveActionsTasks(driver1);
	}

	public void AddIncident(WebDriver driver1) throws Exception {

		ArrayList<Row> locator = OR_Locator.searchSheet("AddIncident", 0, 9);

		ArrayList<Row> Inputdata = input_Data.searchSheet("AddIncident", 0, 0);
		// Loop for mumtiple Validation
		for (int TestCase = 1; TestCase < Inputdata.size(); TestCase++) {
			NavigateLocators(driver1, locator, Inputdata, TestCase);
		}
	}

	public void CreateCar(WebDriver driver1) throws Exception {
		
		ArrayList<Row> locator = OR_Locator.searchSheet("AddJob", 0, 9);

		ArrayList<Row> Inputdata = input_Data.searchSheet("AddJob", 0, 0);

		// Loop for mumtiple Validation
		for (int TestCase = 1; TestCase < Inputdata.size(); TestCase++) {
			NavigateLocators(driver1, locator, Inputdata, TestCase);
		}
		
	//-------------------------------------------------------------------------------------------
		/* ArrayList<Row> locator1 = OR_Locator.searchSheet("DateValidation", 0, 9);

		ArrayList<Row> Inputdata1 = input_Data.searchSheet("DateValidation", 0, 0);

		// Loop for mumtiple Validation
		for (int TestCase = 1; TestCase < Inputdata1.size(); TestCase++) {
			NavigateLocators(driver1, locator1, Inputdata1, TestCase);
			
		}	
			
	//-------------------------------------------------------------------------------------------
			ArrayList<Row> locator2 = OR_Locator.searchSheet("TitleValidation", 0, 9);

			ArrayList<Row> Inputdata2 = input_Data.searchSheet("TitleValidation", 0, 0);

			// Loop for mumtiple Validation
			for (int TestCase = 1; TestCase < Inputdata2.size(); TestCase++) {
				
				NavigateLocators(driver1, locator2, Inputdata2, TestCase);
			}
			
//-------------------------------------------------------------------------------------------
			
			ArrayList<Row> locator3 = OR_Locator.searchSheet("Follow-ups", 0, 9);

			ArrayList<Row> Inputdata3 = input_Data.searchSheet("Follow-ups", 0, 0);

			// Loop for mumtiple Validation
			for (int TestCase = 1; TestCase < Inputdata3.size(); TestCase++) {
				
				NavigateLocators(driver1, locator3, Inputdata3, TestCase);
			}	
//-------------------------------------------------------------------------------------------		
	    	ArrayList<Row> locator4 = OR_Locator.searchSheet("CarDetails", 0, 9);

			ArrayList<Row> Inputdata4 = input_Data.searchSheet("CarDetails", 0, 0);

			// Loop for mumtiple Validation
			for (int TestCase = 1; TestCase < Inputdata4.size(); TestCase++) {
				
				NavigateLocators(driver1, locator4, Inputdata4, TestCase);
			}
 //-------------------------------------------------------------------------------------------			
			ArrayList<Row> locator5 = OR_Locator.searchSheet("EquipmentLocation", 0, 9);

			ArrayList<Row> Inputdata5 = input_Data.searchSheet("EquipmentLocation", 0, 0);

			// Loop for mumtiple Validation
			for (int TestCase = 1; TestCase < Inputdata5.size(); TestCase++) {
			
				NavigateLocators(driver1, locator5, Inputdata5, TestCase);
			} */
 //-------------------------------------------------------------------------------------------					
			/*ArrayList<Row> locator6 = OR_Locator.searchSheet("AddAttachment", 0, 9);

			ArrayList<Row> Inputdata6 = input_Data.searchSheet("AddAttachment", 0, 0);

			// Loop for mumtiple Validation
			for (int TestCase = 1; TestCase < Inputdata6.size(); TestCase++) {
				
				NavigateLocators(driver1, locator6, Inputdata6, TestCase);
			}
			
 //-------------------------------------------------------------------------------------------					
			ArrayList<Row> locator7 = OR_Locator.searchSheet("AddRootCauseAnalysis", 0, 9);

			ArrayList<Row> Inputdata7 = input_Data.searchSheet("AddRootCauseAnalysis", 0, 0);

			// Loop for mumtiple Validation
			for (int TestCase = 1; TestCase < Inputdata7.size(); TestCase++) {
				NavigateLocators(driver1, locator7, Inputdata7, TestCase);
			}
//-------------------------------------------------------------------------------------------							
			ArrayList<Row> locator8 = OR_Locator.searchSheet("EditRootCauseAnalysis", 0, 9);

			ArrayList<Row> Inputdata8 = input_Data.searchSheet("EditRootCauseAnalysis", 0, 0);

			// Loop for mumtiple Validation
			for (int TestCase = 1; TestCase < Inputdata8.size(); TestCase++) {
				NavigateLocators(driver1, locator8, Inputdata8, TestCase);
			}}*/}
//-------------------------------------------------------------------------------------------		
			public void CorrectiveAction(WebDriver driver1) throws Exception {
				
			ArrayList<Row> locator9 = OR_Locator.searchSheet("CorrectiveActionsTasks", 0, 9);

			ArrayList<Row> Inputdata9 = input_Data.searchSheet("CorrectiveActionsTasks", 0, 0);

			// Loop for mumtiple Validation
			for (int TestCase = 1; TestCase < Inputdata9.size(); TestCase++) {
				NavigateLocators(driver1, locator9, Inputdata9, TestCase);
			}
			}
			public void PreventiveActionsTasks(WebDriver driver1) throws Exception {
				
				ArrayList<Row> locator9 = OR_Locator.searchSheet("PreventiveActionsTasks", 0, 9);

				ArrayList<Row> Inputdata9 = input_Data.searchSheet("PreventiveActionsTasks", 0, 0);

				// Loop for mumtiple Validation
				for (int TestCase = 1; TestCase < Inputdata9.size(); TestCase++) {
					NavigateLocators(driver1, locator9, Inputdata9, TestCase);
				}
			
		
		
	}
	

	private void NavigateLocators(WebDriver driver1, ArrayList<Row> locator, ArrayList<Row> Inputdata,int TestCase)
			throws Exception {
		
		
		for (int i = 0; i < locator.size(); i++) {

			// Get type of element (dropdown, text)
			String strControlTypeKey = locator.get(i).getCell(10).toString();

			if (strControlTypeKey != null) {

				// Get property of element
				String LocatorName = locator.get(i).getCell(0).getStringCellValue();

				// Get property of element
				String LocatorType = locator.get(i).getCell(1).getStringCellValue();

				// Get client ID of the element
				String strControl = locator.get(i).getCell(2).getStringCellValue();

				String InputValue =  Inputdata.get(TestCase).getCell(i+1).toString();
				
				// Get Sleep Time
				Long SleepTime = (long) locator.get(i).getCell(4).getNumericCellValue();

				

				// Button Click and navigate page

				if (strControlTypeKey.compareTo("Click_Ctrl") == 0) {
					click_element(driver1, LocatorType, strControl);
					Thread.sleep(SleepTime);
				}
				//Text
				if (strControlTypeKey.compareTo("Dropdown_ctrl") == 0) {
					sendkeys(driver1, LocatorType, strControl, InputValue);
					Thread.sleep(SleepTime);
				}
				if (strControlTypeKey.compareTo("Clear_Ctrl") == 0) {
					clear_element(driver1, LocatorType, strControl);
					Thread.sleep(k);
				}
				if (strControlTypeKey.compareTo("SendKey_Ctrl") == 0) {
					sendkeys(driver1, LocatorType, strControl, InputValue);
					Thread.sleep(SleepTime);
				}
				
				if (strControlTypeKey.compareTo("Alert_accept") == 0) {
					click_element(driver1, LocatorType, strControl); 
					Thread.sleep(SleepTime);
					Alert_accept(driver1);
					Thread.sleep(SleepTime);
				}
				if (strControlTypeKey.compareTo("WindowSwitch_Ctrl") == 0) {
					click_element(driver1, LocatorType, strControl);
					Thread.sleep(SleepTime);
					WindowSwitchto(driver1);
				}
				if (strControlTypeKey.compareTo("Upload_Ctrl") == 0) {
					uploadFile(driver1, LocatorType, strControl, strControl, InputValue, strControl);
					Thread.sleep(SleepTime);

				}
				if (strControlTypeKey.compareTo("FrameSwitch_Ctrl") == 0) {

					 frameSwitchto(driver1, LocatorType, strControl);
	                 Thread.sleep(SleepTime);
				}
				
				if (strControlTypeKey.compareTo("FrameSwitchBack_Ctrl") == 0) {
					 click_element(driver1, LocatorType, strControl);
                     Thread.sleep(SleepTime);
					 frameSwitchBack(driver1);
	                 Thread.sleep(SleepTime);
	                     
					
			}
				if (strControlTypeKey.compareTo("Refresh_Ctrl") == 0) {
					refresh(driver1);
					Thread.sleep(SleepTime);
				}
				
				if (strControlTypeKey.compareTo("SwitchtoParent") == 0) {
					click_element(driver1, LocatorType, strControl);
					Thread.sleep(SleepTime);
					Alert_accept(driver1);
					Thread.sleep(SleepTime);
					SwitchtoParent(driver1);
					Thread.sleep(SleepTime);
				}
			}

		}
	}

}