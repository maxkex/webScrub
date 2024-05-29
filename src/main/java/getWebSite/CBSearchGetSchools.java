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
    public static Integer search(String urlCollegeBoard, WebDriver driver) throws InterruptedException {
        if (urlCollegeBoard == null) {
            return(0);
        }
        driver.get(urlCollegeBoard);
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
        showMoreButton.click();
        Thread.sleep(1600);
        try {
            isShowMoreButtonDisplayed = showMoreButton.isDisplayed();
        } catch (Exception e) {
            break;
        }
    }
    List<WebElement> univElements = driver.findElements(By.className("cs-college-card-outer-container"));
    int countOfUnivrFound = univElements.size();
    int udInx=countOfUnivrFound-1;
   // System.out.println("Universities found: " + countOfUnivrFound);
    

    for (WebElement univElement : univElements) {
        universityData[udInx] = new University();
        University currUniver = universityData[udInx];

        try {
            String urlCollegeBoard = univElement.findElement(By.cssSelector(".cs-college-card-container a")).getAttribute("href");
            currUniver.setUrlCollegeBoard(urlCollegeBoard);
        } catch (NoSuchElementException e) {
            System.out.println("URL CollegeBoard not found");
        }

        try {
            String univerName = univElement.findElement(By.cssSelector(".cs-college-card-college-name span")).getText();
            currUniver.setUniverName(univerName);
        } catch (NoSuchElementException e) {
           // System.out.println("University Name not found");
        }

        try {
            String addr = univElement.findElement(By.cssSelector("[data-testid='cs-college-card-college-address']")).getText();
            String[] parts = addr.split(",");
            String city = parts[0].trim();
            String state = parts[1].trim();
           // System.out.println("City: " + city);
           // System.out.println("State: " + state);
            currUniver.setCity(city);
            currUniver.setState(state);
        } catch (NoSuchElementException e) {
            System.out.println("Address not found");
        }

        try {
            String schoolTypeByYears = univElement.findElement(By.cssSelector("[data-testid='cs-college-card-details-profile-school-type-by-years']")).getText();
            currUniver.setSchoolTypeByYears(schoolTypeByYears);
        } catch (NoSuchElementException e) {
            System.out.println("School Type (Years) not found");
        }

        try {
            String schoolTypeByDesignation = univElement.findElement(By.cssSelector("[data-testid='cs-college-card-details-profile-school-type-by-designation']")).getText();
            currUniver.setSchoolTypeByDesignation(schoolTypeByDesignation);
        } catch (NoSuchElementException e) {
            System.out.println("School Type (Designation) not found");
        }

        try {
            String schoolSize = univElement.findElement(By.cssSelector("[data-testid='cs-college-card-details-profile-school-size']")).getText();
            currUniver.setSchoolSize(schoolSize);
        } catch (NoSuchElementException e) {
            System.out.println("School Size not found");
        }

        try {
            String schoolSetting = univElement.findElement(By.cssSelector("[data-testid='cs-college-card-details-profile-school-setting']")).getText();
            currUniver.setSchoolSetting(schoolSetting);
        } catch (NoSuchElementException e) {
            System.out.println("School Setting not found");
        }

        try {
            String graduationRate = univElement.findElement(By.cssSelector("[data-testid='cs-college-card-details-profile-school-graduation-rate'] strong")).getText();
            currUniver.setGraduationRate(graduationRate);
        } catch (NoSuchElementException e) {
            System.out.println("Graduation Rate not found");
        }
    
        String satScoreRange = "";
        try {
            satScoreRange = univElement.findElement(By.cssSelector("[data-testid='cs-college-card-details-profile-school-sat-range'] span")).getText();
        } catch (NoSuchElementException e) {
            satScoreRange = univElement.findElement(By.cssSelector("[data-testid='cs-college-card-details-profile-school-sat-range'] strong")).getText();
        }
         currUniver.setSatScoreRange(satScoreRange);
    
        udInx--;
    } 
    }
}