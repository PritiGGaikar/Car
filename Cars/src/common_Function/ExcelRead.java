  package common_Function;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import jxl.write.WritableWorkbook;
import org.apache.poi.hssf.usermodel.HSSFCell;


public class ExcelRead 
{
	 
 XSSFWorkbook wb;
	 
	 XSSFSheet sheet1;
	 
	 XSSFCell Cell;
	 
	 static WritableWorkbook wwb;
	 
	 
	 public ExcelRead(String excelpath)
	 {
	  
	  try
	  {
	//Get the excel file 
		  
	   File src = new File(excelpath);// get the excel  path
	   
	   FileInputStream fis = new FileInputStream(src);// get the excel file path
	   
	   wb = new XSSFWorkbook(fis); // load the excel workbook
	   
	   
	  }
	  catch (Exception e)
	  {
	   System.out.println(e.getMessage());
	  }
	 }
	 
	 //get the excel row and column no
	 
	 public String getData (int Sheetnumber ,int row,int column){
	  
	  sheet1 = wb.getSheetAt(Sheetnumber);
	  
	  Cell = sheet1.getRow(row).getCell(column);
	  
	  String data = CellToString(Cell);
	     
	  return data;
	 }
	 
	//---------------------Function for convert cell int to string -------------------------------------//
	 
	 public String CellToString(XSSFCell Cell)
	 {
	  FormulaEvaluator formulaEvalutor = wb.getCreationHelper().createFormulaEvaluator();
	 
	  Object data = null ; 
	  
	  switch(formulaEvalutor.evaluateInCell(Cell).getCellType())
	  {
	   case 0:
	   data = NumberToTextConverter.toText(Cell.getNumericCellValue());  //Cell.getNumericCellValue();
	   break;
	   
	   case 1:
	   data = Cell.getStringCellValue();
	   break;
	           
	  }
	  return data.toString();
	 }
	 //+++++++++++++++++++++++++++End Function+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++//
	 
	 //----------------method for counting total row-----------------------------//
	 
	 public int getRowCount(int sheetIndex){
	  
	  int row = wb.getSheetAt(sheetIndex).getLastRowNum();
	  
	  row = row + 1;
	   
	  return row; 
	  
	  
	 }
	 //+++++++++++++++++++++End method row count++++++++++++++++++++++++++++++++++//

	//----------------method for counting total column-----------------------------//
	 
	 public int getColumnCount(int sheetIndex){
	  
	  int column = sheet1.getRow(0).getLastCellNum();
	  
	  column = column + 1;
	  
	  return column;
	    
	 }
	 
	 //+++++++++++++++++++++End method column count++++++++++++++++++++++++++++++//
	 
	 
		public  ArrayList<Row> searchSheet(String searchText,int sheetNumber,int functionkeyColumnIndex) {
		        // This parameter is for appending sheet rows to mergedSheet in the end
		        
		        Double doubleValue = null;
		        Boolean booleanValue = null;
		        ArrayList<Row> filteredRows = new ArrayList<Row>();

		        //Get double value if searchText is double
		        try {
		            doubleValue = Double.parseDouble(searchText);
		        } catch(Exception e) {  
		        }
		        
		        //Get boolean value if searchText is boolean
		        try {
		            booleanValue = Boolean.parseBoolean(searchText);
		        } catch(Exception e) {  
		        }
		        
		        sheet1 = wb.getSheetAt(sheetNumber);
		      
		        if(sheet1!=null)
		        {
			        for (int j = sheet1.getFirstRowNum(); j <= sheet1.getLastRowNum(); j++) {
		
			           
			          
			            //Iterate columns
			        	int k=functionkeyColumnIndex;
			          //  for (int k = sheet1.getRow(j).getFirstCellNum(); k < sheet1.getRow(j).getLastCellNum(); k++) {
			        	
			               
			                if(sheet1.getRow(j)!=null)
			                {
			               //Search value based on cell type
					                if(sheet1.getRow(j).getCell(k)!=null )
					                {
					                	 XSSFCell cell = sheet1.getRow(j).getCell(k);
							               switch (cell.getCellTypeEnum()) {
							                case  NUMERIC:
							                    if(doubleValue != null && doubleValue.doubleValue() == cell.getNumericCellValue()) {
							                        filteredRows.add(sheet1.getRow(j));
							                    }
							                    break;
							                case STRING:
							                    if(searchText != null && searchText.equals(cell.getStringCellValue())) {
							                        filteredRows.add(sheet1.getRow(j));
							                    }
							                    break;
							                case BOOLEAN:
							                    if(booleanValue != null && booleanValue.booleanValue() == cell.getBooleanCellValue()) {
							                        filteredRows.add(sheet1.getRow(j));
							                    }
							                    break;
							                default:
							                    if(searchText != null && searchText.equals(cell.getStringCellValue())) {
							                        filteredRows.add(sheet1.getRow(j));
							                    }
							                    break;
							                }
					                }
			                }
			            //}
			        }
			     }
		        return filteredRows;
		    }
		


}































