package ExcelConnect;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//import org.apache.poi.ss.usermodel.Row;
//import java.io.IOException;
//import java.util.Iterator;
//import org.apache.poi.EncryptedDocumentException;
//import org.apache.poi.ss.formula.functions.Rows;

public class ExcelUtils {
	
	FileInputStream 	fis;											//reference variable - file input stream		
	XSSFWorkbook 		workbook;										//reference variable - workbook		
	public XSSFSheet readData(String filePath, String sheetName)  		//file path, sheet Name
	{
		try {
/*FileInputStream will be used to open the Excel sheet to read the data.*/
			fis 			= new FileInputStream(filePath);			//file path
			workbook 		= new XSSFWorkbook(fis);					//file input stream
			XSSFSheet sheet = workbook.getSheet(sheetName);				//get sheet
			return sheet;
		}catch (Exception e) {
			
			 return null;
		}		
	}
	public String readDataBasedOnRowAndCell(String filePath, String sheetName, int row, int cell)  
	{
		try {
			XSSFSheet 	sheet 		= readData(filePath, sheetName);			//sheet location
			XSSFRow 	xssfRow 	= sheet.getRow(row);						//Getting row
			Cell 		cellData 	= xssfRow.getCell(cell);					//getting cell
			//System.out.println(cellData);
			return cellData.getStringCellValue();								//getting cell value
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	public Object[][] readAllData(String filePath, String sheetName)  			//read data from file and sheet Name
	{
		try {
			XSSFSheet 	sheet 		= readData(filePath, sheetName);			//file path and sheet Name
			
			int 		rows 		= sheet.getLastRowNum() + 1;				/*To find last row*/
			int 		columns		= sheet.getRow(1).getLastCellNum();			//To save total cells in the row
			Object 		data[][] 	= new Object[rows-1][columns];				//Object has number of rows and columns
			for (int i=1; i < rows; i++) {
				XSSFRow xssfRow = sheet.getRow(i);								//save the row numbers in xssfRow
//int colums = xssfRow.getLastCellNum();
				for (int j = 0; j < columns; j++) {								//for loop for columns
					Cell cell 		= xssfRow.getCell(j);						//save the cell in the cell 
					System.out.print(cell + "    ");
					try {
					data[i-1][j]	= cell.getStringCellValue();
					}catch (Exception e) {
						// TODO: handle exception
					}					
				}
				System.out.println();
			}
			return data;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	public void writeDataBasedOnRowAndCell(String filePath, String sheetName, int row, int cell, String cellDataValue)  
	{
		try {
			
			XSSFSheet 	sheet 		= readData(filePath, sheetName);
			XSSFRow 	xssfRow 	= sheet.getRow(row);
			Cell 		cellData1 	= null;									//empty cell with null
			try {
				cellData1 	= xssfRow.createCell(cell);						//create object cellData1 from createCell.
			}catch (Exception e) {
				cellData1 	= xssfRow.getCell(cell);
			}
			cellData1.setCellValue(cellDataValue);							//write the data into cell
			FileOutputStream fos 	= new FileOutputStream(filePath);		//file output stream (to write data into XL)
			workbook.write(fos);
		//	System.out.println("Reference number moved to Excelsheet");
			workbook.close();
			fos.close();
		//fis.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
