package Base;

import Util.Listeners;
import Util.waits;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.interactions.Actions;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestBase extends Listeners {

    public static Properties prop;
    public static WebDriverWait wait;
    public static Actions act;
    public static JavascriptExecutor js;
    public static ChromeDriver driver;


    public TestBase() {
        prop = new Properties();
        FileInputStream ip = null;
        try {
            ip = new FileInputStream(System.getProperty("user.dir") + "/src/main/java/config/config.properties");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            prop.load(ip);
        } catch (IOException e) {
            e.printStackTrace();

        }

    }

    public static void initialization() throws InterruptedException {
        if (driver == null) {

            // create http request --> send to driver --> driver communicate to broswer

            ChromeOptions option = new ChromeOptions();
            option.addArguments("disable-notifications");
            option.addArguments("--incognito");
            //  option.addArguments("--window-size=2000,2000");
            //  option.addArguments("--start-maximized");
            option.setPageLoadStrategy(PageLoadStrategy.NORMAL);

            driver = new ChromeDriver(option);

            DevTools devtools = driver.getDevTools();
            devtools.createSession();
            Map<String, Object> dm = new HashMap<String, Object>();
            dm.put("width", 360);
            dm.put("height", 800);
            dm.put("deviceScaleFactor", 75);
            dm.put("mobile", true);
            driver.executeCdpCommand("Emulation.setDeviceMetricsOverride", dm);
            driver.get(prop.getProperty("URL"));
            driver.manage().window().fullscreen();
            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(waits.PAGE_LOAD_TIMEOUT));
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waits.IMPLICIT_WAIT));
            wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            act = new Actions(driver);
            js = (JavascriptExecutor) driver;


        }
    }
}
