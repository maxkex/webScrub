package getWebSite;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class CBOverview
{
    public static void main( String[] args ) throws InterruptedException
    {
    }
    public static void univerCbOverview (String urlCollegeBoard, WebDriver driver, University university) throws InterruptedException {
        urlCollegeBoard = university.getUrlCollegeBoard();
        if (urlCollegeBoard == null || urlCollegeBoard.isEmpty()) {
            return;
        }
        driver.get(urlCollegeBoard);
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
            String mapLink = driver.findElement(By.xpath("//a[contains(@href, 'https://www.google.com/maps/search')]")).getAttribute("href");
            // System.out.println(mapLink);
            university.setMapLink(mapLink);
        } catch (NoSuchElementException e) {
            System.out.println("Map link not found");
        }
        try {
            String phone = driver.findElement(By.xpath("//a[contains(@href, 'tel')]")).getText();
            // System.out.println(phone);
            university.setPhone(phone.trim());
        } catch (NoSuchElementException e) {
            System.out.println("Phone number not found");
        }
        try {
            String collegeBoardCode = driver.findElement(By.xpath("//div[contains(text(), 'College Board Code')]/following-sibling::div")).getText();
            // System.out.println(collegeBoardCode);
            university.setCollegeBoardCode(collegeBoardCode);
        } catch (NoSuchElementException e) {
            System.out.println("College Board Code not found");
        }
        try {
            String onlineApplicationLink = driver.findElement(By.id("onlineApplication")).getAttribute("href");
            // System.out.println("View Online Application: " + onlineApplicationLink);
            university.setUrl_univerOnlineApplication(onlineApplicationLink);
        } catch (NoSuchElementException e) {
            System.out.println("element View Online Application not found");
        }
    }
}