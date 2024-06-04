package getWebSite;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CBSearchGetSchools
{
    public static void main( String[] args ) throws InterruptedException
    {
    }
    public static Integer search(String URLCollegeBoard, WebDriver driver) throws InterruptedException {
        if (URLCollegeBoard == null) {
            return(0);
        }
        driver.get(URLCollegeBoard);
        // Wait for the page to load
        Thread.sleep(2000);
        try {
            WebElement collegesFoundElement = driver.findElement(By.id("cs-show-number-of-results"));
            String collegesFoundValue = collegesFoundElement.findElement(By.tagName("span")).getText();
            Integer collegesFound = Integer.parseInt(collegesFoundValue);
            System.out.println("Colleges Found: " + collegesFound);
            return (collegesFound);
        } catch (NoSuchElementException e) {
            System.out.println("Colleges count cannot be found");
            return (0);
        }
    }

    public static void getUnivers(WebDriver driver, University[] universityData) throws InterruptedException {
        boolean isShowMoreButtonDisplayed = false;
        WebElement showMoreButton = null;
        try {
           showMoreButton = driver.findElement(By.cssSelector("button[data-testid='cs-show-more-results']"));
           isShowMoreButtonDisplayed = true;
        } catch (NoSuchElementException e) {
            System.out.println("Show More button not found");

        }

    while (isShowMoreButtonDisplayed) {
        // Scroll down to the "Show More Colleges" button
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(false);", showMoreButton);
        Thread.sleep(1500);
        // Click the "Show More Colleges" button
        try {
            showMoreButton = driver.findElement(By.cssSelector("button[data-testid='cs-show-more-results']"));
            showMoreButton.click();
        } catch (NoSuchElementException e) {
            System.out.println("Show More button not found");
            break;
        }
    
        Thread.sleep(1600);
        try {
            isShowMoreButtonDisplayed = showMoreButton.isDisplayed();
        } catch (Exception e) {
            break;
        }
    }
    List<WebElement> univElements = driver.findElements(By.className("cs-college-card-outer-container"));
    Integer countOfUnivrFound = univElements.size();
    Integer udInx=countOfUnivrFound-1;
   // System.out.println("Universities found: " + countOfUnivrFound);
    

    for (WebElement univElement : univElements) {
        universityData[udInx] = new University();
        University currUniver = universityData[udInx];

        try {
            String URLCollegeBoard = univElement.findElement(By.cssSelector(".cs-college-card-container a")).getAttribute("href");
            currUniver.setURLCollegeBoard(URLCollegeBoard);
        } catch (NoSuchElementException e) {
            System.out.println("URL CollegeBoard not found");
        }

        try {
            String UniverName = univElement.findElement(By.cssSelector(".cs-college-card-college-name span")).getText();
            currUniver.setUniverName(UniverName);
        } catch (NoSuchElementException e) {
           System.out.println("University Name not found");
        }
        String UniverName = currUniver.getUniverName();
        String eaURL = currUniver.getURLCollegeBoard();
        System.out.println("~~~~~~~~| " + UniverName + " |~~~~~" + "\n" + eaURL);

        try {
            String addr = univElement.findElement(By.cssSelector("[data-testid='cs-college-card-college-Address']")).getText();
            String[] parts = addr.split(",");
            String City = parts[0].trim();
            String State = parts[1].trim();
           // System.out.println("City: " + City);
           // System.out.println("State: " + State);
            currUniver.setCity(City);
            currUniver.setState(State);
        } catch (NoSuchElementException e) {
            System.out.println("Address not found");
        }

        try {
            String UniverTypeByYears = univElement.findElement(By.cssSelector("[data-testid='cs-college-card-details-profile-school-type-by-years']")).getText();
            currUniver.setUniverTypeByYears(UniverTypeByYears);
        } catch (NoSuchElementException e) {
            System.out.println("School Type (Years) not found");
        }

        try {
            String UniverTypeByDesignation = univElement.findElement(By.cssSelector("[data-testid='cs-college-card-details-profile-school-type-by-designation']")).getText();
            currUniver.setUniverTypeByDesignation(UniverTypeByDesignation);
        } catch (NoSuchElementException e) {
            System.out.println("School Type (Designation) not found");
        }

        try {
            String UniverSize = univElement.findElement(By.cssSelector("[data-testid='cs-college-card-details-profile-school-size']")).getText();
            currUniver.setUniverSize(UniverSize);
        } catch (NoSuchElementException e) {
            System.out.println("School Size not found");
        }

        try {
            String UniverSetting = univElement.findElement(By.cssSelector("[data-testid='cs-college-card-details-profile-school-setting']")).getText();
            currUniver.setUniverSetting(UniverSetting);
        } catch (NoSuchElementException e) {
            System.out.println("School Setting not found");
        }

        try {
            String GraduationRate = univElement.findElement(By.cssSelector("[data-testid='cs-college-card-details-profile-school-graduation-rate'] strong")).getText();
            currUniver.setGraduationRate(GraduationRate);
        } catch (NoSuchElementException e) {
            System.out.println("Graduation Rate not found");
        }
    
        String SATScoreRange = "";
        try {
            SATScoreRange = univElement.findElement(By.cssSelector("[data-testid='cs-college-card-details-profile-school-sat-range'] span")).getText();
        } catch (NoSuchElementException e) {
            SATScoreRange = univElement.findElement(By.cssSelector("[data-testid='cs-college-card-details-profile-school-sat-range'] strong")).getText();
        }
         currUniver.setSATScoreRange(SATScoreRange);
    
        udInx--;
    } 
    }
}