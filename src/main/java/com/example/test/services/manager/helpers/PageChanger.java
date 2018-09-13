package com.example.test.services.manager.helpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class PageChanger {
    LawyersLinksOpener lawyersLinksOpener;
    public void changesPages(WebDriver siteConnection, int k) {
        List<WebElement> list = siteConnection.findElements(By.xpath("//tr[@class=\"Pager\"]/td//td/a"));
        WebElement lastElement = list.get(list.size() - 1);
        System.out.println(lastElement);

        int size = Integer.parseInt(lastElement.getText());
        for (int j = 2; j <= size + 1; j++) {
           lawyersLinksOpener.opensLinksOfEachLawyer(siteConnection,k);
            if (j > size) break;
            WebElement pageurl = siteConnection.findElement(By.xpath("//tr[@class=\"Pager\"]/td//td[" + j + "]/a"));
            pageurl.click();
        }
        siteConnection.navigate().to("http://member.vsb.org/attsearch/search.aspx");
    }
}
