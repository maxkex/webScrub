package getWebSite;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class CollegeBoard
{
    public static void main( String[] args ) throws InterruptedException
    {
    String SearchURL = "https://bigfuture.collegeboard.org/college-search/filters?s=AL&s=WY&s=WI&s=WV&s=WA&s=VA&s=VT&s=UT&s=TX&s=TN&s=SD&s=SC&s=RI&s=PR&s=PA&s=OH&s=OK&s=ND&s=NC&s=NY&s=NM&s=NH&s=NJ&s=NV&s=NE&s=MA&s=MI&s=MN&s=AZ&s=AR&s=CA&s=CO&s=CT&s=DC&s=DE&s=FL&s=AK&s=GA&s=HI&s=ID&s=IL&s=IN&s=IA&s=KS&s=KY&s=LA&s=ME&s=MD&s=MS&s=MO&s=MT&deg=masters&deg=bachelors&mc=Computer_Hardware_Engineering&mc=Applied_Economics&mc=Computer_and_Information_Systems_Security&mc=Computer_Systems_Analysis&mc=Information_Technology,_General&mc=Computational_and_Applied_Mathematics&mc=Statistics&mc=Physics,_General&mc=Engineering_Physics&mc=Computer_Software_Engineering&mc=Computer_Science,_General&mc=Information_Science&stby=4";
    //String SearchURL = "https://bigfuture.collegeboard.org/college-search/filters?mc=Aerospace_Engineering&deg=bachelors&s=CA&s=MA&stby=4";
    ChromeOptions chromeoption=new ChromeOptions();
    chromeoption.addArguments("--remote-allow-origins=*");
    System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
    WebDriver driver = new ChromeDriver(chromeoption);
    // Declare and initialize the targetSize variable
   // org.openqa.selenium.Dimension targetSize = new Dimension(1400, 1800);
    //driver.manage().window().setSize(targetSize);

    // debug of getEachUniver
    University[] universityData = new University[5];
    System.out.println("universityData: " + universityData.length);
    universityData[0] = new University();
    universityData[0].setUrlCollegeBoard("https://bigfuture.collegeboard.org/colleges/university-of-california-davis");
    universityData[1] = new University();
    universityData[1].setUrlCollegeBoard("https://bigfuture.collegeboard.org/colleges/stanford-university");
    universityData[2] = new University();
    universityData[2].setUrlCollegeBoard("https://bigfuture.collegeboard.org/colleges/bluefield-state-university");
    universityData[3] = new University();
    universityData[3].setUrlCollegeBoard("https://bigfuture.collegeboard.org/colleges/university-of-florida");
    universityData[4] = new University();
    universityData[4].setUrlCollegeBoard("https://bigfuture.collegeboard.org/colleges/massachusetts-institute-of-technology");
    for (University university : universityData) {
        String eaURL = university.getUrlCollegeBoard();
    new CBCosts().univerCBCosts(eaURL, driver, university);
    //new CBAcademics().univerCBAcademics(eaURL, driver, university);
    //new CBAdmissions().univerCBAdmissions(eaURL, driver, university);
        //
    System.out.println("-------------------------------------");
        //univerCBAdmissions(eaURL, driver, university);
    //      univerCbOverview(eaURL, driver, university);
    }
    // end of debug getEachUniver
    driver.get(SearchURL);
    Thread.sleep(2000);


    WebElement showMoreButton = driver.findElement(By.cssSelector("button[data-testid='cs-show-more-results']"));

    while (true) {
        // Scroll down to the "Show More Colleges" button
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(false);", showMoreButton);
        Thread.sleep(1500);
        // Click the "Show More Colleges" button
        showMoreButton.click();
        Thread.sleep(1500);

        boolean isShowMoreButtonDisplayed;
        try {
            isShowMoreButtonDisplayed = showMoreButton.isDisplayed();
        } catch (Exception e) {
            break;
        }
    }

    List<WebElement> univElements = driver.findElements(By.className("cs-college-card-outer-container"));
    int countOfUnivrFound = univElements.size();
  //  University[] universityData = new University[countOfUnivrFound]; 
    int udInx=countOfUnivrFound-1;
    System.out.println("Universities found: " + countOfUnivrFound);
    

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
            System.out.println("University Name not found");
        }

        try {
            String addr = univElement.findElement(By.cssSelector("[data-testid='cs-college-card-college-address']")).getText();
            String[] parts = addr.split(",");
            String city = parts[0].trim();
            String state = parts[1].trim();
            System.out.println("City: " + city);
            System.out.println("State: " + state);
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
        
        // Print the values from universityData[udInx]
        System.out.println((countOfUnivrFound - udInx) + " of " + countOfUnivrFound);
        System.out.println("University Name: " + universityData[udInx].getUniverName());
        System.out.println("Address: " + universityData[udInx].getAddress());
        System.out.println("School Type (Years): " + universityData[udInx].getSchoolTypeByYears());
        System.out.println("School Type (Designation): " + universityData[udInx].getSchoolTypeByDesignation());
        System.out.println("School Size: " + universityData[udInx].getSchoolSize());
        System.out.println("School Setting: " + universityData[udInx].getSchoolSetting());
        System.out.println("Graduation Rate: " + universityData[udInx].getGraduationRate());
        System.out.println("SAT Score Range: " + universityData[udInx].getSatScoreRange());
        System.out.println("URL CollegeBoard: " + universityData[udInx].getUrlCollegeBoard());
        System.out.println("-----------------------------------");

                
        try (PrintWriter writer = new PrintWriter(new FileWriter("/Users/qarnd/Downloads/universityData.txt", true))) {
            StringBuilder sb = new StringBuilder();
            String delim = "|";
            // Append the data for each university
            sb.append((countOfUnivrFound - udInx) + " of " + countOfUnivrFound);
            sb.append(delim);
            sb.append(universityData[udInx].getUniverName());
            sb.append(delim);
            sb.append(universityData[udInx].getAddress());
            sb.append(delim);
            sb.append(universityData[udInx].getSchoolTypeByYears());
            sb.append(delim);
            sb.append(universityData[udInx].getSchoolTypeByDesignation());
            sb.append(delim);
            sb.append(universityData[udInx].getSchoolSize());
            sb.append(delim);
            sb.append(universityData[udInx].getSchoolSetting());
            sb.append(delim);
            sb.append(universityData[udInx].getGraduationRate());
            sb.append(delim);
            sb.append(universityData[udInx].getSatScoreRange());
            sb.append(delim);
            sb.append(universityData[udInx].getUrlCollegeBoard());
            sb.append('\n');
            writer.append(sb.toString());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        udInx--;
        // Process the extracted values here
    }

  
    // Close the browser
    driver.quit();
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
            System.out.println(fullAddr);
            university.setAddress(fullAddr.trim());
        } catch (NoSuchElementException e) {
            System.out.println("Address not found");
        }
        try {
            String mapLink = driver.findElement(By.xpath("//a[contains(@href, 'https://www.google.com/maps/search')]")).getAttribute("href");
            System.out.println(mapLink);
            university.setMapLink(mapLink);
        } catch (NoSuchElementException e) {
            System.out.println("Map link not found");
        }
        try {
            String phone = driver.findElement(By.xpath("//a[contains(@href, 'tel')]")).getText();
            System.out.println(phone);
            university.setPhone(phone.trim());
        } catch (NoSuchElementException e) {
            System.out.println("Phone number not found");
        }
    }
}