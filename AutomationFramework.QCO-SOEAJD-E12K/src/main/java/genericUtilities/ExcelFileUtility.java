package genericUtilities;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * This class consists of generic methods related to excel file
 * @author Keerthana S
 * 
 */
public class ExcelFileUtility {
	/**
	 * This method will read data from Excel file and return the value
	 * @param sheetName
	 * @param rowNo
	 * @param celNo
	 * @return
	 * @throws IOException
	 * @throws EncryptedDocumentException
	 */
	
	
	
	
	public String readDataFromExcelFile(String sheetName,int rowNo,int celNo) throws IOException,EncryptedDocumentException
	{
	
	FileInputStream fis= new FileInputStream("/Users/jesus/Desktop/eclipse-workspace/AutomationFramework.QCO-SOEAJD-E12K/src/test/resources/Testdata.xlsx");
	Workbook wb=WorkbookFactory.create(fis);
	Sheet sh=wb.getSheet(sheetName);
	Row rw=sh.getRow(rowNo);
	Cell cl=rw.getCell(celNo);
	String value=cl.getStringCellValue();
    return value;
	}
	
	
}
