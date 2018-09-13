package com.example.test.services.manager;
import com.example.test.services.connections.SiteConnection;
import com.example.test.services.manager.helpers.LawyersLinksOpener;
import com.example.test.services.manager.helpers.PageChanger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class SiteManager {
    SiteConnection siteConnection = new SiteConnection();
    PageChanger pageChanger=new PageChanger();
    LawyersLinksOpener lawyersLinksOpener=new LawyersLinksOpener();
    int k = 1;
    public void setInputAndGetElements(char a, char b) throws InterruptedException {
        siteConnection.openBrowser();
        for (char j = a; j <= b; j++) {
            for (char i = 'a'; i <= 'z'; i++) {
                StringBuilder stringBuilder = new StringBuilder();
                WebElement input = siteConnection.getDriver().findElement(By.xpath("//input[@id=\"txtLastName\"]"));
                stringBuilder.append(j);
                stringBuilder.append(i);
                input.sendKeys(Keys.chord(Keys.CONTROL, "a"), stringBuilder.toString());
                WebElement button = siteConnection.getDriver().findElement(By.xpath("//input[@id=\"btnSubmit\"]"));
                button.click();
                if (siteConnection.getDriver().findElements(By.xpath("//span[@id=\"lblError\"]")).size() != 0) {
                    System.out.println("no result");
                    continue;
                }
                try {
                    pageChanger.changesPages(siteConnection.getDriver(),k);
                } catch (IndexOutOfBoundsException ex) {
                    lawyersLinksOpener.opensLinksOfEachLawyer(siteConnection.getDriver(),k);
                    siteConnection.getDriver().navigate().to("http://member.vsb.org/attsearch/search.aspx");
                }
            }
        }
        siteConnection.closeBrowser();
    }
}
