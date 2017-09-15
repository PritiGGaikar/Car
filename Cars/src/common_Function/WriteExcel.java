

package common_Function;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;

public class WriteExcel {
	XSSFWorkbook wb;

	XSSFSheet sheet1;

	XSSFCell Cell;


	public WriteExcel(String excelpath) {

		try {

			File src = new File(excelpath); // get the excel  path


			  FileInputStream fis = new FileInputStream(src);	 // get the excel file  path

			  wb = new XSSFWorkbook(fis);			// it loads the workbook

/*			  Workbook wb = Workbook.getWorkbook(fis);*/

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	// get the excel Sheet row and column number

	public String writedata(int sheetnumber, int row, int col, String value) throws Exception {
	String path="C:\\Users\\Priti\\workspace\\Cars\\"; //Workspace path
		
	//File src = new File(path.concat("Output\\Technical_Output.xlsx"));
			File src = new File(path.concat("Excel\\WorklistJob_Input.xlsx"));
		FileInputStream fis = new FileInputStream(src);

		wb = new XSSFWorkbook(fis);	// it loads the workbook

		sheet1 = wb.getSheetAt(sheetnumber);	// get the sheet index

		sheet1.getRow(row).createCell(col).setCellValue(value); //it is used for write someting in the cell

		FileOutputStream fout = new FileOutputStream(src); // file output where the written excel sheet will save

		wb.write(fout); // write on excel sheet

		fout.flush();

		fout.close(); // close the excel sheet
		return null;

	}

	public void WriteData(String pathOfFile, String sheetName, int rowNum, int cellNum, String value) throws InvalidFormatException, IOException{
	    FileInputStream fis = new FileInputStream("C:\\Users\\Priti\\workspace\\Jibe Project\\Output\\Technical_Output.xlsx");
	    Workbook wb = WorkbookFactory.create(fis);
	    wb.getSheet(sheetName).getRow(rowNum).createCell(cellNum).setCellValue(value);
	  //  wb.getSheet(sheetName).createRow(rowNum).createCell(cellNum).setCellValue(value); //use this if you are writing in new row.
	    FileOutputStream fos = new FileOutputStream(pathOfFile);
	    wb.write(fos);
	    
	}
	
	/*public void testreport(ITestResult testresult,int sheetnumber, int row, int col,int value) throws Exception
	{
		//File src = new File("C:\\Work\\JibeTesting\\Excel\\ReadWrite.xlsx");
		File src = new File("C:\\Users\\Priti\\workspace\\Purchase\\Excel\\Purchase_output.xlsx");
		FileInputStream fis = new FileInputStream(src);

		wb = new XSSFWorkbook(fis);

		sheet1 = wb.getSheetAt(sheetnumber);

		sheet1.getRow(row).createCell(col).setCellValue(value);


		FileOutputStream fout = new FileOutputStream(src);



		wb.write(fout);

		fout.flush();

		fout.close();


	}
*/

}