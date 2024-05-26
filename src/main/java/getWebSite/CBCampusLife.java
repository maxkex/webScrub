package getWebSite;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

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
            System.out.println("Undergraduate Students: " + underGradStudents);
            university.setUnderGradStudents(underGradStudents);
        } catch (NoSuchElementException e) {
            System.out.println("Undergraduate Students not found");
        }

    }
}