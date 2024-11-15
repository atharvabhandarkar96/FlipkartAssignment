package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;


// import io.github.bonigarcia.wdm.WebDriverManager;
import demo.wrappers.Wrappers;

public class TestCases {
    ChromeDriver driver;

    /*
     * TODO: Write your tests here with testng @Test annotation. 
     * Follow `testCase01` `testCase02`... format or what is provided in instructions
     */

     
    /*
     * Do not change the provided methods unless necessary, they will help in automation and assessment
     */
    @BeforeTest
    public void startBrowser()
    {
        System.setProperty("java.util.logging.config.file", "logging.properties");

        // NOT NEEDED FOR SELENIUM MANAGER
        // WebDriverManager.chromedriver().timeout(30).setup();

        ChromeOptions options = new ChromeOptions();
        LoggingPreferences logs = new LoggingPreferences();

        logs.enable(LogType.BROWSER, Level.ALL);
        logs.enable(LogType.DRIVER, Level.ALL);
        options.setCapability("goog:loggingPrefs", logs);
        options.addArguments("--remote-allow-origins=*");

        System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, "build/chromedriver.log"); 

        driver = new ChromeDriver(options);

        driver.manage().window().maximize();
       
    }

    @Test
    public void testCase01() throws InterruptedException
    {
        System.out.println("Test Case 1 - Look for high rated Washing Machines");
        driver.get("https://www.flipkart.com/");
        Thread.sleep(4000);
        Assert.assertTrue(driver.getCurrentUrl().contains("flipkart"));

    
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
       
        WebElement searchBox=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@title='Search for Products, Brands and More']")));
         
        Wrappers.searchMethod(searchBox,"Washing Machine");

        List<WebElement> sortingType=driver.findElements(By.xpath(".//div[@class='zg-M3Z']"));
        Wrappers.sort(sortingType,"Popularity");

        List<WebElement> listOfRatings=driver.findElements(By.xpath(".//div[@class='XQDdHH']"));
        Wrappers.countRatings(listOfRatings);


       
    }

    @Test
    public void testCase02() throws InterruptedException
    {
        System.out.println("Test Case 2 - Look for phones with certain discount");
        driver.get("https://www.flipkart.com/");
        Assert.assertTrue(driver.getCurrentUrl().contains("flipkart"));
    
        Thread.sleep(4000);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
       WebElement searchBox=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@title='Search for Products, Brands and More']"))); 
       Wrappers.searchMethod(searchBox,"iPhone");

        

        List<WebElement> dicsounts=driver.findElements(By.xpath(".//div[@class='UkUFwK']//span"));
        Wrappers.countDiscounts(dicsounts);


       
    }

    @Test
    public void testCase03() throws InterruptedException
    {
        System.out.println("Test Case 3 - Look for coffee mugs with certain discount");
        
        driver.get("https://www.flipkart.com/");
        Thread.sleep(4000);
        Assert.assertTrue(driver.getCurrentUrl().contains("flipkart"));
    
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
       
       WebElement searchBox=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@title='Search for Products, Brands and More']")));
        Wrappers.searchMethod(searchBox,"Coffee Mug");

        List<WebElement> ratingCheckbox=driver.findElements(By.xpath(".//div[@class='_6i1qKy']"));
        Wrappers.sort(ratingCheckbox,"4★ & above");
        List<WebElement> sortingType=driver.findElements(By.xpath(".//div[@class='zg-M3Z']"));
        Wrappers.sort(sortingType,"Popularity");

        List<WebElement> titles=driver.findElements(By.xpath(".//a[@class='wjcEIp']"));
        List<WebElement> imageURL=driver.findElements(By.xpath(".//a[@class='VJA3rP']"));
        
        Wrappers.printItems(titles);
        Wrappers.printItems2(imageURL);

        

        

       
    }
    @AfterTest
    public void endTest()
    {
       
        driver.close();
        
       driver.quit();

    }
}