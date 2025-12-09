package com.runner;

import java.awt.AWTException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.base.Base_Class;
import com.pageobjectmanager.PageObjectManager;
import com.utility.ReadExcelData;

public class Test_Class extends Base_Class {

    public static void main(String[] args) throws AWTException {

    	launchBrowser("chrome");
    	launchUrl("https://www.youtube.com/");
    	  implicitWait(30);


        // read value from Excel   (row 1, column 0)
        String searchFactor = ReadExcelData.readParticularData(1, 0);

        WebElement element = driver.findElement(By.xpath("//input[@name='search_query']"));
        element.sendKeys(searchFactor);

        driver.findElement(By.xpath("//button[@title='Search']")).click();
    }
}
