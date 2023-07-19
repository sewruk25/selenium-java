package utils;

import org.openqa.selenium.*;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;

public class TestUtils {
    public static ExpectedCondition<WebElement> steadinessOfElementLocated(final By locator) {
        return new ExpectedCondition<WebElement>() {

            private WebElement _element = null;
            private Point _location = null;

            @Override
            public WebElement apply(WebDriver driver) {
                if(_element == null) {
                    try {
                        _element = driver.findElement(locator);
                    } catch (NoSuchElementException e) {
                        return null;
                    }
                }

                try {
                    if(_element.isDisplayed()){
                        Point location = _element.getLocation();
                        if(location.equals(_location) && isOnTop(_element)) {
                            return _element;
                        }
                        _location = location;
                    }
                } catch (StaleElementReferenceException e) {
                    _element = null;
                }

                return null;
            }

            @Override
            public String toString() {
                return "steadiness of element located by " + locator;
            }
        };
    }
    public static boolean isOnTop(WebElement element) {
        WebDriver driver = ((RemoteWebElement)element).getWrappedDriver();

        return (boolean)((JavascriptExecutor)driver).executeScript(
                "var elm = arguments[0];" +
                        "var doc = elm.ownerDocument || document;" +
                        "var rect = elm.getBoundingClientRect();" +
                        "return elm === doc.elementFromPoint(rect.left + (rect.width / 2), rect.top + (rect.height / 2));"
                , element);
    }

}
