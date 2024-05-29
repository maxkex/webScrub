package getWebSite;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CBCampusLife
{
    public static void main( String[] args ) throws InterruptedException
    {
    }
    public static void univerCBCampusLife(String urlCollegeBoard, WebDriver driver, University university) throws InterruptedException {
        urlCollegeBoard = university.getUrlCollegeBoard();
        if (urlCollegeBoard == null || urlCollegeBoard.isEmpty()) {
            return;
        }
        driver.get(urlCollegeBoard + "/campus-life");
        // Wait for the page to load
        Thread.sleep(2000);
        try {
            String underGradStudents = driver.findElement(By.xpath("//div[text()='Undergraduate Students']/following-sibling::div")).getText();
            // System.out.println("Undergraduate Students: " + underGradStudents);
            university.setUnderGradStudents(underGradStudents);
        } catch (NoSuchElementException e) {
           System.out.println("element Undergraduate Students not found");
        }
        try {
            WebElement housingData = driver.findElement(By.id("csp-housing-data-1"));
            List<WebElement> elements = housingData.findElements(By.xpath(".//p"));
            String fYHosing = elements.get(1).getText();
            // System.out.println("First-Years in College Housing: " + fYHosing);
            university.setFirstYearsInCollegeHousing(fYHosing);
        } catch (NoSuchElementException e) {
           System.out.println("element 'First-Years in College Housing' not found");
        }

        try {
            String totalGradStudents = driver.findElement(By.id("csp-list-item-total-graduates-value")).getText();
            // System.out.println("Total Graduate Students: " + totalGradStudents);
            university.setGraduateStudents(totalGradStudents);
        } catch (NoSuchElementException e) {
            System.out.println("element Total Graduate Students not found");
        }
        try {
            String fullTimeStudents = driver.findElement(By.id("csp-list-item-full-time-enrollment-value")).getText();
            // System.out.println("Full-Time Students: " + fullTimeStudents);
            university.setFullTimeStudents(fullTimeStudents);
        } catch (NoSuchElementException e) {
            System.out.println("element Full-Time Students not found");
        }
        try {
            String partTimeStudents = driver.findElement(By.id("csp-list-item-part-time-enrollment-value")).getText();
            // System.out.println("Part-Time Students: " + partTimeStudents);
            university.setPartTimeStudents(partTimeStudents);
        } catch (NoSuchElementException e) {
            System.out.println("element Part-Time Students not found");
        }
        try {
            String blackOrAfricanAmericanStudents = driver.findElement(By.id("csp-list-item-african-american-value")).getText().replaceAll("[^0-9%]", "");
            // System.out.println("Black or African American Students: " + blackOrAfricanAmericanStudents);
            university.setEthn_black(blackOrAfricanAmericanStudents);
        } catch (NoSuchElementException e) {
            System.out.println("element Black or African American Students not found");
        }
        try {
            String asianStudents = driver.findElement(By.id("csp-list-item-asian-value")).getText().replaceAll("[^0-9%]", "");
            // System.out.println("Asian Students: " + asianStudents);
            university.setEthn_asians(asianStudents);
        } catch (NoSuchElementException e) {
            System.out.println("element Asian Students not found");
        }
        try {
            String hispanicStudents = driver.findElement(By.id("csp-list-item-hispanic-value")).getText().replaceAll("[^0-9%]", "");
            // System.out.println("Hispanic or Latino Students: " + hispanicStudents);
            university.setEthn_hispanics(hispanicStudents);
        } catch (NoSuchElementException e) {
            System.out.println("element Hispanic or Latino Students not found");
        }
        try {
            String multiracialStudents = driver.findElement(By.id("csp-list-item-multiracial-value")).getText().replaceAll("[^0-9%]", "");
            // System.out.println("Multiracial Students: " + multiracialStudents);
            university.setEthn_multi(multiracialStudents);
        } catch (NoSuchElementException e) {
            System.out.println("element Multiracial Students not found");
        }
        try {
            String nativeAmericanStudents = driver.findElement(By.id("csp-list-item-native-american-value")).getText().replaceAll("[^0-9%]", "");
            // System.out.println("Native American Students: " + nativeAmericanStudents);
            university.setEthn_nativAm(nativeAmericanStudents);
        } catch (NoSuchElementException e) {
            System.out.println("element Native American Students not found");
        }
        try {
            String pacificIslanderStudents = driver.findElement(By.id("csp-list-item-pacific-islander-value")).getText().replaceAll("[^0-9%]", "");
            // System.out.println("Pacific Islander Students: " + pacificIslanderStudents);
            university.setEthn_pacificIslr(pacificIslanderStudents);
        } catch (NoSuchElementException e) {
            System.out.println("element Pacific Islander Students not found");
        }
        try {
            String unknownStudents = driver.findElement(By.id("csp-list-item-unknown-value")).getText().replaceAll("[^0-9%]", "");
            // System.out.println("Native American Students: " + unknownStudents);
            university.setEthn_unknown(unknownStudents);
        } catch (NoSuchElementException e) {
            System.out.println("element Unknown Students not found");
        }
        try {
            String whiteStudents = driver.findElement(By.id("csp-list-item-white-value")).getText().replaceAll("[^0-9%]", "");
            // System.out.println("White Students: " + whiteStudents);
            university.setEthn_white(whiteStudents);
        } catch (NoSuchElementException e) {
            System.out.println("element White Students not found");
        }
        try {
            String internationalStudents = driver.findElement(By.id("csp-list-item-international-value")).getText().replaceAll("[^0-9%]", "");
            // System.out.println("International (Non-Citizen) Students: " + internationalStudents);
            university.setEthn_intenational(internationalStudents);
        } catch (NoSuchElementException e) {
            System.out.println("element International (Non-Citizen) Students not found");
        }
        try {
            String outOfStateStudents = driver.findElement(By.id("csp-list-item-out-of-state-value")).getText();
            // System.out.println("Out-of-State Students: " + outOfStateStudents);
            university.setPriRes_OutState(outOfStateStudents);
        } catch (NoSuchElementException e) {
            System.out.println("element Out-of-State Students not found");
        }
    }
}