package getWebSite;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class CBOverview
{
    public static void main( String[] args ) throws InterruptedException
    {
    }
    public static void univerCbOverview (String URLCollegeBoard, WebDriver driver, University university) throws InterruptedException {
        URLCollegeBoard = university.getURLCollegeBoard();
        if (URLCollegeBoard == null || URLCollegeBoard.isEmpty()) {
            return;
        }
        driver.get(URLCollegeBoard);
        // Wait for the page to load
        Thread.sleep(2000);
        try {
            String fullAddr = driver.findElement(By.xpath("//a[contains(@href, 'https://www.google.com/maps/search')]")).getText();
            // System.out.println(fullAddr);
            university.setAddress(fullAddr.trim());
        } catch (NoSuchElementException e) {
            // System.out.println("Address not found");
        }
        try {
            String MapLink = driver.findElement(By.xpath("//a[contains(@href, 'https://www.google.com/maps/search')]")).getAttribute("href");
            // System.out.println(MapLink);
            university.setMapLink(MapLink);
        } catch (NoSuchElementException e) {
            System.out.println("Map link not found");
        }
        try {
            String Phone = driver.findElement(By.xpath("//a[contains(@href, 'tel')]")).getText();
            // System.out.println(Phone);
            university.setPhone(Phone.trim());
        } catch (NoSuchElementException e) {
            System.out.println("Phone number not found");
        }
        try {
            String CollegeBoardCode = driver.findElement(By.xpath("//div[contains(text(), 'College Board Code')]/following-sibling::div")).getText();
            // System.out.println(CollegeBoardCode);
            university.setCollegeBoardCode(CollegeBoardCode);
        } catch (NoSuchElementException e) {
            System.out.println("College Board Code not found");
        }
        try {
            String onlineApplicationLink = driver.findElement(By.id("onlineApplication")).getAttribute("href");
            // System.out.println("View Online Application: " + onlineApplicationLink);
            university.setUniverOnlineApplicationURL(onlineApplicationLink);
        } catch (NoSuchElementException e) {
            System.out.println("element View Online Application not found");
        }
    }
}