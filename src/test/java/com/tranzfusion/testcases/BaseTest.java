package com.tranzfusion.testcases;

import com.tranzfusion.pages.BasePage;
import com.tranzfusion.pages.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class BaseTest {
    WebDriver driver;
    protected Page page;
    private Properties properties;

    public BaseTest() {
        try {
            properties = new Properties();
            String filePath = System.getProperty("user.dir") + "/src/test/resources/config.properties";

            FileInputStream inputStream = new FileInputStream(filePath);

            properties.load(inputStream);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @BeforeMethod

    public void setUpBrowser() {

        String browserName = properties.getProperty("browserName");
        switch (browserName) {
            case "chrome":
                driver = new ChromeDriver();
                break;

            case "firefox":
                driver = new FirefoxDriver();
                break;

            case "firefoxHeadless":        ///If need to run without UI ///
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.addArguments("--headless");
                driver = new FirefoxDriver(firefoxOptions);
                break;


            default:
                System.out.println("Please provide right browser name");
                break;

        }
        driver.get(properties.getProperty("url"));
        driver.manage().window().maximize();

        page = new BasePage(driver);
    }


    @AfterMethod
    public void tearDown() {

                driver.quit();

    }

    public String getMakerUsername() {
        return properties.getProperty("maker_username");
    }

    public String getMakerPassword() {
        return properties.getProperty("maker_password");
    }


    public String getCheckerUsername() {
        return properties.getProperty("checker_username");
    }

    public String getCheckerPassword() {
        return properties.getProperty("checker_password");
    }


}








