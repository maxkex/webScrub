package getWebSite;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SCOIR 
{
    public static void main( String[] args ) throws InterruptedException
    {

    List<String> universityIDs = Arrays.asList("1100376", "6000232", "3000453", "1100510", "1100359");
  
    // Create a list of lists
    List<Map<String, Object>> univerTable = new ArrayList<>();
        // Create a list of Universities with their SCOIR IDs
        for (String universityID : universityIDs) {
            Map<String, Object> row = new HashMap<>();
            row.put("SCOIR id", universityID);
            univerTable.add(row);
        }
    // Setup ChromeDriver
    ChromeOptions chromeoption=new ChromeOptions();
    chromeoption.addArguments("--remote-allow-origins=*");
    System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
    WebDriver driver = new ChromeDriver(chromeoption);
    // WebDriver driver = new SafariDriver();
    // Declare and initialize the targetSize variable
    org.openqa.selenium.Dimension targetSize = new Dimension(1400, 1800);
    driver.manage().window().setSize(targetSize);
    
    // Declare and initialize the universityIDs variable 
    for (Map<String, Object> uRow : univerTable) {
        String universityID = (String) uRow.get("SCOIR id");
        // Launch the website
        String siteURL = "https://app.scoir.com/student/colleges/" + universityID + "/cost-aid";
        driver.get(siteURL);
        // Wait while the page is loading
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[contains(text(), 'Show Net Price by Income')]")).click();
        Thread.sleep(300);
        // Create an array of page elements to extract
        List<WebElement> tables = driver.findElements(By.className("MuiTable-root"));
        List<WebElement> tblRows = new ArrayList<>();

        for (WebElement table : tables) {
            tblRows.addAll(table.findElements(By.className("MuiTableRow-root")));
        }

        // Iterate over the rows
        for (WebElement tblRow : tblRows) {
            // Find each row and extract the columns
            List<String> tblColms = new ArrayList<>();

            try {
                List<WebElement> tblColmsElements = tblRow.findElements(By.tagName("th"));
                for (WebElement tblColmElement : tblColmsElements) {
                    tblColms.add(tblColmElement.getText());
                }
            } catch (Exception e) {
                // Handle the exception or print an error message
                // e.printStackTrace();
            }
            try {
                List<WebElement> tblColmsElements = tblRow.findElements(By.tagName("td"));
                for (WebElement tblColmElement : tblColmsElements) {
                    tblColms.add(tblColmElement.getText());
                }
            } catch (Exception e) {
                // Handle the exception or print an error message
                // e.printStackTrace();
            }
            System.out.println(tblColms);
            // add extracted values to the university record
            for (int i = 0; i < tblColms.size(); i++) {
                String columnName = tblColms.get(i);
                String columnValue = tblColms.get(++i);
                uRow.put(columnName, columnValue);
            }
                System.out.println(uRow);
            }
    System.out.println(univerTable);
    System.out.println("-----------------------------------");
 
        } // end of for loop trough universityIDs
    // Close the browser
    driver.quit();
    }

}
