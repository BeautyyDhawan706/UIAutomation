package Util;

import Base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Generic extends TestBase {


    public  WebElement getElement(By locator){
        return driver.findElement(locator);
    }

    public  WebElement click(By locator){
        return driver.findElement(locator);
    }

}
