package getWebSite;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CBAcademics
{
    public static void main( String[] args ) throws InterruptedException
    {
    }
    public static void univerCBAcademics(String URLCollegeBoard, WebDriver driver, University university) throws InterruptedException {
        URLCollegeBoard = university.getURLCollegeBoard();
        if (URLCollegeBoard == null || URLCollegeBoard.isEmpty()) {
            return;
        }
        driver.get(URLCollegeBoard + "/academics");
        // Wait for the page to load
        Thread.sleep(2000);
        try {
            WebElement studentToFacultyElement = driver.findElement(By.xpath("//div[text()='Student-to-Faculty Ratio']/following-sibling::div"));
            String studentToFaculty = studentToFacultyElement.getText();
            // System.out.println("Student-to-Faculty Ratio: " + studentToFaculty);
            university.setStudentFacultyRatio(studentToFaculty.trim());
        } catch (NoSuchElementException e) {
            System.out.println("Student-to-Faculty Ratio not found");
        }
 
        try {
            WebElement MajorsCountElement = driver.findElement(By.xpath("//div[text()='Majors Available']/following-sibling::div"));
            String MajorsCount = MajorsCountElement.getText();
            // System.out.println("Majors Available: " + MajorsCount);
            university.setMajorsCount(MajorsCount.trim());
        } catch (NoSuchElementException e) {
            System.out.println("Majors Available not found");
        }
 
        try {
            WebElement RetentionRateElement = driver.findElement(By.xpath("//div[text()='Retention Rate']/following-sibling::div"));
            String RetentionRate = RetentionRateElement.getText();
            // System.out.println("Retention Rate: " + RetentionRate);
            university.setRetentionRate(RetentionRate.trim());
        } catch (NoSuchElementException e) {
            System.out.println("Retention Rate not found");
        } 
        try {
            WebElement OffersCreditsElement = driver.findElement(By.xpath("//p[text()='Offers credits']/following-sibling::p"));
            String OffersCredits = OffersCreditsElement.getText();
            // System.out.println("Offers Credits: " + OffersCredits);
            university.setOffersCredits(OffersCredits.trim());
        } catch (NoSuchElementException e) {
            System.out.println("Offers Credits not found");
        } 
        try {
            WebElement OffersAdvancedPlacementsElement = driver.findElement(By.xpath("//p[text()='Offers placement into advanced courses']/following-sibling::p"));
            String OffersAdvancedPlacements = OffersAdvancedPlacementsElement.getText();
            // System.out.println("Offers placement into advanced courses: " + OffersAdvancedPlacements);
            university.setOffersAdvancedPlacements(OffersAdvancedPlacements.trim());
        } catch (NoSuchElementException e) {
            System.out.println("Offers placement into advanced courses not found");
        } 
        // get ALL majors from the majors list
        try {
            // Find the ul element
            List<WebElement> ulElements = driver.findElements(By.className("csp-profile-majors-typeahead-list-content-group-items"));
            
            for (WebElement ulElement : ulElements) {
                // Find all li elements within the ul element
                List<WebElement> liElements = ulElement.findElements(By.tagName("li"));
                
                // Loop through each li element and print its text
                for (WebElement li : liElements) {
                    // System.out.println(li.getText());
                    university.addMajorAvailable(li.getText());
                }
            }
        } catch (NoSuchElementException e) {
            System.out.println("Element Majors not found");
        }
        // System.out.println("\n" + "============================" + "\n" + university.getMajorsAvailable()+"\n" + "============================" );

    }
}