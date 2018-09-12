package com.example.test.services.connections;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SiteConnection
{
    WebDriver driver = new ChromeDriver();

    public void  openBrowser() {
        driver.navigate().to("http://member.vsb.org/attsearch/search.aspx");
    }
    public WebDriver getDriver(){
        return driver;
    }

    public void closeBrowser() throws InterruptedException {
        Thread.sleep(5000);
        driver.close();
    }

}
