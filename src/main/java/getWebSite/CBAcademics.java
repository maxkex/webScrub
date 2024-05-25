package getWebSite;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CBAcademics
{
    public static void main( String[] args ) throws InterruptedException
    {
    }
    public static void univerCBAcademics(String urlCollegeBoard, WebDriver driver, University university) throws InterruptedException {
        urlCollegeBoard = university.getUrlCollegeBoard();
        if (urlCollegeBoard == null || urlCollegeBoard.isEmpty()) {
            return;
        }
        driver.get(urlCollegeBoard + "/academics");
        // Wait for the page to load
        Thread.sleep(2000);
        try {
            WebElement studentToFacultyElement = driver.findElement(By.xpath("//div[text()='Student-to-Faculty Ratio']/following-sibling::div"));
            String studentToFaculty = studentToFacultyElement.getText();
            System.out.println("Student-to-Faculty Ratio: " + studentToFaculty);
            university.setStudentFacultyRatio(studentToFaculty.trim());
        } catch (NoSuchElementException e) {
            System.out.println("Student-to-Faculty Ratio not found");
        }
 
        try {
            WebElement majorsCountElement = driver.findElement(By.xpath("//div[text()='Majors Available']/following-sibling::div"));
            String majorsCount = majorsCountElement.getText();
            System.out.println("Majors Available: " + majorsCount);
            university.setMajorsAvailable(majorsCount.trim());
        } catch (NoSuchElementException e) {
            System.out.println("Majors Available not found");
        }
 
        try {
            WebElement retentionRateElement = driver.findElement(By.xpath("//div[text()='Retention Rate']/following-sibling::div"));
            String retentionRate = retentionRateElement.getText();
            System.out.println("Retention Rate: " + retentionRate);
            university.setRetentionRate(retentionRate.trim());
        } catch (NoSuchElementException e) {
            System.out.println("Retention Rate not found");
        } 
        try {
            WebElement offersCreditsElement = driver.findElement(By.xpath("//p[text()='Offers credits']/following-sibling::p"));
            String offersCredits = offersCreditsElement.getText();
            System.out.println("Offers Credits: " + offersCredits);
            university.setOffersCredits(offersCredits.trim());
        } catch (NoSuchElementException e) {
            System.out.println("Offers Credits not found");
        } 
        try {
            WebElement offersAdvancedPlacementsElement = driver.findElement(By.xpath("//p[text()='Offers placement into advanced courses']/following-sibling::p"));
            String offersAdvancedPlacements = offersAdvancedPlacementsElement.getText();
            System.out.println("Offers placement into advanced courses: " + offersAdvancedPlacements);
            university.setOffersAdvancedPlacements(offersAdvancedPlacements.trim());
        } catch (NoSuchElementException e) {
            System.out.println("Offers placement into advanced courses not found");
        } 
        // ADD search for majors from my majors list

    }
}