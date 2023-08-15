package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import utils.PageTitleUtils;

public class CheckoutPage extends BasePage {
    public CheckoutPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(id = "customer-email")
    protected WebElement txtEmail;
    @FindBy(xpath = "//input[@name='firstname']")
    protected WebElement txtFirstName;
    @FindBy(xpath = "//input[@name='lastname']")
    protected WebElement txtLastName;
    @FindBy(xpath = "//input[@name='street[0]']")
    protected WebElement txtAddress;
    @FindBy(xpath = "//input[@name='city']")
    protected WebElement txtCity;
    @FindBy(xpath = "//select[@name='region_id']")
    protected WebElement ddlRegion;
    @FindBy(xpath = "//input[@name='postcode']")
    protected WebElement txtZipCode;
    @FindBy(xpath = "//select[@name='country_id']")
    protected WebElement ddlCountry;
    @FindBy(xpath = "//input[@name='telephone']")
    protected WebElement txtPhone;
    @FindBy(xpath = "(//input[@class='radio'])[1]")
    protected WebElement rdoFlatRate;
    @FindBy(xpath = "//button[@data-role='opc-continue']")
    protected WebElement btnContinue;
    @FindBy(id = "billing-address-same-as-shipping-checkmo")
    protected WebElement chkConfirmAddres;
    @FindBy(xpath = "//button[@title='Place Order']")
    protected WebElement btnPlaceOrder;
    @FindBy(xpath = "//body[@aria-busy='true']")
    protected WebElement placeOrderLoader;


    public void setShippingAddress(String email, String name, String lastName, String address, String city, String state,
                                   String zipCode, String phone) {
        wait.until(ExpectedConditions.visibilityOf(txtEmail)).sendKeys(email);

        wait.until(ExpectedConditions.visibilityOf(txtFirstName)).sendKeys(name);
        wait.until(ExpectedConditions.visibilityOf(txtLastName)).sendKeys(lastName);
        wait.until(ExpectedConditions.visibilityOf(txtAddress)).sendKeys(address);
        wait.until(ExpectedConditions.visibilityOf(txtCity)).sendKeys(city);

        Select select = new Select(ddlRegion);
        select.selectByVisibleText(state);

        txtZipCode.sendKeys(zipCode);
        txtPhone.sendKeys(phone);

        wait.until(ExpectedConditions.elementToBeClickable(rdoFlatRate)).click();
        btnContinue.click();
        wait.until(ExpectedConditions.invisibilityOf(placeOrderLoader));
        wait.until(ExpectedConditions.visibilityOf(btnPlaceOrder)).click();
        wait.until(ExpectedConditions.invisibilityOf(placeOrderLoader));
    }

    public void acceptShippingMethodAndPlaceOrder(){
        wait.until(ExpectedConditions.visibilityOf(btnContinue)).click();
        wait.until(ExpectedConditions.invisibilityOf(placeOrderLoader));
        wait.until(ExpectedConditions.visibilityOf(btnPlaceOrder)).click();
        wait.until(ExpectedConditions.invisibilityOf(placeOrderLoader));
    }

}
