import java.util.Properties;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import utility.ReadObject;
import keywordDriven.UIOperation;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import excelUtility.ReadGuru99ExcelFile;

import static utility.Constants.TESTCASES;

/**
 * THIS IS THE EXAMPLE OF KEYWORD DRIVEN TEST CASE
 */
public class TestCase01 {
    WebDriver driver;
    ReadGuru99ExcelFile file;
    ReadObject object;
    Properties allObjects;
    UIOperation operation;

    @BeforeClass
    public void SetUp() {
        driver = new ChromeDriver();
        // TODO Auto-generated method stub
        file = new ReadGuru99ExcelFile();
        object = new ReadObject();
        allObjects = object.getObjectRepository();
        operation = new UIOperation(driver);
    }

    @AfterClass
    public void TearDown() {
        driver.quit();
    }

    @Test
    public void testLogin() throws Exception {
        //Read keyword sheet
        Sheet guru99Sheet = file.readExcel(System.getProperty("user.dir"), TESTCASES, "KeywordFramework");
        //Find number of rows in excel file
        int rowCount = guru99Sheet.getLastRowNum() - guru99Sheet.getFirstRowNum();
        //Create a loop over all the rows of excel file to read it
        for (int i = 1; i < rowCount + 1; i++) {
            //Loop over all the rows
            Row row = guru99Sheet.getRow(i);
            //Check if the first cell contain a value, if yes, That means it is the new testcase name
            if (row.getCell(0).toString().length() == 0) {
                //Print testcase detail on console
                System.out.println(row.getCell(1).toString() + "----" + row.getCell(2).toString() + "----" +
                        row.getCell(3).toString() + "----" + row.getCell(4).toString());
                //Call perform function to perform operation on UI
                operation.perform(allObjects, row.getCell(1).toString(), row.getCell(2).toString(),
                        row.getCell(3).toString(), row.getCell(4).toString());
            } else {
                //Print the new  testcase name when it started
                System.out.println("New Testcase->" + row.getCell(0).toString() + " Started");
            }
        }
    }

}
