import excelUtility.ReadGuru99ExcelFile;
import keywordDriven.UIOperation;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import utility.ReadObject;

import java.io.IOException;
import java.util.Properties;

import static utility.Constants.TESTCASES;

public class HybridExecuteTest {
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

    @Test(dataProvider="hybridData")
    public void testLogin(String testcaseName, String keyword, String objectName, String objectType, String value) throws Exception {
        if(testcaseName != null && testcaseName.length() != 0){
            System.out.println("Execute testcaseName: " + testcaseName);
        }
        // Call perform function to perform operation on UI
        operation.perform(allObjects, keyword, objectName, objectType, value);
    }
    @DataProvider(name="hybridData")
    public Object[][] getDataFromDataprovider() throws IOException {
        Object[][] object = null;
        // Read keyword sheet
        Sheet guru99Sheet = file.readExcel(System.getProperty("user.dir"), TESTCASES , "KeywordFramework");
        // Find number of rows in excel file
        int rowCount = guru99Sheet.getLastRowNum() - guru99Sheet.getFirstRowNum();
        object = new Object[rowCount][5];
        for (int i = 0; i < rowCount; i++) {
            //Loop over all the rows
            Row row = guru99Sheet.getRow(i + 1);
            //Create a loop to print cell values in a row
            for (int j = 0; j < row.getLastCellNum(); j++) {
                //Print excel data in console
                object[i][j] = row.getCell(j).toString();
            }
        }
        System.out.println("");
        return object;
    }
}
