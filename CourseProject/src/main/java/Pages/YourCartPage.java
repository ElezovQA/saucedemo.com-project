package Pages;

import net.jodah.failsafe.internal.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class YourCartPage {
    protected WebDriver driver;

    @FindBy(id = "checkout")
    private WebElement checkOutBtn;

    @FindBy(className = "cart_desc_label")
    private WebElement qtyDescriptionLabel;

    public YourCartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

        }

     public  CheckOutPage clickOnCheckout(){
    checkOutBtn.click();

    return new CheckOutPage(driver);

        }

    }

