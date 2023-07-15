package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LogInPage extends BasePage {

    public LogInPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "email")
    protected WebElement inputEmail;
    @FindBy(id="pass")
    protected WebElement inputPassword;
    @FindBy (id="send2")
    protected WebElement btnSignIn;


    public void signIn(String login, String password){
        wait.until(ExpectedConditions.elementToBeClickable(inputEmail)).sendKeys(login);
        inputPassword.sendKeys(password);
        btnSignIn.click();
    }

}
