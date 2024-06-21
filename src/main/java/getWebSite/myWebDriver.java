package getWebSite;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class myWebDriver {
    
    static ChromeOptions chromeoption=new ChromeOptions();

    public static WebDriver getDriver() {
        try {
            System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
            //chromeoption.addArguments("--remote-allow-origins=* --log-level=3");
            chromeoption.addArguments("--remote-allow-origins=*");
            chromeoption.addArguments("--headless");
            WebDriver driver = new ChromeDriver(chromeoption);
            // Declare and initialize the targetSize variable
            // org.openqa.selenium.Dimension targetSize = new Dimension(1400, 1800);
            // driver.manage().window().setSize(targetSize);
            return driver;
        } catch (Exception e) {
            System.out.println("Error getting myWebDriver.getDriver()!");
            return null;
        }
    }
}
