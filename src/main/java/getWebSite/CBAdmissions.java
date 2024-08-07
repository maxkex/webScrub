package getWebSite;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import dataObjects.University;

public class CBAdmissions
{
    public static void main( String[] args ) throws InterruptedException
    {
    }
    public static void univerCBAdmissions(String URLCollegeBoard, WebDriver driver, University university) throws InterruptedException {
        URLCollegeBoard = university.getURLCollegeBoard();
        if (URLCollegeBoard == null || URLCollegeBoard.isEmpty()) {
            return;
        }
        driver.get(URLCollegeBoard + "/admissions");
        // Wait for the page to load
        Thread.sleep(2000);
       
    try {
        WebElement regularApplicationElement = driver.findElement(By.xpath("//div[text()='Regular Application Due']/following-sibling::div"));
        String regularApplication = regularApplicationElement.getText();
        System.out.println("Regular Application Date: " + regularApplication);
        university.setRegularAppDueDate(regularApplication.trim());
    } catch (NoSuchElementException e) {
        System.out.println("Regular Application Date not found");
    }
       
        try {
            WebElement ApplicantsTotalElement = driver.findElement(By.xpath("//div[text()='Total Applicants']/following-sibling::div"));
            String ApplicantsTotal = ApplicantsTotalElement.getText();
            // System.out.println("Total Applicants: " + ApplicantsTotal);
            university.setApplicantsTotal(ApplicantsTotal.trim());
        } catch (NoSuchElementException e) {
            System.out.println("Total Applicants not found");
        }
        try {
            WebElement admittedElement = driver.findElement(By.xpath("//div[text()='Admitted']/following-sibling::div"));
            String admitted = admittedElement.getText();
            // System.out.println("Admitted Applicants: " + admitted);
            university.setApplicantsAdmitted(admitted.trim());
        } catch (NoSuchElementException e) {
            System.out.println("Admitted Applicants not found");
        }
        try {
            WebElement enrolledElement = driver.findElement(By.xpath("//div[text()='Enrolled']/following-sibling::div"));
            String enrolled = enrolledElement.getText();
            // System.out.println("Enrolled applicants: " + enrolled);
            university.setApplicantsEnrolled(enrolled.trim());
        } catch (NoSuchElementException e) {
            System.out.println("Enrolled applicants not found");
        }
        try {
            String univerWebsite = driver.findElement(By.xpath("//a[contains(text(), 'visiting the college website')]")).getAttribute("href");
            // System.out.println("UniverWebsite: " + univerWebsite);
            String UniverURLfriendly = "=HYPERLINK(\"" + univerWebsite + "\",\"" + university.getUniverName() + "\")";
            university.setUniverName(UniverURLfriendly);
        } catch (NoSuchElementException e) {
            System.out.println("College website not found");
        }
       
        try {
            String AcceptanceRate = driver.findElement(By.xpath("//div[text()='Acceptance Rate']/following-sibling::div")).getText();
            // System.out.println("Acceptance Rate: " + AcceptanceRate);
            university.setAcceptanceRate(AcceptanceRate);
        } catch (NoSuchElementException e) {
            System.out.println("Acceptance Rate not found");
        }
        try {
            WebElement feeElement = driver.findElement(By.cssSelector(".cs-label-value-pair-value.cs-application-process-application-fee"));
            String fee = feeElement.getText();
            // System.out.println("Application Fee: " + fee);
            university.setApplicationFee(fee);
        } catch (NoSuchElementException e) {
            System.out.println("Application Fee not found");
        }
        
        try {
            List<WebElement> elements = driver.findElements(By.cssSelector("#selected-range-label"));
            for (WebElement element : elements) {
                String ariaLabel = element.getAttribute("aria-label");
                // extract SAT test type and score
                Pattern pattern = Pattern.compile("SAT (\\w+).*:\\s*(.*)");
                Matcher matcher = pattern.matcher(ariaLabel);
                // System.out.println(ariaLabel);

                if (matcher.find()) {
                    String discipline = matcher.group(1).trim().toLowerCase();
                    String score = matcher.group(2).trim();
                    switch (discipline) {
                        case "composite":
                            university.setSATTotalRange(score);
                            // System.out.println("SAT Composite: " + score);
                            break;
                        case "reading":
                            university.setSATReadingRange(score);
                            // System.out.println("SAT Reading: " + score);
                            break;
                        case "math":
                            university.setSATMathRange(score);
                            // System.out.println("SAT Math: " + score);
                            break;
                        default:
                            // System.out.println("Unknown SAT discipline: " + discipline + " :" + score);
                            break;
                    }
                }
            }
        } catch (NoSuchElementException e) {
            System.out.println("SAT score range not available");
        }

    }
}