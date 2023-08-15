package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class AdressBookPage extends BasePage {

    public AdressBookPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(xpath = "//button[@title='Add New Address']")
    protected WebElement btnNewAddress;
    @FindBy(id = "telephone")
    protected WebElement txtPhoneNumber;
    @FindBy(id = "street_1")
    protected WebElement txtStreet;
    @FindBy(id = "city")
    protected WebElement txtCity;
    @FindBy(id = "region_id")
    protected WebElement ddlRegion;
    @FindBy(id = "zip")
    protected WebElement txtZipCode;
    @FindBy(id = "country")
    protected WebElement ddlCountry;
    @FindBy(xpath = "//button[@class='action save primary']")
    protected WebElement btnSave;


    public void setNewAddress() throws InterruptedException {
        Thread.sleep(300);
        wait.until(ExpectedConditions.elementToBeClickable(btnNewAddress)).click();
    }

    public void setNewAddress(String phoneNumber, String street, String city, String zipCode, String country, String region) throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(txtPhoneNumber)).sendKeys(phoneNumber);
        txtStreet.sendKeys(street);
        txtCity.sendKeys(city);
        txtZipCode.sendKeys(zipCode);
        Thread.sleep(300);
        Select addressCountry = new Select(ddlCountry);
        addressCountry.selectByVisibleText(country);
        Select addressRegion = new Select(ddlRegion);
        addressRegion.selectByVisibleText(region);
        btnSave.click();
    }


}
