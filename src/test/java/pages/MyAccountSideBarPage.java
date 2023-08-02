package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class MyAccountSideBarPage extends BasePage {

    public MyAccountSideBarPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//li[@class='nav item']")
    protected List<WebElement> nav;


    public void selectFromSider(String listOption){
        wait.until(ExpectedConditions.visibilityOfAllElements(nav));
        nav.get(Integer.parseInt(listOption)).click();
    }




}
