package getWebSite;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;

import dataObjects.University;
import fileIO.readFile;
import fileIO.writeToFile;

public class webScrubMain
{
    public static void main( String[] args ) throws InterruptedException, IllegalArgumentException, IllegalAccessException
    {
    // file to write results to
    String path = "./data/";
    String excelFileName = "myUniverData2024.xlsx";
    String sheetName = "wuTest";

    // list of keywords to search majors
    List<String> majorKeywords = new ArrayList<>();
        majorKeywords.add("statist");
        majorKeywords.add("comput");
       // majorKeywords.add("engineer");
       // majorKeywords.add("data");
       // majorKeywords.add("cyber");
    // collebe board search URL, refined to your search criteria

    //ALL! 
    String SearchURL = "https://bigfuture.collegeboard.org/college-search/filters?deg=bachelors&deg=masters&deg=doctoral";
    // MY LIST with Majors: String SearchURL = "https://bigfuture.collegeboard.org/college-search/filters?s=AL&s=WY&s=WI&s=WV&s=WA&s=VA&s=VT&s=UT&s=TX&s=TN&s=SD&s=SC&s=RI&s=PR&s=PA&s=OH&s=OK&s=ND&s=NC&s=NY&s=NM&s=NH&s=NJ&s=NV&s=NE&s=MA&s=MI&s=MN&s=AZ&s=AR&s=CA&s=CO&s=CT&s=DC&s=DE&s=FL&s=AK&s=GA&s=HI&s=ID&s=IL&s=IN&s=IA&s=KS&s=KY&s=LA&s=ME&s=MD&s=MS&s=MO&s=MT&deg=masters&deg=bachelors&mc=Computer_Hardware_Engineering&mc=Applied_Economics&mc=Computer_and_Information_Systems_Security&mc=Computer_Systems_Analysis&mc=Information_Technology,_General&mc=Computational_and_Applied_Mathematics&mc=Statistics&mc=Physics,_General&mc=Engineering_Physics&mc=Computer_Software_Engineering&mc=Computer_Science,_General&mc=Information_Science&stby=4";
    // ALL Majors, ALL US Colleges: String SearchURL = "https://bigfuture.collegeboard.org/college-search/filters?s=AL&s=WY&s=WI&s=WV&s=WA&s=VA&s=VT&s=UT&s=TX&s=TN&s=SD&s=SC&s=RI&s=PR&s=PA&s=OH&s=OK&s=ND&s=NC&s=NY&s=NM&s=NH&s=NJ&s=NV&s=NE&s=MA&s=MI&s=MN&s=AZ&s=AR&s=CA&s=CO&s=CT&s=DC&s=DE&s=FL&s=AK&s=GA&s=HI&s=ID&s=IL&s=IN&s=IA&s=KS&s=KY&s=LA&s=ME&s=MD&s=MS&s=MO&s=MT&s=OR&deg=masters&deg=bachelors&stby=4";
    // DEBUG - 18 univers String SearchURL = "https://bigfuture.collegeboard.org/college-search/filters?mc=Aerospace_Engineering&deg=bachelors&s=CA&s=MA&stby=4";
    // 4 colleges for debug: String SearchURL = "https://bigfuture.collegeboard.org/college-search/filters?mc=Computer_Science,_General&mc=Computer_Software_Engineering&mc=Information_Science&deg=bachelors&stby=4&z=95765&z=50mi";

    // read universities from file
    University[] universityData = readFile.readExcelFile(path + excelFileName, sheetName);  
    System.out.println("universityData: " + universityData.length);
    
    // search for universities on the College Board website
    /* 
    //create a new instance of the webDriver
    WebDriver driver = myWebDriver.getDriver();
    Integer universFoundCount = CBSearchGetSchools.search(SearchURL, driver);
    System.out.println("universFoundCount: " + universFoundCount);
    University[] universityData = new University[universFoundCount]; 
    //University[] universityData = new University[5];
    //System.out.println("universityData: " + universityData.length);
    new CBSearchGetSchools().getUnivers(driver, universityData); 
    driver.quit();
    writeToFile.writeExcelFile(path + excelFileName,sheetName, universityData);
        */

    for (University university : universityData) {
        String eaURL = "";
        String UniverName = "";
    try {
        UniverName = university.getUniverName();
        eaURL = university.getURLCollegeBoard();
        if (eaURL.length() < 15) {
            System.out.println("webScrubMain: Invalid URL for " + UniverName);
            continue;
        }
    } catch (Exception e) {
        System.out.println("webScrubMain: Unable to read from universityData!");
        continue;
    }
    System.out.println("--------- Processing: " + UniverName + " | " + eaURL);
    //create a new instance of the webDriver
   
    WebDriver driver = myWebDriver.getDriver();
    new CBOverview().univerCbOverview(eaURL, driver, university);
    new CBAdmissions().univerCBAdmissions(eaURL, driver, university);
    new CBAcademics().univerCBAcademics(eaURL, driver, university);
    new CBCosts().univerCBCosts(eaURL, driver, university);
    new CBCampusLife().univerCBCampusLife(eaURL, driver, university);
    driver.quit();
    university.setMyMajorsAvailable(majorKeywords); // find majors of my interest in the list of majors for the university
    writeToFile.writeExcelFile(path + excelFileName,sheetName, university);

    }
    }
}