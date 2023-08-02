package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class AdressBookPage extends BasePage{

    public AdressBookPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(xpath = "//button[@title='Add New Address']")
    protected WebElement btnNewAddress;
    @FindBy(id="telephone")
    protected WebElement inputPhoneNumber;
    @FindBy (id="street_1")
    protected WebElement inputStreet;
    @FindBy (id="city")
    protected WebElement inputCity;
    @FindBy(id="region_id")
    protected WebElement selectRegion;
    @FindBy(id="zip")
    protected WebElement inputZipCode;
    @FindBy(id="country")
    protected WebElement selectCountry;
    @FindBy(xpath = "//button[@class='action save primary']")
    protected WebElement btnSave;



    public void setNewAddress(){
        wait.until(ExpectedConditions.elementToBeClickable(btnNewAddress)).click();
    }

    public void setNewAddress(String phoneNumber, String street, String city, String zipCode, String country, String region){
        wait.until(ExpectedConditions.elementToBeClickable(inputPhoneNumber)).sendKeys(phoneNumber);
        inputStreet.sendKeys(street);
        inputCity.sendKeys(city);
        inputZipCode.sendKeys(zipCode);
        Select addressCountry = new Select(selectCountry);
        addressCountry.selectByVisibleText(country);
        Select addressRegion = new Select(selectRegion);
        addressRegion.selectByVisibleText(region);
        btnSave.click();
    }



}
