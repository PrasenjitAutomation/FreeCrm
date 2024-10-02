package com.qa.util;
/*************************************** PURPOSE **********************************

 - This class implements the WebDriverEventListener, which is included under events.
 The purpose of implementing this interface is to override all the methods and define certain useful  Log statements 
 which would be displayed/logged as the application under test is being run.

 Do not call any of these methods, instead these methods will be invoked automatically
 as an when the action done (click, findBy etc). 

 */



import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverListener;

import com.qa.base.TestBase;

public class WebEventListener extends TestBase implements WebDriverListener {

	@Override
    public void beforeClick(WebElement element) {
        System.out.println("Before clicking on: " + element.toString());
    }

    @Override
    public void afterClick(WebElement element) {
        System.out.println("After clicking on: " + element.toString());
    }

    @Override
    public void beforeFindElement(WebDriver driver, By locator) {
        System.out.println("Before finding element: " + locator.toString());
    }

    @Override
    public void afterFindElement(WebDriver driver, By locator, WebElement result) {
        System.out.println("After finding element: " + locator.toString());
    }

    
    public void beforeNavigateTo(String url, WebDriver driver) {
        System.out.println("Before navigating to: " + url);
    }

   
    public void afterNavigateTo(String url, WebDriver driver) {
        System.out.println("After navigating to: " + url);
    }

    
    public void onError(WebDriver driver, Throwable throwable) {
        System.out.println("Exception occurred: " + throwable.getMessage());
        try {
			TestUtil.takeScreenshotAtEndOfTest();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
}