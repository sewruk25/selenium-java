package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class EditAccountInformation extends BasePage {
    public EditAccountInformation(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "change-password")
    protected WebElement chkChangePassword;
    @FindBy(id = "current-password")
    protected WebElement txtCurrentPassword;
    @FindBy(id = "password")
    protected WebElement txtPassword;
    @FindBy(id = "password-confirmation")
    protected WebElement txtPasswordConfirm;
    @FindBy(xpath = "//button[@title='Save']")
    protected WebElement btnSave;


    public void changePassword() {
        wait.until(ExpectedConditions.elementToBeClickable(chkChangePassword)).click();
    }

    public void setNewPassword(String currentPassword, String newPassword) {

        wait.until(ExpectedConditions.elementToBeClickable(txtCurrentPassword)).sendKeys(currentPassword);
        txtPassword.sendKeys(newPassword);
        txtPasswordConfirm.sendKeys(newPassword);
        btnSave.click();
    }

}
