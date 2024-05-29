package getWebSite;
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
            // System.out.println("Average Per Year After Aid: " + costAvrgPerYearAfterAid);
            university.setCostAvrgPerYearAfterAid(costAvrgPerYearAfterAid);
        } catch (NoSuchElementException e) {
            System.out.println("Average Per Year After Aid not found");
        }
        try {
            WebElement avrgAidPackageElement = driver.findElement(By.xpath("//div[text()='Average Aid Package']/following-sibling::div"));
            String avrgAidPackage = avrgAidPackageElement.getText();
            // System.out.println("Average Aid Package: " + avrgAidPackage);
            university.setAvrgAidPackage(avrgAidPackage.trim());
        } catch (NoSuchElementException e) {
            System.out.println("Average Aid Package not found");
        }
 
        try {
            WebElement studentsReceivFinAidElement = driver.findElement(By.xpath("//div[text()='Students Receiving Financial Aid']/following-sibling::div"));
            String studentsReceivFinAid = studentsReceivFinAidElement.getText();
            // System.out.println("Students Receiving Financial Aid: " + studentsReceivFinAid);
            university.setStudentsReceivFinAid(studentsReceivFinAid.trim());
        } catch (NoSuchElementException e) {
            System.out.println("Students Receiving Financial Aid not found");
        }
        try {
            String inStateTuition = driver.findElement(By.id("csp-list-item-csp-tuition-data-1-0-value")).getText().replaceAll("[^0-9]+$", "");
            // System.out.println("In-State Tuition: " + inStateTuition);
            university.setcostInStateFull(inStateTuition);
        } catch (NoSuchElementException e) {
            System.out.println("element In-State Tuition not found");
        }

        try {
            String outOfStateTuition = driver.findElement(By.id("csp-list-item-csp-tuition-data-1-1-value")).getText().replaceAll("[^0-9]+$", "");
            // System.out.println("Out-of-State Tuition: " + outOfStateTuition);
            // Set the tuition value in the university object
            university.setCostOutOfStateFull(outOfStateTuition);
        } catch (NoSuchElementException e) {
            System.out.println("element Out-of-State Tuition not found");
        }

        try {
            String cost100K = driver.findElement(By.id("csp-list-item-csp-tuition-data-0-4-value")).getText().replaceAll("[^0-9]+$", "");
            // System.out.println("Cost for $110k+ income: " + cost100K);
            // Set the value in the university object
            university.setCostFor110kHHIncome(cost100K);
        } catch (NoSuchElementException e) {
            System.out.println("element Cost of $110k+ value not found");
        }

        try {
            String housingCost = driver.findElement(By.id("csp-list-item-csp-tuition-data-2-0-value")).getText().replaceAll("[^0-9]+$", "");
            // System.out.println("Housing Cost: " + housingCost);
            // Set the value in the university object
            university.setCostHousing(housingCost);
        } catch (NoSuchElementException e) {
            System.out.println("Housing cost not found");
        }
        try {
            String booksSuppliesCost = driver.findElement(By.id("csp-list-item-csp-tuition-data-2-1-value")).getText().replaceAll("[^0-9]+$", "");
            // System.out.println("Books and Supplies Cost: " + booksSuppliesCost);
            // Set the value in the university object
            university.setCostBooksSuppl(booksSuppliesCost);
        } catch (NoSuchElementException e) {
            System.out.println("Books and Supplies cost not found");
        }
        try {
            String personalExpensesCost = driver.findElement(By.id("csp-list-item-csp-tuition-data-2-2-value")).getText().replaceAll("[^0-9]+$", "");
            //System.out.println("Personal Expenses Cost: " + personalExpensesCost);
            // Set the value in the university object
            university.setCostPersonalExpenses(personalExpensesCost);
        } catch (NoSuchElementException e) {
            System.out.println("element Personal Expenses not found");
        }
        try {
            String transportationCost = driver.findElement(By.id("csp-list-item-csp-tuition-data-2-3-value")).getText().replaceAll("[^0-9]+$", "");
            // System.out.println("Transportation Cost: " + transportationCost);
            // Set the value in the university object
            university.setCostTransportation(transportationCost);
        } catch (NoSuchElementException e) {
            System.out.println("Transportation cost not found");
        }
    }
}