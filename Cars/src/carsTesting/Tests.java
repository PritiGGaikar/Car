package carsTesting;

import java.util.ArrayList;

import org.apache.poi.ss.usermodel.Row;
import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentReports;

import common_Function.RW;

public class Tests extends RW {

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

	public void CreateNewJob(WebDriver driver1) throws Exception {
		// Get URLPage
		driver1.get("http://192.168.1.102/JIBE/Technical/JMS/JMS_Index.aspx");

		AddIncident(driver1);
		// CreateCar(driver1);
	}

	public void AddIncident(WebDriver driver1) throws Exception {
/*
		ArrayList<Row> locator = OR_Locator.searchSheet("AddIncident", 0, 9);

		ArrayList<Row> Inputdata = input_Data.searchSheet("AddIncident", 1, 0);

		NavigateLocators(driver1, locator, Inputdata);
*/
		// ----------------------------------------------------------------------
		ArrayList<Row> locator1 = OR_Locator.searchSheet("DateValidation", 0, 9);
System.out.println(locator1.get(0));
		ArrayList<Row> Inputdata1 = input_Data.searchSheet("DateValidation", 1, 0);

		NavigateLocators(driver1, locator1, Inputdata1);
		// ----------------------------------------------------------------------

	}

	public void CreateCar(WebDriver driver1) throws Exception {

		ArrayList<Row> locator = OR_Locator.searchSheet("CreateCar", 0, 9);

		ArrayList<Row> Inputdata = input_Data.searchSheet("CreateCar", 1, 0);

		// Loop for mumtiple Validation
		for (int m = 4; m < Inputdata.size(); m++) { // Cell
			NavigateLocators(driver1, locator, Inputdata);

		}
	}

	private  void NavigateLocators(WebDriver driver1, ArrayList<Row> locator, ArrayList<Row> Inputdata)
			throws Exception {

		for (int m = 4; m < 9; m++) { // Cell

			for (int i = 0; i < locator.size(); i++) {
				String InputValue = "";

				// Get property of element
				String LocatorName = locator.get(i).getCell(0).getStringCellValue();

				// Get property of element
				String LocatorType = locator.get(i).getCell(1).getStringCellValue();

				// Get client ID of the element
				String strControl = locator.get(i).getCell(2).getStringCellValue();

				// Get Sleep Time
				Long SleepTime = (long) locator.get(i).getCell(4).getNumericCellValue();

				for (int j = 0; j < Inputdata.size(); j++) {
					if (locator.get(i).getCell(0) != null) {

						if (Inputdata.get(j).getCell(1) != null) {
							if (locator.get(i).getCell(0).toString()
									.compareTo(Inputdata.get(j).getCell(1).toString()) == 0) {
								InputValue = Inputdata.get(j).getCell(m).toString();
								

							}
						}
					}

				}

				if (locator.get(i).getCell(10) != null) {

					String strControlTypeKey = locator.get(i).getCell(10).toString();

					// Button Click and navigate page

					if (strControlTypeKey.compareTo("Click_Ctrl") == 0) {
						click_element(driver1, LocatorType, strControl);
						Thread.sleep(SleepTime);
					}
					// Text
					if (strControlTypeKey.compareTo("Dropdown_ctrl") == 0) {
						sendkeys(driver1, LocatorType, strControl, InputValue);
						Thread.sleep(SleepTime);
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
					
				}
				
			}
		}
		
	}
	
}