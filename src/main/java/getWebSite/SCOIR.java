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
/*
        myPageElement[] pageElements = {
           // new myPageElement("Show Net Price by Income", "", ActionType.CLICK, SelectorType.XPATH, "//div[contains(text(), 'Show Net Price by Income')]"),
           // new myPageElement("Show Net Price by Income", "", ActionType.CLICK, SelectorType.XPATH, "//*[@id=\"app-main-content\"]/div/div[2]/div/div[2]/div/div[1]/div/div[2]/div[1]"),
           // new myPageElement("Show Net Price by Income", "", ActionType.CLICK, SelectorType.CSS_SELECTOR, "#app-main-content > div > div.MuiContainer-root.MuiContainer-maxWidthLg > div > div.MuiBox-root.jss259 > div > div.MuiBox-root.jss263.jss262.jss260 > div > div.MuiPaper-root.MuiAccordion-root.jss285.MuiAccordion-rounded.MuiPaper-elevation1.MuiPaper-rounded > div.MuiButtonBase-root.MuiAccordionSummary-root.jss289"),
            new myPageElement("listPrice", "", ActionType.GETTEXT,SelectorType.XPATH, "//*[@id=\"app-main-content\"]/div/div[2]/div/div[2]/div/div[1]/div/div[1]/div/div[1]/div/div/div/h5"),
            new myPageElement("inStateTuition", "", ActionType.GETTEXT, SelectorType.XPATH, "//*[@id=\"app-main-content\"]/div/div[2]/div/div[2]/div/div[1]/div/div[1]/table/tbody/tr[1]/td/p"),
            new myPageElement("roomBoardCost", "", ActionType.GETTEXT, SelectorType.XPATH, "//*[@id=\"app-main-content\"]/div/div[2]/div/div[2]/div/div[1]/div/div[1]/table/tbody/tr[5]/td/p"),
            new myPageElement("roomBoardCost", "", ActionType.GETTEXT, SelectorType.CSS_SELECTOR, "#app-main-content > div > div.MuiContainer-root.MuiContainer-maxWidthLg > div > div.MuiBox-root.jss272 > div > div.MuiBox-root.jss276.jss275.jss273 > div > div.MuiPaper-root.MuiPaper-elevation0.MuiPaper-rounded > table > tbody > tr:nth-child(4) > td > p")
        
        };
        for (myPageElement pageElement : pageElements) {
            String value = "";
            WebElement element = null;
              
            switch (pageElement.selectorType) {
                case XPATH:
                    try {
                        element = driver.findElement(By.xpath(pageElement.selector));
                    } catch (Exception e) {
                        System.out.println("Failed to find element: '" + pageElement.fieldName + "' with XPath: " + pageElement.selector);
                        //e.printStackTrace();
                    }
                    break;
                case CSS_SELECTOR:
                    try {
                        element = driver.findElement(By.cssSelector(pageElement.selector));
                    } catch (Exception e) {
                        System.out.println("Failed to find element: '" + pageElement.fieldName + "' with CSS selector: " + pageElement.selector);
                        //e.printStackTrace();
                    }
                    break;
                case ID:
                    try {
                        element = driver.findElement(By.id(pageElement.selector));
                    } catch (Exception e) {
                        System.out.println("Failed to find element: '" + pageElement.fieldName + "' with ID: " + pageElement.selector);
                        //e.printStackTrace();
                    }
                    break;
                case NAME:
                    try {
                        element = driver.findElement(By.name(pageElement.selector));
                    } catch (Exception e) {
                        System.out.println("Failed to find element: '" + pageElement.fieldName + "' with name: " + pageElement.selector);
                       //e.printStackTrace();
                    }
                    break;
                case CLASS_NAME:
                    try {
                        element = driver.findElement(By.className(pageElement.selector));
                    } catch (Exception e) {
                        System.out.println("Failed to find element: '" + pageElement.fieldName + "' with class name: " + pageElement.selector);
                        //e.printStackTrace();
                    }
                    break;
                case TAG_NAME:
                    try {
                        element = driver.findElement(By.tagName(pageElement.selector));
                    } catch (Exception e) {
                        System.out.println("Failed to find element: '" + pageElement.fieldName + "' with tag name: " + pageElement.selector);
                        //e.printStackTrace();
                    }
                    break;
                case LINK_TEXT:
                    try {
                        element = driver.findElement(By.linkText(pageElement.selector));
                    } catch (Exception e) {
                        System.out.println("Failed to find element: '" + pageElement.fieldName + "' with link text: " + pageElement.selector);
                        //e.printStackTrace();
                    }
                    break;
                case PARTIAL_LINK_TEXT:
                    try {
                        element = driver.findElement(By.partialLinkText(pageElement.selector));
                    } catch (Exception e) {
                        System.out.println("Failed to find element: '" + pageElement.fieldName + "' with partial link text: " + pageElement.selector);
                        //e.printStackTrace();
                    }
                    break;
                // Add more cases for other SelectorType values if needed
                default:
                    throw new IllegalArgumentException("Invalid selector type: " + pageElement.selectorType);
            }
            
            switch (pageElement.actionType) {
                case CLICK:
                    try {
                        element.click();
                        Thread.sleep(500);
                    } catch (Exception e) {
                            System.out.println("Action:Click not supported for pageElement: " + '"' 
                            + pageElement.fieldName + '"'
                            + "actionType: " + pageElement.actionType);
                        //e.printStackTrace();
                    }
                    break;
                case GETTEXT:
                    try {
                        value = element.getText();
                        System.out.println(pageElement.fieldName + ": " + value);
                    } catch (Exception e) {
                        System.out.println("Failed to extract value for pageElement: " + '"' 
                            + pageElement.fieldName + '"'
                            + " actionType: " + pageElement.actionType);
                        //e.printStackTrace();
                    }
                    break;
                // Add more cases for other ActionType values if needed
                default:
                    throw new IllegalArgumentException("Usupported action type for pageElement: " + '"' 
                            + pageElement.fieldName + '"'
                            + "actionType: " + pageElement.actionType);
            }
            pageElement.extractedValue = value;
        }
        for (myPageElement pageElement : pageElements) {
            System.out.println(pageElement.fieldName + ": " + pageElement.extractedValue);
        }
        // Take a screenshot
        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        // Specify the destination path for the screenshot
        // Get the current date and time
        LocalDateTime now = LocalDateTime.now();
        // Format the date and time as desired
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        String formattedDateTime = now.format(formatter);
        // Specify the destination path for the screenshot
        String fileName = "/Users/qarnd/Downloads/" + universityID + "_" + formattedDateTime + ".png";
        File imageFile = new File(fileName);
        // Move the screenshot file to the destination path
        screenshotFile.renameTo(imageFile);
        
        System.out.println("Screenshot file path: " + imageFile.getAbsolutePath());
      */   
        } // end of for loop trough universityIDs
    // Close the browser
    driver.quit();
    }

}
