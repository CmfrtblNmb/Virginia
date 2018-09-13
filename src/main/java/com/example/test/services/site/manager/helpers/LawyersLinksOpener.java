package com.example.test.services.site.manager.helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LawyersLinksOpener {
    DataWriter dataWriter;
    FileCreator fileCreator;
    LawyerInfoGetter lawyerInfoGetter;
    public void opensLinksOfEachLawyer(WebDriver siteConnection, int k) {
        for (int i = 2; ; i++) {
            try {
                WebDriver driver = siteConnection;
                WebElement url = driver.findElement(By.xpath("//*[@id=\"gvResult\"]//tr[" + i + "]/td/a"));
                url.click();
                dataWriter.writesDataAsJson(fileCreator.createsNewFiles(k),lawyerInfoGetter.getsLawyersInfo(siteConnection));
                driver.navigate().back();

                k++;
            } catch (Exception ex) {
                break;
            }
        }
    }
}
