package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import utils.PageTitleUtils;


public class HeaderPage extends BasePage{


    public HeaderPage(WebDriver driver) {
        super(driver);
    }



    @FindBy(id="search")
    protected WebElement inputSearch;
    @FindBy(xpath = "//button[@class='action search']")
    protected WebElement btnSearch;
    @FindBy(xpath = "//span[@class='base']")
    protected WebElement titlePage;
    @FindBy(id="ui-id-3")
    protected WebElement lnkWhatsNew;
    @FindBy(id="ui-id-4")
    protected WebElement lnkWomen;
    @FindBy(id="ui-id-5")
    protected WebElement lnkMen;
    @FindBy(id="ui-id-6")
    protected WebElement lnkGear;
    @FindBy(id="ui-id-7")
    protected WebElement lnkTraining;
    @FindBy(id="ui-id-8")
    protected WebElement lnkSale;
    @FindBy(xpath = "//a[@class='action showcart']")
    protected WebElement lnkShowCart;
    @FindBy(xpath = "//span[@class='minicart-price']")
    protected WebElement oneItemPrice;
    @FindBy(xpath ="//span[@data-bind='html: cart().subtotal_excl_tax']" )
    protected WebElement sumPrice;
    @FindBy (id="top-cart-btn-checkout")
    protected WebElement btnToCheckoutCart;
    @FindBy (xpath = "//div[@class='loading-mask']")
    protected WebElement cartLoader;
    @FindBy (id="ui-id-9")
    protected WebElement tops;
    @FindBy (id="ui-id-11")
    protected WebElement jackets;

    public void titleAssert(String title){
        wait.until(ExpectedConditions.visibilityOf(titlePage));
        Assert.assertEquals(titlePage.getText(),title);
    }

    public void verifylnkWhatsNew(){
        wait.until(ExpectedConditions.elementToBeClickable(lnkWhatsNew)).click();
        Assert.assertEquals(titlePage.getText(), PageTitleUtils.WHATS_NEW);
    }
    public void verifylnkWomen(){
        wait.until(ExpectedConditions.elementToBeClickable(lnkWomen)).click();
        Assert.assertEquals(titlePage.getText(), PageTitleUtils.WOMEN);
    }
    public void verifylnkMen(){
        wait.until(ExpectedConditions.elementToBeClickable(lnkMen)).click();
        Assert.assertEquals(titlePage.getText(), PageTitleUtils.MEN);
    }
    public void verifylnkGear(){
        wait.until(ExpectedConditions.elementToBeClickable(lnkGear)).click();
        Assert.assertEquals(titlePage.getText(), PageTitleUtils.GEAR);
    }
    public void verifylnkTraining(){
        wait.until(ExpectedConditions.elementToBeClickable(lnkTraining)).click();
        Assert.assertEquals(titlePage.getText(), PageTitleUtils.TRAINING);
    }
    public void verifylnkSale(){
        wait.until(ExpectedConditions.elementToBeClickable(lnkSale)).click();
        Assert.assertEquals(titlePage.getText(), PageTitleUtils.SALE);
    }

    public void showCart() throws InterruptedException {
        wait.until(ExpectedConditions.invisibilityOf(cartLoader));
//        wait.until(ExpectedConditions.elementToBeClickable(lnkShowCart)).click();
        lnkShowCart.click();
        Thread.sleep(1500);
    }

    public int getPrice() throws InterruptedException {
        Thread.sleep(5000);
        String cena = oneItemPrice.getText().substring(1, 3);
        return Integer.parseInt(cena);
    }

    public String multiplyPrice() throws InterruptedException {
        return Integer.toString(6*getPrice());
    }
    public String cutPrice(){
        return sumPrice.getText().substring(1,4);
    }
    public void verifyPriceInCart() throws InterruptedException {
        Assert.assertEquals(cutPrice(),multiplyPrice());
    }
    public void searchFor(String itemName){
        wait.until(ExpectedConditions.elementToBeClickable(inputSearch)).sendKeys(itemName);
        inputSearch.sendKeys(Keys.ENTER);
    }
    public void goToCheckout(){
        wait.until(ExpectedConditions.elementToBeClickable(btnToCheckoutCart)).click();
    }



    public void moveToJacketUsingHover() throws InterruptedException {
        Thread.sleep(5000);
        Actions actions = new Actions(driver);
//        wait.until(ExpectedConditions.elementToBeClickable(lnkWomen));
        actions.moveToElement(lnkWomen).build().perform();
        wait.until(ExpectedConditions.elementToBeClickable(tops));
        actions.moveToElement(tops).build().perform();
        wait.until(ExpectedConditions.elementToBeClickable(jackets));
        jackets.click();
        wait.until(ExpectedConditions.elementToBeClickable(titlePage));
        Assert.assertEquals(titlePage.getText(),PageTitleUtils.JACKETS);

    }


}
