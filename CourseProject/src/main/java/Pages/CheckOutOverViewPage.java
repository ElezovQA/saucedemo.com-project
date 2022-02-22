package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckOutOverViewPage {
    protected WebDriver driver;

    @FindBy(id = "finish")
    private WebElement finishBtn;

    public CheckOutOverViewPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public CheckOutCompletePage clickOnFinish(){
        finishBtn.click();
        return new CheckOutCompletePage(driver);

    }
}
