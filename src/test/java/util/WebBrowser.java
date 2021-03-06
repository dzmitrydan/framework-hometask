package util;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;

public class WebBrowser {

    public WebDriver openNewWebBrowserTab(WebDriver driver) {
        ((JavascriptExecutor) driver).executeScript("window.open()");
        ArrayList<String> webBrowserTabList = new ArrayList<>(driver.getWindowHandles());
        return driver.switchTo().window(webBrowserTabList.get(1));
    }

    public WebDriver openExistingWebBrowserTab(WebDriver driver, String webBrowserTab) {
        return driver.switchTo().window(webBrowserTab);
    }

}
