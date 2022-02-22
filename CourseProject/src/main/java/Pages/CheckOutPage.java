package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckOutPage {
    protected WebDriver driver;

    @FindBy(id = "first-name")
    private WebElement firstNameInput;

    @FindBy(id = "last-name")
    private WebElement lastNameInput;

    @FindBy(id = "postal-code")
    private WebElement postalCodeInput;

    @FindBy(id = "continue")
    private WebElement continueBtn;

    @FindBy(id = "cancel")
    private WebElement cancelBtn;

    public CheckOutPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

        public CheckOutOverViewPage checkoutInfo(){
            firstNameInput.clear();
            firstNameInput.sendKeys("testname");

            lastNameInput.clear();
            lastNameInput.sendKeys("testlastname");

            postalCodeInput.clear();
            postalCodeInput.sendKeys("testpostalcode");

            continueBtn.click();

            return new CheckOutOverViewPage(driver);

        }
    }

