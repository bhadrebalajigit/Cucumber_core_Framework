package com.qa.utils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class JSWaite {
	
	public static void waitUntilJSReady(WebDriver driver) 
	{
        ExpectedCondition<Boolean> pageLoadCondition = new
                ExpectedCondition<Boolean>() 
                 {
                    public Boolean apply(WebDriver driver) 
                    {
                    	boolean Ready=((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
                    	System.out.println("DOM Loaded or not:"+Ready);
                        return ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
                    }
                 };
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(pageLoadCondition);
    }
	
	public static void waitForJQueryLoad(WebDriver driver)
	{
		
	        ExpectedCondition<Boolean> pageLoadCondition = new
	                ExpectedCondition<Boolean>() 
	                 {
	        	
	        	
	        	  public Boolean apply(WebDriver driver) {
	        	        JavascriptExecutor js = (JavascriptExecutor) driver;
	        	        return (Boolean)js.executeScript("return jQuery.active == 0");
	        	  }
	                /*    public Boolean apply(WebDriver driver) 
	                    {
	                    	boolean jQueryLoad=(boolean) ((JavascriptExecutor)driver).executeScript("return jQuery.active");
	                    	System.out.println("JQuery Loaded or not:"+jQueryLoad);
	                        return (Boolean) ((JavascriptExecutor)driver).executeScript("return jQuery.active");
	                    }*/
	                 };
	        WebDriverWait wait = new WebDriverWait(driver, 30);   
	        wait.until(pageLoadCondition);   
	        
	}
	
	 public static void ajaxComplete(WebDriver driver) {
		 ((JavascriptExecutor)driver).executeScript("var callback = arguments[arguments.length - 1];"
	            + "var xhr = new XMLHttpRequest();" + "xhr.open('GET', '/Ajax_call', true);"
	            + "xhr.onreadystatechange = function() {" + "  if (xhr.readyState == 4) {"
	            + "    callback(xhr.responseText);" + "  }" + "};" + "xhr.send();");
	    }
	 

}
