package com.example.test.services.manager.helpers;

import com.example.test.lawyerDTO.Lawyer;
import com.example.test.lawyerDTO.License;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class LawyerInfoGetter {

    public List<Lawyer> getsLawyersInfo(WebDriver siteConnection) {
        List<Lawyer> lawyerList = new ArrayList<>();
        lawyerList.clear();
        WebElement name = siteConnection.findElement(By.xpath("//table[@id=\"dtvResult\"]/tbody/tr/td"));
        WebElement adress = siteConnection.findElement(By.xpath("//table[@id=\"dtvResult\"]/tbody/tr[3]//span"));
        //ამით მომქონდა შტატი მაგრამ საიტზე არაფერით არ არის გამოყოფილი Br -თი მარტო და
        //მაგით რო ვყოფ და ვიღებ იმ ნაწილს რაც მინდა მოაქვს ტექსტად და ვინახავ ელემენტში
        //და მაგაზე მიგდებს შეცდომას
        //ელემენტის ნაცვლად სტრინგი რო დავწერო ეგეც არ მუშაობს და არაფერი მუშაობს რაც ვცადე
        // WebElement state = siteConnection.findElement(By.xpath("//table[@id=\"dtvResult\"]/tbody/tr[3]//span/text()[preceding-sibling::br]"));
        WebElement phoneNumber = siteConnection.findElement(By.xpath("//table[@id=\"dtvResult\"]/tbody/tr[4]/td/span[@id=\"dtvResult_Label3\"]"));
        WebElement memberClass = siteConnection.findElement(By.xpath("//table[@id=\"dtvResult\"]/tbody/tr[6]/td/span[@id=\"dtvResult_lblMemberClass\"]"));
        int indexOfComma = adress.getText().indexOf(',');
        String adress1 = adress.getText().substring(0, indexOfComma);
        lawyerList.add(new Lawyer(name.getText(), phoneNumber.getText(), adress1,
                new License("", memberClass.getText())));
        return lawyerList;
    }
}
