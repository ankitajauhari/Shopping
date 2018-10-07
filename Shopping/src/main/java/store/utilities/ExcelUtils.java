package store.utilities;

import java.io.File;

import java.io.FileInputStream;
import java.util.ArrayList;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelUtils extends Base{
	
protected static Workbook workbook; 	
protected static Sheet sheet; 	
protected static Row row;
protected static Cell cell;
protected static String sheetName="Login";


static
{
	
	try
	{

	File f= new File("C:\\Users\\admin\\eclipse-workspace\\Shopping\\src\\test\\resources\\TestData.xlsx");
	FileInputStream inputStream = new FileInputStream(f);


	//Find the file extension by splitting file name in substring  and getting only extension name
	String fileName="TestData.xlsx";
	String fileExtensionName = fileName.substring(fileName.indexOf("."));

	//Check condition if the file is xlsx file

	if(fileExtensionName.equals(".xlsx")){

	//If it is xlsx file then create object of XSSFWorkbook class

		workbook = new XSSFWorkbook(inputStream);

	}

	//Check condition if the file is xls file

	else if(fileExtensionName.equals(".xls")){

	    //If it is xls file then create object of XSSFWorkbook class

		workbook = new HSSFWorkbook(inputStream);

	}

	//Read sheet inside the workbook by its name

	sheet = workbook.getSheet(sheetName);

	

	}
	catch (Exception e)
	{
		e.printStackTrace();
	}
	
	}
	

public static int getRowCount()
{
	int rowCount=0;
	//Find number of rows in excel file

		 rowCount = sheet.getLastRowNum()-sheet.getFirstRowNum();
		System.out.println(rowCount);

	return rowCount;

}

public static String getCellData(int rowNum, int colNum, String sheetName)
{
	String data;
	
	cell= sheet.getRow(rowNum).getCell(colNum);
	data=cell.getStringCellValue();
	//System.out.println(data);
	return data;
	 
}

public static ArrayList<Object[]> getLoginDatafromExcel()
{

ArrayList<Object[]> data= new ArrayList<Object[]>();
try { 
	
	int totalRows=getRowCount();

	for (int i=1;i<=totalRows;i++)
	{
		String user = getCellData(i, 0, sheetName);
		String pass= getCellData(i, 1, sheetName);
		

	Object[] ob= {user, pass};
	
	data.add(ob);
	}
	
	return data;
}
 catch (Exception e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
return null;

}


}