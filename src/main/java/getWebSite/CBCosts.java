package getWebSite;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CBCosts
{
    public static void main( String[] args ) throws InterruptedException
    {
    }
    public static void univerCBCosts(String urlCollegeBoard, WebDriver driver, University university) throws InterruptedException {
        urlCollegeBoard = university.getUrlCollegeBoard();
        if (urlCollegeBoard == null || urlCollegeBoard.isEmpty()) {
            return;
        }
        driver.get(urlCollegeBoard + "/tuition-and-costs");
        // Wait for the page to load
        Thread.sleep(2000);
        try {
            String costAvrgPerYearAfterAid = driver.findElement(By.xpath("//div[text()='Average Per Year After Aid']/following-sibling::div")).getText();
            System.out.println("Average Per Year After Aid: " + costAvrgPerYearAfterAid);
            university.setCostAvrgPerYearAfterAid(costAvrgPerYearAfterAid);
        } catch (NoSuchElementException e) {
            System.out.println("Average Per Year After Aid not found");
        }

        try {
            WebElement avrgAidPackageElement = driver.findElement(By.xpath("//div[text()='Average Aid Package']/following-sibling::div"));
            String avrgAidPackage = avrgAidPackageElement.getText();
            System.out.println("Average Aid Package: " + avrgAidPackage);
            university.setAvrgAidPackage(avrgAidPackage.trim());
        } catch (NoSuchElementException e) {
            System.out.println("Average Aid Package not found");
        }
 
        try {
            WebElement studentsReceivFinAidElement = driver.findElement(By.xpath("//div[text()='Students Receiving Financial Aid']/following-sibling::div"));
            String studentsReceivFinAid = studentsReceivFinAidElement.getText();
            System.out.println("Students Receiving Financial Aid: " + studentsReceivFinAid);
            university.setStudentsReceivFinAid(studentsReceivFinAid.trim());
        } catch (NoSuchElementException e) {
            System.out.println("Students Receiving Financial Aid not found");
        }

        try {
            List<WebElement> elements = driver.findElements(By.cssSelector("#selected-range-label"));
            for (WebElement element : elements) {
                String ariaLabel = element.getAttribute("aria-label");
                // extract SAT test type and score
                Pattern pattern = Pattern.compile("SAT (\\w+).*:\\s*(.*)");
                Matcher matcher = pattern.matcher(ariaLabel);
                //System.out.println(ariaLabel);

                if (matcher.find()) {
                    String discipline = matcher.group(1).trim().toLowerCase();
                    String score = matcher.group(2).trim();
                    switch (discipline) {
                        case "composite":
                            university.setSatTotalRange(score);
                            System.out.println("SAT Composite: " + score);
                            break;
                        case "reading":
                            university.setSatReadingRange(score);
                            System.out.println("SAT Reading: " + score);
                            break;
                        case "math":
                            university.setSatMathRange(score);
                            System.out.println("SAT Math: " + score);
                            break;
                        default:
                            System.out.println("Unknown SAT discipline: " + discipline + " :" + score);
                            break;
                    }
                }
            }
        } catch (NoSuchElementException e) {
            System.out.println("SAT score range not available");
        }

    }
}