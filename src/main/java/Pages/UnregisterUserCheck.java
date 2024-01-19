package Pages;

import Base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UnregisterUserCheck extends TestBase {

    @FindBy(id="email")
    WebElement ClickOnEmail;
    @FindBy(id="password")
    WebElement ClickOnPWD;
    @FindBy(xpath="//span[contains(text(),'Sign in')]")
    WebElement ClickOnSubmit;

    public UnregisterUserCheck() {
        PageFactory.initElements(driver, this);

    }


}
