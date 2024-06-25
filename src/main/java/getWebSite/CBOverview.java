package getWebSite;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import dataObjects.University;

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
            String GraduationRate = driver.findElement(By.xpath("//div[text()='Graduation Rate']/following-sibling::div")).getText();
            university.setGraduationRate(GraduationRate);
        } catch (NoSuchElementException e) {
            System.out.println("CBOveriew: Graduation Rate not found");
        }
    
        try {
            String SATScoreRange = driver.findElement(By.xpath("//div[text()='SAT Range']/following-sibling::div")).getText();
            university.setSATScoreRange(SATScoreRange);
        } catch (NoSuchElementException e) {
            System.out.println("CBOveriew: SAT Range filed not found!");
        }

        try {
            String addr = driver.findElement(By.cssSelector("[data-testid='csp-banner-section-school-location-label']")).getText();
            String[] parts = addr.split(",");
            String City = parts[0].trim();
            university.setCity(City);
            try { 
            String State = parts[1].trim();
            university.setState(State);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("CBOverview: State not found");
        }
        } catch (NoSuchElementException e) {
            System.out.println("Address not found");
        }

        try {
            String univerType = driver.findElement(By.xpath("//div[text()='Type']/following-sibling::div")).getText();
            String[] univerTypes = univerType.split("•");
            university.setUniverTypeByYears(univerTypes[0].trim());
            try { 
            university.setUniverTypeByDesignation(univerTypes[1].trim());
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("CBOverview: University Type has single value!");
            }
            //System.out.println("univerType: " + univerType);
        } catch (NoSuchElementException e) {
            System.out.println("CBOverview: University Type filed not found");
        }

        try {
            String campusLife = driver.findElement(By.xpath("//div[text()='Campus Life']/following-sibling::div")).getText();
            String[] cLife = campusLife.split("•");
            if (cLife.length == 1) {
                university.setUniverSetting(cLife[0].trim());
            } else university.setUniverSize(cLife[0].trim());

            try {
            university.setUniverSetting(cLife[1].trim());
            } catch (ArrayIndexOutOfBoundsException e) {
                //System.out.println("CBOverview: Campus Life has single value!");
            }
            //System.out.println("campusLife: " + campusLife);
        } catch (NoSuchElementException e) {
            System.out.println("CBOverview: Campus Life filed not found");
        }

        try {
            String gradRate = driver.findElement(By.xpath("//div[text()='Graduation Rate']/following-sibling::div")).getText();
            university.setGraduationRate(gradRate);
        } catch (NoSuchElementException e) {
            System.out.println("CBOverview: Graduation Rate filed not found");

        }
        String MapLink = "";
        try {
            MapLink = driver.findElement(By.xpath("//a[contains(@href, 'https://www.google.com/maps/search')]")).getAttribute("href");
        } catch (NoSuchElementException e) {
            System.out.println("Map link not found");
        }
        try {
            String fullAddr = driver.findElement(By.xpath("//a[contains(@href, 'https://www.google.com/maps/search')]")).getText();
            // System.out.println(fullAddr);
            String friendlyAddrMapLink = "=HYPERLINK(\"" + MapLink + "\",\"" + fullAddr.trim() + "\")";
            university.setAddress(friendlyAddrMapLink);
        } catch (NoSuchElementException e) {
            // System.out.println("Address not found");
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
            String friendlyURL = "=HYPERLINK(\"" + URLCollegeBoard + "\",\"" + CollegeBoardCode + "\")";
            university.setCollegeBoardCode(friendlyURL);

        } catch (NoSuchElementException e) {
            System.out.println("College Board Code not found");
        }
        try {
            String onlineApplicationLink = driver.findElement(By.id("onlineApplication")).getAttribute("href");
            // System.out.println("View Online Application: " + onlineApplicationLink);
            String friendlyOnlineAppLink = "=HYPERLINK(\"" + onlineApplicationLink + "\",\"" + "Online Application" + "\")";
            university.setUniverOnlineApplicationURL(friendlyOnlineAppLink);
        } catch (NoSuchElementException e) {
            System.out.println("element View Online Application not found");
        }
    }
}