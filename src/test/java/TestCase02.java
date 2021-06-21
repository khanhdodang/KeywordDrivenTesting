import keywordDriven.ActionKeywords;
import excelUtility.ReadExcelSheet;

public class TestCase02 {
    public static void main(String[] args) throws Exception {
        ReadExcelSheet rs = new ReadExcelSheet();
        rs.readExcelData(4);
        ActionKeywords actionKeyword = new ActionKeywords();
        actionKeyword.openBrowser();
        actionKeyword.navigate();
        actionKeyword.enterUsername();
        actionKeyword.enterPassword();
        actionKeyword.clickLogin();
        actionKeyword.logout();
        actionKeyword.closeBrowser();
        System.out.println("Test executed successfully");
    }
}