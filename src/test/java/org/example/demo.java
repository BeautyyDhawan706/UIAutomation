package org.example;


import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.DevTools;
import java.util.HashMap;
import java.util.Map;

public class demo {


    public static void main(String[] args) {

        // create hhtp request --> send to driver --> driver communicate to broswer

        ChromeOptions option = new ChromeOptions();
        option.addArguments("disable-notifications");
        option.addArguments("--incognito");
      //  option.addArguments("--window-size=2000,2000");
      //  option.addArguments("--start-maximized");
        option.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        ChromeDriver driver = new ChromeDriver(option);
        DevTools devtools =  driver.getDevTools();
         devtools.createSession();
        Map<String,Object> dm = new HashMap<String,Object>();
        dm.put("width", 360);
        dm.put("height", 800);
        dm.put("deviceScaleFactor", 75);
        dm.put("mobile", true);
        driver.executeCdpCommand("Emulation.setDeviceMetricsOverride", dm);
        driver.get("https://app.gajigesa.com/Login/Login");
       driver.manage().window().fullscreen();


    }
}
