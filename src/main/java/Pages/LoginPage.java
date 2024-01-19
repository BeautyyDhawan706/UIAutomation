package Pages;



import Base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends TestBase {



    @FindBy(xpath="//input[@placeholder='8123456789']")
    WebElement ClickOnInputBox;
    @FindBy(xpath="//div[@data-testid='btnSMS']")
    WebElement ClickOnSMS;
    @FindBy(xpath="")
    WebElement otpBox1;
    @FindBy(xpath="")
    WebElement otpBox2;
    @FindBy(xpath="")
    WebElement otpBox3;
    @FindBy(xpath="//div[@data-testid='txtWelcome']")
    WebElement loginText;



    // initializing the page objects
    public LoginPage() {   // constructor creation
        // this is pointing current class object
        PageFactory.initElements(driver, this);

    }

    public String validateTextMsgOnLoginPage(){
       return loginText.getText();

    }

    public OtpPage login(String validNumber) throws InterruptedException {
      Thread.sleep(2000);
        WebElement ele = wait.until(ExpectedConditions.visibilityOf(ClickOnInputBox));
        ClickOnInputBox.click();
        Thread.sleep(2000);
        ClickOnInputBox.sendKeys(validNumber);
        ClickOnSMS.click();
        return new OtpPage();
    }





}
