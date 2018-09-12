package com.example.test.services.manager;

import com.example.test.lawyerDTO.Lawyer;
import com.example.test.lawyerDTO.License;
import com.example.test.services.connections.SiteConnection;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class SiteManager {

    SiteConnection siteConnection = new SiteConnection();

    int k=1;
    public void setInputAndGetElements(char a, char b) throws InterruptedException {

        siteConnection.openBrowser();
        for (char j = a; j <= b; j++) {
            for ( char i = 'b'; i <= 'z'; i++) {
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
                    getElements();
                } catch (IndexOutOfBoundsException ex) {
                    iterateLinks();
                    siteConnection.getDriver().navigate().to("http://member.vsb.org/attsearch/search.aspx");
                }

            }
        }
        siteConnection.closeBrowser();
    }

    public void iterateLinks() {
        for (int i = 2; ; i++) {
            try {
                WebElement url = siteConnection.getDriver().findElement(By.xpath("//*[@id=\"gvResult\"]//tr[" + i + "]/td/a"));
                url.click();
                dataWriter(k);
                siteConnection.getDriver().navigate().back();

                k++;
            } catch (Exception ex) {
                break;
            }
        }
    }

    public void getElements() {


        List<WebElement> list = new ArrayList<>();
        list = siteConnection.getDriver().findElements(By.xpath("//tr[@class=\"Pager\"]/td//td/a"));
        WebElement lastElement = list.get(list.size() - 1);
        System.out.println(lastElement);

        int size = Integer.parseInt(lastElement.getText());
        for (int j = 2; j <= size + 1; j++) {
            iterateLinks();
            if (j > size) break;
            WebElement pageurl = siteConnection.getDriver().findElement(By.xpath("//tr[@class=\"Pager\"]/td//td[" + j + "]/a"));
            pageurl.click();
        }

        siteConnection.getDriver().navigate().to("http://member.vsb.org/attsearch/search.aspx");
    }

    public File fileCreator(int i) {
        File file = new File("Files/file" + i + ".txt");
        return file;
    }

    public List getData() {
        List<Lawyer> lawyerList = new ArrayList<>();
        lawyerList.clear();
        WebElement name = siteConnection.getDriver().findElement(By.xpath("//table[@id=\"dtvResult\"]/tbody/tr/td"));
        WebElement adress = siteConnection.getDriver().findElement(By.xpath("//table[@id=\"dtvResult\"]/tbody/tr[3]//span"));
       //ამით მომქონდა შტატი მაგრამ საიტზე არაფერით არ არის გამოყოფილი Br -თი მარტო და
        //მაგით რო ვყოფ და ვიღებ იმ ნაწილს რაც მინდა მოაქვს ტექსტად და ვინახავ ელემენტში
        //და მაგაზე მიგდებს შეცდომას
        //ელემენტის ნაცვლად სტრინგი რო დავწერო ეგეც არ მუშაობს და არაფერი მუშაობს რაც ვცადე
        // WebElement state = siteConnection.getDriver().findElement(By.xpath("//table[@id=\"dtvResult\"]/tbody/tr[3]//span/text()[preceding-sibling::br]"));
        WebElement phoneNumber = siteConnection.getDriver().findElement(By.xpath("//table[@id=\"dtvResult\"]/tbody/tr[4]/td/span[@id=\"dtvResult_Label3\"]"));
        WebElement memberClass = siteConnection.getDriver().findElement(By.xpath("//table[@id=\"dtvResult\"]/tbody/tr[6]/td/span[@id=\"dtvResult_lblMemberClass\"]"));


        int indexOfComma = adress.getText().indexOf(',');
        String adress1 = adress.getText().substring(0, indexOfComma);

        lawyerList.add(new Lawyer(name.getText(), phoneNumber.getText(), adress1,
                new License("", memberClass.getText())));
        return lawyerList;
    }

    public void dataWriter(int i) throws IOException {
        Gson gson = new Gson();
        Type type = new TypeToken<List<Lawyer>>() {
        }.getType();

        List<Lawyer> lawyerList = getData();
        String json = gson.toJson(lawyerList, type);
        Files.write(fileCreator(i).toPath(), json.getBytes());
        lawyerList.clear();
    }


}
