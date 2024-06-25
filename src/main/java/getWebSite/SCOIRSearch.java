package getWebSite;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SCOIRSearch 
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
    String baseUrl = "https://app.scoir.com/student/discover/search?page=1";
    driver.get(baseUrl);
    // select 4-years colleges search
    // Find the "Degrees" element and click it
    try {
    driver.findElement(By.xpath("//span[contains(text(), 'Degrees')]")).click();
    } catch (NoSuchElementException e) {
        System.out.println(e.getClass().getName() + ": Can not find element: Degrees");
    }
    // Find the "4-Year" checkbox and check it
    try {
        driver.findElement(By.xpath("//input[@aria-labelledby='label-checklist-0-4-year']")).click();
    } catch (NoSuchElementException e) {
        System.out.println(e.getClass().getName() + ": Can not find checkbox: 4-Year");
    }
    // Find the close button and click it
    try {
        driver.findElement(By.cssSelector("button[aria-label='close']")).click();
    } catch (NoSuchElementException e) {
        System.out.println(e.getClass().getName() + ": Can not find \"X\" button");
    }
    // Find all elements with class "MuiPaper-root MuiCard-root"
    List<WebElement> elements = driver.findElements(By.cssSelector(".MuiPaper-root.MuiCard-root"));

    // Print the text of each element
    for (WebElement element : elements) {
        System.out.println(element.getText());
    }
    // Close the browser
    driver.quit();
    }

}
