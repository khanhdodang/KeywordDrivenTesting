package excelUtility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import utility.Constants;

public class ReadExcelSheet {
    public ArrayList readExcelData(int colNo) throws IOException {
        String filePath = Constants.filePath;
        File file = new File(filePath);
        // Create an object of FileInputStream class and pass file as parameter to its constructor.
        FileInputStream fis = new FileInputStream(file);
        XSSFWorkbook wb = new XSSFWorkbook(fis);
        XSSFSheet sheet = wb.getSheet("Sheet1");

        Iterator row = sheet.rowIterator();
        row.next();
        ArrayList<String> arrayList = new ArrayList();

        // Checking the next element availability using the reference variable row.
        while (row.hasNext()) {
            Row r = (Row) row.next();

            // Moving cursor to the cell by getting arrayList cell number.
            Cell c = r.getCell(colNo);
            String data = c.getStringCellValue();
            arrayList.add(data);
            arrayList.add(((Row) row.next()).getCell(colNo).getStringCellValue());
        }
        System.out.println("List: " + arrayList);
        // Return the data to the Arraylist method.
        return arrayList;
    }

    public void DemoFile(int i) {
        // TODO Auto-generated method stub

    }
}
