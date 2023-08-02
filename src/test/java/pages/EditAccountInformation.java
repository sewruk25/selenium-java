package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class EditAccountInformation extends BasePage{
    public EditAccountInformation(WebDriver driver) {
        super(driver);
    }

    @FindBy(id="change-password")
    protected WebElement chkChangePassword;
    @FindBy(id="current-password")
    protected WebElement inputCurrentPassword;
    @FindBy(id="password")
    protected WebElement inputPassword;
    @FindBy(id="password-confirmation")
    protected WebElement inputPasswordConfirm;
    @FindBy(xpath = "//button[@title='Save']")
    protected WebElement btnSave;



    public void changePassword(){
        wait.until(ExpectedConditions.elementToBeClickable(chkChangePassword)).click();
    }

    public void setNewPassword(String currentPassword, String newPassword) {
//        Thread.sleep(1300);
//        inputCurrentPassword.sendKeys(currentPassword);
        wait.until(ExpectedConditions.elementToBeClickable(inputCurrentPassword)).sendKeys(currentPassword);
        inputPassword.sendKeys(newPassword);
        inputPasswordConfirm.sendKeys(newPassword);
        btnSave.click();
    }

}
