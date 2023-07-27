package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import utils.PageTitleUtils;

public class CheckoutPage extends BasePage{
    public CheckoutPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(id="customer-email")
    protected WebElement inputEmail;
    @FindBy(xpath="//input[@name='firstname']")
    protected WebElement intputFirstName;
    @FindBy(xpath="//input[@name='lastname']")
    protected WebElement inputLastName;
    @FindBy(xpath="//input[@name='street[0]']")
    protected WebElement inputAddress;
    @FindBy(xpath="//input[@name='city']")
    protected WebElement inputCity;
    @FindBy(xpath = "//select[@name='region_id']")
    protected WebElement selectRegion;
    @FindBy(xpath="//input[@name='postcode']")
    protected WebElement inputZipCode;
    @FindBy(xpath="//select[@name='country_id']")
    protected WebElement selectCountry;
    @FindBy(xpath="//input[@name='telephone']")
    protected WebElement inputPhone;
    @FindBy(xpath = "(//input[@class='radio'])[1]")
    protected WebElement radioFlatRate;
    @FindBy(xpath = "//button[@data-role='opc-continue']")
    protected WebElement btnContinue;
    @FindBy(id="billing-address-same-as-shipping-checkmo")
    protected WebElement chkConfirmAddres;
    @FindBy(xpath = "//button[@title='Place Order']")
    protected WebElement btnPlaceOrder;
    @FindBy(xpath = "//span[@class='base']")
    protected WebElement purchaseConfirmation;
    @FindBy(xpath = "//body[@aria-busy='true']")
    protected WebElement placeOrderLoader;




    public void setShippingAddress(String email,String name, String lastName, String address, String city, String state,
                                   String zipCode, String phone) throws InterruptedException {
        Thread.sleep(5000);
        inputEmail.sendKeys(email);
        intputFirstName.sendKeys(name);
        inputLastName.sendKeys(lastName);
        inputAddress.sendKeys(address);
        inputCity.sendKeys(city);

        Select select = new Select(selectRegion);
        select.selectByVisibleText(state);

        inputZipCode.sendKeys(zipCode);
        inputPhone.sendKeys(phone);
        radioFlatRate.click();
        btnContinue.click();
        Thread.sleep(3500);
        wait.until(ExpectedConditions.invisibilityOf(placeOrderLoader));
        btnPlaceOrder.click();
        wait.until(ExpectedConditions.invisibilityOf(placeOrderLoader));
        wait.until(ExpectedConditions.visibilityOf(purchaseConfirmation));
        Assert.assertEquals(purchaseConfirmation.getText(), PageTitleUtils.PURCHASE_CONFIRMATION);
    }


}
