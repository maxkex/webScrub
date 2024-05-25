package getWebSite;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CBAdmissions
{
    public static void main( String[] args ) throws InterruptedException
    {
    }
    public static void univerCBAdmissions(String urlCollegeBoard, WebDriver driver, University university) throws InterruptedException {
        urlCollegeBoard = university.getUrlCollegeBoard();
        if (urlCollegeBoard == null || urlCollegeBoard.isEmpty()) {
            return;
        }
        driver.get(urlCollegeBoard + "/admissions");
        // Wait for the page to load
        Thread.sleep(2000);
        try {
            WebElement totalApplicantsElement = driver.findElement(By.xpath("//div[text()='Total Applicants']/following-sibling::div"));
            String totalApplicants = totalApplicantsElement.getText();
            System.out.println("Total Applicants: " + totalApplicants);
            university.setTotalApplicants(totalApplicants.trim());
        } catch (NoSuchElementException e) {
            System.out.println("Total Applicants not found");
        }
        try {
            WebElement admittedElement = driver.findElement(By.xpath("//div[text()='Admitted']/following-sibling::div"));
            String admitted = admittedElement.getText();
            System.out.println("Admitted Applicants: " + admitted);
            university.setAdmittedAppl(admitted.trim());
        } catch (NoSuchElementException e) {
            System.out.println("Admitted Applicants not found");
        }
        try {
            WebElement enrolledElement = driver.findElement(By.xpath("//div[text()='Enrolled']/following-sibling::div"));
            String enrolled = enrolledElement.getText();
            System.out.println("Enrolled applicants: " + enrolled);
            university.setEnrolledAppl(enrolled.trim());
        } catch (NoSuchElementException e) {
            System.out.println("Enrolled applicants not found");
        }
        try {
            String univerWebsite = driver.findElement(By.xpath("//a[contains(text(), 'visiting the college website')]")).getAttribute("href");
            System.out.println("UniverWebsite: " + univerWebsite);
            university.setUrlUniverWebSite(univerWebsite);
        } catch (NoSuchElementException e) {
            System.out.println("College website not found");
        }
       
        try {
            String acceptanceRate = driver.findElement(By.xpath("//div[text()='Acceptance Rate']/following-sibling::div")).getText();
            System.out.println("Acceptance Rate: " + acceptanceRate);
            university.setAcceptanceRate(acceptanceRate);
        } catch (NoSuchElementException e) {
            System.out.println("Acceptance Rate not found");
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