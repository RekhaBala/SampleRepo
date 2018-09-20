package mySampleProjectTests;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class sampleTest {

	@Test
	public void TestReadExcel() throws IOException
	{
		File location=new File("C:/Users/HOME/Desktop/New Microsoft Office Excel Worksheet.xlsx");
		FileInputStream fis=new FileInputStream(location);
		Workbook wb=new XSSFWorkbook(fis);
		Sheet sh=wb.getSheet("Sheet1");
		System.out.println(sh.getPhysicalNumberOfRows());
		for(int i=0;i<sh.getPhysicalNumberOfRows();i++){
			Row getrows=sh.getRow(i);
			if(getrows==null)
			{
				continue;
			}
			else
			{
			//	System.out.println(getrows.getRowNum());
				
				for(int j=0;j<getrows.getPhysicalNumberOfCells();j++)
				{
					Cell currentcell=getrows.getCell(j);
					if(currentcell==null)
					{
						continue;
					}
					else
					{
						int type=currentcell.getCellType();
						if(type==0)
						{
							System.out.println(currentcell.getNumericCellValue());
						}
						else if(type==1)
						{
							System.out.println(currentcell.getStringCellValue());
						}
					}
				}
			}
				
			}
		}	
	/*@Test
	public void TestWriteExcel() throws IOException
	{
		File location=new File("C:/Users/HOME/Desktop/New Microsoft Office Excel Worksheet.xlsx");
		FileInputStream fis=new FileInputStream(location);
		Workbook wb=new XSSFWorkbook(fis);
		Sheet sh=wb.getSheet("Sheet1");
		int row=15;
		int col=4;
		Row getrow=sh.getRow(row);
		if(getrow==null){
			sh.createRow(row);
		}
		Cell cell=sh.getRow(row).getCell(col);
		if(cell==null){
			sh.getRow(row).createCell(col).setCellValue("Remark");
		}else{
			sh.getRow(row).getCell(col).setCellValue("Remark");
		}
		FileOutputStream fos=new FileOutputStream("C:/Users/HOME/Desktop/New Microsoft Office Excel Worksheet.xlsx");
		wb.write(fos);
		fos.close();
	}*/
}
