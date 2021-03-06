package page;

import com.paulhammant.ngwebdriver.ByAngularModel;
import com.paulhammant.ngwebdriver.ByAngularPartialButtonText;
import com.paulhammant.ngwebdriver.NgWebDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class EmailYourEstimatePopup extends AbstractPage {

    private NgWebDriver ngDriver;
    private final String webBrowserTab;

    @FindBy(xpath = "//devsite-iframe/iframe")
    private WebElement frameGoog;

    @FindBy(id = "myFrame")
    private WebElement frameMyFrame;

    @ByAngularModel.FindBy(model = "emailQuote.user.email")
    private WebElement inputEmail;

    @ByAngularPartialButtonText.FindBy(partialButtonText = "Send Email")
    private WebElement buttonSendEmail;

    protected EmailYourEstimatePopup(WebDriver driver) {
        super(driver);
        ngDriver = new NgWebDriver((JavascriptExecutor) driver);
        ngDriver.waitForAngularRequestsToFinish();
        webBrowserTab = driver.getWindowHandle();
    }

    public void fillingAndSubmitEmailYourEstimateForm(String email) {

        driver.switchTo().defaultContent();
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameGoog));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameMyFrame));

        executor.executeScript("arguments[0].scrollIntoView(false);", inputEmail);
        inputEmail.sendKeys(email);
        clickWebElement(buttonSendEmail);

        logger.info("The estimate has been sent to email: " + email);
    }

    public String getWebBrowserTab() {
        return webBrowserTab;
    }

}
