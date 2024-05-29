package getWebSite;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class CollegeBoard
{
    public static void main( String[] args ) throws InterruptedException
    {
    List<String> majorKeywords = new ArrayList<>();
        majorKeywords.add("statistics");
        majorKeywords.add("comput");
        
    // ALL String SearchURL = "https://bigfuture.collegeboard.org/college-search/filters?s=AL&s=WY&s=WI&s=WV&s=WA&s=VA&s=VT&s=UT&s=TX&s=TN&s=SD&s=SC&s=RI&s=PR&s=PA&s=OH&s=OK&s=ND&s=NC&s=NY&s=NM&s=NH&s=NJ&s=NV&s=NE&s=MA&s=MI&s=MN&s=AZ&s=AR&s=CA&s=CO&s=CT&s=DC&s=DE&s=FL&s=AK&s=GA&s=HI&s=ID&s=IL&s=IN&s=IA&s=KS&s=KY&s=LA&s=ME&s=MD&s=MS&s=MO&s=MT&deg=masters&deg=bachelors&mc=Computer_Hardware_Engineering&mc=Applied_Economics&mc=Computer_and_Information_Systems_Security&mc=Computer_Systems_Analysis&mc=Information_Technology,_General&mc=Computational_and_Applied_Mathematics&mc=Statistics&mc=Physics,_General&mc=Engineering_Physics&mc=Computer_Software_Engineering&mc=Computer_Science,_General&mc=Information_Science&stby=4";
    String SearchURL = "https://bigfuture.collegeboard.org/college-search/filters?mc=Aerospace_Engineering&deg=bachelors&s=CA&s=MA&stby=4";
    //String SearchURL = "https://bigfuture.collegeboard.org/college-search/filters?z=95765&z=200mi&deg=bachelors&mc=Computational_and_Applied_Mathematics&stby=4";
    ChromeOptions chromeoption=new ChromeOptions();
    chromeoption.addArguments("--remote-allow-origins=*");
    System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
    WebDriver driver = new ChromeDriver(chromeoption);
    // Declare and initialize the targetSize variable
   // org.openqa.selenium.Dimension targetSize = new Dimension(1400, 1800);
    //driver.manage().window().setSize(targetSize);

    Integer universFoundCount = new CBSearchGetSchools().search(SearchURL, driver);
   // System.out.println("universFoundCount: " + universFoundCount);
    University[] universityData = new University[universFoundCount]; 
    //University[] universityData = new University[5];
    //System.out.println("universityData: " + universityData.length);
    new CBSearchGetSchools().getUnivers(driver, universityData); 
     /*
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
    */
    for (University university : universityData) {
        String univerName = university.getUniverName();
        String eaURL = university.getUrlCollegeBoard();
    System.out.println("----------------| " + univerName + " |------" + "\n" + eaURL);
    new CBOverview().univerCbOverview(eaURL, driver, university);
    new CBAdmissions().univerCBAdmissions(eaURL, driver, university);
    new CBAcademics().univerCBAcademics(eaURL, driver, university);
    new CBCosts().univerCBCosts(eaURL, driver, university);
    new CBCampusLife().univerCBCampusLife(eaURL, driver, university);
    }
    // Close the browser
    driver.quit();
    }
}